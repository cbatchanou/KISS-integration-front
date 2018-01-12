package fr.canalplus.front.bdd.steps.base;

import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.annotation.Resource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jmx.export.annotation.ManagedResource;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;

@PropertySource("classpath:configurations/browserstack.properties")
public class BrowserstackSerenityDriver {

	public WebDriver newDriver() {

		EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
		//Properties property = new Properties();
		String username = System.getenv("BROWSERSTACK_USERNAME");
		if (username == null) {
			username = environmentVariables.getProperty("browserstack.user");
		}
		String accesskey = System.getenv("BROWSERSTACK_ACCESS_KEY");
		if (accesskey == null) {
			accesskey = environmentVariables.getProperty("browserstack.key");
		}
		String environment = System.getProperty("environment");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		Iterator it = environmentVariables.getKeys().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			System.out.println(key);
			if (key.equals("browserstack.user") || key.equals("browserstack.key")
					|| key.equals("browserstack.server")) {
				continue;
			} else if (key.startsWith("browserstack.")) {
				capabilities.setCapability(key.replace("browserstack.", ""), environmentVariables.getProperty(key));
				if (key.equals("browserstack.local")) {
					System.setProperty(key, environmentVariables.getProperty(key));
				}
			} else if (environment != null && key.startsWith("environment." + environment)) {
				capabilities.setCapability(key.replace("environment." + environment + ".", ""),
						environmentVariables.getProperty(key));
				if (key.equals("environment." + environment + ".browserstack.local")) {
					System.setProperty(key.replace("environment." + environment + ".", ""),
							environmentVariables.getProperty(key));
				}
			}
		}
		try {
			return new RemoteWebDriver(new URL("http://" + username + ":" + accesskey + "@"
					+ environmentVariables.getProperty("browserstack.server") + "/wd/hub"), capabilities);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
}
