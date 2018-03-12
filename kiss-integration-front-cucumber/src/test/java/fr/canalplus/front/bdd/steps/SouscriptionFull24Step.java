package fr.canalplus.front.bdd.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.fr.Et;
import fr.canalplus.front.bdd.steps.base.BaseIntegration;
import fr.canalplus.front.bdd.steps.base.Constants;

public class SouscriptionFull24Step extends BaseIntegration {

	@Et("^Vérification des éléments présents dans soucription tnt 24 mois$")
	public void elementMateriel_tnt24() throws InterruptedException {

		for (int i = 0; i < Constants.elementsTNT24.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(Constants.elementsTNT24[i])));
		}
		assertEquals("MyCanal - Souscrire - Matériel", browserStackLocaldriver.getTitle());
		assertEquals("Matériel", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		Thread.sleep(5000);
	}

	@Override
	public void prix_offre() {
		String prix = browserStackLocaldriver.findElement(By.cssSelector("span.price-footer")).getText();
		assertEquals(Constants.PRIX_OFFRE_24CECS + "/mois", prix);
	}


	@Override
	@Et("^Vérifier que le prix du panier correspond bien au prix de l'offre$")
	public void detail_panier() {
		String prix = browserStackLocaldriver.findElement(By.cssSelector("div.recap-products__amount > span"))
				.getText();
		assertEquals(Constants.PRIX_OFFRE_24CECS + "/mois", prix);
	}

	public void detail_panier_materiel() {
		List<WebElement> elements = browserStackLocaldriver.findElements(By.cssSelector("recap-products__section"));
		System.out.println("elements:" + elements.toString());
		//assertEquals("Location de décodeur", browserStackLocaldriver.findElement(By.cssSelector("")));
		//assertEquals("Dépôt de garantie", browserStackLocaldriver.findElement(By.cssSelector("")));
		//assertEquals("Frais d'accès", browserStackLocaldriver.findElement(By.cssSelector("")));

	}

}
