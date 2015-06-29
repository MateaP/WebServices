package check.com.web.service;

public class EMBGProxy implements check.com.web.service.EMBG {
  private String _endpoint = null;
  private check.com.web.service.EMBG eMBG = null;
  
  public EMBGProxy() {
    _initEMBGProxy();
  }
  
  public EMBGProxy(String endpoint) {
    _endpoint = endpoint;
    _initEMBGProxy();
  }
  
  private void _initEMBGProxy() {
    try {
      eMBG = (new check.com.web.service.EMBGServiceLocator()).getEMBG();
      if (eMBG != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)eMBG)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)eMBG)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (eMBG != null)
      ((javax.xml.rpc.Stub)eMBG)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public check.com.web.service.EMBG getEMBG() {
    if (eMBG == null)
      _initEMBGProxy();
    return eMBG;
  }
  
  public java.lang.String testEMBG(java.lang.String embg) throws java.rmi.RemoteException{
    if (eMBG == null)
      _initEMBGProxy();
    return eMBG.testEMBG(embg);
  }
  
  
}