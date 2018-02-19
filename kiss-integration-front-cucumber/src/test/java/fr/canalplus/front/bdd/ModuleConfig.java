package fr.canalplus.front.bdd;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.apache.bcel.generic.IF_ACMPEQ;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;

import bsh.Capabilities;
import fr.canalplus.front.bdd.service.BrowserstackSerenityDriver;

@Configuration
@ComponentScan(basePackageClasses = ModuleConfig.class)
@Import(fr.canalplus.integration.common.ModuleConfig.class)
@PropertySources(value = { @PropertySource("classpath:configurations/browserstack.properties"), @PropertySource("classpath:configurations/stepMateriel.properties"), @PropertySource("classpath:configurations/sqlQueries.properties")})
public class ModuleConfig {

	@Autowired
	private Environment environment;

	/*@Bean(name = "chromeDriver")
	public WebDriver chromeDriver() throws URISyntaxException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		return new ChromeDriver();
	}*/
	
	@Bean(name = "browserStackLocalDriver")
	public WebDriver browserStackLocalDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities = getCapabilities();
		capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		try {
			return (new BrowserstackSerenityDriver()).connectViaProxy(capabilities);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Bean
	public URI getSiteCanal() throws URISyntaxException {
		return new URI(environment.getRequiredProperty("siteCanal.url"));
	}
	
	private Map<String, Object> displayAllProperties() {
		Map<String, Object> map = new HashMap<>();
		for (Iterator it = ((AbstractEnvironment) environment).getPropertySources().iterator(); it.hasNext();) {
			org.springframework.core.env.PropertySource propertySource = (org.springframework.core.env.PropertySource) it
					.next();
			if (propertySource instanceof MapPropertySource) {
				map.putAll(((MapPropertySource) propertySource).getSource());
			}
		}
		return map;
	}
	
	public DesiredCapabilities getCapabilities() {
		String username = environment.getProperty("browserstack.user");
		String accessKey = environment.getProperty("browserstack.key");

		String profil = System.getProperty("environment");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		Map<String, Object> map = displayAllProperties();

		for (Map.Entry<String, Object> entry : map.entrySet()) {
			String key = (String) entry.getKey();

			if (key.equals("browserstack.key") || key.equals("browserstack.user")
					|| key.equals("browserstack.server")) {
				continue;
			} else if (key.equals("capabilities.browserstack.local") || key.equals("capabilities.browserstack.debug")) {
				capabilities.setCapability(key.replace("capabilities.", ""), (String) entry.getValue());
			} else if (key.startsWith("capabilities.browserstack.")) {
				capabilities.setCapability(key.replace("capabilities.browserstack.", ""), (String) entry.getValue());
			} else if (profil != null && key.startsWith("environment." + profil)) {
				capabilities.setCapability(key.replace("environment." + profil + ".", ""), (String) entry.getValue());
				if (key.equals("environment." + profil + ".browserstack.local")) {
					System.setProperty(key.replace("environment." + profil + ".", ""), (String) entry.getValue());
				}
			}
		}
		System.setProperty("browserstack.local", "true");
		return capabilities;
	}
	
	

}
