package model;

import java.util.Date;
import java.text.SimpleDateFormat;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Client {
	private int idClient;
	@XmlElement
	private String nom;
	@XmlElement
	private String prenom;
	@XmlElement
	private Date dateNaissance;
	// A sécuriser ??
	@XmlElement
	private String carteDeCredit;
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	public Client() {};
	
	public Client(String nom, String prenom, Date dateNaissance, String carteDeCredit) {
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setDateNaissance(dateNaissance);
		this.setCarteDeCredit(carteDeCredit);
	}
	
	// Avec carte de crédit
	public Client(int idClient, String nom, String prenom, Date dateNaissance, String carteDeCredit) {
		this.idClient = idClient;
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setDateNaissance(dateNaissance);
		this.setCarteDeCredit(carteDeCredit);
	}
	
	// Modification de la méthode toString()
	public String toString() {
		return "ID: " + idClient + ", Nom : " + this.getNom() + ", Prénom : " + this.getPrenom() + ", Date de Naissance : "
	+ DATE_FORMAT.format(this.getDateNaissance()) + ", Carte de crédit : " + this.getCarteDeCredit();
	}

	// Pour récupérer l'ID du client
	@XmlTransient
	public int getId() {
		return this.idClient;
	}
	
	// Pour récupérer le nom du client
	@XmlTransient
	public String getNom() {
		return this.nom;
	}
	
	// Pour modifier le nom du client
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// Pour récupérer le prénom du client
	@XmlTransient
	public String getPrenom() {
		return this.prenom;
	}
	
	// Pour modifier le prénom du client
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	// Pour récupérer la date de naissance du client
	@XmlTransient
	public Date getDateNaissance() {
		return this.dateNaissance;
	}
	
	// Pour modifier la date de naissance du client
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	// Carte de crédit ??
	@XmlTransient
	public String getCarteDeCredit() {
		return this.carteDeCredit;
	}
	
	public void setCarteDeCredit(String carteDeCredit) {
		this.carteDeCredit = carteDeCredit;
	}
	
}
