package fr.canalplus.front.bdd.steps.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SpringStep extends BaseIntegration{
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringStep.class);
	
	@Before
	public void setUp() throws Exception {
		LOGGER.info("Debut scenario de test");
	}
	
	@After
	public void tearDown() throws Exception {
		LOGGER.info("Closing drivers...");
		if(driver != null)	driver.quit();
		if(browserStackLocaldriver != null)	browserStackLocaldriver.quit();
		if(context != null) context.close(); 
	}
}
