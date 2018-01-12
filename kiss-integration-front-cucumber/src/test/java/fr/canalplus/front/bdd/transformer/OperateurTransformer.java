package fr.canalplus.front.bdd.transformer;

import cucumber.api.Transformer;
import fr.canalplus.integration.common.enums.OperateurEnum;

public class OperateurTransformer extends Transformer<OperateurEnum>{

	@Override
	public OperateurEnum transform(String value) {
		return OperateurEnum.fromLabel(value);
	}

}
