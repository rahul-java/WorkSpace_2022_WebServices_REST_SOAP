import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MultiplyClient {

	public static void main(String[] args) {


		try {
			JSONObject jo = new JSONObject();
			jo.put("fn", 12);
			jo.put("sn", 13);
			Client client = Client.create();
	        WebResource wr = client.resource("http://localhost:8080/WebService4_REST_Server/ok/rhr/mul");
			ClientResponse res = wr.accept("application/text").post(ClientResponse.class,jo.toString());
			String str = res.getEntity(String.class);
			System.out.println("Result : "+str);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
