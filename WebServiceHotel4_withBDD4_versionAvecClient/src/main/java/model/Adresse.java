package model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Adresse {
	private int idAdresse;
	@XmlElement
	private String pays;
	@XmlElement
	private int codePostal;
	@XmlElement
	private String ville;
	@XmlElement
	private String numeroEtRue;
	@XmlElement
	private String lieuDit;
	@XmlElement
	private String coordonneesGPS;
	
	public Adresse() {};

	// Pour créer une adresse sans le lieu dit et les coordonnéés GPS
	public Adresse(String pays, int codePostal, String ville, String numeroEtRue) {
		this.setPays(pays);
		this.setCodePostal(codePostal);
		this.setVille(ville);
		this.setNumeroEtRue(numeroEtRue);
		// Initialiser lieuDit et coordonneesGPS à NULL
		this.setLieuDit(null);
		this.setCoordonneesGPS(null);
	}
	
	// Pour créer une adresse avec le lieu dit et les coordonnéés GPS
	public Adresse(int IdAdresse, String pays, int codePostal, String ville, String numeroEtRue, String lieuDit, String coordonneesGPS) {
		this.idAdresse = idAdresse;
		this.setPays(pays);
		this.setCodePostal(codePostal);
		this.setVille(ville);
		this.setNumeroEtRue(numeroEtRue);
		this.setLieuDit(lieuDit);
		this.setCoordonneesGPS(coordonneesGPS);
	}
	
	// Modification de la méthode toString()
	public String toString() {
		return "Pays : " + this.getPays() + ", Code postal : " + this.getCodePostal() + ", Ville : " + this.getVille() + ", Numéro et rue : "
				+ this.getNumeroEtRue() + ", Lieu dit : " + this.getLieuDit() + ", Coordonnées GPS : " + this.getCoordonneesGPS();
	}
	
	// Pour récupérer le pays de l'hotel
	@XmlTransient
	public String getPays() {
		return this.pays;
	}
	
	// Pour modifier le pays de l'hotel
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	// Pour récupérer le code postal de l'hotel
	@XmlTransient
	public int getCodePostal() {
		return this.codePostal;
	}
	
	// Pour modifier le code postal de l'hotel
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	
	// Pour récupérer la ville de l'hotel
	@XmlTransient
	public String getVille() {
		return this.ville;
	}
	
	// Pour modifier la ville de l'hotel
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	// Pour récupérer le numéro et la rue de l'hotel
	@XmlTransient
	public String getNumeroEtRue() {
		return this.numeroEtRue;
	}
	
	// Pour modifier le numéro et la rue de l'hotel
	public void setNumeroEtRue(String numeroEtRue) {
		this.numeroEtRue = numeroEtRue;
	}
	
	// Pour récupérer le lieu dit de l'hotel
	@XmlTransient
	public String getLieuDit() {
		return this.lieuDit;
	}
	
	// Pour modifier le lieu dit de l'hotel
	public void setLieuDit(String lieuDit) {
		this.lieuDit = lieuDit;
	}
	
	// Pour récupérer les coordonnees GPS de l'hotel
	@XmlTransient
	public String getCoordonneesGPS() {
		return this.coordonneesGPS;
	}
	
	// Pour modifier les coordonnees GPS de l'hotel
	public void setCoordonneesGPS(String coordonneesGPS) {
		this.coordonneesGPS = coordonneesGPS;
	}
}
