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
	
	@Value("#{'${elements.recapitulatif}'.split(',')}")
	public String[] recapitulatif; 

	@Value("${link.decodeurCompatible}")
	public String link_decodeur_compatible;

	@Value("${link.decodeurCanal}")
	public String link_decodeur_canal;

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
		WebDriverWait wait = new WebDriverWait(browserStackLocaldriver, 60);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}

	/*public void getPageUrl(String propalId) {
		browserStackLocaldriver.manage().deleteAllCookies();
		browserStackLocaldriver.get(siteCanal.toString());
		browserStackLocaldriver.get("https://boutique-recette.mycanal.fr/souscrire/offre?propalId=" + propalId);
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
	}*/
	
	public void getPageUrl() throws InterruptedException {
		browserStackLocaldriver.manage().deleteAllCookies();
		browserStackLocaldriver.get(siteCanal.toString());
		browserStackLocaldriver.get("https://boutique-dev.mycanal.fr/subscribe/offer/select-material/000012242");
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		Thread.sleep(5000);
	}

	public void getPageUrl(String propalId) throws InterruptedException {
		browserStackLocaldriver.manage().deleteAllCookies();
		browserStackLocaldriver
				.get(siteCanal.toString());
		if (browserName.equals("chrome")) {
			browserStackLocaldriver.get("https://boutique-recette.mycanal.fr/souscrire/offre?propalId=" + propalId);
		} else {
			browserStackLocaldriver.navigate().to(browserStackLocaldriver.getCurrentUrl());
		}
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		Thread.sleep(5000);
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


	public void confirmer() throws InterruptedException {
		// switchBrowser(By.cssSelector(Constants.confirmer));
		browserStackLocaldriver.findElement(By.className(Constants.confirmer)).click();
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
			op = Constants.BOUYGUES;
			break;
		case "FREE":
			op = Constants.FREE;
			break;
		case "ORANGE":
			op = Constants.ORANGE;
			break;
		case "SFR":
			op = Constants.SFR;
			break;
		case "NUMERICABLE":
			op = Constants.NUMERICABLE;
			break;
		case "AUTRE":
			op = Constants.AUTRE;
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
		WebElement element;
		Actions clickerElement;
		switch (browserName) {
		case "chrome":
			element = browserStackLocaldriver.findElement(locator);
			clickerElement = new Actions(browserStackLocaldriver);
			clickerElement.moveToElement(element, 0, 0).click().perform();
			break;
		case "firefox":
			browserStackLocaldriver.findElement(locator).click();
			break;
		case "IE":
			element = browserStackLocaldriver.findElement(locator);
			clickerElement = new Actions(browserStackLocaldriver);
			clickerElement.moveToElement(element, 0, 0).click().perform();
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
