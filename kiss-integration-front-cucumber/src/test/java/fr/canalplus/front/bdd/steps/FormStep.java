package fr.canalplus.front.bdd.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import cucumber.api.Transform;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import fr.canalplus.front.bdd.ModuleConfig;
import fr.canalplus.front.bdd.steps.base.BaseIntegration;
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
	
	private static final String REF_ORANGE = "33RZ1";
	private static final String REF_SFR = "081FF2";
	private static final String REF_FREE = "044FF1";
	private static final String REF_BBOX = "085MF1";
	private static final String REF_NUMERICABLE = "038MF1";
	
	
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

	@Et("^L'on renseigne les champs nom et téléphone$")
	public void input_name_and_phone() {
		Subscriber subscriber = subscriberContext().find(10214344);
		inputName(subscriber.getNom());
		inputPhone(subscriber.getPhone());
	}
	@Et("^L'on verifie les messages d'erreurs affichés du nom invalide et du téléphone invalide$")
	public void nom_et_telephone_invalides() throws InterruptedException {
		Subscriber subscriber = subscriberContext().find(10214344);
		inputName(getPassword()); inputPhone(getString());
		valider_le_formulaire();
		assertEquals("Veuillez saisir un nom valide", browserStackLocaldriver.findElement(By.xpath("//div[1]/div[3]/p[1]")).getText());
		assertEquals("Veuillez saisir un numéro de téléphone valide", browserStackLocaldriver.findElement(By.xpath("//div[1]/div[3]/p[2]")).getText());
		
		inputName(subscriber.getNom());
		valider_le_formulaire();
		assertEquals("Veuillez saisir un numéro de téléphone valide", browserStackLocaldriver.findElement(By.xpath("//div[1]/div[3]/p[2]")).getText());
		
		inputName(getPassword()); inputPhone(subscriber.getPhone());
		valider_le_formulaire();
		assertEquals("Veuillez saisir un nom valide", browserStackLocaldriver.findElement(By.xpath("//div[1]/div[3]/p[1]")).getText());
	}
	
	public void hitbox() {
		assertTrue(isElementPresent(By.cssSelector("tooltip-hitbix-info")));
	}

	@Et("^L'on renseigne le numéro de matériel (.*?)$")
	public void formulaireOperateursFai(@Transform(OperateurTransformer.class)OperateurEnum operateurEnum) {
		MaterialNumber material = materialContext().findMaterial(refOperateur(operateurEnum.toString()));
		inputMaterial(material.getNumeroSerie());
	}

	@Alors("^Valider donc le formulaire$")
	public void valider_le_formulaire() throws InterruptedException {
		browserStackLocaldriver.findElement(By.cssSelector(continuer)).click();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		Thread.sleep(5000);
	}

	public void click_sur_conditionsGenerales(String selector) {
		WebElement element = browserStackLocaldriver.findElement(org.openqa.selenium.By.xpath(selector));
		Actions clickerConditions = new Actions(browserStackLocaldriver);
		clickerConditions.moveToElement(element, 0, 0).click().perform();
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
	}
	
	@Et("^Renseigner un (.*) et un (.*) <status>$")
	public void identifiez_vous(String email, String password) throws InterruptedException {
		
		browserStackLocaldriver.findElement(By.id("sso-email")).clear();
		browserStackLocaldriver.findElement(By.id("sso-email")).sendKeys(email);
		
		browserStackLocaldriver.findElement(By.id("sso-pass")).clear();
		browserStackLocaldriver.findElement(By.id("sso-pass")).sendKeys(password);
		click_sur_reCAPTCHA();
		valider_le_formulaire();
		
	}
	@Et("^Verifier les messages d'erreurs$")
	public void messageErreurIdentification() {
		assertEquals("Erreur d'identification", browserStackLocaldriver.findElement(By.id("errorTitle")).getText());
		assertEquals("Merci de verifier votre email et votre mot de passe", browserStackLocaldriver.findElement(By.id("errorText")).getText());
	}
	
	public void verification_elements_presents() {
		
	}

	@Alors("^Je créé une personne avec les données: (\\d+), (.*), (.*), (\\d+), (.*), (.*), (.*), (.*)$")
	public void formulaireCreationDeCompte(int civility, String prenom, String nom, int codeP, String adresse, String mobile, String email, String mdp ) {
		inputCivility(civility);
		inputFirstName(prenom); inputLastName(nom);
		inputZipCode(codeP); inputAdress(adresse);
		inputMobile(mobile); inputEmail(email);
		click_sur_conditionsGenerales(conditionsG);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public void Verifier_les_elements_de_la_page() {

	}
	public String refOperateur(String op) {
		switch(op.toString()) {
		case "BOUYGUES":
			op = REF_BBOX;
			break;
		case "FREE":
			op = REF_FREE;
			break;
		case "ORANGE":
			op = REF_ORANGE;
			break;
		case "SFR":
			op = REF_SFR;
			break;
		case "NUMERICABLE":
			op = REF_NUMERICABLE;
			break;
		case "AUTRE":
			op = REF_BBOX;
			break;
		}	
	return op;
		
	}
}
