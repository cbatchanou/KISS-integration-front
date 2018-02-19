package fr.canalplus.front.bdd.transformer;

import cucumber.api.Transformer;
import fr.canalplus.integration.common.enums.NavigateurEnum;

public class NavigateurTransformer extends Transformer<NavigateurEnum>{

	@Override
	public NavigateurEnum transform(String value) {
		return NavigateurEnum.fromLabel(value);
	}

}
