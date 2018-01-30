package fr.canalplus.front.bdd.steps.base;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CommandInfo;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.HttpClient.Factory;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class BrowserstackSerenityDriver {
	
	public RemoteWebDriver connectViaProxy(DesiredCapabilities capability) {

		EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
		String proxyHost = environmentVariables.getProperty("https.proxyHost");
		int proxyPort = 8080;
		String proxyUserDomain = "cpgrp.root.local";
		String proxyUser = environmentVariables.getProperty("https.proxyUser");
		System.out.println("proxyuser"+proxyUser);
		String proxyPassword = environmentVariables.getProperty("https.proxyPass");

		String username = System.getenv("BROWSERSTACK_USERNAME");
		if (username == null) {
			username = environmentVariables.getProperty("browserstack.user");
		}
		String accesskey = System.getenv("BROWSERSTACK_ACCESS_KEY");
		if (accesskey == null) {
			accesskey = environmentVariables.getProperty("browserstack.key");
		}

		URL url;
		try {
			url = new URL("http://" + username + ":" + accesskey + "@"
					+ environmentVariables.getProperty("browserstack.server") + "/wd/hub");

		} catch (MalformedURLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		HttpClientBuilder builder = HttpClientBuilder.create();

		HttpHost proxy = new HttpHost(proxyHost, proxyPort);

		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		System.out.println("getworstation:"+getWorkstation());
		credsProvider.setCredentials(new AuthScope(proxyHost, proxyPort),
				new NTCredentials(proxyUser, proxyPassword, getWorkstation(), ""));
		
		System.out.println("credentialsProvider: " + credsProvider.toString());
		/*if (url.getUserInfo() != null && !url.getUserInfo().isEmpty()) {
			credsProvider.setCredentials(
					new AuthScope(url.getHost(), (url.getPort() > 0 ? url.getPort() : url.getDefaultPort())),
					new UsernamePasswordCredentials(url.getUserInfo()));
		}*/

		builder.setProxy(proxy);
		builder.setDefaultCredentialsProvider(credsProvider);

		Factory factory = new MyHttpClientFactory(builder);
		HttpCommandExecutor executor = new HttpCommandExecutor(new HashMap<String, CommandInfo>(), url, factory);
		System.out.println("capabiblities: " + capability.toString());
		return new RemoteWebDriver(executor, capability);
	}

	private static String getWorkstation() {
		Map<String, String> env = System.getenv();

		if (env.containsKey("COMPUTERNAME")) {
			// Windows
			return env.get("COMPUTERNAME");
		} else if (env.containsKey("HOSTNAME")) {
			// Unix/Linux/MacOs
			return env.get("HOSTNAME");
		} else {
			// From DNS
			try {
				return InetAddress.getLocalHost().getHostName();
			} catch (UnknownHostException ex) {
				return "Unknown";
			}
		}
	}

}
