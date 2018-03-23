package fr.canalplus.front.bdd.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import cucumber.api.java.fr.Et;
import cucumber.api.java.fr.Etantdonné;
import cucumber.api.java.fr.Lorsque;
import fr.canalplus.front.bdd.steps.base.BaseIntegration;
import fr.canalplus.front.bdd.steps.base.Constants;

public class SouscriptionFull12 extends BaseIntegration {

	@Etantdonné("^L'ouverture de la page$")
	public void Charger_la_page() throws InterruptedException {
		getPageUrl();
		assertEquals("CANAL BOUTIQUE - Souscrire - Configuration matériel", browserStackLocaldriver.getTitle());
	}

	public void elementsPageAccueil() {
		for (int i = 0; i < Constants.elementsEntete.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(Constants.elementsEntete[i])));
		}
		for (int i = 0; i < Constants.elementsPanierflottant.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(Constants.elementsPanierflottant[i])));
		}
		if (browserStackLocaldriver.findElement(By.cssSelector("div.switch.ng-scope.selected")).getText()
				.equals("Je choisis un décodeur TV")) {
			for (int i = 0; i < Constants.ElementDecodeurCanal.length; i++) {
				assertTrue(isElementPresent(By.cssSelector(Constants.ElementDecodeurCanal[i])));
			}

			for (int i = 0; i < Constants.ElementPlusCube.length; i++) {
				assertTrue(isElementPresent(By.cssSelector(Constants.ElementDecodeurCanal[i])));
			}
		} else if (browserStackLocaldriver.findElement(By.cssSelector("div.switch.ng-scope.selected")).getText()
				.equals("J’utilise mon matériel")) {
			for (int i = 0; i < Constants.ElementFaiBox.length; i++) {
				assertTrue(isElementPresent(By.cssSelector(Constants.ElementFaiBox[i])));
			}
			for (int i = 0; i < Constants.ElementEcransConnectes.length; i++) {
				assertTrue(isElementPresent(By.cssSelector(Constants.ElementEcransConnectes[i])));
			}
			for (int i = 0; i < Constants.ElementSmartTV.length; i++) {
				assertTrue(isElementPresent(By.cssSelector(Constants.ElementSmartTV[i])));
			}

		}
		assertEquals("Matériel",
				browserStackLocaldriver.findElement(By.cssSelector("div.breadcrumb_step.ng-scope.active")).getText());

	}

	@Et("^Le choix d'un Décodeur TV$")
	public void click_sur_je_choisis_un_décodeur_TV() {
		browserStackLocaldriver.findElement(By.xpath("/html/body/div[2]/div/div/ui-view/div/div[2]/div[1]")).click();
		assertEquals("Je choisis un décodeur TV",
				browserStackLocaldriver.findElement(By.cssSelector("div.switch.ng-scope.selected")).getText());
		elementsPageAccueil();
	}

	@Et("^Le choix d'un materiel$")
	public void click_sur_jutilise_mon_materiel() throws InterruptedException {
		browserStackLocaldriver.findElement(By.xpath("/html/body/div[2]/div/div/ui-view/div/div[2]/div[2]"))
				.click();
		assertEquals("J’utilise mon matériel",
				browserStackLocaldriver.findElement(By.cssSelector("div.switch.ng-scope.selected")).getText());
		elementsPageAccueil();
	}
	@Lorsque("^L'on choisit le Décodeur CANAL$")
	public void click_sur_choisir_le_décodeurCanal() {
		browserStackLocaldriver.findElement(By.xpath("/html/body/div[2]/div/div/ui-view/div/div[3]/div[1]/div[3]"))
				.click();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		assertEquals("CANAL BOUTIQUE - Souscrire - Matériel", browserStackLocaldriver.getTitle());
	}

	@Lorsque("^L'on choisit le Décodeur plus Le Cube$")
	public void click_sur_choisir_le_décodeurPlusLeCube() throws InterruptedException {
		browserStackLocaldriver.findElement(By.xpath("/html/body/div[2]/div/div/ui-view/div/div[3]/div[2]/div[3]"))
				.click();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		assertEquals("CANAL BOUTIQUE - Souscrire - Matériel", browserStackLocaldriver.getTitle());
		confirmer();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
	}

	@Lorsque("^L'on choisit la Box TV opérateur$")
	public void click_sur_choisir_la_BoxTV() {
		browserStackLocaldriver.findElement(By.xpath("/html/body/div[2]/div/div/ui-view/div/div[4]/div[1]/div[3]"))
				.click();
		assertEquals("CANAL BOUTIQUE - Souscrire - Matériel", browserStackLocaldriver.getTitle());
	}

	@Lorsque("^L'on choisit écrans connectés$")
	public void click_sur_choisir_écrans_connectés() {
		browserStackLocaldriver.findElement(By.xpath("/html/body/div[2]/div/div/ui-view/div/div[4]/div[2]/div[3]"))
				.click();
		assertEquals("CANAL BOUTIQUE - Souscrire - Matériel", browserStackLocaldriver.getTitle());
	}

	@Lorsque("^L'on choisit Smart TV Samsung$")
	public void click_sur_choisir_Smart_TV_Samsung() {
		browserStackLocaldriver.findElement(By.xpath("/html/body/div[2]/div/div/ui-view/div/div[4]/div[3]/div[3]"))
				.click();
		assertEquals("CANAL BOUTIQUE - Souscrire - Matériel", browserStackLocaldriver.getTitle());
		assertTrue(isElementPresent(By.cssSelector(Constants.lienModalitesOffre)));
		assertTrue(isElementPresent(By.cssSelector("div.isp-logo.ott")));
	}


}
