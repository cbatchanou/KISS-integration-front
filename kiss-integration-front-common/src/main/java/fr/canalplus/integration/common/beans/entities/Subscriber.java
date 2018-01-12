package fr.canalplus.integration.common.beans.entities;

/**
 * @author cbatchanou
 *
 */
public class Subscriber {

	private Integer numAbo;
	private String nom;
	private String prenom;
	private Integer civility;
	private String adresse;
	
	private Integer codepostal;
	private String ville;
	private String phone;
	private String email;
	
	
	public Subscriber(Integer numAbo) {
		this.numAbo = numAbo;
	}
	

	public Subscriber() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getNumAbo() {
		return numAbo;
	}


	public void setNumAbo(Integer numAbo) {
		this.numAbo = numAbo;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Integer getCivility() {
		return civility;
	}


	public void setCivility(Integer civility) {
		this.civility = civility;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public Integer getCodepostal() {
		return codepostal;
	}


	public void setCodepostal(Integer codepostal) {
		this.codepostal = codepostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}
	
	
	public void  setEmail(String email) {
		this.email = email;
	}
	
}
