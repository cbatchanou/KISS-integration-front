package fr.canalplus.front.bdd;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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

import fr.canalplus.front.bdd.steps.base.BrowserstackSerenityDriver;


@Configuration
@ComponentScan(basePackageClasses = ModuleConfig.class)
@Import(fr.canalplus.integration.common.ModuleConfig.class)
@PropertySources(value = { @PropertySource("classpath:configurations/browserstack.properties"),
		@PropertySource("classpath:configurations/stepMateriel.properties"),
		@PropertySource("classpath:configurations/connection.properties"),
		@PropertySource("classpath:configurations/sqlQueries.properties") })
public class ModuleConfig {

	@Autowired
	private Environment environment;

	@Bean(name = "browserStackLocalDriver")
	public WebDriver browserStackLocalDriver() {
		return  (new BrowserstackSerenityDriver()).newDriver();
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
}
