
package clientSoap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour faireReservation complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="faireReservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nomHotel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroChambre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dateDebut" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateFin" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="nomClient" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prenomClient" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateNaissance" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="carteCredit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomAgence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombrePersonnes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "faireReservation", propOrder = {
    "nomHotel",
    "numeroChambre",
    "dateDebut",
    "dateFin",
    "nomClient",
    "prenomClient",
    "dateNaissance",
    "carteCredit",
    "nomAgence",
    "nombrePersonnes"
})
public class FaireReservation {

    protected String nomHotel;
    protected int numeroChambre;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateDebut;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateFin;
    protected String nomClient;
    protected String prenomClient;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateNaissance;
    protected String carteCredit;
    protected String nomAgence;
    protected int nombrePersonnes;

    /**
     * Obtient la valeur de la propriété nomHotel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomHotel() {
        return nomHotel;
    }

    /**
     * Définit la valeur de la propriété nomHotel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomHotel(String value) {
        this.nomHotel = value;
    }

    /**
     * Obtient la valeur de la propriété numeroChambre.
     * 
     */
    public int getNumeroChambre() {
        return numeroChambre;
    }

    /**
     * Définit la valeur de la propriété numeroChambre.
     * 
     */
    public void setNumeroChambre(int value) {
        this.numeroChambre = value;
    }

    /**
     * Obtient la valeur de la propriété dateDebut.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateDebut() {
        return dateDebut;
    }

    /**
     * Définit la valeur de la propriété dateDebut.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateDebut(XMLGregorianCalendar value) {
        this.dateDebut = value;
    }

    /**
     * Obtient la valeur de la propriété dateFin.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateFin() {
        return dateFin;
    }

    /**
     * Définit la valeur de la propriété dateFin.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateFin(XMLGregorianCalendar value) {
        this.dateFin = value;
    }

    /**
     * Obtient la valeur de la propriété nomClient.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomClient() {
        return nomClient;
    }

    /**
     * Définit la valeur de la propriété nomClient.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomClient(String value) {
        this.nomClient = value;
    }

    /**
     * Obtient la valeur de la propriété prenomClient.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenomClient() {
        return prenomClient;
    }

    /**
     * Définit la valeur de la propriété prenomClient.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenomClient(String value) {
        this.prenomClient = value;
    }

    /**
     * Obtient la valeur de la propriété dateNaissance.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Définit la valeur de la propriété dateNaissance.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateNaissance(XMLGregorianCalendar value) {
        this.dateNaissance = value;
    }

    /**
     * Obtient la valeur de la propriété carteCredit.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarteCredit() {
        return carteCredit;
    }

    /**
     * Définit la valeur de la propriété carteCredit.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarteCredit(String value) {
        this.carteCredit = value;
    }

    /**
     * Obtient la valeur de la propriété nomAgence.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomAgence() {
        return nomAgence;
    }

    /**
     * Définit la valeur de la propriété nomAgence.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomAgence(String value) {
        this.nomAgence = value;
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

}
