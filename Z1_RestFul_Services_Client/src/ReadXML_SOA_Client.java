import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ReadXML_SOA_Client
{
	public static void main(String[] args) {
		
		try {
			
			Client client=Client.create();
			WebResource wr = client.resource("http://localhost:8080/Z1_RestFul_Services_Server/ok/rh/stateDataBySOA");
			ClientResponse cr = wr.accept("application/text").post(ClientResponse.class);
			
			String rst = cr.getEntity(String.class);
			System.out.println(rst);
			
			JSONObject jo = new JSONObject(rst);
			String js=jo.getString("AllState");
			
			JSONObject jo1 = new JSONObject(js);
			String js1 = jo1.getString("State");
			
			 JSONArray ja = new JSONArray(js1);
			 
			 for(int i=0;i<ja.length();i++)
			 {
				 JSONObject ob = ja.getJSONObject(i);
				 System.out.println(ob.getString("state_Code")+" - "+ob.getString("state_Name")+" - "+ob.getString("short_Name"));
			 }
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
