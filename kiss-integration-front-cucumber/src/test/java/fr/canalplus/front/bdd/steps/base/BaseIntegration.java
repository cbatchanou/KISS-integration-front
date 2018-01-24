package fr.canalplus.front.bdd.steps.base;

import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import fr.canalplus.front.bdd.DBConfig;
import fr.canalplus.front.bdd.ModuleConfig;

@ContextConfiguration(classes = {ModuleConfig.class, DBConfig.class})
public abstract class BaseIntegration {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseIntegration.class);

	@Autowired
	@Qualifier("browserStackLocalDriver")
	public WebDriver browserStackLocaldriver;
	
	/*@Autowired
	@Qualifier("chromeDriver")
	public WebDriver driver;*/
	
	@Autowired
	public URI siteCanal;
	
	public static AbstractApplicationContext context;
	
	public Properties property;
	
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
	
	@FindBy(css="span.price-footer")
	public String prix;
	
	public void listElementOf(String prefix){
		property = new Properties();
		for (Entry<Object, Object> entry : property.entrySet())
	    {
			if(entry.getKey().toString().startsWith(prefix))
			assertTrue(isElementPresent(By.xpath(entry.getValue().toString())));
	    }
	}
	
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
	
	public void getPageUrl() {
		browserStackLocaldriver.manage().deleteAllCookies();
		browserStackLocaldriver.get(siteCanal.toString());
		browserStackLocaldriver.get("https://boutique-recette.mycanal.fr/souscrire/offre?propalId=000012242");
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
	}
	
	public String recupere_prix_offre() {
		String prix = browserStackLocaldriver.findElement(By.cssSelector("span.price-footer")).getText();
		return prix;
	}
	
	public String getPassword() {
		String pass = "";
		String possible = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for(int x = 0; x < 15; x++) {
			int i = (int) Math.floor(Math.random() * 62);
			pass += possible.charAt(i);
		}
		return pass;
	}
	public String getString() {
		String email = "";
		String possible = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for(int x = 0; x <8 ; x++) {
			int i = (int) Math.floor(Math.random() * 62);
			email += possible.charAt(i);
		}
		email += "@yopmail.com";
		return email;
	}
	public String getOperateur(String op) {
		switch(op.toString()) {
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
}
