package fr.canalplus.integration.common.enums;

public enum OperateurEnum {

	BOUYGUES("BOUYGUES"),
	FREE("FREE"),
	ORANGE("ORANGE"),
	SFR("SFR"),
	NUMERICABLE("NUMERICABLE"),
	AUTRE("AUTRE");
	
	private final String Label;
	
	public String getLabel() {
		return Label;
	}

	OperateurEnum(String operateur){
	this.Label = operateur;	
	}
	
	public static OperateurEnum fromLabel(String lbl) {
		for(OperateurEnum operateur: OperateurEnum.values()) {
			if(operateur.getLabel().equalsIgnoreCase(lbl)) {
				return operateur;
			}
		}
		throw new IllegalArgumentException(String.format("Le libellé ne correspond à aucun type ", lbl));
	}
}
