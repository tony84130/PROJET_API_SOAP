package service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import model.Adresse;
import model.AgencePartenaire;
import model.Chambre;
import model.Client;
import model.Hotel;
import model.Reservation;
import webService.AgenceReservation;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

import java.util.logging.Logger;

import config.BDDConnection;

@WebService(endpointInterface = "webService.AgenceReservation")
public class AgenceReservationImpl implements AgenceReservation{
	
	@WebMethod
	public ArrayList<Hotel> voirListeHotel() {
	    ArrayList<Hotel> hotels = new ArrayList<>();
	    String hotelQuery = "SELECT * FROM hotel INNER JOIN adresse ON hotel.id_adresse = adresse.id_adresse";
	    String chambreQuery = "SELECT c.* FROM chambre c INNER JOIN liste_chambres lc on c.id_chambre = lc.id_chambre INNER JOIN hotel h ON h.id_hotel = lc.id_hotel WHERE h.id_hotel = ?";

	    // Connexion à la BDD
	    try (Connection conn = BDDConnection.getConnection();
	         PreparedStatement hotelStmt = conn.prepareStatement(hotelQuery);
	         ResultSet hotelRs = hotelStmt.executeQuery()) {

	        while (hotelRs.next()) {
	            int idHotel = hotelRs.getInt("id_hotel");
	            String nomHotel = hotelRs.getString("nom_hotel");
	            int stars = hotelRs.getInt("nombre_etoiles");

	            // Récupération de l'adresse
	            String pays = hotelRs.getString("pays");
	            int codePostal = hotelRs.getInt("code_postal");
	            String ville = hotelRs.getString("ville");
	            String numeroRue = hotelRs.getString("numero_et_rue");
	            String lieuDit = hotelRs.getString("lieu_dit");
	            String coordGps = hotelRs.getString("coordonnees_gps");
	            Adresse adresse = new Adresse(idHotel, pays, codePostal, ville, numeroRue, lieuDit, coordGps);

	            // Création de l'hôtel
	            Hotel hotel = new Hotel(idHotel, nomHotel, adresse, stars);

	            // Récupération des chambres pour l'hôtel
	            try (PreparedStatement chambreStmt = conn.prepareStatement(chambreQuery)) {
	                chambreStmt.setInt(1, idHotel);
	                try (ResultSet chambreRs = chambreStmt.executeQuery()) {
	                    while (chambreRs.next()) {
	                        int idChambre = chambreRs.getInt("id_chambre");
	                        int numeroChambre = chambreRs.getInt("numero_chambre");
	                        int nombreLits = chambreRs.getInt("nombre_lits");
	                        double tarif = chambreRs.getDouble("tarif");
	                        boolean disponible = chambreRs.getBoolean("disponible");
                            String imageUrl = chambreRs.getString("image_url");

	                        Chambre chambre = new Chambre(idChambre, numeroChambre, nombreLits, tarif, disponible, imageUrl);
                            // Ajout des chambres à l'hôtel
                            hotel.ajouterChambre(chambre);
	                    }
	                }
	            }
	            // Ajout de l'hôtel avec ses chambres à la liste
	            hotels.add(hotel);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return hotels;
	}

    @WebMethod
    public ArrayList<Chambre> voirListeChambres(@WebParam(name = "idHotel") int idHotel) {
        ArrayList<Chambre> chambres = new ArrayList<>();
        String query = "SELECT c.* FROM chambre c INNER JOIN liste_chambres lc on c.id_chambre = lc.id_chambre INNER JOIN hotel h ON h.id_hotel = lc.id_hotel WHERE c.disponible = 1 AND h.id_hotel = ?";

        try (Connection conn = BDDConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idHotel);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idChambre = rs.getInt("id_chambre");
                int numeroChambre = rs.getInt("numero_chambre");
                int nombreLits = rs.getInt("nombre_lits");
                double tarif = rs.getDouble("tarif");
                boolean disponible = rs.getBoolean("disponible");
                String imageUrl = rs.getString("image_url");

                // Création de chambre
                Chambre chambre = new Chambre(idChambre, numeroChambre, nombreLits, tarif, disponible, imageUrl);
                chambres.add(chambre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return chambres;
    }

    @WebMethod
    public ArrayList<Client> voirListeClient() {
        ArrayList<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM client";

        try (Connection conn = BDDConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int idClient = rs.getInt("id_client");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                Date dateNaissance = rs.getDate("date_naissance");
                String carteCredit = rs.getString("carte_credit");

                Client client = new Client(idClient, nom, prenom, dateNaissance, carteCredit);
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @WebMethod
    public ArrayList<Reservation> voirListeReservation() {
        ArrayList<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservation " +
                       "INNER JOIN client ON reservation.id_client = client.id_client " +
                       "INNER JOIN hotel ON reservation.id_hotel = hotel.id_hotel " +
                       "INNER JOIN chambre ON reservation.id_chambre = chambre.id_chambre " +
                       "INNER JOIN agence_partenaire ON agence_partenaire.id_agence_part = reservation.id_agence_part";

        try (Connection conn = BDDConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int idReservation = rs.getInt("id_reservation");
                Date dateDebut = rs.getDate("date_arrivee");
                Date dateFin = rs.getDate("date_depart");

                // Client
                String clientNom = rs.getString("client.nom");
                String clientPrenom = rs.getString("client.prenom");

                // Hôtel
                String hotelNom = rs.getString("hotel.nom_hotel");
                int hotelEtoiles = rs.getInt("hotel.nombre_etoiles");

                // Chambre
                int chambreNumero = rs.getInt("chambre.numero_chambre");
                boolean chambreDisponible = rs.getBoolean("chambre.disponible");
                String imageUrl = rs.getString("chambre.image_url");
                int tarifChambre = rs.getInt("chambre.tarif");
                int nombresLits = rs.getInt("chambre.nombre_lits");
                
                // Agence
                String nomAgence = rs.getString("agence_partenaire.nom_agence");
                int tauxReduction = rs.getInt("agence_partenaire.taux_reduction");

                // Nombre de personnes
                int nombrePersonnes = rs.getInt("reservation.nombre_personnes");

                // Création des objets
                Client client = new Client(0, clientNom, clientPrenom, dateDebut, "");
                Hotel hotel = new Hotel(0, hotelNom, new Adresse(0, "", 0, "", "", "", ""), hotelEtoiles);
                Chambre chambre = new Chambre(0, chambreNumero, nombresLits, tarifChambre, chambreDisponible, imageUrl);
                AgencePartenaire agencePartenaire = new AgencePartenaire(0, nomAgence, tauxReduction);

                // Création de la réservation
                Reservation reservation = new Reservation(idReservation, hotel, chambre, dateDebut, dateFin, client, agencePartenaire, nombrePersonnes);
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    @WebMethod
    public String ajouterClient(@WebParam(name = "nom") String nom,
                                @WebParam(name = "prenom") String prenom,
                                @WebParam(name = "dateNaissance") java.util.Date dateNaissance,
                                @WebParam(name = "carteCredit") String carteCredit) {

        // Requêtes SQL pour vérifier les doublons et insérer un client
        String checkQuery = "SELECT COUNT(*) FROM client WHERE nom = ? AND prenom = ? AND date_naissance = ?";
        String insertQuery = "INSERT INTO client (nom, prenom, date_naissance, carte_credit) VALUES (?, ?, ?, ?)";

        try (Connection conn = BDDConnection.getConnection()) {
            // Vérification des doublons
            try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
                checkStmt.setString(1, nom);
                checkStmt.setString(2, prenom);
                checkStmt.setDate(3, new java.sql.Date(dateNaissance.getTime()));

                ResultSet rs = checkStmt.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    return "Un client avec les mêmes informations existe déjà.";
                }
            }

            // Insertion du client
            try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                insertStmt.setString(1, nom);
                insertStmt.setString(2, prenom);
                insertStmt.setDate(3, new java.sql.Date(dateNaissance.getTime()));
                insertStmt.setString(4, carteCredit);

                int rowsAffected = insertStmt.executeUpdate();
                if (rowsAffected > 0) {
                    return "Client ajouté avec succès !";
                } else {
                    return "Erreur lors de l'ajout du client.";
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Erreur lors de la connexion à la base de données ou de l'exécution des requêtes.";
        }
    }

    @WebMethod
    public String faireReservation(@WebParam(name = "nomHotel") String nomHotel, @WebParam(name = "numeroChambre") int numeroChambre,
                                   @WebParam(name = "dateDebut") Date dateDebut, @WebParam(name = "dateFin") Date dateFin,
                                   @WebParam(name = "nomClient") String nomClient, @WebParam(name = "prenomClient") String prenomClient,
                                   @WebParam(name = "dateNaissance") Date dateNaissance, @WebParam(name = "carteCredit") String carteCredit,
                                   @WebParam(name = "nomAgence") String nomAgence, @WebParam(name = "nombrePersonnes") int nombrePersonnes) {
        try (Connection conn = BDDConnection.getConnection()) {
            // Contrôle des dates
            if (dateDebut == null || dateFin == null) {
                return "Erreur : Les dates fournies sont invalides.";
            }
            if (dateFin.before(dateDebut) || dateFin.equals(dateDebut)) {
                return "Erreur : La date de départ doit être postérieure à la date d'arrivée.";
            }

            // Hôtel
            String hotelQuery = "SELECT * FROM hotel WHERE nom_hotel = ?";
            PreparedStatement hotelStmt = conn.prepareStatement(hotelQuery);
            hotelStmt.setString(1, nomHotel);
            ResultSet rsHotel = hotelStmt.executeQuery();

            if (rsHotel.next()) {
                int idHotel = rsHotel.getInt("id_hotel");

                // Chambre
                String chambreQuery = "SELECT c.* FROM chambre c INNER JOIN liste_chambres lc ON c.id_chambre = lc.id_chambre WHERE c.disponible = 1 AND c.numero_chambre = ? AND lc.id_hotel = ?";
                PreparedStatement chambreStmt = conn.prepareStatement(chambreQuery);
                chambreStmt.setInt(1, numeroChambre);
                chambreStmt.setInt(2, idHotel);
                ResultSet rsChambre = chambreStmt.executeQuery();

                if (!rsChambre.next()) {
                    return "Chambre non trouvée.";
                }

                Chambre chambre = new Chambre(
                    rsChambre.getInt("id_chambre"),
                    rsChambre.getInt("numero_chambre"),
                    rsChambre.getInt("nombre_lits"),
                    rsChambre.getDouble("tarif"),
                    rsChambre.getBoolean("disponible"),
                        rsChambre.getString("image_url")
                );

                if (rsChambre.getInt("nombre_lits") < nombrePersonnes) {
                    return "Erreur : La chambre sélectionnée ne peut pas accueillir " + nombrePersonnes + " personnes.";
                }

                // Vérification des disponibilités pour les dates demandées
                //String dispoQuery = "SELECT 1 FROM disponibilite WHERE id_chambre = ? AND ((date_debut < ? AND date_fin > ?) OR (date_debut < ? AND date_fin > ?))";
                String dispoQuery = "SELECT 1 FROM reservation WHERE id_chambre = ? AND ((date_arrivee < ? AND date_depart > ?) OR (date_arrivee < ? AND date_depart > ?))";
                //String dispoQuery = "SELECT 1 FROM reservation WHERE id_chambre = ? AND ((date_arrivee <= ? AND date_depart > ?) OR (date_arrivee < ? AND date_depart >= ?))";
                PreparedStatement dispoStmt = conn.prepareStatement(dispoQuery);
                dispoStmt.setInt(1, chambre.getIdChambre());
                dispoStmt.setDate(2, new java.sql.Date(dateFin.getTime()));
                dispoStmt.setDate(3, new java.sql.Date(dateDebut.getTime()));
                dispoStmt.setDate(4, new java.sql.Date(dateDebut.getTime()));
                dispoStmt.setDate(5, new java.sql.Date(dateFin.getTime()));
                ResultSet rsDispo = dispoStmt.executeQuery();

                if (rsDispo.next()) {
                    return "Erreur : La chambre numéro " + numeroChambre + " à l'hôtel " + nomHotel + " est déjà réservée pour les dates sélectionnées.";
                }

                // Client
                String clientQuery = "SELECT id_client, nom, prenom, date_naissance, carte_credit FROM client WHERE nom = ? AND prenom = ? AND date_naissance = ?";
                PreparedStatement clientStmt = conn.prepareStatement(clientQuery);
                clientStmt.setString(1, nomClient);
                clientStmt.setString(2, prenomClient);
                clientStmt.setDate(3, new java.sql.Date(dateNaissance.getTime()));
                ResultSet rsClient = clientStmt.executeQuery();

                // Récupération ou création du client
                Client client = null;
                if (!rsClient.next()) {
                    String clientInsertQuery = "INSERT INTO client (nom, prenom, date_naissance, carte_credit) VALUES (?, ?, ?, ?)";
                    PreparedStatement clientInsertStmt = conn.prepareStatement(clientInsertQuery, Statement.RETURN_GENERATED_KEYS);
                    clientInsertStmt.setString(1, nomClient);
                    clientInsertStmt.setString(2, prenomClient);
                    clientInsertStmt.setDate(3, new java.sql.Date(dateNaissance.getTime()));
                    clientInsertStmt.setString(4, carteCredit);
                    clientInsertStmt.executeUpdate();
                    ResultSet generatedKeys = clientInsertStmt.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        client = new Client(generatedKeys.getInt(1), nomClient, prenomClient, dateNaissance, carteCredit);
                    }
                } else {
                    client = new Client(rsClient.getInt("id_client"), rsClient.getString("nom"), rsClient.getString("prenom"), rsClient.getDate("date_naissance"), rsClient.getString("carte_credit"));
                }

                // Agence partenaire
                String agenceQuery = "SELECT * FROM agence_partenaire WHERE nom_agence = ?";
                PreparedStatement agenceStmt = conn.prepareStatement(agenceQuery);
                agenceStmt.setString(1, nomAgence);
                ResultSet rsAgence = agenceStmt.executeQuery();
                AgencePartenaire agencePartenaire = null;
                if (rsAgence.next()) {
                    agencePartenaire = new AgencePartenaire(rsAgence.getInt("id_agence_part"), rsAgence.getString("nom_agence"), rsAgence.getInt("taux_reduction"));
                }

                if (agencePartenaire == null) {
                    return "Agence partenaire non trouvée.";
                }

                // Hôtel
                Hotel hotel = new Hotel(idHotel, nomHotel, 0);

                // Création réservation
                Reservation reservation = new Reservation(hotel, chambre, dateDebut, dateFin, client, agencePartenaire, nombrePersonnes);

                // Récupération du prix total avec réduction de l'agence partenaire
                double prixTotal = reservation.calculerPrixTotal();

                // Insertion de la réservation dans la BDD
                String reservationQuery = "INSERT INTO reservation (id_hotel, id_chambre, date_arrivee, date_depart, id_client, id_agence_part, nombre_personnes, nombre_nuits, prix_total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement reservationStmt = conn.prepareStatement(reservationQuery);
                reservationStmt.setInt(1, idHotel);
                reservationStmt.setInt(2, chambre.getIdChambre());
                reservationStmt.setDate(3, new java.sql.Date(dateDebut.getTime()));
                reservationStmt.setDate(4, new java.sql.Date(dateFin.getTime()));
                reservationStmt.setInt(5, client.getId());
                reservationStmt.setInt(6, agencePartenaire != null ? agencePartenaire.getIdAgencePartenaire() : null);
                reservationStmt.setInt(7, nombrePersonnes);
                reservationStmt.setInt(8, reservation.calculerNombreNuits());
                reservationStmt.setDouble(9, prixTotal);
                reservationStmt.executeUpdate();

                /*
                // A garder ??
                // Ajout d'une table disponibilité au cas où pour faire une méthode qui recherche les périodes diponibles
                // Mise à jour de la table disponibilité
                String dispoInsertQuery = "INSERT INTO disponibilite (id_chambre, date_debut, date_fin) VALUES (?, ?, ?)";
                PreparedStatement dispoInsertStmt = conn.prepareStatement(dispoInsertQuery);
                dispoInsertStmt.setInt(1, chambre.getIdChambre());
                dispoInsertStmt.setDate(2, new java.sql.Date(dateDebut.getTime()));
                dispoInsertStmt.setDate(3, new java.sql.Date(dateFin.getTime()));
                dispoInsertStmt.executeUpdate();
                */

                return "Réservation effectuée avec succès!!!";
            } else {
                return "Hôtel non trouvé.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erreur lors de la réservation.";
        }
    }

    @WebMethod
    public String annulerReservation(@WebParam(name = "idReservation") int idReservation) {
        try (Connection conn = BDDConnection.getConnection()) {
            String clientQuery = "DELETE FROM reservation WHERE id_reservation = ?";
            PreparedStatement clientStmt = conn.prepareStatement(clientQuery);
            clientStmt.setInt(1, idReservation);

            int rowsAffected = clientStmt.executeUpdate();

            if (rowsAffected > 0) {
                return "Réservation annulée avec succès.";
            } else {
                return "Aucune réservation trouvée avec cet ID.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erreur lors de l'annulation.";
        }
    }

    // Seulement la ville, la date d'arrivée et la date de départ sont obligatoires
    @WebMethod
    public ArrayList<Hotel> rechercherDispo(@WebParam(name = "ville") String ville,
            @WebParam(name = "dateArrivee") Date dateArrivee, @WebParam(name = "dateDepart") Date dateDepart,
            @WebParam(name = "prixMin") double prixMin, @WebParam(name = "prixMax") double prixMax,
            @WebParam(name = "nombreEtoiles") int nombreEtoiles, @WebParam(name = "nombrePersonnes") int nombrePersonnes) {

        ArrayList<Hotel> hotels = new ArrayList<>();
        String query = "SELECT h.id_hotel, h.nom_hotel, h.nombre_etoiles, a.pays, a.ville, a.numero_et_rue, a.lieu_dit, a.coordonnees_gps, c.numero_chambre, c.nombre_lits, c.tarif, c.disponible, c.image_url " +
                "FROM hotel h " +
                "INNER JOIN adresse a ON h.id_adresse = a.id_adresse " +
                "INNER JOIN liste_chambres lc ON h.id_hotel = lc.id_hotel " +
                "INNER JOIN chambre c ON lc.id_chambre = c.id_chambre " +
                "WHERE a.ville = ? AND c.disponible = 1 " +
                "AND (? = 0 OR h.nombre_etoiles = ?) " +
                "AND ((? = 0 AND ? = 0) OR c.tarif BETWEEN ? AND ?) " +
                "AND (c.nombre_lits >= ? OR ? = 0)" +
                "AND c.id_chambre NOT IN ( " +
                "   SELECT r.id_chambre FROM reservation r WHERE (r.date_arrivee < ? AND r.date_depart > ?)) " +
                "GROUP BY h.id_hotel, c.id_chambre";

        try (Connection conn = BDDConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, ville);
            stmt.setObject(2, nombreEtoiles);
            stmt.setObject(3, nombreEtoiles);
            stmt.setObject(4, prixMin);
            stmt.setObject(5, prixMax);
            stmt.setObject(6, prixMin);
            stmt.setObject(7, prixMax);
            stmt.setInt(8, nombrePersonnes);
            stmt.setInt(9, nombrePersonnes);
            stmt.setDate(10, new java.sql.Date(dateDepart.getTime()));
            stmt.setDate(11, new java.sql.Date(dateArrivee.getTime()));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Hôtel
                int idHotel = rs.getInt("id_hotel");
                String nomHotel = rs.getString("nom_hotel");
                int etoiles = rs.getInt("nombre_etoiles");

                // Adresse
                String pays = rs.getString("pays");
                String adresseVille = rs.getString("ville");
                String numeroRue = rs.getString("numero_et_rue");
                String lieuDit = rs.getString("lieu_dit");
                String coordonneesGPS = rs.getString("coordonnees_gps");
                Adresse adresse = new Adresse(idHotel, pays, 0, adresseVille, numeroRue, lieuDit, coordonneesGPS);

                // Chambre
                int numeroChambre = rs.getInt("numero_chambre");
                int lits = rs.getInt("nombre_lits");
                double tarif = rs.getDouble("tarif");
                boolean disponible = rs.getBoolean("disponible");
                String imageUrl = rs.getString("image_url");

                // Création de l'hôtel
                Hotel hotel = new Hotel(idHotel, nomHotel, adresse, etoiles);
                hotel.ajouterChambre(new Chambre(0, numeroChambre, lits, tarif, disponible, imageUrl));

                // Ajout de l'hôtel à la liste
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotels;
    }

    @WebMethod
    public AgencePartenaire connexionAgence(@WebParam(name = "login") String login,
                                            @WebParam(name = "motDePasse") String motDePasse) {
        String query = "SELECT * FROM agence_partenaire WHERE login = ? AND mot_de_passe = ?";

        try (Connection conn = BDDConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, login);
            stmt.setString(2, motDePasse);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int idAgence = rs.getInt("id_agence_part");
                String nomAgence = rs.getString("nom_agence");
                int tauxReduction = rs.getInt("taux_reduction");

                return new AgencePartenaire(idAgence, nomAgence, tauxReduction, login, motDePasse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
