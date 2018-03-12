package fr.canalplus.front.bdd.steps.base;

import java.net.URI;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.ContextConfiguration;

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

	public void getPageUrl(String propalId) {
		browserStackLocaldriver.manage().deleteAllCookies();
		browserStackLocaldriver.get(siteCanal.toString());
		browserStackLocaldriver.get("https://boutique-recette.mycanal.fr/souscrire/offre?propalId=" + propalId);
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
	}

	public void ClearBrowserCache() throws InterruptedException {
		browserStackLocaldriver.manage().getCookies().clear();
		browserStackLocaldriver.manage().getCookies();
		Thread.sleep(5000);
	}

	public void prix_offre() {
	}

	public void detail_panier() throws InterruptedException {
	}

	public void inputfield(org.openqa.selenium.By by, Object field) {
		browserStackLocaldriver.findElement(by).clear();
		browserStackLocaldriver.findElement(by).sendKeys(field.toString());
	}


	public void valider() throws InterruptedException {
		browserStackLocaldriver.findElement(By.cssSelector(continuer)).click();
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		Thread.sleep(5000);
	}

	public void retour() {
		browserStackLocaldriver.findElement(By.cssSelector("button.button.button-back")).click();
	}
	
	public void click_sur_conditionsGenerales(org.openqa.selenium.By locator) {
		switchBrowser(locator);
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
