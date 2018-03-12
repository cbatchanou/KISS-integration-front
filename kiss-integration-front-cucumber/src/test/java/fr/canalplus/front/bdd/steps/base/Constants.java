package fr.canalplus.front.bdd.steps.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Constants {
	private static final Logger LOGGER = LoggerFactory.getLogger(Constants.class);
	public static final String DECODEUR_CANAL = "";
	public static final String DECODEUR_CANAL_CUBE = "";
	
	public static final String FAI_BOUYGUES = "";
	public static final String FAI_FREE = "";
	public static final String FAI_ORANGE = "";
	public static final String FAI_SFR = "";
	public static final String FAI_NUMERICABLE = "";
	public static final String FAI_AUTRE = "";
	
	public static final String FAI_SMARTTV = "";
	public static final String FAI_CARTESAT = "";
	public static final String FAI_CARTETNT = "";
	
	public static final String EN_SAVOIR_PLUS_DECODEURS_CANAL = "";
	public static final String EN_SAVOIR_PLUS_DECODEURS_COMPATIBLES = "";
	public static final String VOIR_MODALITES_OFFRE = "";
	public static final String VOIR_LE_DETAIL = "";
	
	public static final String[] PAGE_DECODEUR_CANAL = {"div.price-bloc","div.material.with-infos","",""};
	
	public static final String NOM_INVALIDE = "Veuillez saisir un nom valide";
	public static final String TELEPHONE_INVALIDE = "Veuillez saisir un numéro de téléphone valide";
	public static final String MATERIEL_INVALIDE = "Veuillez saisir votre numéro de matériel";
	public static final String MATERIEL_VIDE = "Votre numéro de matériel est invalide";
	
	public static final String REF_ORANGE = "33RZ1";
	public static final String REF_SFR = "081FF2";
	//public static final String[] REF_SFR = {"081FF2","062"};
	public static final String REF_FREE = "044FF1";
	public static final String REF_BBOX = "085MF1";
	public static final String REF_NUMERICABLE = "038MF1";
	
	public static final String PRIX_OFFRE_24CECS = "44,90€";
	
	public static final String breadcrum_main="/html/body/div[2]/ui-view/subscription-full/div/breadcrumb/div/div[2]/ul";  
	public static final String breadcrum_offre="/html/body/div[2]/ui-view/subscription-full/div/breadcrumb/div/div[2]/ul/li[1]";
	public static final String breadcrum_Materiel="/html/body/div[2]/ui-view/subscription-full/div/breadcrumb/div/div[2]/ul/li[2]";
	public static final String breadcrum_Coordonnees="/html/body/div[2]/ui-view/subscription-full/div/breadcrumb/div/div[2]/ul/li[3]";
	public static final String breadcrum_Livraison="/html/body/div[2]/ui-view/subscription-full/div/breadcrumb/div/div[2]/ul/li[4]";
	public static final String breadcrum_Recapitulatif="/html/body/div[2]/ui-view/subscription-full/div/breadcrumb/div/div[2]/ul/li[5]";
	public static final String breadcrum_paiement="/html/body/div[2]/ui-view/subscription-full/div/breadcrumb/div/div[2]/ul/li[6]";
	
	public static final String[] elementsPanierflottant = { "div.cart-footer-content", "a.show-modal",
			"span.price-footer" };
	public static final String[] elementsEntete = { "div.logo", "div.click-call", "div.secured-space" };
	public static final String[] elementsTNT24 = { "div.visuel", "span.free", "span.guarantee", "h1", "a",
			"span.price-footer", "a.show-modal", "div.offer-price.offer-price-no-promo" };
	// "div.offer-price-amount-container", "span.offer-price-promo",
	// "span;price-footer", "a.show-modal",
	// "div.offer-reco", "a" };
	public static final String[] elementsFelication = { "span.firstname", "span.email.strong",
			"button.button.button-primary" };
	public static final String lienVoirDetail = "/html/body/div[2]/ui-view/subscription-full/footer-cart/section/div/a";
	public static final String conditionsG = "/html/body/div[2]/ui-view/subscription-full/div/ui-view/subscription-full-auth/div/div/form/div[6]/label/div";
	public static String generateIban() {
        // TODO: a refaire
        StringBuilder iban = new StringBuilder();

        try {
            String country = "FR76";
            // code banque
            final int bankCode = 16906;
            // code guichet
            final long branchCode = 1010;
            // numero aleatoire pour le numero de compte
            final long accountNb1 = 10000000000L;
            final long accountNumber = (long) (Math.random() * accountNb1 + 1);
            // cle RIB
            final int bankParam1 = 97;
            final int bankParam2 = 89;
            final int branchParam1 = 15;
            final int branchParam2 = 3;

            String key = String.format("%02d",
                    bankParam1 - ((bankParam2 * (bankCode % bankParam1) + branchParam1 * (branchCode % bankParam1) + branchParam2 * (accountNumber % bankParam1)) % bankParam1));

            iban.append(country);
            iban.append(String.format("%05d", bankCode));
            iban.append(String.format("%05d", branchCode));
            iban.append(String.format("%011d", accountNumber));
            iban.append(key);

        } catch (NumberFormatException e) {
            LOGGER.error("Erreur Impossible de gÃ©nÃ©rer un IBAN. ", e);
        }
        return iban.toString();
    }

	public static String getPassword() {
		String pass = "";
		String possible = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		for (int x = 0; x < 15; x++) {
			int i = (int) Math.floor(Math.random() * 62);
			pass += possible.charAt(i);
		}
		return pass;
	}

	public static String getString() {
		String email = "";
		String possible = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		for (int x = 0; x < 8; x++) {
			int i = (int) Math.floor(Math.random() * 62);
			email += possible.charAt(i);
		}
		email += "@yopmail.com";
		return email;
	}
	
	public static String refOperateur(String op) {
		switch (op.toString()) {
		case "BOUYGUES":
			op = REF_BBOX;
			break;
		case "FREE":
			op = REF_FREE;
			break;
		case "ORANGE":
			op = REF_ORANGE;
			break;
		case "SFR":
			op = REF_SFR;
			break;
		case "NUMERICABLE":
			op = REF_NUMERICABLE;
			break;
		case "AUTRE":
			op = REF_BBOX;
			break;
		}
		return op;

	}
}
