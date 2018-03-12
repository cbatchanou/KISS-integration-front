package fr.canalplus.front.bdd.steps;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Value;

import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Lorsque;
import fr.canalplus.front.bdd.steps.base.BaseIntegration;
import fr.canalplus.front.bdd.steps.base.Constants;
import net.serenitybdd.core.annotations.findby.By;

public class CoordonneesStep extends BaseIntegration {

	@Value("${civility.male}")
	private String civilityM;

	@Value("${civility.female}")
	private String civilityF;

	@Alors("^Création d'une personne avec les données: (\\d+), (.*), (.*), (\\d+), (.*), (.*)$")
	public void formulaireCreationDeCompte(int civility, String prenom, String nom, int codeP, String adresse,
			String mobile) throws InterruptedException {

		if (isElementPresent(By.cssSelector("h2.large"))) {
			switchBrowser(By.linkText("Ce n'est pas vous ?"));
			waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		}

		inputCivility(civility);
		inputfield(org.openqa.selenium.By.id("firstName"), prenom);
		inputfield(org.openqa.selenium.By.id("lastName"), nom);
		inputfield(org.openqa.selenium.By.name("zipCode"), codeP);
		inputfield(org.openqa.selenium.By.id("streetName"), adresse);
		inputfield(org.openqa.selenium.By.id("mobile"), mobile);
		inputfield(org.openqa.selenium.By.id("email"), Constants.getString());
		inputfield(org.openqa.selenium.By.id("password"), Constants.getPassword());

		assertEquals("MyCanal - Souscrire - Identification", browserStackLocaldriver.getTitle());
		assertEquals("Coordonnées", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		click_sur_conditionsGenerales(By.xpath(Constants.conditionsG));
		valider();
		Thread.sleep(5000);

	}

	@Lorsque("^L'on créé une personne avec les données: (\\d+), (.*), (.*), (.*)$")
	public void formulaireCreationDeCompte1mois(int civility, String prenom, String nom, String mobile) {
		inputCivility(civility);
		inputfield(org.openqa.selenium.By.id("firstName"), prenom);
		inputfield(org.openqa.selenium.By.id("lastName"), nom);
		inputfield(org.openqa.selenium.By.id("mobile"), mobile);
	}


	public void inputCivility(Integer civility) {
		if (civility == 1) {
			browserStackLocaldriver.findElement(org.openqa.selenium.By.xpath(civilityM)).click();
		} else
			browserStackLocaldriver.findElement(org.openqa.selenium.By.xpath(civilityF)).click();
	}

}
