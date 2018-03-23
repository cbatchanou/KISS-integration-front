package fr.canalplus.front.bdd.steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import cucumber.api.java.fr.Et;
import fr.canalplus.front.bdd.steps.base.BaseIntegration;

public class FelicitationsStep extends BaseIntegration {

	@Et("^Vérifier que les données de la page félicitation sont correctes$")
	public void page_felicitation() throws InterruptedException {
		/*
		 * for (int i = 0; i < Constants.elementsFelication.length; i++) {
		 * assertTrue(isElementPresent(By.cssSelector(Constants.elementsFelication[i])))
		 * ; }
		 */
		assertEquals("MyCanal - Souscrire - Félicitations", browserStackLocaldriver.getTitle());
		switchBrowser(By.cssSelector("button.button.button-primary"));
		Thread.sleep(5000);
		ClearBrowserCache();
	}
}
