import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class CL {
	public static void main(String[] args) {
		try {
			Client client = Client.create();
        WebResource wr = client.resource("http://localhost:8080/WebService3_REST_Server/ok/rhr/data");
		ClientResponse res = wr.accept("application/text").post(ClientResponse.class,"rani");
		String str = res.getEntity(String.class);
		System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
