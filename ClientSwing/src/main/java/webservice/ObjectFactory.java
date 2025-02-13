
package webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AjouterClientResponse_QNAME = new QName("http://webService/", "ajouterClientResponse");
    private final static QName _VoirListeReservationResponse_QNAME = new QName("http://webService/", "voirListeReservationResponse");
    private final static QName _AnnulerReservation_QNAME = new QName("http://webService/", "annulerReservation");
    private final static QName _VoirListeHotel_QNAME = new QName("http://webService/", "voirListeHotel");
    private final static QName _VoirListeReservation_QNAME = new QName("http://webService/", "voirListeReservation");
    private final static QName _AnnulerReservationResponse_QNAME = new QName("http://webService/", "annulerReservationResponse");
    private final static QName _AgencePartenaire_QNAME = new QName("http://webService/", "agencePartenaire");
    private final static QName _Client_QNAME = new QName("http://webService/", "client");
    private final static QName _Hotel_QNAME = new QName("http://webService/", "hotel");
    private final static QName _Reservation_QNAME = new QName("http://webService/", "reservation");
    private final static QName _Adresse_QNAME = new QName("http://webService/", "adresse");
    private final static QName _AjouterClient_QNAME = new QName("http://webService/", "ajouterClient");
    private final static QName _VoirListeChambresResponse_QNAME = new QName("http://webService/", "voirListeChambresResponse");
    private final static QName _VoirListeClientResponse_QNAME = new QName("http://webService/", "voirListeClientResponse");
    private final static QName _FaireReservationResponse_QNAME = new QName("http://webService/", "faireReservationResponse");
    private final static QName _VoirListeHotelResponse_QNAME = new QName("http://webService/", "voirListeHotelResponse");
    private final static QName _ConnexionAgenceResponse_QNAME = new QName("http://webService/", "connexionAgenceResponse");
    private final static QName _FaireReservation_QNAME = new QName("http://webService/", "faireReservation");
    private final static QName _RechercherDispo_QNAME = new QName("http://webService/", "rechercherDispo");
    private final static QName _RechercherDispoResponse_QNAME = new QName("http://webService/", "rechercherDispoResponse");
    private final static QName _ConnexionAgence_QNAME = new QName("http://webService/", "connexionAgence");
    private final static QName _Chambre_QNAME = new QName("http://webService/", "chambre");
    private final static QName _VoirListeClient_QNAME = new QName("http://webService/", "voirListeClient");
    private final static QName _VoirListeChambres_QNAME = new QName("http://webService/", "voirListeChambres");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Hotel }
     * 
     */
    public Hotel createHotel() {
        return new Hotel();
    }

    /**
     * Create an instance of {@link VoirListeHotelResponse }
     * 
     */
    public VoirListeHotelResponse createVoirListeHotelResponse() {
        return new VoirListeHotelResponse();
    }

    /**
     * Create an instance of {@link VoirListeClientResponse }
     * 
     */
    public VoirListeClientResponse createVoirListeClientResponse() {
        return new VoirListeClientResponse();
    }

    /**
     * Create an instance of {@link FaireReservationResponse }
     * 
     */
    public FaireReservationResponse createFaireReservationResponse() {
        return new FaireReservationResponse();
    }

    /**
     * Create an instance of {@link VoirListeChambres }
     * 
     */
    public VoirListeChambres createVoirListeChambres() {
        return new VoirListeChambres();
    }

    /**
     * Create an instance of {@link FaireReservation }
     * 
     */
    public FaireReservation createFaireReservation() {
        return new FaireReservation();
    }

    /**
     * Create an instance of {@link RechercherDispo }
     * 
     */
    public RechercherDispo createRechercherDispo() {
        return new RechercherDispo();
    }

    /**
     * Create an instance of {@link RechercherDispoResponse }
     * 
     */
    public RechercherDispoResponse createRechercherDispoResponse() {
        return new RechercherDispoResponse();
    }

    /**
     * Create an instance of {@link ConnexionAgenceResponse }
     * 
     */
    public ConnexionAgenceResponse createConnexionAgenceResponse() {
        return new ConnexionAgenceResponse();
    }

    /**
     * Create an instance of {@link Chambre }
     * 
     */
    public Chambre createChambre() {
        return new Chambre();
    }

    /**
     * Create an instance of {@link VoirListeClient }
     * 
     */
    public VoirListeClient createVoirListeClient() {
        return new VoirListeClient();
    }

    /**
     * Create an instance of {@link ConnexionAgence }
     * 
     */
    public ConnexionAgence createConnexionAgence() {
        return new ConnexionAgence();
    }

    /**
     * Create an instance of {@link AnnulerReservation }
     * 
     */
    public AnnulerReservation createAnnulerReservation() {
        return new AnnulerReservation();
    }

    /**
     * Create an instance of {@link VoirListeReservation }
     * 
     */
    public VoirListeReservation createVoirListeReservation() {
        return new VoirListeReservation();
    }

    /**
     * Create an instance of {@link VoirListeHotel }
     * 
     */
    public VoirListeHotel createVoirListeHotel() {
        return new VoirListeHotel();
    }

    /**
     * Create an instance of {@link AjouterClientResponse }
     * 
     */
    public AjouterClientResponse createAjouterClientResponse() {
        return new AjouterClientResponse();
    }

    /**
     * Create an instance of {@link VoirListeReservationResponse }
     * 
     */
    public VoirListeReservationResponse createVoirListeReservationResponse() {
        return new VoirListeReservationResponse();
    }

    /**
     * Create an instance of {@link Adresse }
     * 
     */
    public Adresse createAdresse() {
        return new Adresse();
    }

    /**
     * Create an instance of {@link AjouterClient }
     * 
     */
    public AjouterClient createAjouterClient() {
        return new AjouterClient();
    }

    /**
     * Create an instance of {@link VoirListeChambresResponse }
     * 
     */
    public VoirListeChambresResponse createVoirListeChambresResponse() {
        return new VoirListeChambresResponse();
    }

    /**
     * Create an instance of {@link Client }
     * 
     */
    public Client createClient() {
        return new Client();
    }

    /**
     * Create an instance of {@link Reservation }
     * 
     */
    public Reservation createReservation() {
        return new Reservation();
    }

    /**
     * Create an instance of {@link AnnulerReservationResponse }
     * 
     */
    public AnnulerReservationResponse createAnnulerReservationResponse() {
        return new AnnulerReservationResponse();
    }

    /**
     * Create an instance of {@link AgencePartenaire }
     * 
     */
    public AgencePartenaire createAgencePartenaire() {
        return new AgencePartenaire();
    }

    /**
     * Create an instance of {@link Hotel.Chambres }
     * 
     */
    public Hotel.Chambres createHotelChambres() {
        return new Hotel.Chambres();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjouterClientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "ajouterClientResponse")
    public JAXBElement<AjouterClientResponse> createAjouterClientResponse(AjouterClientResponse value) {
        return new JAXBElement<AjouterClientResponse>(_AjouterClientResponse_QNAME, AjouterClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoirListeReservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "voirListeReservationResponse")
    public JAXBElement<VoirListeReservationResponse> createVoirListeReservationResponse(VoirListeReservationResponse value) {
        return new JAXBElement<VoirListeReservationResponse>(_VoirListeReservationResponse_QNAME, VoirListeReservationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnulerReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "annulerReservation")
    public JAXBElement<AnnulerReservation> createAnnulerReservation(AnnulerReservation value) {
        return new JAXBElement<AnnulerReservation>(_AnnulerReservation_QNAME, AnnulerReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoirListeHotel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "voirListeHotel")
    public JAXBElement<VoirListeHotel> createVoirListeHotel(VoirListeHotel value) {
        return new JAXBElement<VoirListeHotel>(_VoirListeHotel_QNAME, VoirListeHotel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoirListeReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "voirListeReservation")
    public JAXBElement<VoirListeReservation> createVoirListeReservation(VoirListeReservation value) {
        return new JAXBElement<VoirListeReservation>(_VoirListeReservation_QNAME, VoirListeReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnulerReservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "annulerReservationResponse")
    public JAXBElement<AnnulerReservationResponse> createAnnulerReservationResponse(AnnulerReservationResponse value) {
        return new JAXBElement<AnnulerReservationResponse>(_AnnulerReservationResponse_QNAME, AnnulerReservationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgencePartenaire }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "agencePartenaire")
    public JAXBElement<AgencePartenaire> createAgencePartenaire(AgencePartenaire value) {
        return new JAXBElement<AgencePartenaire>(_AgencePartenaire_QNAME, AgencePartenaire.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Client }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "client")
    public JAXBElement<Client> createClient(Client value) {
        return new JAXBElement<Client>(_Client_QNAME, Client.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hotel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "hotel")
    public JAXBElement<Hotel> createHotel(Hotel value) {
        return new JAXBElement<Hotel>(_Hotel_QNAME, Hotel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Reservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "reservation")
    public JAXBElement<Reservation> createReservation(Reservation value) {
        return new JAXBElement<Reservation>(_Reservation_QNAME, Reservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Adresse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "adresse")
    public JAXBElement<Adresse> createAdresse(Adresse value) {
        return new JAXBElement<Adresse>(_Adresse_QNAME, Adresse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjouterClient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "ajouterClient")
    public JAXBElement<AjouterClient> createAjouterClient(AjouterClient value) {
        return new JAXBElement<AjouterClient>(_AjouterClient_QNAME, AjouterClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoirListeChambresResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "voirListeChambresResponse")
    public JAXBElement<VoirListeChambresResponse> createVoirListeChambresResponse(VoirListeChambresResponse value) {
        return new JAXBElement<VoirListeChambresResponse>(_VoirListeChambresResponse_QNAME, VoirListeChambresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoirListeClientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "voirListeClientResponse")
    public JAXBElement<VoirListeClientResponse> createVoirListeClientResponse(VoirListeClientResponse value) {
        return new JAXBElement<VoirListeClientResponse>(_VoirListeClientResponse_QNAME, VoirListeClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaireReservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "faireReservationResponse")
    public JAXBElement<FaireReservationResponse> createFaireReservationResponse(FaireReservationResponse value) {
        return new JAXBElement<FaireReservationResponse>(_FaireReservationResponse_QNAME, FaireReservationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoirListeHotelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "voirListeHotelResponse")
    public JAXBElement<VoirListeHotelResponse> createVoirListeHotelResponse(VoirListeHotelResponse value) {
        return new JAXBElement<VoirListeHotelResponse>(_VoirListeHotelResponse_QNAME, VoirListeHotelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnexionAgenceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "connexionAgenceResponse")
    public JAXBElement<ConnexionAgenceResponse> createConnexionAgenceResponse(ConnexionAgenceResponse value) {
        return new JAXBElement<ConnexionAgenceResponse>(_ConnexionAgenceResponse_QNAME, ConnexionAgenceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaireReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "faireReservation")
    public JAXBElement<FaireReservation> createFaireReservation(FaireReservation value) {
        return new JAXBElement<FaireReservation>(_FaireReservation_QNAME, FaireReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RechercherDispo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "rechercherDispo")
    public JAXBElement<RechercherDispo> createRechercherDispo(RechercherDispo value) {
        return new JAXBElement<RechercherDispo>(_RechercherDispo_QNAME, RechercherDispo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RechercherDispoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "rechercherDispoResponse")
    public JAXBElement<RechercherDispoResponse> createRechercherDispoResponse(RechercherDispoResponse value) {
        return new JAXBElement<RechercherDispoResponse>(_RechercherDispoResponse_QNAME, RechercherDispoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnexionAgence }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "connexionAgence")
    public JAXBElement<ConnexionAgence> createConnexionAgence(ConnexionAgence value) {
        return new JAXBElement<ConnexionAgence>(_ConnexionAgence_QNAME, ConnexionAgence.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Chambre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "chambre")
    public JAXBElement<Chambre> createChambre(Chambre value) {
        return new JAXBElement<Chambre>(_Chambre_QNAME, Chambre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoirListeClient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "voirListeClient")
    public JAXBElement<VoirListeClient> createVoirListeClient(VoirListeClient value) {
        return new JAXBElement<VoirListeClient>(_VoirListeClient_QNAME, VoirListeClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoirListeChambres }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "voirListeChambres")
    public JAXBElement<VoirListeChambres> createVoirListeChambres(VoirListeChambres value) {
        return new JAXBElement<VoirListeChambres>(_VoirListeChambres_QNAME, VoirListeChambres.class, null, value);
    }

}
