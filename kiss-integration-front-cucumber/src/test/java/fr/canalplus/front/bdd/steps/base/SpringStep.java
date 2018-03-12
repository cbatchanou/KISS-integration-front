package fr.canalplus.front.bdd.steps.base;

import org.openqa.selenium.remote.SessionId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SpringStep extends BaseIntegration{
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringStep.class);
	SessionId sessionId;
	
	@Before
	public void setUp() throws Exception {
		LOGGER.info("Debut scenario de test");
	}
	
	@After
	public void tearDown() throws Exception {
		LOGGER.info("Closing drivers...");
		// if (browserStackLocaldriver != null)
		// browserStackLocaldriver.quit();

		if(context != null) context.close(); 
	}
	

}
