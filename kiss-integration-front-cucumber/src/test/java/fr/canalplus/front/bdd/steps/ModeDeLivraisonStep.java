package fr.canalplus.front.bdd.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.fr.Et;
import fr.canalplus.front.bdd.steps.base.BaseIntegration;
import net.serenitybdd.core.annotations.findby.By;

public class ModeDeLivraisonStep extends BaseIntegration {

	public void mode_livraison() throws InterruptedException {
		waitForElementIsVisible(By.cssSelector("h1"));
		assertEquals("MyCanal - Souscrire - Livraison", browserStackLocaldriver.getTitle());
		assertTrue(isElementPresent(By.cssSelector("ul.container.delivery-bloc")));
		assertTrue(isElementPresent(By.cssSelector("h1")));
		Thread.sleep(5000);

	}

	@Et("^Choix du retrait en 1h en boutique$")
	public void retrait_en_boutique() throws InterruptedException {
		mode_livraison();
		assertEquals("Livraison", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		// browserStackLocaldriver.findElement(By.cssSelector("html body div ui-view
		// subscription-full ")).click();
		switchBrowser(By.xpath("//div/ui-view/subscription-full-delivery/div/ul/li[1]"));
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		for (int i = 0; i < retrait_boutique.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(retrait_boutique[i])));
		}
		String[] elt = { "L21332", "P13981", "X16877", "M19587", "V17837", "M17839" };
		int i = (int) Math.floor(Math.random() * (elt.length));
		String id = "anchor" + elt[i];
		browserStackLocaldriver.findElement(By.id(id)).click();
		browserStackLocaldriver.findElement(By.cssSelector("div.action")).click();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
	}

	@Et("^Choix du retrait en 72h à domicile$")
	public void livraison_a_domicile() throws InterruptedException {
		mode_livraison();
		assertEquals("Livraison", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		switchBrowser(By.xpath("//div/ui-view/subscription-full-delivery/div/ul/li[2]"));
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		assertEquals("MyCanal - Souscrire - Livraison", browserStackLocaldriver.getTitle());
		for (int i = 0; i < livraison_domicile.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(livraison_domicile[i])));
		}
		valider();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
	}

	@Et("^Choix de la livraison en 72h en point relais$")
	public void livraison_en_point_relais() throws InterruptedException {
		mode_livraison();
		assertEquals("Livraison", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		switchBrowser(By.xpath("//div/ui-view/subscription-full-delivery/div/ul/li[3]"));
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		assertEquals("MyCanal - Souscrire - Livraison", browserStackLocaldriver.getTitle());
		for (int i = 0; i < retrait_boutique.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(retrait_boutique[i])));
		}

		String[] element = { "4077S", "3440S", "4074S", "2968R" };
		int i = (int) Math.floor(Math.random() * (element.length));
		String id = "anchor" + element[i];
		switchBrowser(By.id(id));
		switchBrowser(By.cssSelector("div.action"));
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
	}

	@Et("^Choix de l'installation à domicile$")
	public void installation_a_domicile() throws InterruptedException {
		mode_livraison();
		assertEquals("Livraison", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		switchBrowser(By.xpath("//div/ui-view/subscription-full-delivery/div/ul/li[4]"));
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		annule_modification_adresse();
		browserStackLocaldriver.findElement(By.cssSelector("span.next")).click();
		browserStackLocaldriver.findElement(By.cssSelector("span.previous")).click();
		Thread.sleep(2000);
	}

	public void annule_modification_adresse() {
		assertEquals("MyCanal - Souscrire - Livraison", browserStackLocaldriver.getTitle());
		switchBrowser(By.linkText("Modifier l'adresse"));
		browserStackLocaldriver.findElement(By.linkText("Annuler")).click();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
	}
}
