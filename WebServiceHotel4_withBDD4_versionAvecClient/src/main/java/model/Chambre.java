package model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Chambre {
	private int idChambre;
	@XmlElement
    private int numeroChambre;
	@XmlElement
    private int nombreLits;
	@XmlElement
    private double tarif;
	@XmlElement
    private boolean disponible;
	@XmlElement
	private Hotel hotel;
	@XmlElement
	private String imageUrl;

	public Chambre() {};
    
    public Chambre(int idChambre, int numeroChambre, int nombreLits, double tarif, boolean disponible, String imageUrl) {
        this.idChambre = idChambre;
        this.setNumeroChambre(numeroChambre);
		this.setnombreLits(nombreLits);
		this.setTarif(tarif);
		this.setDisponible(disponible);
		this.setImageUrl(imageUrl);
    }
	
	// Modification de la méthode toString()	
	@Override
    public String toString() {
        return "Chambre [id=" + idChambre + ", numéro=" + this.getNumeroChambre() + 
               ", lits=" + this.getnombreLits() + ", tarif=" + this.getTarif() + 
               ", disponible=" + this.getDisponible() + "]";
    }

	@XmlTransient
	public int getIdChambre() {
		return idChambre;
	}
	
	// Pour récupérer le numéro de la chambre
	@XmlTransient
	public int getNumeroChambre() {
		return numeroChambre;
	}
	
	// Si besoin pour modifier le numéro de la chambre
	public void setNumeroChambre(int numeroChambre) {
		if (numeroChambre > 0) {
			this.numeroChambre = numeroChambre;
		}
	}
	
	// Pour récupérer le nombre de lits dans la chambre
	@XmlTransient
	public int getnombreLits() {
		return nombreLits;
	}
	
	// Si besoin pour modifier le nombre de lits dans la chambre
	public void setnombreLits(int nombreLits) {
		if (nombreLits > 0) {
			this.nombreLits = nombreLits;
		}
	}
	
	// Pour récupérer le tarif de la chambre
	@XmlTransient
	public double getTarif() {
		return tarif;
	}
	
	// Pour modifier le tarif de la chambre
	public void setTarif(double tarif) {
		if (tarif > 0) {
			this.tarif = tarif;
		}
	}
	
	// Pour voir si la chambre est disponible
	@XmlTransient
	public boolean getDisponible() {
		return disponible;
	}
	
	// Pour modifier la disponibilité de la chambre
	public void setDisponible(boolean bool) {
		this.disponible = bool;
	}

	// Pour voir la photo de la chambre
	@XmlTransient
	public String getImageUrl() {
		return this.imageUrl;
	}

	// Pour modifier la photo de la chambre
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
