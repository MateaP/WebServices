/**
 * EMBGService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package check.com.web.service;

public interface EMBGService extends javax.xml.rpc.Service {
    public java.lang.String getEMBGAddress();

    public check.com.web.service.EMBG getEMBG() throws javax.xml.rpc.ServiceException;

    public check.com.web.service.EMBG getEMBG(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
