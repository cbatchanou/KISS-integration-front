package fr.canalplus.front.bdd.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.annotation.Timed;
import org.testng.annotations.BeforeSuite;
import cucumber.api.java.fr.Et;
import cucumber.api.Transform;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Lorsque;
import cucumber.api.java.fr.Etantdonné;
import fr.canalplus.front.bdd.steps.base.BaseIntegration;
import fr.canalplus.front.bdd.transformer.OperateurTransformer;
import fr.canalplus.integration.common.enums.OperateurEnum;

public class SouscriptionStep extends BaseIntegration {
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(SouscriptionStep.class);

	@BeforeSuite
	public void setUp() throws URISyntaxException {
		// setProperties();
	}

	@Etantdonné("^L'ouverture de la page souscription$")
	public void open_the_Firefox_and_launch_the_application() throws InterruptedException {
		getPageUrl();
		Thread.sleep(1000);
		assertEquals("MyCanal - Souscrire - Configuration matériel", browserStackLocaldriver.getTitle());

	}

	@Et("^Retour a la page precedente$")
	public void back_to_preview_page() {
		browserStackLocaldriver.navigate().back();
		waitForElementIsInvisible(By.cssSelector("div[class='bubblingG']"));
	}

	@Lorsque("^L'on clique sur Le Decodeur Canal$")
	public void click_sur_Decodeur_Canal() throws InterruptedException {
		browserStackLocaldriver.findElement(By.xpath(decodeur_canal)).click();
		waitForElementIsInvisible(By.cssSelector("div[class='bubblingG']"));
		assertEquals("MyCanal - Souscrire - Matériel", browserStackLocaldriver.getTitle());
	}

	@Lorsque("^L'on clique sur materiel Le Cube$")
	public void click_sur_Le_Cube() throws InterruptedException, IOException {
		browserStackLocaldriver.findElement(By.xpath(le_cube)).click();
		waitForElementIsInvisible(By.cssSelector("div[class='bubblingG']"));
		assertEquals("MyCanal - Souscrire - Matériel", browserStackLocaldriver.getTitle());
	}

	@Lorsque("^L'on clique sur materiel (.*?)$")
	public void click_sur_materiel(@Transform(OperateurTransformer.class) OperateurEnum operateurEnum)
			throws InterruptedException, IOException {
		browserStackLocaldriver.findElement(By.xpath(getOperateur(operateurEnum.toString()))).click();
		Thread.sleep(5000);
	}

	 
	@Lorsque("^L'on clique sur materiel smartTV$")
	public void click_sur_materiel_smartTV() throws InterruptedException, IOException {
		browserStackLocaldriver.findElement(By.xpath(smartTV)).click();
		Thread.sleep(5000);
	}

	@Lorsque("^L'on clique sur materiel cartesat$")
	public void click_sur_materiel_cartesat() throws InterruptedException, IOException {
		browserStackLocaldriver.findElement(By.xpath(cartesat)).click();
		Thread.sleep(5000);
	}

	@Lorsque("^L'on clique sur materiel cartetnt$")
	public void click_sur_materiel_cartetnt() throws InterruptedException, IOException {
		browserStackLocaldriver.findElement(By.xpath(cartetnt)).click();
		Thread.sleep(5000);
	}

	@Lorsque("^L'on clique sur en savoir plus sur les decodeurs canal$")
	public void en_savoir_sur_les_décodeurs_canal() throws InterruptedException, IOException {
		browserStackLocaldriver.findElement(By.xpath(link_decodeur_canal)).click();
		back_to_preview_page();
		Thread.sleep(5000);
	}

	@Lorsque("^L'on clique sur voir les modalités de loffre et des services$")
	public void voir_les_modalités_de_loffre_et_des_services() throws InterruptedException, IOException {
		browserStackLocaldriver.findElement(By.xpath(link_modalite_offre)).click();

		Thread.sleep(5000);
	}

	@Lorsque("^L'on clique sur en savoir plus sur les decodeurs compatibles$")
	public void en_savoir_sur_les_décodeurs_compatibles() throws InterruptedException, IOException {
		browserStackLocaldriver.findElement(By.xpath(link_decodeur_compatible)).click();
		back_to_preview_page();
		Thread.sleep(5000);
	}

	@Lorsque("^L'on clique sur voir le detail$")
	public void click_sur_voir_le_detail() throws InterruptedException {
		browserStackLocaldriver.findElement(By.xpath(link_voir_le_detail)).click();
		Thread.sleep(5000);
	}

	@Et("^L'on clique sur recevoir une parabole$")
	public void click_sur_recevoir_une_parabole() throws InterruptedException {
		browserStackLocaldriver.findElement(By.cssSelector("install-selection-button.opposite")).click();
		waitForElementIsInvisible(By.cssSelector("div[class='bubblingG']"));
	}

	@Et("^L'on clique sur jai deja une parabole$")
	public void click_sur_jai_deja_une_parabole() throws InterruptedException {
		browserStackLocaldriver.findElement(By.cssSelector("install-selection-button")).click();
		Thread.sleep(5000);
	}

	@Alors("^Cliquer sur Continuer$")
	public void click_sur_continuer() {
		browserStackLocaldriver.findElement(By.cssSelector(continuer)).click();
		assertEquals("MyCanal - Souscrire - Identification", browserStackLocaldriver.getTitle());
	}

	@Et("^Verifier la presence entete page$") // elements.entete
	public void verifier_la_presence_entete_page() {
		for (int i = 0; i < eltHead.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(eltHead[i])));
		}
	}

	@Et("^Verifier la presence du panier flottant$")
	public void verifier_la_presence_du_panier_flottant() throws InterruptedException {
		for (int i = 0; i < eltFooter.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(eltFooter[i])));
		}
	}

	@Et("^Verifier que tous les elements de la page sont presents$")
	public void verifier_que_tous_les_elements_de_la_page_sont_presents() throws InterruptedException {
		listElementOf("materiel");
		listElementOf("link");
	}

	@Et("^Verification des elements presents dans soucription decodeurs canal$")
	public void verification_des_elements_presents_dans_souscription_decodeurs_canal() throws InterruptedException {
		for (int i = 0; i < elementsDECC.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(elementsDECC[i])));
		}
		Thread.sleep(5000);
	}

	@Et("^Verification des elements presents dans soucription tnt$")
	public void verification_des_elements_dans_souscription_materiel_tnt() throws InterruptedException {
		for (int i = 0; i < elementsTNT.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(elementsTNT[i])));
		}
		Thread.sleep(5000);
	}

	public void verification_des_elements_dans_souscription_materiel_bbox() throws InterruptedException {
		assertTrue(isElementPresent(By.xpath("//div[1]/div[1]/material/div/div[1]")));
		assertTrue(isElementPresent(By.id("phone")));
		assertTrue(isElementPresent(By.id("name")));
		assertTrue(isElementPresent(By.tagName("i")));
		assertTrue(isElementPresent(By.xpath("//subscription-full/header-light/div/div[2]")));
		Thread.sleep(5000);
	}

	public void verification_des_elements_dans_souscription_materiel_free() throws InterruptedException {
		assertTrue(isElementPresent(By.cssSelector("div.visuel")));
		assertTrue(isElementPresent(By.tagName("i")));
		Thread.sleep(5000);
	}

	public void verification_des_elements_dans_souscription_materiel_orange() throws InterruptedException {

		assertTrue(isElementPresent(By.cssSelector("div.visuel")));
		assertTrue(isElementPresent(By.xpath("//div[1]/div[2]/input-tooltipped/div/div[2]/div[1]/i")));
		assertTrue(isElementPresent(By.xpath("//div[2]/input-tooltipped/div/div[2]/div[1]/i")));
		Thread.sleep(5000);
		browserStackLocaldriver.navigate().back();
	}

	public void verification_des_elements_dans_souscription_materiel_sfr() throws InterruptedException {
		assertTrue(isElementPresent(By.cssSelector("div.visuel")));
		assertTrue(isElementPresent(By.tagName("i")));
		Thread.sleep(5000);
		browserStackLocaldriver.navigate().back();
	}

	public void verification_des_elements_dans_souscription_materiel_numericable() throws InterruptedException {
		assertTrue(isElementPresent(By.cssSelector("div.visuel")));
		assertTrue(isElementPresent(By.tagName("i")));
		Thread.sleep(5000);
		browserStackLocaldriver.navigate().back();
	}

	public void verification_des_elements_dans_souscription_materiel_autre() throws InterruptedException {
		assertTrue(isElementPresent(By.cssSelector("div.visuel")));
		assertTrue(isElementPresent(By.id("equipmentId")));
		Thread.sleep(5000);
		browserStackLocaldriver.navigate().back();
	}

	public void verification_des_elements_dans_souscription_materiel_smartTV() throws InterruptedException {
		assertTrue(isElementPresent(By.cssSelector("div.visuel")));
		assertTrue(isElementPresent(By.id("equipmentId")));
		Thread.sleep(5000);
		browserStackLocaldriver.navigate().back();
	}

	public void verification_des_elements_dans_souscription_materiel_cartesat() throws InterruptedException {
		assertTrue(isElementPresent(By.cssSelector("div.visuel")));
		assertTrue(isElementPresent(By.xpath("//div/breadcrumb/div/div[1]/button")));
		Thread.sleep(5000);
		browserStackLocaldriver.navigate().back();
	}

	public void verification_des_elements_dans_souscription_materiel_cartetnt() throws InterruptedException {
		assertTrue(isElementPresent(By.xpath("//div/ui-view/subscription-full-material/div[1]/div[1]/material/div")));
		assertTrue(isElementPresent(By.xpath("//subscription-full-material/div[1]/p/a")));
		Thread.sleep(5000);
		browserStackLocaldriver.navigate().back();
	}

	@Alors("^Verification des elements presents dans soucription materiel voirledetail$")
	public void verification_des_elements_dans_souscription_materiel_voirledetail() throws Exception {
		assertTrue(isElementPresent(By.xpath("/html/body/div[2]/ui-view/subscription-full/footer-cart/section/div/a")));
		assertTrue(isElementPresent(By.cssSelector("div.recap-products__container")));
		assertEquals(recupere_prix_offre(),
				browserStackLocaldriver.findElement(By.xpath("//recap-products/div[1]/div[2]/div/div[2]/span")).getText());
		Thread.sleep(5000);
		browserStackLocaldriver.navigate().back();
	}

}
