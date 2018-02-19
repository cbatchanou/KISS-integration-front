package fr.canalplus.front.bdd.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
	
	@Et("^L'on renseigne le numéro de matériel (.*?)$")
	public void formulaireOperateursFai(@Transform(OperateurTransformer.class)OperateurEnum operateurEnum) {
		MaterialNumber material = materialContext().findMaterial(refOperateur(operateurEnum.toString()));
		inputMaterial(material.getNumeroSerie());
	}

	@Alors("^Valider donc le formulaire$")
	public void valider_le_formulaire() throws InterruptedException {
		browserStackLocaldriver.findElement(By.cssSelector(continuer)).click();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		Thread.sleep(8000);
	}

	public void click_sur_conditionsGenerales(String selector) {
		switchBrowser(selector);
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
		valider_le_formulaire();
		
	}
	
	@Et("^Saisir le cas d'un nom invalide et d'un téléphone valide: (.*); (.*)$")
	public void formulaire_recap_nom_invalide(String name, String phone) throws InterruptedException {
		inputName(name);
		inputPhone(phone);
		valider_le_formulaire();
		assertTrue(ConstantsWebElement.NOM_INVALIDE, isElementPresent(By.xpath("//subscription-full-material/div/div[3]/p[1]")));		
	}
	
	@Et("^Saisir le cas d'un nom valide et d'un téléphone invalide: (.*); (.*)$")
	public void formulaire_recap_phone_invalide(String name, String phone) throws InterruptedException {
		inputName(name);
		inputPhone(phone);
		valider_le_formulaire();
		assertTrue(ConstantsWebElement.TELEPHONE_INVALIDE, isElementPresent(By.xpath("//subscription-full-material/div/div[3]/p[2]")));		
	}
	
	@Et("^Saisir le cas d'un materiel vide et invalide: (.*); (.*); (.*)$")
	public void formulaire_recap_materiel_invalide(String name, String phone, String materiel) throws InterruptedException {
		inputName(name);
		inputPhone(phone);
		tooltip_info();
		
		if(materiel.equals("") || materiel==null) {
			valider_le_formulaire();
			assertTrue(ConstantsWebElement.MATERIEL_VIDE, isElementPresent(By.xpath("//subscription-full-material/div/div[3]p[3]")));
			Thread.sleep(3000);
		}
		else {
			inputMaterial(materiel);
			valider_le_formulaire();
			waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
			assertTrue(ConstantsWebElement.MATERIEL_INVALIDE, isElementPresent(By.xpath("//subscription-full-material/div/div[3]p[3]")));
		}
		
		assertEquals("MyCanal - Souscrire - Matériel", browserStackLocaldriver.getTitle());
		Thread.sleep(3000);
	}
	
	@Et("^Saisir le cas d'un nom et d'un téléphone vides $")
	public void formulaire_recap_invalide(String name, String phone) throws InterruptedException {
		valider_le_formulaire();
		assertTrue(ConstantsWebElement.NOM_INVALIDE, isElementPresent(By.xpath("//subscription-full-material/div/div[3]/p[1]")));		
		assertTrue(ConstantsWebElement.TELEPHONE_INVALIDE, isElementPresent(By.xpath("//subscription-full-material/div/div[3]/p[2]")));		
		Thread.sleep(3000);
	}
	
	
	
	
	@Et("^Verifier les messages d'erreurs$")
	public void messageErreurIdentification() {
		assertEquals("Erreur d'identification", browserStackLocaldriver.findElement(By.id("errorTitle")).getText());
		assertEquals("Merci de verifier votre email et votre mot de passe", browserStackLocaldriver.findElement(By.id("errorText")).getText());
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
	
	public void tooltip_info() {
		assertTrue(isElementPresent(By.xpath("//div/div[2]/div[2]/input-tooltipped/div/div[2]/div[1]/i")));
		assertTrue(isElementPresent(By.xpath("//div/div[2]/div[1]/div[2]/input-tooltipped/div/div[2]/div[1]/i")));
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
