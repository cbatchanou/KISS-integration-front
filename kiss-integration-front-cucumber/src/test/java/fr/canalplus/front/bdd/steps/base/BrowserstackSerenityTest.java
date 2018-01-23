package fr.canalplus.front.bdd.steps.base;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import com.browserstack.local.Local;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;


public class BrowserstackSerenityTest {
	static Local bsLocal;

	@BeforeClass
	public static void setUp() throws Exception {
		EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

		String accessKey = System.getenv("BROWSERSTACK_USERNAME");
		if (accessKey == null) {
			accessKey = environmentVariables.getProperty("browserstack.key");
		}
		String proxyHost = environmentVariables.getProperty("https.proxyHost");
		String proxyPort = environmentVariables.getProperty("https.proxyPort");
		String environment = System.getProperty("environment");
		String key = "browserstack.local";
		boolean is_local = environmentVariables.getProperty(key) != null
				&& environmentVariables.getProperty(key).equals("true");

		if (environment != null && !is_local) {
			key = "environment." + environment + ".browserstack.local";
			is_local = environmentVariables.getProperty(key) != null
					&& environmentVariables.getProperty(key).equals("true");
		}
		if (is_local) {
			bsLocal = new Local();
			Map<String, String> bsLocalArgs = new HashedMap<String, String>();
			bsLocalArgs.put("key", accessKey);
			bsLocalArgs.put("proxyHost", proxyHost);
			bsLocalArgs.put("proxyPort", proxyPort);
			bsLocal.start(bsLocalArgs);
		}
	}

	@AfterClass
	public static void tearDown() throws Exception {
		if (bsLocal != null) {
			bsLocal.stop();
		}
	}
}
