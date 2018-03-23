package fr.canalplus.front.bdd.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cucumber.api.Transform;
import cucumber.api.java.fr.Et;
import fr.canalplus.front.bdd.ModuleConfig;
import fr.canalplus.front.bdd.steps.base.BaseIntegration;
import fr.canalplus.front.bdd.steps.base.Constants;
import fr.canalplus.front.bdd.transformer.OperateurTransformer;
import fr.canalplus.integration.bdd.DBConfig;
import fr.canalplus.integration.common.beans.entities.MaterialNumber;
import fr.canalplus.integration.common.enums.OperateurEnum;
import fr.canalplus.integration.common.services.interfaces.MaterialNumberService;

public class SouscriptionFAIStep extends BaseIntegration {

	public static MaterialNumberService materialContext() {
		context = new AnnotationConfigApplicationContext(ModuleConfig.class, DBConfig.class);
		return context.getBean(MaterialNumberService.class);
	}

	@Et("^Que l'on clique sur le materiel (.*?)$")
	public void ChoixMateriel(@Transform(OperateurTransformer.class) OperateurEnum operateurEnum) {
		assertEquals("CANAL BOUTIQUE - Souscrire - Matériel", browserStackLocaldriver.getTitle());
		assertEquals("Matériel",
				browserStackLocaldriver.findElement(By.cssSelector("div.breadcrumb_step.ng-scope.active")).getText());
		browserStackLocaldriver.findElement(By.cssSelector(getOperateur(operateurEnum.toString()))).click();
		assertTrue(isElementPresent(By.name("ispForm")));

		if (operateurEnum.toString().equals("ORANGE")) {
			assertTrue(isElementPresent(By.xpath(
					"/html/body/div[2]/div/div/ui-view/div/form/div[1]/div[2]/input-tooltipped/div/div[2]/div[1]/i")));
			assertTrue(isElementPresent(By
					.xpath("/html/body/div[2]/div/div/ui-view/div/form/div[2]/input-tooltipped/div/div[2]/div[1]/i")));
		} else if (operateurEnum.toString().equals("FREE") || operateurEnum.toString().equals("BOUYGUES")) {
			assertTrue(isElementPresent(By.xpath(
					"/html/body/div[2]/div/div/ui-view/div/form/div[1]/div[2]/input-tooltipped/div/div[2]/div[1]/i")));

		} else {
			assertTrue(isElementPresent(By
					.xpath("/html/body/div[2]/div/div/ui-view/div/form/div[1]/input-tooltipped/div/div[2]/div[1]/i")));
		}

	}

	@Et("^En remplissant le formulaire (.*): (.*), (.*) et n°materiel$")
	public void input_name_and_phone(@Transform(OperateurTransformer.class) OperateurEnum operateurEnum, String nom,
			String mobile) throws InterruptedException {

		if (operateurEnum.toString().equals("ORANGE") || operateurEnum.toString().equals("FREE")
				|| operateurEnum.toString().equals("BOUYGUES")) {
			inputfield(org.openqa.selenium.By.name("name"), nom);
			inputfield(org.openqa.selenium.By.name("phoneNumber"), mobile);
		}
		if (operateurEnum.toString().equals("ORANGE") || operateurEnum.toString().equals("SFR")
				|| operateurEnum.toString().equals("NUMERICABLE") || operateurEnum.toString().equals("AUTRE")) {
			MaterialNumber material = materialContext().findMaterial(Constants.refOperateur(operateurEnum.toString()));
			inputfield(org.openqa.selenium.By.name("equipmentNumber"), material.getNumeroSerie());
		}
		confirmer();
		Thread.sleep(1000);
		waitForElementIsInvisible(By.cssSelector("div[class='spinner']"));
		if (operateurEnum.toString().equals("NUMERICABLE") || operateurEnum.toString().equals("AUTRE")) {
			confirmer();
			Thread.sleep(5000);
		}
	}
}
