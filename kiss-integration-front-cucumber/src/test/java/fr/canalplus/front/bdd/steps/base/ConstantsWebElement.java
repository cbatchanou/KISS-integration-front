package fr.canalplus.front.bdd.steps.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ConstantsWebElement {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConstantsWebElement.class);
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
	
	
	public static final String breadcrum_main="/html/body/div[2]/ui-view/subscription-full/div/breadcrumb/div/div[2]/ul";  
	public static final String breadcrum_offre="/html/body/div[2]/ui-view/subscription-full/div/breadcrumb/div/div[2]/ul/li[1]";
	public static final String breadcrum_Materiel="/html/body/div[2]/ui-view/subscription-full/div/breadcrumb/div/div[2]/ul/li[2]";
	public static final String breadcrum_Coordonnees="/html/body/div[2]/ui-view/subscription-full/div/breadcrumb/div/div[2]/ul/li[3]";
	public static final String breadcrum_Livraison="/html/body/div[2]/ui-view/subscription-full/div/breadcrumb/div/div[2]/ul/li[4]";
	public static final String breadcrum_Recapitulatif="/html/body/div[2]/ui-view/subscription-full/div/breadcrumb/div/div[2]/ul/li[5]";
	public static final String breadcrum_paiement="/html/body/div[2]/ui-view/subscription-full/div/breadcrumb/div/div[2]/ul/li[6]";
	
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
	
	
}
