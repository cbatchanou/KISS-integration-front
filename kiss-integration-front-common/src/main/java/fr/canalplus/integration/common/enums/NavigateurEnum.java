package fr.canalplus.integration.common.enums;

public enum NavigateurEnum {

	CHROME("CHROME"),
	FIREFOX("FIREFOX"),
	IE("INTERNET EXPLORER"),
	SAFARI("SAFARI"),
	EDGE("EDGE"),
	ANDROID("ANDROID");
	
	private final String Label;
	
	public String getLabel() {
		return Label;
	}

	NavigateurEnum(String navigateur){
	this.Label = navigateur;	
	}
	
	public static NavigateurEnum fromLabel(String lbl) {
		for(NavigateurEnum navigateur: NavigateurEnum.values()) {
			if(navigateur.getLabel().equalsIgnoreCase(lbl)) {
				return navigateur;
			}
		}
		throw new IllegalArgumentException(String.format("Le libellé ne correspond à aucun type ", lbl));
	}
}
