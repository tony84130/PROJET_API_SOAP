
package clientSoap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour voirListeChambres complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="voirListeChambres">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idHotel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "voirListeChambres", propOrder = {
    "idHotel"
})
public class VoirListeChambres {

    protected int idHotel;

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

}
