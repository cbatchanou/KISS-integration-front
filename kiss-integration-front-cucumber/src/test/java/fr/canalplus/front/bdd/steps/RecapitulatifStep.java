package fr.canalplus.front.bdd.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.fr.Et;
import fr.canalplus.front.bdd.steps.base.BaseIntegration;
import net.serenitybdd.core.annotations.findby.By;

public class RecapitulatifStep extends BaseIntegration {

	public void page_recapitulatif_decodeurCanal() throws InterruptedException {

		assertEquals("Dépôt de garantie", browserStackLocaldriver
				.findElement(By.xpath("//subscription-full-recap/div/div/recap-products/div[3]/div/div[1]")).getText());
		assertEquals("75€", browserStackLocaldriver
				.findElement(By.xpath("//subscription-full-recap/div/div/recap-products/div[3]/div/div[2]")).getText());
		assertEquals("OFFERT", browserStackLocaldriver
				.findElement(By.xpath("//subscription-full-recap/div/div/recap-products/div[4]/div/div[2]")).getText());
		assertEquals("Récapitulatif", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		Thread.sleep(5000);
		valider();
	}

	@Et("^Récapitulatif de la souscription TNT 24 mois$")
	public void page_recapitulatif_TNT24() throws InterruptedException {
		assertTrue(isElementPresent(By.cssSelector("h1")));
		Thread.sleep(5000);
		assertEquals("Récapitulatif", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		assertEquals("39,90€/mois", browserStackLocaldriver
				.findElement(
						By.xpath("//subscription-full-recap/div/div/recap-products/div[1]/div[2]/div/div[2]/span[1]"))
				.getText());

		assertEquals("Location de décodeur", browserStackLocaldriver
				.findElement(By.xpath("//subscription-full-recap/div/div/recap-products/div[2]/div[2]/div/div[1]"))
				.getText());

		assertEquals("OFFERT", browserStackLocaldriver
				.findElement(By.xpath("//subscription-full-recap/div/div/recap-products/div[2]/div[2]/div/div[2]/span"))
				.getText());

		assertEquals("Dépôt de garantie", browserStackLocaldriver
				.findElement(By.xpath("//subscription-full-recap/div/div/recap-products/div[3]/div/div[1]")).getText());

		assertEquals("75€", browserStackLocaldriver
				.findElement(By.xpath("//subscription-full-recap/div/div/recap-products/div[3]/div/div[2]")).getText());
		assertEquals("Frais d'accès", browserStackLocaldriver
				.findElement(By.xpath("//subscription-full-recap/div/div/recap-products/div[4]/div/div[1]")).getText());

		assertEquals("OFFERT", browserStackLocaldriver
				.findElement(By.xpath("//subscription-full-recap/div/div/recap-products/div[4]/div/div[2]")).getText());

		Thread.sleep(5000);
		valider();
	}

	@Et("^Récapitulatif de la souscription TNT 12 mois$")
	public void page_recapitulatif_TNT12() throws InterruptedException {

		for (int i = 0; i < recapitulatif.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(recapitulatif[i])));
		}
		assertEquals("OFFERT", browserStackLocaldriver
				.findElement(By.xpath("//subscription-full-recap/div/div/recap-products/div[1]/div[2]/div/div[2]/span"))
				.getText());
		assertEquals("OFFERT", browserStackLocaldriver
				.findElement(By.xpath("//subscription-full-recap/div/div/recap-products/div[2]/div[2]/div/div[2]/span"))
				.getText());
		assertEquals("Récapitulatif", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		Thread.sleep(5000);
		valider();
	}

	@Et("^Validation du recapitulatif du récap matériel <operateur>$")
	public void page_recapitulatif_fai() throws InterruptedException {
		valider();
	}
}
