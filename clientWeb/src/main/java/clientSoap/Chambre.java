
package clientSoap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour chambre complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="chambre">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroChambre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreLits" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tarif" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="disponible" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="hotel" type="{http://webService/}hotel" minOccurs="0"/>
 *         &lt;element name="imageUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chambre", propOrder = {
    "numeroChambre",
    "nombreLits",
    "tarif",
    "disponible",
    "hotel",
    "imageUrl"
})
public class Chambre {

    protected int numeroChambre;
    protected int nombreLits;
    protected double tarif;
    protected boolean disponible;
    protected Hotel hotel;
    protected String imageUrl;

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
     * Obtient la valeur de la propriété nombreLits.
     * 
     */
    public int getNombreLits() {
        return nombreLits;
    }

    /**
     * Définit la valeur de la propriété nombreLits.
     * 
     */
    public void setNombreLits(int value) {
        this.nombreLits = value;
    }

    /**
     * Obtient la valeur de la propriété tarif.
     * 
     */
    public double getTarif() {
        return tarif;
    }

    /**
     * Définit la valeur de la propriété tarif.
     * 
     */
    public void setTarif(double value) {
        this.tarif = value;
    }

    /**
     * Obtient la valeur de la propriété disponible.
     * 
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Définit la valeur de la propriété disponible.
     * 
     */
    public void setDisponible(boolean value) {
        this.disponible = value;
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
     * Obtient la valeur de la propriété imageUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Définit la valeur de la propriété imageUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageUrl(String value) {
        this.imageUrl = value;
    }

}
