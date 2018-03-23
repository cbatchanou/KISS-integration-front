package fr.canalplus.front.bdd.steps;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;

import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import cucumber.api.java.fr.Lorsque;
import fr.canalplus.front.bdd.steps.base.BaseIntegration;
import fr.canalplus.front.bdd.steps.base.Constants;

public class CommonStep extends BaseIntegration {

	// LIEN VOIR LE DETAIL
	@Lorsque("^L'on clique sur voir le detail$")
	public void lien_voir_le_detail() throws InterruptedException {
		browserStackLocaldriver.findElement(By.xpath(Constants.lienVoirDetail)).click();
		Thread.sleep(5000);
	}

	// LIEN EN SAVOIR PLUS SUR LES DECODEURS CANAL
	@Lorsque("^L'on clique sur en savoir plus sur les decodeurs canal$")
	public void lien_en_savoir_sur_les_décodeurs_canal() throws InterruptedException, IOException {
		browserStackLocaldriver.findElement(By.cssSelector(link_decodeur_canal)).click();
		Thread.sleep(5000);
	}

	// LIEN VOIR LES MODALITES DE L'OFFRE ET DES SERVICES
	@Lorsque("^L'on clique sur voir les modalités de loffre et des services$")
	public void voir_les_modalités_de_loffre_et_des_services() throws InterruptedException, IOException {
		switchBrowser(By.xpath(Constants.lienModalitesOffre));
		Thread.sleep(5000);
	}

	// ENTETE PAGE CANAL BOUTIQUE
	@Et("^Vérifier la présence entete page$") // elements.entete
	public void verifier_la_presence_entete_page() {
		for (int i = 0; i < Constants.elementsEntete.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(Constants.elementsEntete[i])));
		}
	}

	// PIED DE PAGE: PANIER FLOTTANT
	@Et("^Vérifier la présence du panier flottant$")
	public void verifier_la_presence_du_panier_flottant() throws InterruptedException {
		for (int i = 0; i < Constants.elementsPanierflottant.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(Constants.elementsPanierflottant[i])));
		}
	}

	@Alors("^Retour à la page mode de livraison$")
	public void retour_livraison() {
		retour();
	}

}
