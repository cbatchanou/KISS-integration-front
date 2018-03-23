package fr.canalplus.front.bdd.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;

import cucumber.api.java.fr.Et;
import fr.canalplus.front.bdd.steps.base.BaseIntegration;
import fr.canalplus.front.bdd.steps.base.Constants;
import net.serenitybdd.core.annotations.findby.By;

public class ModeDeLivraisonStep extends BaseIntegration {

	public void mode_livraison() throws InterruptedException {
		waitForElementIsVisible(By.cssSelector("h1"));
		assertEquals("MyCanal - Souscrire - Livraison", browserStackLocaldriver.getTitle());
		assertEquals("Livraison", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		assertTrue(isElementPresent(By.cssSelector("ul.container.delivery-bloc")));
		assertTrue(isElementPresent(By.cssSelector("h1")));
		Thread.sleep(5000);

	}

	@Et("^Choix du retrait en 1h en boutique$")
	public void retrait_en_boutique() throws InterruptedException {
		mode_livraison();
		typeLivraison(0);
		for (int i = 0; i < Constants.ElementRetraitBoutique.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(Constants.ElementRetraitBoutique[i])));
		}
		WebElement section = browserStackLocaldriver.findElement(By.className("drop-off-points-content"));
		List<WebElement> items = section.findElements(By.tagName("delivery-store"));
		int i = (int) Math.floor(Math.random() * (items.size()));
		items.get(i).click();
		browserStackLocaldriver
				.findElement(By.xpath("//*[@id=\"" + items.get(i).getAttribute("id") + "\"]/div[2]/button")).click();
		Thread.sleep(5000);
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
	}

	public void findId() {
		WebElement section = browserStackLocaldriver.findElement(By.className("drop-off-points-content"));
		List<WebElement> items = section.findElements(By.tagName("delivery-store"));
		int i = (int) Math.floor(Math.random() * (items.size()));
		items.get(i).click();
	}

	public void typeLivraison(int livraison) {
		WebElement section = browserStackLocaldriver.findElement(By.cssSelector("ul.container.delivery-bloc"));
		List<WebElement> items = section.findElements(By.tagName("li"));
		items.get(livraison).click();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
	}

	@Et("^Choix du retrait en 72h à domicile$")
	public void livraison_a_domicile() throws InterruptedException {
		mode_livraison();
		typeLivraison(1);
		for (int i = 0; i < Constants.ElementLivraisonDomicile.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(Constants.ElementLivraisonDomicile[i])));
		}
		browserStackLocaldriver.findElement(By.cssSelector("button.button.button-primary")).click();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		Thread.sleep(5000);
	}

	@Et("^Choix du retrait en 72h à domicile avec changement d'adresse (.*), (.*)$")
	public void LDEtChangementAdresse(String zipCodeBis, String streetNameBis) throws InterruptedException {
		mode_livraison();
		typeLivraison(1);
		for (int i = 0; i < Constants.ElementLivraisonDomicile.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(Constants.ElementLivraisonDomicile[i])));
		}
		String adresseAvant = browserStackLocaldriver.findElement(By.cssSelector("p.address")).getText();

		/* CHANGEMENT D'ADRESSE */
		switchBrowser(By.linkText("Modifier l'adresse"));
		Thread.sleep(2000);
		inputfield(org.openqa.selenium.By.name("zipCode"), zipCodeBis);
		inputfield(org.openqa.selenium.By.name("streetName"), streetNameBis);
		switchBrowser(By.cssSelector("button.button.button-primary"));
		Thread.sleep(2000);
		String adresseApres = browserStackLocaldriver.findElement(By.cssSelector("p.address")).getText();
		Thread.sleep(2000);
		browserStackLocaldriver.findElement(By.cssSelector("button.button.button-primary")).click();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		Thread.sleep(2000);
	}

	@Et("^Choix de la livraison en 72h en point relais$")
	public void livraison_en_point_relais() throws InterruptedException {
		mode_livraison();
		typeLivraison(2);

		for (int i = 0; i < Constants.ElementRetraitBoutique.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(Constants.ElementRetraitBoutique[i])));
		}
		WebElement section = browserStackLocaldriver.findElement(By.className("drop-off-points-content"));
		List<WebElement> items = section.findElements(By.tagName("delivery-store"));
		int i = (int) Math.floor(Math.random() * (items.size()));
		items.get(i).click();
		browserStackLocaldriver
				.findElement(By.xpath("//*[@id=\"" + items.get(i).getAttribute("id") + "\"]/div[2]/button")).click();
		Thread.sleep(5000);
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
	}

	@Et("^Choix de l'installation à domicile$")
	public void installation_a_domicile() throws InterruptedException {
		mode_livraison();
		typeLivraison(3);
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));

		WebElement section = browserStackLocaldriver.findElement(By.xpath(
				"/html/body/div[2]/ui-view/subscription-full/div/ui-view/subscription-full-appointment/div/div/section/div[2]/ul"));
		List<WebElement> items = section.findElements(By.tagName("li"));
		int i = (int) Math.floor(Math.random() * (items.size()));
		List<WebElement> span = items.get(i)
				.findElements(By.cssSelector("span.ng-binding.ng-scope.availabilitie.available"));
		int j = (int) Math.floor(Math.random() * (span.size()));
		span.get(j).click();
		switchBrowser(By.cssSelector("button.button.button-primary"));
		Thread.sleep(2000);
	}
}
