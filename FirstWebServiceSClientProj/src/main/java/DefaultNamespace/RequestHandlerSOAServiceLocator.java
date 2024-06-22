/**
 * RequestHandlerSOAServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public class RequestHandlerSOAServiceLocator extends org.apache.axis.client.Service implements DefaultNamespace.RequestHandlerSOAService {

    public RequestHandlerSOAServiceLocator() {
    }


    public RequestHandlerSOAServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RequestHandlerSOAServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RequestHandlerSOA
    private java.lang.String RequestHandlerSOA_address = "http://localhost:8080/FirstWebServiceServerProj/services/RequestHandlerSOA";

    public java.lang.String getRequestHandlerSOAAddress() {
        return RequestHandlerSOA_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RequestHandlerSOAWSDDServiceName = "RequestHandlerSOA";

    public java.lang.String getRequestHandlerSOAWSDDServiceName() {
        return RequestHandlerSOAWSDDServiceName;
    }

    public void setRequestHandlerSOAWSDDServiceName(java.lang.String name) {
        RequestHandlerSOAWSDDServiceName = name;
    }

    public DefaultNamespace.RequestHandlerSOA getRequestHandlerSOA() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RequestHandlerSOA_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRequestHandlerSOA(endpoint);
    }

    public DefaultNamespace.RequestHandlerSOA getRequestHandlerSOA(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            DefaultNamespace.RequestHandlerSOASoapBindingStub _stub = new DefaultNamespace.RequestHandlerSOASoapBindingStub(portAddress, this);
            _stub.setPortName(getRequestHandlerSOAWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRequestHandlerSOAEndpointAddress(java.lang.String address) {
        RequestHandlerSOA_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (DefaultNamespace.RequestHandlerSOA.class.isAssignableFrom(serviceEndpointInterface)) {
                DefaultNamespace.RequestHandlerSOASoapBindingStub _stub = new DefaultNamespace.RequestHandlerSOASoapBindingStub(new java.net.URL(RequestHandlerSOA_address), this);
                _stub.setPortName(getRequestHandlerSOAWSDDServiceName());
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
        if ("RequestHandlerSOA".equals(inputPortName)) {
            return getRequestHandlerSOA();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DefaultNamespace", "RequestHandlerSOAService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DefaultNamespace", "RequestHandlerSOA"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RequestHandlerSOA".equals(portName)) {
            setRequestHandlerSOAEndpointAddress(address);
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
