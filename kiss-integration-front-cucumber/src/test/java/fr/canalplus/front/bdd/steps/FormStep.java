package fr.canalplus.front.bdd.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.validation.constraints.AssertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import cucumber.api.Transform;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import fr.canalplus.front.bdd.ModuleConfig;
import fr.canalplus.front.bdd.steps.base.BaseIntegration;
import fr.canalplus.front.bdd.steps.base.ConstantsWebElement;
import fr.canalplus.front.bdd.transformer.OperateurTransformer;
import fr.canalplus.integration.bdd.DBConfig;
import fr.canalplus.integration.common.beans.entities.MaterialNumber;
import fr.canalplus.integration.common.beans.entities.Subscriber;
import fr.canalplus.integration.common.enums.OperateurEnum;
import fr.canalplus.integration.common.services.interfaces.MaterialNumberService;
import fr.canalplus.integration.common.services.interfaces.SubscriberService;
import net.serenitybdd.core.annotations.findby.By;

public class FormStep extends BaseIntegration {
	private static final Logger LOGGER = LoggerFactory.getLogger(FormStep.class);
	
	private String nom;
	private String prenom;
	private String codePostal;
	private String adresse;
	private String mobile;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public static SubscriberService subscriberContext() {
		context = new AnnotationConfigApplicationContext(ModuleConfig.class, DBConfig.class);
		return context.getBean(SubscriberService.class);
	}

	public static MaterialNumberService materialContext() {
		context = new AnnotationConfigApplicationContext(ModuleConfig.class, DBConfig.class);
		return context.getBean(MaterialNumberService.class);
	}
	
	@Value("${civility.male}")
	private String civilityM;
	
	@Value("${civility.female}")
	private String civilityF;
	
	@Value("${conditionsG}")
	private String conditionsG;

	
	public void inputCivility(Integer civility) {
		if(civility == 1) { 
			browserStackLocaldriver.findElement(org.openqa.selenium.By.xpath(civilityM)).click();
		}
		else browserStackLocaldriver.findElement(org.openqa.selenium.By.xpath(civilityF)).click();
	}

	public void inputName(String name) {
		browserStackLocaldriver.findElement(org.openqa.selenium.By.id("name")).clear();
		browserStackLocaldriver.findElement(org.openqa.selenium.By.id("name")).sendKeys(name);
	}

	public void inputLastName(String lastName) {
		browserStackLocaldriver.findElement(org.openqa.selenium.By.id("lastName")).clear();
		browserStackLocaldriver.findElement(org.openqa.selenium.By.id("lastName")).sendKeys(lastName);
	}

	public void inputFirstName(String firstName) {
		browserStackLocaldriver.findElement(org.openqa.selenium.By.id("firstName")).clear();
		browserStackLocaldriver.findElement(org.openqa.selenium.By.id("firstName")).sendKeys(firstName);
	}

	public void inputZipCode(Integer zipCode) {
		browserStackLocaldriver.findElement(org.openqa.selenium.By.name("zipCode")).clear();
		browserStackLocaldriver.findElement(org.openqa.selenium.By.name("zipCode")).sendKeys(zipCode.toString());
	}

	public void inputAdress(String streetName) {
		browserStackLocaldriver.findElement(org.openqa.selenium.By.id("streetName")).clear();
		browserStackLocaldriver.findElement(org.openqa.selenium.By.id("streetName")).sendKeys(streetName);
	}

	// TELEPHONE FIXE
	public void inputPhone(String phone) {
		browserStackLocaldriver.findElement(org.openqa.selenium.By.id("phone")).clear();
		browserStackLocaldriver.findElement(org.openqa.selenium.By.id("phone")).sendKeys(phone);
	}

	public void inputMobile(String mobile) {
		browserStackLocaldriver.findElement(org.openqa.selenium.By.id("mobile")).clear();
		browserStackLocaldriver.findElement(org.openqa.selenium.By.id("mobile")).sendKeys(mobile);
	}

	public void inputEmail(String email) {
		browserStackLocaldriver.findElement(org.openqa.selenium.By.id("email")).clear();
		browserStackLocaldriver.findElement(org.openqa.selenium.By.id("email")).sendKeys(email);
	}
	

	public void inputPassword(String password) {
		browserStackLocaldriver.findElement(org.openqa.selenium.By.id("password")).clear();
		browserStackLocaldriver.findElement(org.openqa.selenium.By.id("password")).sendKeys(password);
	}

	public void inputMaterial(String numMaterial) {
		browserStackLocaldriver.findElement(org.openqa.selenium.By.id("equipmentId")).clear();
		browserStackLocaldriver.findElement(org.openqa.selenium.By.id("equipmentId")).sendKeys(numMaterial);
	}

	
	@Et("^L'on verifie les messages d'erreurs affichés du nom invalide et du téléphone invalide$")
	public void nom_et_telephone_invalides() throws InterruptedException {
		Subscriber subscriber = subscriberContext().find(10214344);
		inputName(getPassword()); inputPhone(getString());
		valider();
		assertEquals("Veuillez saisir un nom valide", browserStackLocaldriver.findElement(By.xpath("//div[1]/div[3]/p[1]")).getText());
		assertEquals("Veuillez saisir un numéro de téléphone valide", browserStackLocaldriver.findElement(By.xpath("//div[1]/div[3]/p[2]")).getText());
		
		inputName(subscriber.getNom());
		valider();
		assertEquals("Veuillez saisir un numéro de téléphone valide", browserStackLocaldriver.findElement(By.xpath("//div[1]/div[3]/p[2]")).getText());
		
		inputName(getPassword()); inputPhone(subscriber.getPhone());
		valider();
		assertEquals("Veuillez saisir un nom valide", browserStackLocaldriver.findElement(By.xpath("//div[1]/div[3]/p[1]")).getText());
	}
	
	@Et("^L'on renseigne le numéro de matériel (.*?)$")
	public void formulaireOperateursFai(@Transform(OperateurTransformer.class)OperateurEnum operateurEnum) {
		MaterialNumber material = materialContext().findMaterial(refOperateur(operateurEnum.toString()));
		inputMaterial(material.getNumeroSerie());
	}

	public void click_sur_conditionsGenerales(org.openqa.selenium.By locator) {
		switchBrowser(locator);
	}
	
	public void click_sur_reCAPTCHA() {
		WebElement element = browserStackLocaldriver.findElement(org.openqa.selenium.By.cssSelector(reCAPTCHA));
		Actions clickerConditions = new Actions(browserStackLocaldriver);
		clickerConditions.moveToElement(element, 0, 0).click().perform();
	}
	@Alors("^cliquer sur le lien Identifiez-vous$")
	public void click_sur_identifiez_vous() throws InterruptedException {
		browserStackLocaldriver.findElement(By.linkText("Identifiez-vous")).click();
		assertEquals("MyCanal - Souscrire - Identification", browserStackLocaldriver.getTitle());
		WebDriverWait wait = new WebDriverWait(browserStackLocaldriver, 40);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Mot de passe")));
		Thread.sleep(5000);
	}
	
	@Et("^L'on renseigne les champs nom et téléphone$")
	public void input_name_and_phone() {
		Subscriber subscriber = subscriberContext().find(10214344);
		inputName(subscriber.getNom());
		inputPhone(subscriber.getPhone());
	}
	
	@Et("^Renseigner un (.*) et un (.*)$")
	public void identifiez_vous(String email, String password) throws InterruptedException {
		
		browserStackLocaldriver.findElement(By.cssSelector("input#sso-email")).clear();
		browserStackLocaldriver.findElement(By.cssSelector("input#sso-email")).sendKeys(email);
		
		browserStackLocaldriver.findElement(By.id("sso-pass")).clear();
		browserStackLocaldriver.findElement(By.id("sso-pass")).sendKeys(password);
		click_sur_reCAPTCHA();
		valider();
		
	}
	
	@Et("^Saisir le cas d'un nom invalide et d'un téléphone valide: (.*); (.*)$")
	public void formulaire_recap_nom_invalide(String name, String phone) throws InterruptedException {
		inputName(name);
		inputPhone(phone);
		valider();
		assertTrue(ConstantsWebElement.NOM_INVALIDE, isElementPresent(By.xpath("//subscription-full-material/div/div[3]/p[1]")));		
	}
	
	@Et("^Saisir le cas d'un nom valide et d'un téléphone invalide: (.*); (.*)$")
	public void formulaire_recap_phone_invalide(String name, String phone) throws InterruptedException {
		inputName(name);
		inputPhone(phone);
		valider();
		assertTrue(ConstantsWebElement.TELEPHONE_INVALIDE, isElementPresent(By.xpath("//subscription-full-material/div/div[3]/p[2]")));		
	}
	
	@Et("^Saisir le cas d'un materiel vide et invalide: (.*); (.*); (.*)$")
	public void formulaire_recap_materiel_invalide(String name, String phone, String materiel) throws InterruptedException {
		inputName(name);
		inputPhone(phone);
		tooltip_info();
		
		if(materiel.equals("") || materiel==null) {
			valider();
			assertTrue(ConstantsWebElement.MATERIEL_VIDE, isElementPresent(By.xpath("//subscription-full-material/div/div[3]p[3]")));
			Thread.sleep(3000);
		}
		else {
			inputMaterial(materiel);
			valider();
			waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
			assertTrue(ConstantsWebElement.MATERIEL_INVALIDE, isElementPresent(By.xpath("//subscription-full-material/div/div[3]p[3]")));
		}
		
		assertEquals("MyCanal - Souscrire - Matériel", browserStackLocaldriver.getTitle());
		Thread.sleep(3000);
	}
	
	@Et("^Saisir le cas d'un nom et d'un téléphone vides $")
	public void formulaire_recap_invalide(String name, String phone) throws InterruptedException {
		valider();
		assertTrue(ConstantsWebElement.NOM_INVALIDE, isElementPresent(By.xpath("//subscription-full-material/div/div[3]/p[1]")));		
		assertTrue(ConstantsWebElement.TELEPHONE_INVALIDE, isElementPresent(By.xpath("//subscription-full-material/div/div[3]/p[2]")));		
		Thread.sleep(3000);
	}
	
	@Et("^Verifier les messages d'erreurs$")
	public void messageErreurIdentification() {
		assertEquals("Erreur d'identification", browserStackLocaldriver.findElement(By.id("errorTitle")).getText());
		assertEquals("Merci de verifier votre email et votre mot de passe", browserStackLocaldriver.findElement(By.id("errorText")).getText());
	}

	@Alors("^Création d'une personne avec les données: (\\d+), (.*), (.*), (\\d+), (.*), (.*)$")
	public void formulaireCreationDeCompte(int civility, String prenom, String nom, int codeP, String adresse, String mobile) {
		//waitForElementIsVisible(By.cssSelector("button.button.button-primary"));
		
		inputCivility(civility);
		inputFirstName(prenom); inputLastName(nom);
		inputZipCode(codeP); inputAdress(adresse);
		inputMobile(mobile); inputEmail(getString());
		inputPassword(getPassword());
		assertEquals("Coordonnées", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		click_sur_conditionsGenerales(By.xpath(conditionsG));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public void tooltip_info() {
		assertTrue(isElementPresent(By.xpath("//div/div[2]/div[2]/input-tooltipped/div/div[2]/div[1]/i")));
		assertTrue(isElementPresent(By.xpath("//div/div[2]/div[1]/div[2]/input-tooltipped/div/div[2]/div[1]/i")));
	}
	
	public void mode_livraison() throws InterruptedException {
		waitForElementIsVisible(By.cssSelector("h1"));
		assertEquals("MyCanal - Souscrire - Livraison", browserStackLocaldriver.getTitle());
		assertTrue(isElementPresent(By.cssSelector("ul.container.delivery-bloc")));
		assertTrue(isElementPresent(By.cssSelector("h1")));
		Thread.sleep(5000);
		
	}
	
	/* STEP CHOIX DU TYPE DE LIVRAISON */
	
	@Et("^Choix du retrait en 1h en boutique$")
	public void retrait_en_boutique() throws InterruptedException {
		mode_livraison();
		assertEquals("Livraison", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		//browserStackLocaldriver.findElement(By.cssSelector("html body div ui-view subscription-full ")).click();
		switchBrowser(By.xpath("//div/ui-view/subscription-full-delivery/div/ul/li[1]"));
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		for (int i = 0; i < retrait_boutique.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(retrait_boutique[i])));
		}
		String[] elt= {"L21332","P13981","X16877","M19587","V17837","M17839"};
		int i = (int) Math.floor(Math.random() * (elt.length));
		String id="anchor"+elt[i];
		browserStackLocaldriver.findElement(By.id(id)).click();
		browserStackLocaldriver.findElement(By.cssSelector("div.action")).click();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		page_recapitulatif_decodeurCanal();
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
		page_recapitulatif_decodeurCanal();
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
		
		String[] element= {"4077S","3440S","4074S","2968R"};
		int i = (int) Math.floor(Math.random() * (element.length));
		String id="anchor"+element[i];
		browserStackLocaldriver.findElement(By.id(id)).click();
		browserStackLocaldriver.findElement(By.cssSelector("div.action")).click();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		page_recapitulatif_decodeurCanal();
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
	
	/* RECAPITULATIF */
	public void page_recapitulatif_decodeurCanal() throws InterruptedException {
		/*for (int i = 0; i < recapitulatif.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(recapitulatif[i])));
		}*/
		assertEquals("Dépôt de garantie", browserStackLocaldriver.findElement(By.xpath("//subscription-full-recap/div/div/recap-products/div[3]/div/div[1]")).getText());
		assertEquals("75€", browserStackLocaldriver.findElement(By.xpath("//subscription-full-recap/div/div/recap-products/div[3]/div/div[2]")).getText());
		assertEquals("OFFERT", browserStackLocaldriver.findElement(By.xpath("//subscription-full-recap/div/div/recap-products/div[4]/div/div[2]")).getText());
		assertEquals("Récapitulatif", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		Thread.sleep(5000);
		valider();
	}
	public void page_recapitulatif_TNT() throws InterruptedException {
		/*for (int i = 0; i < recapitulatif.length; i++) {
			assertTrue(isElementPresent(By.cssSelector(recapitulatif[i])));
		}*/
		assertEquals("Dépôt de garantie", browserStackLocaldriver.findElement(By.xpath("//subscription-full-recap/div/div/recap-products/div[3]/div/div[1]")).getText());
		assertEquals("75€", browserStackLocaldriver.findElement(By.xpath("//subscription-full-recap/div/div/recap-products/div[3]/div/div[2]")).getText());
		assertEquals("OFFERT", browserStackLocaldriver.findElement(By.xpath("//subscription-full-recap/div/div/recap-products/div[4]/div/div[2]")).getText());
		assertEquals("Récapitulatif", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		Thread.sleep(5000);
		valider();
	}
	@Et("^Validation du recapitulatif du récap matériel <operateur>$")
	public void page_recapitulatif_fai() throws InterruptedException {
		valider();
	}
	
	@Et("^Validation du paiement par CB (.*) IBAN$")
	public void page_paiement(String iban) throws InterruptedException {
		assertEquals("Paiement", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		/* IBAN */
		System.out.println("valeur iban:"+iban.toString());
		if(iban.equals("avec")) {
			browserStackLocaldriver.findElement(By.linkText("Régler mon abonnement par IBAN")).click();
			browserStackLocaldriver.findElement(By.id("iban")).clear();
			browserStackLocaldriver.findElement(By.id("iban")).sendKeys(ConstantsWebElement.generateIban());
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
	
	@Alors("^Validation du formulaire$")
	public void valider() throws InterruptedException {
		browserStackLocaldriver.findElement(By.cssSelector(continuer)).click();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		Thread.sleep(8000);
	}
	
	public void annule_modification_adresse() {
		assertEquals("MyCanal - Souscrire - Livraison", browserStackLocaldriver.getTitle());
		switchBrowser(By.linkText("Modifier l'adresse"));
		//browserStackLocaldriver.findElement(By.linkText("Modifier l'adresse")).click();
		browserStackLocaldriver.findElement(By.linkText("Annuler")).click();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
	}
	
	public void page_felicitation() {
		assertEquals("MyCanal - Souscrire - Félicitations", browserStackLocaldriver.getTitle());
		// Vérifier l'adresse de livraison
		//verifier que l'offre de 
	}
	
	@Alors("^Retour à la page mode de livraison$")
	public void retour_page_precedente() {
		browserStackLocaldriver.findElement(By.cssSelector("button.button.button-back")).click();
	}
	
}
