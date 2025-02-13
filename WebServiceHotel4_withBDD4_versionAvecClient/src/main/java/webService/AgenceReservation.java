package webService;

import java.util.ArrayList;
import java.util.Date;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import model.*;

@WebService
public interface AgenceReservation {
    @WebMethod
    ArrayList<Hotel> voirListeHotel();
    @WebMethod
    ArrayList<Chambre> voirListeChambres(@WebParam(name = "idHotel") int idHotel);
    @WebMethod
    ArrayList<Client> voirListeClient();
    @WebMethod
    ArrayList<Reservation> voirListeReservation();
    @WebMethod
    String ajouterClient(@WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom,
                         @WebParam(name = "dateNaissance") Date dateNaissance, @WebParam(name = "carteCredit") String carteCredit);
    @WebMethod
    String faireReservation(@WebParam(name = "nomHotel") String nomHotel, @WebParam(name = "numeroChambre") int numeroChambre,
                            @WebParam(name = "dateDebut") Date dateDebut, @WebParam(name = "dateFin") Date dateFin,
                            @WebParam(name = "nomClient") String nomClient, @WebParam(name = "prenomClient") String prenomClient,
                            @WebParam(name = "dateNaissance") Date dateNaissance, @WebParam(name = "carteCredit") String carteCredit,
                            @WebParam(name = "nomAgence") String nomAgence, @WebParam(name = "nombrePersonnes") int nombrePersonnes);
    @WebMethod
    String annulerReservation(@WebParam(name = "idReservation") int idReservation);
    @WebMethod
    public ArrayList<Hotel> rechercherDispo(@WebParam(name = "ville") String ville, @WebParam(name = "dateArrivee") Date dateArrivee,
            @WebParam(name = "dateDepart") Date dateDepart, @WebParam(name = "prixMin") double prixMin,
            @WebParam(name = "prixMax") double prixMax, @WebParam(name = "nombreEtoiles") int nombreEtoiles,
            @WebParam(name = "nombrePersonnes") int nombrePersonnes);
    @WebMethod
    public AgencePartenaire connexionAgence(@WebParam(name = "login") String login, @WebParam(name = "motDePasse") String motDePasse);
}