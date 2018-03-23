package fr.canalplus.front.bdd.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;

import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import cucumber.api.java.fr.Etantdonné;
import cucumber.api.java.fr.Lorsque;
import fr.canalplus.front.bdd.steps.base.BaseIntegration;

public class MaterielStep extends BaseIntegration {
	private static final Logger LOGGER = LoggerFactory.getLogger(MaterielStep.class);

	@BeforeSuite
	public void setUp() throws URISyntaxException {

	}

	@Etantdonné("^L'ouverture de la page souscription avec un propalId (.*)$")
	public void open_the_Firefox_and_launch_the_application(String propalId) throws InterruptedException {
		getPageUrl(propalId);
		Thread.sleep(5000);
		assertEquals("MyCanal - Souscrire - Configuration matériel", browserStackLocaldriver.getTitle());
		assertEquals("Matériel", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		Thread.sleep(3000);

	}

	@Etantdonné("^L'ouverture de la page souscription$")
	public void ouvrir_la_page_souscription() throws InterruptedException {
		getPageUrl();
		Thread.sleep(5000);
		assertEquals("MyCanal - Souscrire - Configuration matériel", browserStackLocaldriver.getTitle());
		assertEquals("Matériel", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		Thread.sleep(3000);

	}

	@Etantdonné("^Une offre sans engagement de propalId (.*)$")
	public void UrlpourSansEngagement(String propalId) throws InterruptedException {
		getPageUrl(propalId);
		Thread.sleep(5000);
		assertEquals("MyCanal - Souscrire - Identification", browserStackLocaldriver.getTitle());
		assertEquals("Matériel", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		Thread.sleep(3000);

	}

	@Lorsque("^L'on clique sur le décodeur Canal$")
	public void click_sur_Decodeur_Canal() throws InterruptedException {
		switchBrowser(By.cssSelector(decodeur_canal));
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		assertEquals("MyCanal - Souscrire - Matériel", browserStackLocaldriver.getTitle());
	}

	@Lorsque("^L'on clique sur le décodeur Canal plus Le Cube$")
	public void click_sur_Le_Cube() throws InterruptedException, IOException {
		browserStackLocaldriver.findElement(By.xpath(le_cube)).click();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		assertEquals("MyCanal - Souscrire - Matériel", browserStackLocaldriver.getTitle());
	}


	@Lorsque("^L'on clique sur materiel smartTV$")
	public void click_sur_materiel_smartTV() throws InterruptedException, IOException {
		browserStackLocaldriver.findElement(By.xpath(smartTV)).click();
		assertEquals("MyCanal - Souscrire - Matériel", browserStackLocaldriver.getTitle());
		Thread.sleep(5000);
	}

	@Lorsque("^L'on clique sur materiel cartesat$")
	public void click_sur_materiel_cartesat() throws InterruptedException, IOException {
		browserStackLocaldriver.findElement(By.xpath(cartesat)).click();
		assertEquals("MyCanal - Souscrire - Matériel", browserStackLocaldriver.getTitle());
		Thread.sleep(5000);
	}

	@Lorsque("^L'on clique sur materiel cartetnt$")
	public void click_sur_materiel_cartetnt() throws InterruptedException, IOException {
		browserStackLocaldriver.findElement(By.xpath(cartetnt)).click();
		assertEquals("MyCanal - Souscrire - Matériel", browserStackLocaldriver.getTitle());
		Thread.sleep(5000);
	}

	@Lorsque("^L'on clique sur en savoir plus sur les decodeurs compatibles$")
	public void en_savoir_sur_les_décodeurs_compatibles() throws InterruptedException, IOException {
		switchBrowser(By.xpath(link_decodeur_compatible));
		browserStackLocaldriver.switchTo().parentFrame();
		Thread.sleep(5000);
	}

	@Et("^L'on clique sur recevoir une parabole$")
	public void click_sur_recevoir_une_parabole() throws InterruptedException {
		browserStackLocaldriver.findElement(By.cssSelector("install-selection-button.opposite")).click();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		Thread.sleep(5000);
	}

	@Et("^L'on clique sur jai deja une parabole$")
	public void click_sur_jai_deja_une_parabole() throws InterruptedException {
		browserStackLocaldriver.findElement(By.cssSelector("install-selection-button")).click();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		Thread.sleep(5000);
	}

	@Alors("^Cliquer sur Continuer$")
	public void click_sur_continuer() {
		browserStackLocaldriver.findElement(By.cssSelector(continuer)).click();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		assertEquals("MyCanal - Souscrire - Identification", browserStackLocaldriver.getTitle());
	}

	@Et("^Vérification des éléments présents dans soucription décodeur canal$")
	public void verification_des_elements_presents_dans_souscription_decodeurs_canal() throws InterruptedException {
		for (int i = 0; i < elementsDECC.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(elementsDECC[i])));
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
		Thread.sleep(5000);
		browserStackLocaldriver.navigate().back();
	}

}
