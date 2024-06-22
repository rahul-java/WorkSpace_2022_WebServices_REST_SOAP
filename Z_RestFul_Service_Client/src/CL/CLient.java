package CL;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class CLient {

	public static void main(String[] args) throws UniformInterfaceException, JSONException 
	{
	Client client=Client.create();
	WebResource wr = client.resource("http://localhost:8080/Z_RestFul_Service_Server/ok/rh/data5");
	ClientResponse cr = wr.accept("application/text").post(ClientResponse.class,"raj mahal");
	
	
	//WebResource wr = client.resource("http://localhost:8080/Z_RestFul_Service_Server/ok/rh/data1?n="+"indianarmy"+"");
	//ClientResponse cr = wr.accept("application/text").post(ClientResponse.class);
	
	//WebResource wr = client.resource("http://localhost:8080/Z_RestFul_Service_Server/ok/rh/data4");
	//ClientResponse cr = wr.accept("application/text").post(ClientResponse.class,getJSONData());
	
	
	String rst = cr.getEntity(String.class);
	System.out.println(rst);
	}

	public static String getJSONData() throws JSONException
	{
		JSONObject j = new JSONObject();
		j.put("name", "rahul");
		j.put("phone", "789456120");
		j.put("adhar", "122113322");
		j.put("add", "Allahabad");
		j.put("pin", "211001");
		j.put("age", "30");
		return j.toString();
	}
}
