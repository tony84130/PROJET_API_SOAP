
package service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AgenceReservationImplService", targetNamespace = "http://service/", wsdlLocation = "http://localhost:8082/agencereservation?wsdl")
public class AgenceReservationImplService
    extends Service
{

    private final static URL AGENCERESERVATIONIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException AGENCERESERVATIONIMPLSERVICE_EXCEPTION;
    private final static QName AGENCERESERVATIONIMPLSERVICE_QNAME = new QName("http://service/", "AgenceReservationImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8082/agencereservation?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        AGENCERESERVATIONIMPLSERVICE_WSDL_LOCATION = url;
        AGENCERESERVATIONIMPLSERVICE_EXCEPTION = e;
    }

    public AgenceReservationImplService() {
        super(__getWsdlLocation(), AGENCERESERVATIONIMPLSERVICE_QNAME);
    }

    public AgenceReservationImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), AGENCERESERVATIONIMPLSERVICE_QNAME, features);
    }

    public AgenceReservationImplService(URL wsdlLocation) {
        super(wsdlLocation, AGENCERESERVATIONIMPLSERVICE_QNAME);
    }

    public AgenceReservationImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, AGENCERESERVATIONIMPLSERVICE_QNAME, features);
    }

    public AgenceReservationImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AgenceReservationImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AgenceReservation
     */
    @WebEndpoint(name = "AgenceReservationImplPort")
    public AgenceReservation getAgenceReservationImplPort() {
        return super.getPort(new QName("http://service/", "AgenceReservationImplPort"), AgenceReservation.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AgenceReservation
     */
    @WebEndpoint(name = "AgenceReservationImplPort")
    public AgenceReservation getAgenceReservationImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service/", "AgenceReservationImplPort"), AgenceReservation.class, features);
    }

    private static URL __getWsdlLocation() {
        if (AGENCERESERVATIONIMPLSERVICE_EXCEPTION!= null) {
            throw AGENCERESERVATIONIMPLSERVICE_EXCEPTION;
        }
        return AGENCERESERVATIONIMPLSERVICE_WSDL_LOCATION;
    }

}
