import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ReadJSONClient 
{
	public static void main(String[] args) {
		
		try {
			
			Client client=Client.create();
			WebResource wr = client.resource("http://localhost:8080/Z1_RestFul_Services_Server/ok/rh/stateData1");
			ClientResponse cr = wr.accept("application/text").post(ClientResponse.class);
			
			String rst = cr.getEntity(String.class);
			System.out.println(rst);
			
			JSONArray ja = new JSONArray(rst);
			for(int i=0;i<ja.length();i++)
			{
				JSONObject j = ja.getJSONObject(i);
				System.out.println(j.getString("state_Code")+"   "+j.getString("state_Name")+"   "+j.getString("short_Name"));
			}
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
