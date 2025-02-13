
package clientSoap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour rechercherDispo complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="rechercherDispo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ville" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateArrivee" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateDepart" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="prixMin" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="prixMax" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="nombreEtoiles" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "rechercherDispo", propOrder = {
    "ville",
    "dateArrivee",
    "dateDepart",
    "prixMin",
    "prixMax",
    "nombreEtoiles",
    "nombrePersonnes"
})
public class RechercherDispo {

    protected String ville;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateArrivee;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateDepart;
    protected double prixMin;
    protected double prixMax;
    protected int nombreEtoiles;
    protected int nombrePersonnes;

    /**
     * Obtient la valeur de la propriété ville.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVille() {
        return ville;
    }

    /**
     * Définit la valeur de la propriété ville.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVille(String value) {
        this.ville = value;
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
     * Obtient la valeur de la propriété prixMin.
     * 
     */
    public double getPrixMin() {
        return prixMin;
    }

    /**
     * Définit la valeur de la propriété prixMin.
     * 
     */
    public void setPrixMin(double value) {
        this.prixMin = value;
    }

    /**
     * Obtient la valeur de la propriété prixMax.
     * 
     */
    public double getPrixMax() {
        return prixMax;
    }

    /**
     * Définit la valeur de la propriété prixMax.
     * 
     */
    public void setPrixMax(double value) {
        this.prixMax = value;
    }

    /**
     * Obtient la valeur de la propriété nombreEtoiles.
     * 
     */
    public int getNombreEtoiles() {
        return nombreEtoiles;
    }

    /**
     * Définit la valeur de la propriété nombreEtoiles.
     * 
     */
    public void setNombreEtoiles(int value) {
        this.nombreEtoiles = value;
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
