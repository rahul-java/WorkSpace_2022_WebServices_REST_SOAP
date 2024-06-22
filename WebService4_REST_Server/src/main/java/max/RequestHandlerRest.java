package max;


import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import hibernate.StateDTO;

//http://localhost:8080/WebService4_REST_Server/ok/rhr/state

@Path("/rhr")
public class RequestHandlerRest {
	@POST
	@Path("/state")
	public String getStateList(String s) throws JSONException
	{
		JSONArray ja = new JSONArray();
		LoactionDAO loactionDAIO=new LoactionDAO();
		 List<StateDTO> list = loactionDAIO.getStateList();
		 for(StateDTO st:list)
		 {
			JSONObject j = new JSONObject();
			j.put("State_Code", st.getState_code());
			j.put("State_Name", st.getState_name());
			j.put("State_Short_Name", st.getState_short_name());
			ja.put(j);
		 }
		 
		return ja.toString();
	}
	
	
	@POST
	@Path("/add")
	public String add(@QueryParam("n1") int n1, @QueryParam("n2") int n2)
	{
		int n=n1+n2;
		System.out.println("n1 :"+n1);
		System.out.println("n2 "+n2);
		return "Sum----> "+n;
	}
	
	@POST
	@Path("/mul")
	public String mul(String jo_str) throws JSONException
	{
		JSONObject jo = new JSONObject(jo_str);
		String fn = jo.getString("fn");
		String sn = jo.getString("sn");
		  int n1=Integer.parseInt(fn);
		  int n2=Integer.parseInt(sn);
		return "Multiplication : "+(n1*n2);
	}

}
