import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class AddClient {

	public static void main(String[] args) {
		
		try {
			
			Client client = Client.create();
	        WebResource wr = client.resource("http://localhost:8080/WebService4_REST_Server/ok/rhr/add?n1="+10+"&n2="+20+"");
			ClientResponse res = wr.accept("application/text").post(ClientResponse.class);
			String str = res.getEntity(String.class);
			System.out.println("Result is : "+str);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
