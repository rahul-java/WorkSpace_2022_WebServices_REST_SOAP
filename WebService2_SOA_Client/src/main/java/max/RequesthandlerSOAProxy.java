package max;

public class RequesthandlerSOAProxy implements max.RequesthandlerSOA {
  private String _endpoint = null;
  private max.RequesthandlerSOA requesthandlerSOA = null;
  
  public RequesthandlerSOAProxy() {
    _initRequesthandlerSOAProxy();
  }
  
  public RequesthandlerSOAProxy(String endpoint) {
    _endpoint = endpoint;
    _initRequesthandlerSOAProxy();
  }
  
  private void _initRequesthandlerSOAProxy() {
    try {
      requesthandlerSOA = (new max.RequesthandlerSOAServiceLocator()).getRequesthandlerSOA();
      if (requesthandlerSOA != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)requesthandlerSOA)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)requesthandlerSOA)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (requesthandlerSOA != null)
      ((javax.xml.rpc.Stub)requesthandlerSOA)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public max.RequesthandlerSOA getRequesthandlerSOA() {
    if (requesthandlerSOA == null)
      _initRequesthandlerSOAProxy();
    return requesthandlerSOA;
  }
  
  public java.lang.String getstateList() throws java.rmi.RemoteException{
    if (requesthandlerSOA == null)
      _initRequesthandlerSOAProxy();
    return requesthandlerSOA.getstateList();
  }
  
  public java.lang.String getFacto(java.lang.String no) throws java.rmi.RemoteException{
    if (requesthandlerSOA == null)
      _initRequesthandlerSOAProxy();
    return requesthandlerSOA.getFacto(no);
  }
  
  public java.lang.String gettt() throws java.rmi.RemoteException{
    if (requesthandlerSOA == null)
      _initRequesthandlerSOAProxy();
    return requesthandlerSOA.gettt();
  }
  
  public max.User getUserDetail() throws java.rmi.RemoteException{
    if (requesthandlerSOA == null)
      _initRequesthandlerSOAProxy();
    return requesthandlerSOA.getUserDetail();
  }
  
  
}