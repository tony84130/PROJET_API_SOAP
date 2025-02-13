
package webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour hotel complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="hotel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idHotel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adresse" type="{http://webService/}adresse" minOccurs="0"/>
 *         &lt;element name="nombreEtoiles" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="chambres" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="chambre" type="{http://webService/}chambre" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hotel", propOrder = {
    "idHotel",
    "nom",
    "adresse",
    "nombreEtoiles",
    "chambres"
})
public class Hotel {

    protected int idHotel;
    protected String nom;
    protected Adresse adresse;
    protected int nombreEtoiles;
    protected Hotel.Chambres chambres;

    /**
     * Obtient la valeur de la propriété idHotel.
     * 
     */
    public int getIdHotel() {
        return idHotel;
    }

    /**
     * Définit la valeur de la propriété idHotel.
     * 
     */
    public void setIdHotel(int value) {
        this.idHotel = value;
    }

    /**
     * Obtient la valeur de la propriété nom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit la valeur de la propriété nom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * Obtient la valeur de la propriété adresse.
     * 
     * @return
     *     possible object is
     *     {@link Adresse }
     *     
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Définit la valeur de la propriété adresse.
     * 
     * @param value
     *     allowed object is
     *     {@link Adresse }
     *     
     */
    public void setAdresse(Adresse value) {
        this.adresse = value;
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
     * Obtient la valeur de la propriété chambres.
     * 
     * @return
     *     possible object is
     *     {@link Hotel.Chambres }
     *     
     */
    public Hotel.Chambres getChambres() {
        return chambres;
    }

    /**
     * Définit la valeur de la propriété chambres.
     * 
     * @param value
     *     allowed object is
     *     {@link Hotel.Chambres }
     *     
     */
    public void setChambres(Hotel.Chambres value) {
        this.chambres = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="chambre" type="{http://webService/}chambre" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "chambre"
    })
    public static class Chambres {

        protected List<Chambre> chambre;

        /**
         * Gets the value of the chambre property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the chambre property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getChambre().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Chambre }
         * 
         * 
         */
        public List<Chambre> getChambre() {
            if (chambre == null) {
                chambre = new ArrayList<Chambre>();
            }
            return this.chambre;
        }

    }

}
