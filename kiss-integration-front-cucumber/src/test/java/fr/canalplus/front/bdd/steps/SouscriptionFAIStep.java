package fr.canalplus.front.bdd.steps;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;

import cucumber.api.Transform;
import cucumber.api.java.fr.Lorsque;
import fr.canalplus.front.bdd.steps.base.BaseIntegration;
import fr.canalplus.front.bdd.transformer.OperateurTransformer;
import fr.canalplus.integration.common.enums.OperateurEnum;

public class SouscriptionFAIStep extends BaseIntegration {

	@Lorsque("^L'on clique sur materiel (.*?)$")
	public void click_sur_materiel(@Transform(OperateurTransformer.class) OperateurEnum operateurEnum)
			throws InterruptedException, IOException {
		switchBrowser(By.xpath(getOperateur(operateurEnum.toString())));
		assertEquals("MyCanal - Souscrire - Matériel", browserStackLocaldriver.getTitle());
		Thread.sleep(5000);
	}
}
