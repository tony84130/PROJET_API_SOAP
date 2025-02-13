
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour reservation complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="reservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idReservation" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hotel" type="{http://webService/}hotel" minOccurs="0"/>
 *         &lt;element name="chambre" type="{http://webService/}chambre" minOccurs="0"/>
 *         &lt;element name="dateArrivee" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateDepart" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="client" type="{http://webService/}client" minOccurs="0"/>
 *         &lt;element name="agence" type="{http://webService/}agencePartenaire" minOccurs="0"/>
 *         &lt;element name="nombrePersonnes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreNuits" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="prixTotal" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reservation", propOrder = {
    "idReservation",
    "hotel",
    "chambre",
    "dateArrivee",
    "dateDepart",
    "client",
    "agence",
    "nombrePersonnes",
    "nombreNuits",
    "prixTotal"
})
public class Reservation {

    protected int idReservation;
    protected Hotel hotel;
    protected Chambre chambre;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateArrivee;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateDepart;
    protected Client client;
    protected AgencePartenaire agence;
    protected int nombrePersonnes;
    protected int nombreNuits;
    protected double prixTotal;

    /**
     * Obtient la valeur de la propriété idReservation.
     * 
     */
    public int getIdReservation() {
        return idReservation;
    }

    /**
     * Définit la valeur de la propriété idReservation.
     * 
     */
    public void setIdReservation(int value) {
        this.idReservation = value;
    }

    /**
     * Obtient la valeur de la propriété hotel.
     * 
     * @return
     *     possible object is
     *     {@link Hotel }
     *     
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Définit la valeur de la propriété hotel.
     * 
     * @param value
     *     allowed object is
     *     {@link Hotel }
     *     
     */
    public void setHotel(Hotel value) {
        this.hotel = value;
    }

    /**
     * Obtient la valeur de la propriété chambre.
     * 
     * @return
     *     possible object is
     *     {@link Chambre }
     *     
     */
    public Chambre getChambre() {
        return chambre;
    }

    /**
     * Définit la valeur de la propriété chambre.
     * 
     * @param value
     *     allowed object is
     *     {@link Chambre }
     *     
     */
    public void setChambre(Chambre value) {
        this.chambre = value;
    }

    /**
     * Obtient la valeur de la propriété dateArrivee.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateArrivee() {
        return dateArrivee;
    }

    /**
     * Définit la valeur de la propriété dateArrivee.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateArrivee(XMLGregorianCalendar value) {
        this.dateArrivee = value;
    }

    /**
     * Obtient la valeur de la propriété dateDepart.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateDepart() {
        return dateDepart;
    }

    /**
     * Définit la valeur de la propriété dateDepart.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateDepart(XMLGregorianCalendar value) {
        this.dateDepart = value;
    }

    /**
     * Obtient la valeur de la propriété client.
     * 
     * @return
     *     possible object is
     *     {@link Client }
     *     
     */
    public Client getClient() {
        return client;
    }

    /**
     * Définit la valeur de la propriété client.
     * 
     * @param value
     *     allowed object is
     *     {@link Client }
     *     
     */
    public void setClient(Client value) {
        this.client = value;
    }

    /**
     * Obtient la valeur de la propriété agence.
     * 
     * @return
     *     possible object is
     *     {@link AgencePartenaire }
     *     
     */
    public AgencePartenaire getAgence() {
        return agence;
    }

    /**
     * Définit la valeur de la propriété agence.
     * 
     * @param value
     *     allowed object is
     *     {@link AgencePartenaire }
     *     
     */
    public void setAgence(AgencePartenaire value) {
        this.agence = value;
    }

    /**
     * Obtient la valeur de la propriété nombrePersonnes.
     * 
     */
    public int getNombrePersonnes() {
        return nombrePersonnes;
    }

    /**
     * Définit la valeur de la propriété nombrePersonnes.
     * 
     */
    public void setNombrePersonnes(int value) {
        this.nombrePersonnes = value;
    }

    /**
     * Obtient la valeur de la propriété nombreNuits.
     * 
     */
    public int getNombreNuits() {
        return nombreNuits;
    }

    /**
     * Définit la valeur de la propriété nombreNuits.
     * 
     */
    public void setNombreNuits(int value) {
        this.nombreNuits = value;
    }

    /**
     * Obtient la valeur de la propriété prixTotal.
     * 
     */
    public double getPrixTotal() {
        return prixTotal;
    }

    /**
     * Définit la valeur de la propriété prixTotal.
     * 
     */
    public void setPrixTotal(double value) {
        this.prixTotal = value;
    }

}
