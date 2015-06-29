/**
 * EMBGServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package check.com.web.service;

public class EMBGServiceLocator extends org.apache.axis.client.Service implements check.com.web.service.EMBGService {

    public EMBGServiceLocator() {
    }


    public EMBGServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EMBGServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EMBG
    private java.lang.String EMBG_address = "http://localhost:8080/CheckEMBG/services/EMBG";

    public java.lang.String getEMBGAddress() {
        return EMBG_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EMBGWSDDServiceName = "EMBG";

    public java.lang.String getEMBGWSDDServiceName() {
        return EMBGWSDDServiceName;
    }

    public void setEMBGWSDDServiceName(java.lang.String name) {
        EMBGWSDDServiceName = name;
    }

    public check.com.web.service.EMBG getEMBG() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EMBG_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEMBG(endpoint);
    }

    public check.com.web.service.EMBG getEMBG(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            check.com.web.service.EMBGSoapBindingStub _stub = new check.com.web.service.EMBGSoapBindingStub(portAddress, this);
            _stub.setPortName(getEMBGWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEMBGEndpointAddress(java.lang.String address) {
        EMBG_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (check.com.web.service.EMBG.class.isAssignableFrom(serviceEndpointInterface)) {
                check.com.web.service.EMBGSoapBindingStub _stub = new check.com.web.service.EMBGSoapBindingStub(new java.net.URL(EMBG_address), this);
                _stub.setPortName(getEMBGWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("EMBG".equals(inputPortName)) {
            return getEMBG();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.web.com.check", "EMBGService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.web.com.check", "EMBG"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EMBG".equals(portName)) {
            setEMBGEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
