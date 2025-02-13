// Pour générer les méthodes du wsdl
// wsimport -s ./src/main/java -d ./bin -p clientSoap http://localhost:8082/agencereservation?wsdl

package com.clientSOAP.clientWeb;

import clientSoap.*;
import clientSoap.AgencePartenaire;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class ClientWebApplication {
	// Fonction format date dd/MM/yyyy
	public static String convertMysqlDate(XMLGregorianCalendar xmlDate) {
		Date date = xmlDate.toGregorianCalendar().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(date);
	}

	public static void main(String[] args) {
		try {
			// URL du WSDL du service SOAP
			URL wsdlURL = new URL("http://localhost:8082/agencereservation?wsdl");

			QName serviceName = new QName("http://service/", "AgenceReservationImplService");
			Service service = Service.create(wsdlURL, serviceName);
			AgenceReservation client = service.getPort(AgenceReservation.class);

			// Scanner
			boolean scannerAgence = true;
			Scanner sc = new Scanner(System.in);

			boolean boolAgence = true;
			AgencePartenaire agence = null;

			while (boolAgence) {
				System.out.println("#################################################################");
				System.out.println();
				System.out.println("Veuillez vous connecter à votre agence.");
				System.out.println("Rentrez le login de l'agence : ");
				String login = sc.nextLine();
				System.out.println("Rentrez le mot de passe de l'agence : ");
				String motDePasse = sc.nextLine();

				try {
					// Création ConnexionAgence
					ConnexionAgence connexion = new ConnexionAgence();
					connexion.setLogin(login);
					connexion.setMotDePasse(motDePasse);

					// Vérif identifiants
					agence = client.connexionAgence(login, motDePasse);

					if (agence != null) {
						System.out.println();
						System.out.println("Connexion réussie !!");
						System.out.println("Bienvenue : " + agence.getNom());
						System.out.println("Votre pourcentage de réduction est de : " + agence.getTauxReduction() + " %.");
						System.out.println();
						System.out.println("#################################################################");
						boolAgence = false;
					} else {
						System.out.println("Identifiants incorrects. Veuillez réessayer.");
					}
				} catch (Exception e) {
					System.out.println("Erreur lors de la connexion : " + e.getMessage());
				}
			}

			// Affichage du menu principal
			System.out.println();
			System.out.println("#################################################################");
			System.out.println("#         BIENVENUE SUR LE SITE DE RÉSERVATION D'HÔTEL          #");
			System.out.println("#################################################################");
			System.out.println();
			System.out.println("   ➤ aide                : Pour afficher la liste des commandes");
			System.out.println("   ➤ fin                 : Pour quitter le programme");
			System.out.println();
			System.out.println("#################################################################");
			System.out.println();

			// Début boucle while
			while (scannerAgence) {
				String commandeUtilisateur = sc.next();
				System.out.println();

				// aide : Pour afficher les commandes disponibles
				if (commandeUtilisateur.equals("aide")) {
					System.out.println("#################################################################");
					System.out.println("#                       AIDE DU PROGRAMME                       #");
					System.out.println("#################################################################");
					System.out.println();
					System.out.println("   ➤ voirListeHotels       : Pour voir la liste des hôtels");
					System.out.println("   ➤ voirListeChambres     : Pour voir la liste des chambres d'un hôtel");
					System.out.println("   ➤ voirListeClients      : Pour voir la liste des clients");
					System.out.println("   ➤ voirListeReservations : Pour voir la liste des reservations");
					System.out.println();
					System.out.println("   ➤ RechercheDispo       : Pour faire une recherche des diponibilités");
					System.out.println("   ➤ faireReservation     : Pour faire une réservation sur le site");
					System.out.println("   ➤ annulerReservation   : Pour annuler une réservation sur le site");
					System.out.println("   ➤ AjouterClient        : Pour ajouter un client");
					System.out.println();
					System.out.println("   ➤ fin                  : Pour terminer le programme");
					System.out.println();
					System.out.println("#################################################################");
					continue;
				}
				// voirListeHotels : Pour voir la liste des hotels
				else if (commandeUtilisateur.equals("voirListeHotels")) {
					System.out.println("Liste des hôtels disponibles :");
					try {
						List<Hotel> hotels = client.voirListeHotel();
						for (Hotel hotel : hotels) {
							System.out.println("- ID: " + hotel.getIdHotel() + ", " + hotel.getNom() + " (" + hotel.getNombreEtoiles() + " étoiles)"
												+ ", Adresse : " + hotel.getAdresse().getNumeroEtRue() + ", " + hotel.getAdresse().getCodePostal()
												+ " " + hotel.getAdresse().getVille() + ", " + hotel.getAdresse().getPays());
						}
					} catch (Exception e) {
						System.out.println("Erreur lors de la récupération de la liste des hôtels : " + e.getMessage());
					}
				}
				// voirListeChambres : Pour voir la liste des chambres d'un hôtel
				else if (commandeUtilisateur.equals("voirListeChambres")) {
					System.out.println("Entrez l'id de l'hôtel :");
					int idHotel = sc.nextInt();
					try {
						List<Chambre> chambres = client.voirListeChambres(idHotel);
						System.out.println("Liste des chambres disponibles :");
						for (Chambre chambre : chambres) {
							System.out.println("- Chambre n°" + chambre.getNumeroChambre() + ", "
												+ chambre.getNombreLits() + " lits, Tarif : " + chambre.getTarif() + "€"
												//+ ", Disponibilité: " + chambre.isDisponible()
												+ ", Url de l'image : " + chambre.getImageUrl());
						}
					} catch (Exception e) {
						System.out.println("Erreur lors de la récupération des chambres : " + e.getMessage());
					}
				}
				// voirListeClients : Pour voir la liste des clients
				else if (commandeUtilisateur.equals("voirListeClients")) {
					System.out.println("Liste des clients enregistrés :");
					try {
						List<Client> clients = client.voirListeClient();
						for (Client c : clients) {
							System.out.println("- " + c.getNom() + " " + c.getPrenom()
												+ " : " + convertMysqlDate(c.getDateNaissance()));
						}
					} catch (Exception e) {
						System.out.println("Erreur lors de la récupération des clients : " + e.getMessage());
					}
				}
				// voirListeReservations : Pour voir la liste des reservations
				else if (commandeUtilisateur.equals("voirListeReservations")) {
					System.out.println("Liste des réservations :");
					try {
						List<Reservation> reservations = client.voirListeReservation();
						for (Reservation res : reservations) {
							System.out.println("- Réservation n°" + res.getIdReservation() + ", Hôtel : " + res.getHotel().getNom()
												+ ", Chambre n°: " + res.getChambre().getNumeroChambre()
												+ ", Date d'arrivée : " + convertMysqlDate(res.getDateArrivee()) + ", Date de départ : " + convertMysqlDate(res.getDateDepart())
												+ ", Client : " + res.getClient().getPrenom() +" "+res.getClient().getNom()
												+ ", Prix : " + res.getPrixTotal() + "€");
						}
					} catch (Exception e) {
						System.out.println("Erreur lors de la récupération des réservations : " + e.getMessage());
					}
				}
				// RechercheDispo : Pour faire une recherche des diponibilités
				else if (commandeUtilisateur.equals("RechercheDispo")) {
					System.out.println("Entrez la ville :");
					String ville = sc.next();

					System.out.println("Entrez la date d'arrivée (jj mm aaaa) :");
					int jourDateDebut = sc.nextInt();
					int moisDateDebut = sc.nextInt() - 1;
					int anneeDateDebut = sc.nextInt();
					sc.nextLine();
					GregorianCalendar calendar1 = new GregorianCalendar(anneeDateDebut, moisDateDebut, jourDateDebut);
					XMLGregorianCalendar dateDebut = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar1);

					System.out.println("Entrez la date de départ (jj mm aaaa) :");
					int jourDateFin = sc.nextInt();
					int moisDateFin = sc.nextInt() - 1;
					int anneeDateFin = sc.nextInt();
					sc.nextLine();
					GregorianCalendar calendar2 = new GregorianCalendar(anneeDateFin, moisDateFin, jourDateFin);
					XMLGregorianCalendar dateFin = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar2);

					System.out.println("Entrez le prix minimum : (Optionnel, entrez 0 pour ignorer)");
					int prixMin = sc.nextInt();
					System.out.println("Entrez le prix maximum : (Optionnel, entrez 0 pour ignorer)");
					int prixMax = sc.nextInt();
					System.out.println("Entrez le nombre d'étoiles : (Optionnel, entrez 0 pour ignorer)");
					int nbEtoiles = sc.nextInt();
					System.out.println("Entrez le nombre de personnes : (Optionnel, entrez 0 pour ignorer)");
					int nbPersonnes = sc.nextInt();

					try {
						List<Hotel> hotelsDispo = client.rechercherDispo(ville, dateDebut, dateFin, prixMin, prixMax, nbEtoiles, nbPersonnes);

						for (Hotel h : hotelsDispo) {
							System.out.println("- " + h.getNom() + " (" + h.getNombreEtoiles() + " étoiles)");

							// Récupération des chambres
							Hotel.Chambres chambres = h.getChambres();
							if (chambres == null || chambres.getChambre() == null || chambres.getChambre().isEmpty()) {
								System.out.println("  Aucune chambre disponible pour ces dates.");
							} else {
								List<Chambre> chambresDisponibles = chambres.getChambre();
								System.out.println("Liste des chambres disponibles :");
								for (Chambre c : chambresDisponibles) {
									if (c.isDisponible()) {
										System.out.println("  Chambre n°" + c.getNumeroChambre() +
												" - Nombre de lits : " + c.getNombreLits() +
												" - Prix : " + c.getTarif() + "€");
									}
								}
							}
						}
					} catch (Exception e) {
						System.out.println("Erreur lors de la recherche des disponibilités : " + e.getMessage());
					}
				}
				// faireReservation : Pour faire une réservation sur le site
				else if (commandeUtilisateur.equals("faireReservation")) {
					sc.nextLine();
					System.out.println("Entrez le nom de l'hôtel :");
					String nomHotel = sc.nextLine();
					System.out.println("Entrez le numéro de la chambre :");
					int numeroChambre = sc.nextInt();
					sc.nextLine();

					System.out.println("Entrez la date d'arrivée (jj mm aaaa) :");
					int jourDateDebut = sc.nextInt();
					int moisDateDebut = sc.nextInt() - 1;
					int anneeDateDebut = sc.nextInt();
					sc.nextLine();
					GregorianCalendar calendar1 = new GregorianCalendar(anneeDateDebut, moisDateDebut, jourDateDebut);
					XMLGregorianCalendar dateDebut = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar1);

					System.out.println("Entrez la date de départ (jj mm aaaa) :");
					int jourDateFin = sc.nextInt();
					int moisDateFin = sc.nextInt() - 1;
					int anneeDateFin = sc.nextInt();
					sc.nextLine();
					GregorianCalendar calendar2 = new GregorianCalendar(anneeDateFin, moisDateFin, jourDateFin);
					XMLGregorianCalendar dateFin = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar2);

					System.out.println("Entrez le nom du client :");
					String nomClient = sc.nextLine();
					System.out.println("Entrez le prénom du client :");
					String prenomClient = sc.nextLine();

					System.out.println("Entrez la date de naissance du client (jj mm aaaa) :");
					int jourNaissance = sc.nextInt();
					int moisNaissance = sc.nextInt() - 1;
					int anneeNaissance = sc.nextInt();
					sc.nextLine();
					GregorianCalendar calendar3 = new GregorianCalendar(anneeNaissance, moisNaissance, jourNaissance);
					XMLGregorianCalendar dateNaissance = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar3);

					System.out.println("Entrez la carte de crédit du client :");
					String carteCredit = sc.nextLine();
					//System.out.println("Entrez le nom de l'agence :");
					// Initialisation du nom de l'agence via la connexion du lancement de l'application
					String nomAgence = agence.getNom();
					System.out.println("Entrez le nombre de personnes :");
					int nombrePersonnes = sc.nextInt();

					try {
						String retourFaireReservation = client.faireReservation(
								nomHotel, numeroChambre, dateDebut, dateFin,
								nomClient, prenomClient, dateNaissance,
								carteCredit, nomAgence, nombrePersonnes);

						System.out.println(retourFaireReservation);

					} catch (Exception e) {
						System.out.println("Erreur lors de la réservation : " + e.getMessage());
					}
				}
				// annulerReservation : Pour annuler une réservation sur le site
				else if (commandeUtilisateur.equals("annulerReservation")) {
					System.out.println("Entrez l'ID de la réservation à annuler :");
					int idReservation = sc.nextInt();
					try {
						String resultat = client.annulerReservation(idReservation);
						System.out.println(resultat);
					} catch (Exception e) {
						System.out.println("Erreur lors de l'annulation : " + e.getMessage());
					}
				}
				// AjouterClient : Pour ajouter un client
				else if (commandeUtilisateur.equals("AjouterClient")) {
					System.out.println("Entrez le prénom du client :");
					String prenom = sc.next();
					System.out.println("Entrez le nom du client :");
					String nom = sc.next();
					System.out.println("Entrez la date de naissance du client (jj mm aaaa) :");
					int jourNaissance = sc.nextInt();
					int moisNaissance = sc.nextInt() - 1;
					int anneeNaissance = sc.nextInt(); // - 1900;
					//Date dateNaissance = new Date(anneeNaissance, moisNaissance, jourNaissance);
					GregorianCalendar calendar = new GregorianCalendar(anneeNaissance, moisNaissance, jourNaissance);
					XMLGregorianCalendar dateNaissance = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
					System.out.println("Entrez la carte de crédit du client :");
					String carteCredit = sc.next();
					try {
						String resultat = client.ajouterClient(nom, prenom, dateNaissance, carteCredit);
						System.out.println(resultat);
					} catch (Exception e) {
						System.out.println("Erreur lors de l'ajout : " + e.getMessage());
					}
				}
				// fin : Pour mettre fin au programme
				else if (commandeUtilisateur.equals("fin")) {
					scannerAgence = false;
					break;
				} else {
					System.out.println("Commande inconnue. Tapez 'aide' pour voir la liste des commandes disponibles.");
				}
				System.out.println();
				System.out.println("#################################################################");
				System.out.println("#             VEUILLEZ ENTRER UNE NOUVELLE COMMANDE             #");
				System.out.println("#################################################################");
				System.out.println();
				System.out.println("   ➤ aide                : Pour afficher la liste des commandes");
				System.out.println("   ➤ fin                 : Pour quitter le programme");
				System.out.println();
				System.out.println("#################################################################");
				System.out.println();
			}
			sc.close();
			System.out.println();
			System.out.println("#################################################################");
			System.out.println("#   MERCI D'AVOIR UTILISÉ LE LE SITE DE RESERVATION D'HOTEL     #");
			System.out.println("#################################################################");
			System.out.println("###                       À bientôt !                         ###");
			System.out.println("#################################################################");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
