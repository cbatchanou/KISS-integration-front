package fr.canalplus.front.bdd.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cucumber.api.Transform;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import fr.canalplus.front.bdd.ModuleConfig;
import fr.canalplus.front.bdd.steps.base.BaseIntegration;
import fr.canalplus.front.bdd.steps.base.Constants;
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

	@Et("^L'on verifie les messages d'erreurs affichés du nom invalide et du téléphone invalide$")
	public void nom_et_telephone_invalides() throws InterruptedException {
		Subscriber subscriber = subscriberContext().find(10214344);
		inputfield(org.openqa.selenium.By.id("name"), Constants.getPassword());
		inputfield(org.openqa.selenium.By.id("phone"), Constants.getString());
		confirmer();
		assertEquals("Veuillez saisir un nom valide",
				browserStackLocaldriver.findElement(By.xpath("//div[1]/div[3]/p[1]")).getText());
		assertEquals("Veuillez saisir un numéro de téléphone valide",
				browserStackLocaldriver.findElement(By.xpath("//div[1]/div[3]/p[2]")).getText());

		inputfield(org.openqa.selenium.By.id("name"), subscriber.getNom());
		confirmer();
		assertEquals("Veuillez saisir un numéro de téléphone valide",
				browserStackLocaldriver.findElement(By.xpath("//div[1]/div[3]/p[2]")).getText());
		inputfield(org.openqa.selenium.By.id("name"), Constants.getPassword());
		inputfield(org.openqa.selenium.By.id("phone"), subscriber.getPhone());

		confirmer();
		assertEquals("Veuillez saisir un nom valide",
				browserStackLocaldriver.findElement(By.xpath("//div[1]/div[3]/p[1]")).getText());
	}


	@Et("^L'on renseigne le numéro de matériel (.*?)$")
	public void formulaireOperateursFai(@Transform(OperateurTransformer.class) OperateurEnum operateurEnum) {
		MaterialNumber material = materialContext().findMaterial(Constants.refOperateur(operateurEnum.toString()));
		inputfield(org.openqa.selenium.By.id("numMaterial"), material.getNumeroSerie());
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
		Thread.sleep(5000);
	}

	@Et("^L'on renseigne les champs nom et téléphone$")
	public void input_name_and_phone() throws InterruptedException {
		Subscriber subscriber = subscriberContext().find(10214344);
		inputfield(org.openqa.selenium.By.id("name"), subscriber.getNom());
		inputfield(org.openqa.selenium.By.id("phone"), subscriber.getPhone());
		confirmer();
	}

	@Et("^Renseigner un (.*) et un (.*)$")
	public void identifiez_vous(String email, String password) throws InterruptedException {
		browserStackLocaldriver.findElement(By.cssSelector("input#sso-email")).clear();
		browserStackLocaldriver.findElement(By.cssSelector("input#sso-email")).sendKeys(email);

		browserStackLocaldriver.findElement(By.id("sso-pass")).clear();
		browserStackLocaldriver.findElement(By.id("sso-pass")).sendKeys(password);
		click_sur_reCAPTCHA();
		confirmer();

	}

	@Et("^Saisir le cas d'un nom invalide et d'un téléphone valide: (.*); (.*)$")
	public void formulaire_recap_nom_invalide(String name, String phone) throws InterruptedException {
		inputfield(org.openqa.selenium.By.id("name"), name);
		inputfield(org.openqa.selenium.By.id("phone"), phone);

		confirmer();
		assertTrue(Constants.NOM_INVALIDE, isElementPresent(By.xpath("//subscription-full-material/div/div[3]/p[1]")));
	}

	@Et("^Saisir le cas d'un nom valide et d'un téléphone invalide: (.*); (.*)$")
	public void formulaire_recap_phone_invalide(String name, String phone) throws InterruptedException {
		inputfield(org.openqa.selenium.By.id("name"), name);
		inputfield(org.openqa.selenium.By.id("phone"), phone);
		confirmer();
		assertTrue(Constants.TELEPHONE_INVALIDE,
				isElementPresent(By.xpath("//subscription-full-material/div/div[3]/p[2]")));
	}

	@Et("^Saisir le cas d'un materiel vide et invalide: (.*); (.*); (.*)$")
	public void formulaire_recap_materiel_invalide(String name, String phone, String materiel)
			throws InterruptedException {
		inputfield(org.openqa.selenium.By.id("name"), name);
		inputfield(org.openqa.selenium.By.id("phone"), phone);
		tooltip_info();

		if (materiel.equals("") || materiel == null) {
			confirmer();
			assertTrue(Constants.MATERIEL_VIDE,
					isElementPresent(By.xpath("//subscription-full-material/div/div[3]p[3]")));
			Thread.sleep(3000);
		} else {
			inputfield(org.openqa.selenium.By.id("numMaterial"), materiel);
			confirmer();
			waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
			assertTrue(Constants.MATERIEL_INVALIDE,
					isElementPresent(By.xpath("//subscription-full-material/div/div[3]p[3]")));
		}

		assertEquals("MyCanal - Souscrire - Matériel", browserStackLocaldriver.getTitle());
		Thread.sleep(3000);
	}

	@Et("^Saisir le cas d'un nom et d'un téléphone vides $")
	public void formulaire_recap_invalide(String name, String phone) throws InterruptedException {
		confirmer();
		assertTrue(Constants.NOM_INVALIDE, isElementPresent(By.xpath("//subscription-full-material/div/div[3]/p[1]")));
		assertTrue(Constants.TELEPHONE_INVALIDE,
				isElementPresent(By.xpath("//subscription-full-material/div/div[3]/p[2]")));
		Thread.sleep(3000);
	}

	@Et("^Verifier les messages d'erreurs$")
	public void messageErreurIdentification() {
		assertEquals("Erreur d'identification", browserStackLocaldriver.findElement(By.id("errorTitle")).getText());
		assertEquals("Merci de verifier votre email et votre mot de passe",
				browserStackLocaldriver.findElement(By.id("errorText")).getText());
	}

	public void tooltip_info() {
		assertTrue(isElementPresent(By.xpath("//div/div[2]/div[2]/input-tooltipped/div/div[2]/div[1]/i")));
		assertTrue(isElementPresent(By.xpath("//div/div[2]/div[1]/div[2]/input-tooltipped/div/div[2]/div[1]/i")));
	}
}
