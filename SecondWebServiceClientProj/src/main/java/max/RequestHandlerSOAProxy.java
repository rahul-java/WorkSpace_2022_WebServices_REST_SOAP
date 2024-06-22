package max;

public class RequestHandlerSOAProxy implements max.RequestHandlerSOA {
  private String _endpoint = null;
  private max.RequestHandlerSOA requestHandlerSOA = null;
  
  public RequestHandlerSOAProxy() {
    _initRequestHandlerSOAProxy();
  }
  
  public RequestHandlerSOAProxy(String endpoint) {
    _endpoint = endpoint;
    _initRequestHandlerSOAProxy();
  }
  
  private void _initRequestHandlerSOAProxy() {
    try {
      requestHandlerSOA = (new max.RequestHandlerSOAServiceLocator()).getRequestHandlerSOA();
      if (requestHandlerSOA != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)requestHandlerSOA)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)requestHandlerSOA)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (requestHandlerSOA != null)
      ((javax.xml.rpc.Stub)requestHandlerSOA)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public max.RequestHandlerSOA getRequestHandlerSOA() {
    if (requestHandlerSOA == null)
      _initRequestHandlerSOAProxy();
    return requestHandlerSOA;
  }
  
  public java.lang.String getStateData() throws java.rmi.RemoteException{
    if (requestHandlerSOA == null)
      _initRequestHandlerSOAProxy();
    return requestHandlerSOA.getStateData();
  }
  
  
}