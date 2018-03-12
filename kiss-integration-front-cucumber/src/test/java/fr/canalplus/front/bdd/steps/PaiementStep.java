package fr.canalplus.front.bdd.steps;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.fr.Et;
import fr.canalplus.front.bdd.steps.base.BaseIntegration;
import fr.canalplus.front.bdd.steps.base.Constants;
import net.serenitybdd.core.annotations.findby.By;

public class PaiementStep extends BaseIntegration {

	@Et("^Validation du paiement par CB (.*) IBAN$")
	public void page_paiement(String iban) throws InterruptedException {
		assertEquals("Paiement", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		/* IBAN */
		System.out.println("valeur iban:" + iban.toString());
		if (iban.equals("avec")) {
			browserStackLocaldriver.findElement(By.linkText("Régler mon abonnement par IBAN")).click();
			browserStackLocaldriver.findElement(By.id("iban")).clear();
			browserStackLocaldriver.findElement(By.id("iban")).sendKeys(Constants.generateIban());
		}
		/* CREDIT CARD */
		browserStackLocaldriver.findElement(By.name("credit-card-numbers")).clear();
		browserStackLocaldriver.findElement(By.name("credit-card-numbers")).sendKeys("4970101000022008");
		/* DEAD LINE */
		browserStackLocaldriver.findElement(By.name("credit-card-expires")).clear();
		browserStackLocaldriver.findElement(By.name("credit-card-expires")).sendKeys("1219");
		/* CVC */
		browserStackLocaldriver.findElement(By.name("credit-card-cvc")).clear();
		browserStackLocaldriver.findElement(By.name("credit-card-cvc")).sendKeys("567");

		click_sur_conditionsGenerales(By.cssSelector("div.control__indicator"));
		valider();
	}
}
