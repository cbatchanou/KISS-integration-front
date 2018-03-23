package fr.canalplus.front.bdd.steps;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.openqa.selenium.support.ui.ExpectedConditions;
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

		assertEquals("MyCanal - Souscrire - Identification", browserStackLocaldriver.getTitle());
		assertEquals("Coordonnées", browserStackLocaldriver.findElement(By.cssSelector("li.done.active")).getText());
		/*
		 * if (!verifyElementAbsent(By.linkText("Ce n'est pas vous ?"))) {
		 * browserStackLocaldriver.findElement(By.linkText("Ce n'est pas vous ?")).click
		 * (); } Thread.sleep(5000);
		 */
		formulairePristine();
		inputCivility(civility);
		inputfield(org.openqa.selenium.By.id("firstName"), prenom);
		inputfield(org.openqa.selenium.By.id("lastName"), nom);
		inputfield(org.openqa.selenium.By.name("zipCode"), codeP);
		inputfield(org.openqa.selenium.By.id("streetName"), adresse);
		inputfield(org.openqa.selenium.By.id("mobile"), mobile);
		inputfield(org.openqa.selenium.By.id("email"), Constants.getString());
		inputfield(org.openqa.selenium.By.id("password"), Constants.getPassword());

		click_sur_conditionsGenerales(By.xpath(Constants.conditionsG));
		Thread.sleep(1000);
		browserStackLocaldriver
				.findElement(org.openqa.selenium.By.cssSelector("button.button.button-primary.ng-binding")).click();
		Thread.sleep(10000);

	}

	public void formulairePristine() {
		org.openqa.selenium.By lien = By.linkText("Ce n'est pas vous ?");
		// WebDriverWait wait = new WebDriverWait(browserStackLocaldriver, 5);
		Boolean notPresent = true;
		try {
			System.out.println("###########sdjh###############");
			notPresent = ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(lien))
					.apply(browserStackLocaldriver);
			browserStackLocaldriver.findElement(By.linkText("Ce n'est pas vous ?")).click();
			Thread.sleep(5000);
			browserStackLocaldriver.navigate().refresh();
			waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
			
			System.out.println("NotPresent:" + notPresent);
		} catch (Exception e) {
			System.out.println("Element absennt!");
		}

	}

	public boolean verifyElementAbsent(org.openqa.selenium.By by) {
		try {
			browserStackLocaldriver.findElement(by);
			System.out.println("Element Present");
			return false;

		} catch (NoSuchElementException e) {
			System.out.println("Element absent");
			return true;
		}
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
