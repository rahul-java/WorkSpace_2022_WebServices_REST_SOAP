import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class CL {
	public static void main(String[] args) {
		try {
			Client client = Client.create();
        WebResource wr = client.resource("http://localhost:8080/WebService4_REST_Server/ok/rhr/state");
		ClientResponse res = wr.accept("application/text").post(ClientResponse.class);
		String str = res.getEntity(String.class);
		System.out.println(str);
		
		JSONArray ja = new JSONArray(str);
		for(int i=0;i<ja.length();i++)
		{
			JSONObject jo = ja.getJSONObject(i);
			System.out.println(jo.getString("State_Code")+"   "+jo.getString("State_Name")+"   "+jo.getString("State_Short_Name"));
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
