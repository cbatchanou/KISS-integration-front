package fr.canalplus.front.bdd.steps.base;

import java.net.URL;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.remote.http.HttpClient.Factory;
import org.openqa.selenium.remote.internal.ApacheHttpClient;

public class MyHttpClientFactory implements Factory {
	final HttpClientBuilder builder;
	
	public MyHttpClientFactory(HttpClientBuilder builder) {
		this.builder=builder;
	}

	@Override
	public HttpClient createClient(URL url) {
		return new ApacheHttpClient(builder.build(), url);
	}

}
