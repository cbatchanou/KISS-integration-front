package fr.canalplus.front.bdd.steps.base;

import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import fr.canalplus.front.bdd.ModuleConfig;
import fr.canalplus.integration.bdd.DBConfig;

@ContextConfiguration(classes = { ModuleConfig.class, DBConfig.class })
public abstract class BaseIntegration {

	/*@Autowired
	@Qualifier("chromeDriver")
	public WebDriver driver;*/
	
	@Autowired
	@Qualifier("browserStackLocalDriver")
	public WebDriver browserStackLocaldriver;
	
	@Autowired
	@Qualifier("capabilities")
	public DesiredCapabilities capabilities;

	@Autowired
	public URI siteCanal;

	public static AbstractApplicationContext context;

	public Properties property;

	@Value("${environment.single.browser}")
	public String browserName;
	
	@Value("${materiel.bbox}")
	public String bbox;

	@Value("${materiel.orange}")
	public String orange;

	@Value("${materiel.free}")
	public String free;

	@Value("${materiel.sfr}")
	public String sfr;

	@Value("${materiel.numericable}")
	public String numericable;

	@Value("${materiel.autre}")
	public String autre;

	@Value("${materiel.smartTV}")
	public String smartTV;

	@Value("${materiel.cartesat}")
	public String cartesat;

	@Value("${materiel.cartetnt}")
	public String cartetnt;

	@Value("${button.back}")
	public String back;

	@Value("${button.continuer}")
	public String continuer;

	@Value("#{'${elements.decodeursCanal}'.split(',')}")
	public String[] elementsDECC;

	@Value("#{'${elements.tnt}'.split(',')}")
	public String[] elementsTNT;

	@Value("#{'${elements.head}'.split(',')}")
	public String[] eltHead;

	@Value("#{'${elements.footer}'.split(',')}")
	public String[] eltFooter;
	
	@Value("#{'${elements.livraisonRetraitBoutique}'.split(',')}")
	public String[] retrait_boutique; 

	@Value("#{'${elements.livraisonDomicile}'.split(',')}")
	public String[] livraison_domicile;
	
	@Value("#{'${elements.recapitulatif}'.split(',')}")
	public String[] recapitulatif; 
	
	@Value("${link.decodeurCompatible}")
	public String link_decodeur_compatible;

	@Value("${link.decodeurCanal}")
	public String link_decodeur_canal;

	@Value("${link.voirledetail}")
	public String link_voir_le_detail;

	@Value("${link.modalitesOffre}")
	public String link_modalite_offre;

	@Value("${materiel.DecodeurCanal}")
	public String decodeur_canal;

	@Value("${materiel.LeCube}")
	public String le_cube;
	
	@Value("${materiel.LeCube}")
	public String reCAPTCHA;


	public boolean isElementPresent(By by) {
		try {
			browserStackLocaldriver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void waitForElementIsInvisible(By by) {
		WebDriverWait wait = new WebDriverWait(browserStackLocaldriver, 40);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public void waitForElementIsVisible(By by) {
		WebDriverWait wait = new WebDriverWait(browserStackLocaldriver, 40);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}

	public void getPageUrl() {
		browserStackLocaldriver.manage().deleteAllCookies();
		browserStackLocaldriver.get(siteCanal.toString());
		browserStackLocaldriver.get("https://boutique-recette.mycanal.fr/souscrire/offre?propalId=000012242");
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
	}

	public String getPassword() {
		String pass = "";
		String possible = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		for (int x = 0; x < 15; x++) {
			int i = (int) Math.floor(Math.random() * 62);
			pass += possible.charAt(i);
		}
		return pass;
	}

	public String getString() {
		String email = "";
		String possible = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		for (int x = 0; x < 8; x++) {
			int i = (int) Math.floor(Math.random() * 62);
			email += possible.charAt(i);
		}
		email += "@yopmail.com";
		return email;
	}

	
	public String getOperateur(String op) {
		switch (op.toString()) {
		case "BOUYGUES":
			op = bbox;
			break;
		case "FREE":
			op = free;
			break;
		case "ORANGE":
			op = orange;
			break;
		case "SFR":
			op = sfr;
			break;
		case "NUMERICABLE":
			op = numericable;
			break;
		case "AUTRE":
			op = autre;
			break;
		}

		return op;

	}
	/* METHODE QUI RENVOIE LA REFERENCE DU TYPE DE MATERIEL PRECISE*/
	public String refOperateur(String op) {
		switch(op.toString()) {
		case "BOUYGUES":
			op = ConstantsWebElement.REF_BBOX;
			break;
		case "FREE":
			op = ConstantsWebElement.REF_FREE;
			break;
		case "ORANGE":
			op = ConstantsWebElement.REF_ORANGE;
			break;
		case "SFR":
			op = ConstantsWebElement.REF_SFR;
			break;
		case "NUMERICABLE":
			op = ConstantsWebElement.REF_NUMERICABLE;
			break;
		case "AUTRE":
			op = ConstantsWebElement.REF_BBOX;
			break;
		}	
	return op;
		
	}
	
	/*
	 * cette methode permet de switcher entre les navigateurs. 
	 * Le code n'etant pas pareil pour tous les navigateurs, 
	 * cette methode me permet d'executer le code specifique pour X si le navigateur est X.  
	 * 
	 * */
	public void switchBrowser(By locator) {
		
		switch (browserName) {
		case "chrome":
			WebElement element = browserStackLocaldriver.findElement(locator);
			Actions clickerElement = new Actions(browserStackLocaldriver);
			clickerElement.moveToElement(element, 0, 0).click().perform();
			break;
		case "firefox":
			browserStackLocaldriver.findElement(locator).click();
			break;
		case "IE":
			browserStackLocaldriver.findElement(locator).click();
			break;
		case "safari":
			browserStackLocaldriver.findElement(locator).click();
			break;
		case "edge":
			browserStackLocaldriver.findElement(locator).click();
			break;
		}
	}
}
