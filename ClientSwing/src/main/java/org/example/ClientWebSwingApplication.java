// Pour générer les méthodes du wsdl
// wsimport -keep -verbose -d src/main/java http://localhost:8082/agencereservation?wsdl

package org.example;

//import clientSoap.*;
import service.AgenceReservation;
import webservice.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.xml.datatype.*;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class ClientWebSwingApplication {
    private static AgenceReservation client;
    private static AgencePartenaire agence;

    // Fonction format date DD/MM/YYYY
    public static String convertMysqlDate(XMLGregorianCalendar xmlDate) {
        Date date = xmlDate.toGregorianCalendar().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createMainWindow();
            }
        });
    }

    private static JButton loginButton;
    private static JButton listHotelsButton;
    private static JButton listChambresButton;
    private static JButton listClientsButton;
    private static JButton listReservationsButton;
    private static JButton rechercherDispoButton;
    private static JButton faireReservationButton;
    private static JButton annulerReservationButton;
    private static JButton ajouterClientButton;
    private static JButton quitButton;

    private static void createMainWindow() {
        JFrame frame = new JFrame("Agence de Réservation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Bouton de connexion
        loginButton = new JButton("Se connecter à l'agence");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLoginDialog();
            }
        });

        // Autres boutons (initialement masqués)
        // Liste des hôtels
        listHotelsButton = new JButton("Voir la liste des hôtels");
        listHotelsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHotelList();
            }
        });
        // Liste des chambres
        listChambresButton = new JButton("Voir la liste des chambres");
        listChambresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionShowChambreList();
            }
        });
        // Liste des clients
        listClientsButton = new JButton("Voir la liste des clients");
        listClientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showClientList();
            }
        });
        // Liste des réservations
        listReservationsButton = new JButton("Voir la liste des réservations");
        listReservationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showReservationsList();
            }
        });
        // Recherche de disponibilité
        rechercherDispoButton = new JButton("Faire une recherche de disponibilité");
        rechercherDispoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionRechercherDispo();
            }
        });
        // Faire une réservation
        faireReservationButton = new JButton("Faire une réservation");
        faireReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionFaireReservation();
            }
        });
        // Annuler une réservation
        annulerReservationButton = new JButton("Annuler une réservation");
        annulerReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionAnnulerReservation();
            }
        });
        // Ajouter un client
        ajouterClientButton = new JButton("Ajouter un client");
        ajouterClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionAjouterClient();
            }
        });
        // Quitter l'application
        quitButton = new JButton("Quitter");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        // Ajouter les boutons à la fenêtre
        panel.add(loginButton);

        panel.add(listHotelsButton);
        panel.add(listChambresButton);
        panel.add(listClientsButton);
        panel.add(listReservationsButton);
        panel.add(rechercherDispoButton);
        panel.add(faireReservationButton);
        panel.add(annulerReservationButton);
        panel.add(ajouterClientButton);
        panel.add(quitButton);

        frame.add(panel);
        frame.setVisible(true);

        hideButtonsAfterLogin();
    }

    private static void hideButtonsAfterLogin() {
        listHotelsButton.setVisible(false);
        listChambresButton.setVisible(false);
        listClientsButton.setVisible(false);
        listReservationsButton.setVisible(false);
        rechercherDispoButton.setVisible(false);
        faireReservationButton.setVisible(false);
        annulerReservationButton.setVisible(false);
        ajouterClientButton.setVisible(false);
    }

    // Affiche tous les boutons après la connexion réussie
    private static void showButtonsAfterLogin() {
        listHotelsButton.setVisible(true);
        listChambresButton.setVisible(true);
        listClientsButton.setVisible(true);
        listReservationsButton.setVisible(true);
        rechercherDispoButton.setVisible(true);
        faireReservationButton.setVisible(true);
        annulerReservationButton.setVisible(true);
        ajouterClientButton.setVisible(true);

        // Cache le bouton de connexion
        loginButton.setVisible(false);
    }

    private static void openLoginDialog() {
        JTextField loginField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);

        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Login :"));
        panel.add(loginField);
        panel.add(new JLabel("Mot de passe :"));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Se connecter", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String login = loginField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (!login.isEmpty() && !password.isEmpty()) {
                loginToAgency(login, password);
            } else {
                JOptionPane.showMessageDialog(null, "Le login et le mot de passe sont obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void loginToAgency(String login, String password) {
        try {
            // URL du WSDL
            URL wsdlURL = new URL("http://localhost:8082/agencereservation?wsdl");
            QName serviceName = new QName("http://service/", "AgenceReservationImplService");
            Service service = Service.create(wsdlURL, serviceName);
            client = service.getPort(AgenceReservation.class);

            // Vérif des identifiants
            agence = client.connexionAgence(login, password);
            if (agence != null) {
                JOptionPane.showMessageDialog(null, "Connexion réussie! \nBienvenue : " + agence.getNom() + "\nVotre taux de réduction : " + agence.getTauxReduction() + "%", "Connexion", JOptionPane.INFORMATION_MESSAGE);
                showButtonsAfterLogin();
            } else {
                JOptionPane.showMessageDialog(null, "Identifiants incorrects. Veuillez réessayer.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la connexion : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Demande l'ID de l'hôtel à l'utilisateur et affiche les chambres
    private static void functionShowChambreList() {
        String idHotelStr = JOptionPane.showInputDialog(null, "Entrez l'ID de l'hôtel :", "Liste des chambres", JOptionPane.QUESTION_MESSAGE);

        if (idHotelStr != null && !idHotelStr.isEmpty()) {
            try {
                int idHotel = Integer.parseInt(idHotelStr);
                showChambreList(idHotel);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer un ID valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Recherche de disponibilité
    private static void functionRechercherDispo() {
        JTextField villeField = new JTextField(15);
        JTextField jourDateDebutField = new JTextField(2);
        JTextField moisDateDebutField = new JTextField(2);
        JTextField anneeDateDebutField = new JTextField(4);
        JTextField jourDateFinField = new JTextField(2);
        JTextField moisDateFinField = new JTextField(2);
        JTextField anneeDateFinField = new JTextField(4);
        JTextField prixMinField = new JTextField(5);
        JTextField prixMaxField = new JTextField(5);
        JTextField nbEtoilesField = new JTextField(2);
        JTextField nbPersonnesField = new JTextField(5);

        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.add(new JLabel("Ville:"));
        panel.add(villeField);
        panel.add(new JLabel("Date d'arrivée (jour/mois/année):"));
        JPanel dateDebutPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        dateDebutPanel.add(jourDateDebutField);
        dateDebutPanel.add(new JLabel("/"));
        dateDebutPanel.add(moisDateDebutField);
        dateDebutPanel.add(new JLabel("/"));
        dateDebutPanel.add(anneeDateDebutField);
        panel.add(dateDebutPanel);
        panel.add(new JLabel("Date de départ (jour/mois/année):"));
        JPanel dateFinPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        dateFinPanel.add(jourDateFinField);
        dateFinPanel.add(new JLabel("/"));
        dateFinPanel.add(moisDateFinField);
        dateFinPanel.add(new JLabel("/"));
        dateFinPanel.add(anneeDateFinField);
        panel.add(dateFinPanel);
        panel.add(new JLabel("Prix minimum (0 pour ignorer):"));
        panel.add(prixMinField);
        panel.add(new JLabel("Prix maximum (0 pour ignorer):"));
        panel.add(prixMaxField);
        panel.add(new JLabel("Nombre d'étoiles (0 pour ignorer):"));
        panel.add(nbEtoilesField);
        panel.add(new JLabel("Nombre de personnes (0 pour ignorer):"));
        panel.add(nbPersonnesField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Recherche des disponibilités", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String ville = villeField.getText().trim();
                int jourDateDebut = Integer.parseInt(jourDateDebutField.getText().trim());
                int moisDateDebut = Integer.parseInt(moisDateDebutField.getText().trim()) - 1;
                int anneeDateDebut = Integer.parseInt(anneeDateDebutField.getText().trim());
                int jourDateFin = Integer.parseInt(jourDateFinField.getText().trim());
                int moisDateFin = Integer.parseInt(moisDateFinField.getText().trim()) - 1;
                int anneeDateFin = Integer.parseInt(anneeDateFinField.getText().trim());
                int prixMin = Integer.parseInt(prixMinField.getText().trim());
                int prixMax = Integer.parseInt(prixMaxField.getText().trim());
                int nbEtoiles = Integer.parseInt(nbEtoilesField.getText().trim());
                int nbPersonnes = Integer.parseInt(nbPersonnesField.getText().trim());

                if (ville.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "La ville doit être renseignée.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Conversion des dates
                GregorianCalendar calendarDebut = new GregorianCalendar(anneeDateDebut, moisDateDebut, jourDateDebut);
                XMLGregorianCalendar dateDebut = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendarDebut);
                GregorianCalendar calendarFin = new GregorianCalendar(anneeDateFin, moisDateFin, jourDateFin);
                XMLGregorianCalendar dateFin = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendarFin);

                // Recherche des hôtels
                List<Hotel> hotelsDispo = client.rechercherDispo(ville, dateDebut, dateFin, prixMin, prixMax, nbEtoiles, nbPersonnes);

                // Gestion des résultats
                if (hotelsDispo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Aucun hôtel disponible pour ces critères.", "Résultats", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                // Affichage des hôtels disponibles
                StringBuilder message = new StringBuilder("<html><h3>Hôtels disponibles :</h3><ul>");
                for (Hotel h : hotelsDispo) {
                    message.append("<li>").append(h.getNom())
                            .append(" (").append(h.getNombreEtoiles()).append(" étoiles)</li>");
                    List<Chambre> chambresDisponibles = h.getChambres() != null ? h.getChambres().getChambre() : null;
                    if (chambresDisponibles == null || chambresDisponibles.isEmpty()) {
                        message.append("<ul><li>Aucune chambre disponible.</li></ul>");
                    } else {
                        message.append("<ul>");
                        for (Chambre c : chambresDisponibles) {
                            if (c.isDisponible()) {
                                message.append("<li>Chambre n°").append(c.getNumeroChambre())
                                        .append(" - ").append(c.getNombreLits()).append(" lits - ")
                                        .append(c.getTarif()).append("€</li>");
                            }
                        }
                        message.append("</ul>");
                    }
                }
                message.append("</ul></html>");

                JOptionPane.showMessageDialog(null, new JLabel(message.toString()), "Résultats de recherche", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer des nombres valides pour les champs numériques.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erreur lors de la recherche : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Faire une réservation
    private static void functionFaireReservation() {
        JTextField nomHotelField = new JTextField(15);
        JTextField numeroChambreField = new JTextField(5);
        JTextField jourDateDebutField = new JTextField(2);
        JTextField moisDateDebutField = new JTextField(2);
        JTextField anneeDateDebutField = new JTextField(4);
        JTextField jourDateFinField = new JTextField(2);
        JTextField moisDateFinField = new JTextField(2);
        JTextField anneeDateFinField = new JTextField(4);
        JTextField nomClientField = new JTextField(15);
        JTextField prenomClientField = new JTextField(15);
        JTextField jourNaissanceField = new JTextField(2);
        JTextField moisNaissanceField = new JTextField(2);
        JTextField anneeNaissanceField = new JTextField(4);
        JTextField carteCreditField = new JTextField(16);
        JTextField nombrePersonnesField = new JTextField(5);

        JPanel panel = new JPanel(new GridLayout(12, 2, 5, 5));
        panel.add(new JLabel("Nom de l'hôtel:"));
        panel.add(nomHotelField);
        panel.add(new JLabel("Numéro de chambre:"));
        panel.add(numeroChambreField);

        panel.add(new JLabel("Date d'arrivée (jj/mm/aaaa):"));
        JPanel panelDateDebut = new JPanel(new GridLayout(1, 3));
        panelDateDebut.add(jourDateDebutField);
        panelDateDebut.add(moisDateDebutField);
        panelDateDebut.add(anneeDateDebutField);
        panel.add(panelDateDebut);

        panel.add(new JLabel("Date de départ (jj/mm/aaaa):"));
        JPanel panelDateFin = new JPanel(new GridLayout(1, 3));
        panelDateFin.add(jourDateFinField);
        panelDateFin.add(moisDateFinField);
        panelDateFin.add(anneeDateFinField);
        panel.add(panelDateFin);

        panel.add(new JLabel("Nom du client:"));
        panel.add(nomClientField);
        panel.add(new JLabel("Prénom du client:"));
        panel.add(prenomClientField);

        panel.add(new JLabel("Date de naissance (jj/mm/aaaa):"));
        JPanel panelNaissance = new JPanel(new GridLayout(1, 3));
        panelNaissance.add(jourNaissanceField);
        panelNaissance.add(moisNaissanceField);
        panelNaissance.add(anneeNaissanceField);
        panel.add(panelNaissance);

        panel.add(new JLabel("Carte de crédit:"));
        panel.add(carteCreditField);
        panel.add(new JLabel("Nombre de personnes:"));
        panel.add(nombrePersonnesField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Faire une réservation", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String nomHotel = nomHotelField.getText().trim();
                int numeroChambre = Integer.parseInt(numeroChambreField.getText().trim());
                int jourDateDebut = Integer.parseInt(jourDateDebutField.getText().trim());
                int moisDateDebut = Integer.parseInt(moisDateDebutField.getText().trim()) - 1;
                int anneeDateDebut = Integer.parseInt(anneeDateDebutField.getText().trim());
                int jourDateFin = Integer.parseInt(jourDateFinField.getText().trim());
                int moisDateFin = Integer.parseInt(moisDateFinField.getText().trim()) - 1;
                int anneeDateFin = Integer.parseInt(anneeDateFinField.getText().trim());
                String nomClient = nomClientField.getText().trim();
                String prenomClient = prenomClientField.getText().trim();
                int jourNaissance = Integer.parseInt(jourNaissanceField.getText().trim());
                int moisNaissance = Integer.parseInt(moisNaissanceField.getText().trim()) - 1;
                int anneeNaissance = Integer.parseInt(anneeNaissanceField.getText().trim());
                String carteCredit = carteCreditField.getText().trim();
                int nombrePersonnes = Integer.parseInt(nombrePersonnesField.getText().trim());

                if (nomHotel.isEmpty() || nomClient.isEmpty() || prenomClient.isEmpty() || carteCredit.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tous les champs doivent être remplis.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Format des dates
                GregorianCalendar calendarDebut = new GregorianCalendar(anneeDateDebut, moisDateDebut, jourDateDebut);
                XMLGregorianCalendar dateDebut = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendarDebut);
                GregorianCalendar calendarFin = new GregorianCalendar(anneeDateFin, moisDateFin, jourDateFin);
                XMLGregorianCalendar dateFin = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendarFin);
                GregorianCalendar calendarNaissance = new GregorianCalendar(anneeNaissance, moisNaissance, jourNaissance);
                XMLGregorianCalendar dateNaissance = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendarNaissance);

                String retourFaireReservation = client.faireReservation(
                        nomHotel, numeroChambre, dateDebut, dateFin,
                        nomClient, prenomClient, dateNaissance,
                        carteCredit, agence.getNom(), nombrePersonnes);

                JOptionPane.showMessageDialog(null, retourFaireReservation, "Réservation effectuée", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer des nombres valides pour les champs de numéro de chambre, dates et nombre de personnes.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erreur lors de la réservation : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Annuler une réservation
    private static void functionAnnulerReservation() {
        String idReservationStr = JOptionPane.showInputDialog(
                null,
                "Entrez l'ID de la réservation à annuler :",
                "Annulation de réservation",
                JOptionPane.QUESTION_MESSAGE
        );

        if (idReservationStr != null && !idReservationStr.trim().isEmpty()) {
            try {
                int idReservation = Integer.parseInt(idReservationStr.trim());
                annulerReservation(idReservation);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        null,
                        "Veuillez entrer un ID valide (un nombre entier).",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "L'ID de réservation ne peut pas être vide.",
                    "Erreur",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    // Ajouter un client
    private static void functionAjouterClient() {
        try {
            JTextField prenomField = new JTextField(15);
            JTextField nomField = new JTextField(15);
            JTextField jourField = new JTextField(2);
            JTextField moisField = new JTextField(2);
            JTextField anneeField = new JTextField(4);
            JTextField carteCreditField = new JTextField(16);

            JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
            panel.add(new JLabel("Prénom :"));
            panel.add(prenomField);
            panel.add(new JLabel("Nom :"));
            panel.add(nomField);

            panel.add(new JLabel("Date de naissance (jj/mm/aaaa) :"));
            JPanel datePanel = new JPanel(new GridLayout(1, 3));
            datePanel.add(jourField);
            datePanel.add(moisField);
            datePanel.add(anneeField);
            panel.add(datePanel);

            panel.add(new JLabel("Carte de crédit :"));
            panel.add(carteCreditField);

            int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un client", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                String prenom = prenomField.getText().trim();
                String nom = nomField.getText().trim();
                int jour = Integer.parseInt(jourField.getText().trim());
                int mois = Integer.parseInt(moisField.getText().trim()) - 1;
                int annee = Integer.parseInt(anneeField.getText().trim());
                String carteCredit = carteCreditField.getText().trim();

                if (prenom.isEmpty() || nom.isEmpty() || carteCredit.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tous les champs doivent être remplis.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Conversion de la date
                GregorianCalendar calendar = new GregorianCalendar(annee, mois, jour);
                XMLGregorianCalendar dateNaissance = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);

                String resultat = client.ajouterClient(nom, prenom, dateNaissance, carteCredit);

                JOptionPane.showMessageDialog(null, resultat, "Résultat", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Veuillez entrer une date valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout du client : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Affiche la liste des hôtels
    private static void showHotelList() {
        try {
            List<Hotel> hotels = client.voirListeHotel();
            StringBuilder hotelList = new StringBuilder("Liste des hôtels :\n");
            for (Hotel hotel : hotels) {
                hotelList.append("- ID : ").append(hotel.getIdHotel())
                        .append(", Nom : ").append(hotel.getNom())
                        .append(" (").append(hotel.getNombreEtoiles() + " étoiles)")
                        .append(", Adresse : ").append(hotel.getAdresse().getNumeroEtRue() + ", "
                                + hotel.getAdresse().getCodePostal() + " " + hotel.getAdresse().getVille()
                                + ", " + hotel.getAdresse().getPays())
                        .append("\n");
            }
            JOptionPane.showMessageDialog(null, hotelList.toString(), "Hôtels disponibles", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des hôtels : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
    // Affiche la liste des chambres d'un hôtel
    private static void showChambreList(int idHotel) {
        try {
            List<Chambre> chambres = client.voirListeChambres(idHotel);
            StringBuilder chambreList = new StringBuilder("Liste des chambres :\n");
            for (Chambre chambre : chambres) {
                chambreList.append("- N° : ").append(chambre.getNumeroChambre())
                        .append(", Nombre de lits : ").append(chambre.getNombreLits())
                        .append(", Tarif : ").append(chambre.getTarif())
                        .append(", Url de l'image : ").append(chambre.getImageUrl())
                        .append("\n");
            }
            JOptionPane.showMessageDialog(null, chambreList.toString(), "Chambres disponibles", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des chambres : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    */
    private static void showChambreList(int idHotel) {
        try {
            List<Chambre> chambres = client.voirListeChambres(idHotel);

            JPanel chambrePanel = new JPanel();
            chambrePanel.setLayout(new BoxLayout(chambrePanel, BoxLayout.Y_AXIS));

            for (Chambre chambre : chambres) {
                JPanel chambreInfoPanel = new JPanel();
                chambreInfoPanel.setLayout(new FlowLayout());

                String infoText = "<html>- N° : " + chambre.getNumeroChambre()
                        + ", Nombre de lits : " + chambre.getNombreLits()
                        + ", Tarif : " + chambre.getTarif() + "€ " + "</html>";
                JLabel infoLabel = new JLabel(infoText);

                String imageUrl = chambre.getImageUrl();
                try {
                    URL url = new URL(imageUrl);
                    ImageIcon originalImageIcon = new ImageIcon(url);
                    Image originalImage = originalImageIcon.getImage();

                    // Redimension de l'image
                    Image resizedImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

                    ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
                    JLabel imageLabel = new JLabel(resizedImageIcon);
                    chambreInfoPanel.add(imageLabel);
                } catch (Exception e) {
                    chambreInfoPanel.add(new JLabel("Image non disponible"));
                }

                chambreInfoPanel.add(infoLabel);
                chambrePanel.add(chambreInfoPanel);
            }

            JOptionPane.showMessageDialog(null, new JScrollPane(chambrePanel), "Chambres disponibles", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des chambres : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Affiche la liste des clients
    private static void showClientList() {
        try {
            List<Client> clients = client.voirListeClient();
            StringBuilder clientList = new StringBuilder("Liste des clients :\n");
            for (Client client : clients) {
                /*clientList.append("- Prénom : ").append(client.getPrenom())
                        .append("- Nom : ").append(client.getNom())
                        .append("- Date de naissance : ").append(convertMysqlDate(client.getDateNaissance()))
                        .append("\n");*/
                clientList.append("- ").append(client.getPrenom() +" "+ client.getNom() + " : " + convertMysqlDate(client.getDateNaissance()))
                        .append("\n");
            }
            JOptionPane.showMessageDialog(null, clientList.toString(), "Clients enregistrés", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des clients : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Affiche la liste des réservations
    private static void showReservationsList() {
        try {
            List<Reservation> reservations = client.voirListeReservation();
            StringBuilder reservationList = new StringBuilder("Liste des réservations :\n");
            for (Reservation reservation : reservations) {
                reservationList.append("- ID : ").append(reservation.getIdReservation())
                        .append("- Hôtel : ").append(reservation.getHotel().getNom())
                        .append("- Chambre : ").append(reservation.getChambre().getNumeroChambre())
                        .append("- Date d'arrivée : ").append(convertMysqlDate(reservation.getDateArrivee()))
                        .append("- Date de départ : ").append(convertMysqlDate(reservation.getDateDepart()))
                        .append("- Client : ").append(reservation.getClient().getPrenom() +" "+ reservation.getClient().getNom())
                        .append("- Prix : ").append(reservation.getPrixTotal() + "€")
                        .append("\n");
            }
            JOptionPane.showMessageDialog(null, reservationList.toString(), "Clients enregistrés", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des clients : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Annuler une réservation
    private static void annulerReservation(int idReservation) {
        try {
            String response = client.annulerReservation(idReservation);
            JOptionPane.showMessageDialog(
                    null,
                    response,
                    "Résultat de l'annulation",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erreur lors de l'annulation de la réservation : " + e.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
