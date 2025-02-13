
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour adresse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="adresse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pays" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codePostal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ville" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroEtRue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lieuDit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coordonneesGPS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "adresse", propOrder = {
    "pays",
    "codePostal",
    "ville",
    "numeroEtRue",
    "lieuDit",
    "coordonneesGPS"
})
public class Adresse {

    protected String pays;
    protected int codePostal;
    protected String ville;
    protected String numeroEtRue;
    protected String lieuDit;
    protected String coordonneesGPS;

    /**
     * Obtient la valeur de la propriété pays.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPays() {
        return pays;
    }

    /**
     * Définit la valeur de la propriété pays.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPays(String value) {
        this.pays = value;
    }

    /**
     * Obtient la valeur de la propriété codePostal.
     * 
     */
    public int getCodePostal() {
        return codePostal;
    }

    /**
     * Définit la valeur de la propriété codePostal.
     * 
     */
    public void setCodePostal(int value) {
        this.codePostal = value;
    }

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
     * Obtient la valeur de la propriété numeroEtRue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroEtRue() {
        return numeroEtRue;
    }

    /**
     * Définit la valeur de la propriété numeroEtRue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroEtRue(String value) {
        this.numeroEtRue = value;
    }

    /**
     * Obtient la valeur de la propriété lieuDit.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLieuDit() {
        return lieuDit;
    }

    /**
     * Définit la valeur de la propriété lieuDit.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLieuDit(String value) {
        this.lieuDit = value;
    }

    /**
     * Obtient la valeur de la propriété coordonneesGPS.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordonneesGPS() {
        return coordonneesGPS;
    }

    /**
     * Définit la valeur de la propriété coordonneesGPS.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordonneesGPS(String value) {
        this.coordonneesGPS = value;
    }

}
