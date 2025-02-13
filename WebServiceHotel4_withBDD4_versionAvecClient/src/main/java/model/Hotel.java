package model;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Hotel {
	@XmlElement
	private int idHotel;
	@XmlElement
	private String nom;
	@XmlElement
	private Adresse adresse;
	@XmlElement
	private int nombreEtoiles;
	@XmlElementWrapper(name = "chambres")
	@XmlElement(name = "chambre")
	private ArrayList<Chambre> chambres = new ArrayList<>();

	public Hotel() {
        this.chambres = new ArrayList<>();
    }
	
	public Hotel(int id, String nom, Adresse adresse, int nombreEtoiles) {
        this.idHotel = id;
        this.setNom(nom);
		this.setAdresse(adresse);
		this.setNombreEtoiles(nombreEtoiles);
		this.chambres = new ArrayList<>();
    }
	
	public Hotel(int id, String nom, int nombreEtoiles) {
        this.idHotel = id;
        this.setNom(nom);
		this.setAdresse(null);
		this.setNombreEtoiles(nombreEtoiles);
		this.chambres = new ArrayList<>();
    }

    public Hotel(int id, String nom, Adresse adresse, int nombreEtoiles, ArrayList<Chambre> chambres) {
        this.idHotel = id;
        this.setNom(nom);
		this.setAdresse(adresse);
		this.setNombreEtoiles(nombreEtoiles);
        this.chambres = (chambres != null) ? chambres : new ArrayList<>();
    }

	// Modification de la méthode toString()
    @Override
	public String toString() {
		return "ID : " + this.idHotel + ", Nom de l'hôtel : " + this.getNom() + ", Adresse : " + this.getAdresse().toString()
				+ ", Nombre d'étoiles : " + this.getNombreEtoiles() + ", Nombre de chambres disponible : "
				+ this.getNombreChambresDisponible();
    }

	// Pour récupérer l'id' de l'hotel
	@XmlTransient
	public int getId() {
		return this.idHotel;
	}

	// Pour récupérer le nom de l'hotel
	@XmlTransient
	public String getNom() {
		return this.nom;
	}
	
	// Pour modifier le nom de l'hotel
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// Pour récupérer l'adresse de l'hotel
	@XmlTransient
	public Adresse getAdresse() {
		return this.adresse;
	}
	
	// Pour modifier l'adresse de l'hotel
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	// Pour récupérer le nombre d'étoiles
	@XmlTransient
	public int getNombreEtoiles() {
		return this.nombreEtoiles;
	}
	
	// Pour modifier le nombre d'étoiles
	public void setNombreEtoiles(int nombreEtoiles) {
		if (nombreEtoiles >= 0 && nombreEtoiles <= 5) {
			this.nombreEtoiles = nombreEtoiles;
		}
	}

	@XmlTransient
	public ArrayList<Chambre> getChambres() {
	    return chambres;
	}
	
	// Pour retourner la liste des chambres de l'hotel
	@XmlTransient
	public ArrayList<Chambre> getToutesLesChambres() {
    	return chambres;
    }
	
	// Pour retourner la liste des chambres de l'hotel
	@XmlTransient
	public ArrayList<Chambre> getToutesLesChambresDisponible() {
    	ArrayList<Chambre> chambresDispo = new ArrayList<Chambre>();
		for (Chambre c: getToutesLesChambres()) {
			if (c.getDisponible()) {
				chambresDispo.add(c);
			}
		}
    	return chambresDispo;
    }
	
	// Pour le nombre de chambre dispo
	@XmlTransient
	public int getNombreChambresDisponible() {
		int count = 0;
		for (Chambre c: getToutesLesChambres()) {
			if (c.getDisponible()) {
				count = count + 1;
			}
		}
    	return count;
    }
	
	// Pour ajouter une chambre dans l'hotel
	public void ajouterChambre(Chambre chambre) {
		boolean booleanNumero = true;
		for (Chambre c: chambres) {
			if (c.getNumeroChambre() == chambre.getNumeroChambre()) {
				booleanNumero = false;
				System.out.println("Numéro de chambre déjà existant");
			}
		}
		if (booleanNumero == true) {
			chambres.add(chambre);
		}
	}
}