package model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class AgencePartenaire {
	private int idAgencePartenaire;
	@XmlElement
	private String nom;
	@XmlElement
	private int tauxReduction;

	private String login;
	private String motDePasse;
	
	public AgencePartenaire () {}
	
	public AgencePartenaire (int idAgencePartenaire, String Nom, int tauxReduction) {
		this.idAgencePartenaire = idAgencePartenaire;
		this.setNom(Nom);
		this.setTauxReduction(tauxReduction);
	}

	public AgencePartenaire (int idAgencePartenaire, String Nom, int tauxReduction, String login, String motDePasse) {
		this.idAgencePartenaire = idAgencePartenaire;
		this.setNom(Nom);
		this.setTauxReduction(tauxReduction);
		this.setMotDePasse(motDePasse);
	}

	@XmlTransient
	public int getIdAgencePartenaire() {
		return this.idAgencePartenaire;
	}

	@XmlTransient
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@XmlTransient
	public double getTauxReduction() {
		return this.tauxReduction;
	}

	public void setTauxReduction(int tauxReduction) {
		if (tauxReduction >= 0 && tauxReduction <= 100) {
			this.tauxReduction = tauxReduction;
		}
	}

	@XmlTransient
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@XmlTransient
	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
}
