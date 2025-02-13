package model;

import java.util.Date;
import java.text.SimpleDateFormat;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Reservation {
	@XmlElement
	private int idReservation;
	@XmlElement
	private Hotel hotel;
	@XmlElement
	private Chambre chambre;
	@XmlElement
	private Date dateArrivee;
	@XmlElement
	private Date dateDepart;
	@XmlElement
	private Client client;
	@XmlElement
	private AgencePartenaire agence;
	@XmlElement
	private int nombrePersonnes;
	@XmlElement
	private int nombreNuits;
	@XmlElement
	private double prixTotal;

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {};
	
	public Reservation(int idReservation, Hotel hotel, Chambre chambre, Date dateArrivee, Date dateDepart, Client client, AgencePartenaire agence, int nombrePersonnes) {
		this.idReservation = idReservation;
		this.setHotel(hotel);
		this.setChambre(chambre);
		this.setDateArrivee(dateArrivee);
		this.setDateDepart(dateDepart);
		this.setClient(client);
		this.setAgence(agence);
		this.setNombrePersonnes(nombrePersonnes);
		this.prixTotal = calculerPrixTotal();
		this.nombreNuits = calculerNombreNuits();
	}
	
	public Reservation(Hotel hotel, Chambre chambre, Date dateArrivee, Date dateDepart, Client client, AgencePartenaire agence, int nombrePersonnes) {
		this.setHotel(hotel);
		this.setChambre(chambre);
		this.setDateArrivee(dateArrivee);
		this.setDateDepart(dateDepart);
		this.setClient(client);
		this.setAgence(agence);
		this.setNombrePersonnes(nombrePersonnes);
		this.prixTotal = calculerPrixTotal();
		this.nombreNuits = calculerNombreNuits();
	}

	// Modification de la méthode toString()
	public String toString() {
		return "Réservation ID : " + idReservation + ", Hotel : " + this.getHotel().getNom() + ", Chambre : " + this.getChambre().getNumeroChambre()
				+ ", Nombre de nuits : " + this.calculerNombreNuits()
				+ ", Date d'arrivée : " + DATE_FORMAT.format(this.getDateArrivee()) + ", Date de départ : "
				+ DATE_FORMAT.format(this.getDateDepart()) + ", Client : " + this.getClient().getNom() + " "
				+ this.getClient().getPrenom() + ", Prix total : " + String.format("%.2f", this.getPrixTotal());
	}

	@XmlTransient
	public int getIdReservation() {
		return this.idReservation;
	}

	// Pour récupérer l'hotel
	@XmlTransient
	public Hotel getHotel() {
		return hotel;
	}

	// Pour modifier l'hotel
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	// Pour récupérer la chambre
	@XmlTransient
	public Chambre getChambre() {
		return chambre;
	}

	// Pour modifier la chambre
	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}
	
	// Pour récupérer la date d'arrivée
	@XmlTransient
	public Date getDateArrivee() {
		return dateArrivee;
	}

	// Pour modifier la date d'arrivée
	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	
	// Pour récupérer la date de départ
	@XmlTransient
	public Date getDateDepart() {
		return dateDepart;
	}

	// Pour modifier la date de départ
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	
	// Pour récupérer le client
	@XmlTransient
	public Client getClient() {
		return client;
	}

	// Pour modifier le client
	public void setClient(Client client) {
		this.client = client;
	}

	// Pour récupérer le prix total
	@XmlTransient
	public double getPrixTotal() {
		return prixTotal;
	}

	@XmlTransient
	public AgencePartenaire getAgence() {
		return agence;
	}

	public void setAgence(AgencePartenaire agence) {
		this.agence = agence;
	}

	@XmlTransient
	public int getNombrePersonnes() {
		return this.nombrePersonnes;
	}

	public void setNombrePersonnes(int nombrePersonnes) {
		this.nombrePersonnes = nombrePersonnes;
	}

	/*
	// Si besoin pour modifier le prix total
	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}
	*/

	// Pour calculer le prix avec la reduction éventuelle de l'agence partenaire
	public double calculerPrixTotal() {
        long dureeSejour = (dateDepart.getTime() - dateArrivee.getTime()) / (1000 * 60 * 60 * 24);
        return (dureeSejour * chambre.getTarif()) * ((100 - agence.getTauxReduction()) /100);
    }

	// Pour calculer le nombre de nuits
	public int calculerNombreNuits() {
		long difference = dateDepart.getTime() - dateArrivee.getTime();
	    return (int) (difference / (1000 * 60 * 60 * 24));
	}

	public int nombreNuits() {
		return nombreNuits;
	}
		
}
