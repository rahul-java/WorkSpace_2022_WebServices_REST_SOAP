package max;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import hib.StateDTO;
//http://localhost:8080/First_RestFul_Services_Server/ok/rh/data

//import com.sun.jersey.spi.container.servlet.ServletContainer;


@Path("/rh")
public class RequestHandler
{
	
//ServletContainer
@POST
@Path("/data")
	public String getData()
	{
	String s="indiabb";
		return s.toUpperCase();
		
	}


@POST
@Path("/data5")
	public String getData5(String s1)
	{
	
		return s1.toUpperCase()+"Call ho gya...";
		
	}



//http://localhost:8080/First_RestFul_Services_Server/ok/rh/data1?n=raja
@POST
@Path("/data1")
public String getData1(@QueryParam("n") String s)
{

	return s.toUpperCase()+"is the best...";
	
}


//http://localhost:8080/First_RestFul_Services_Server/ok/rh/data2?n1=rahul&n2=pandey
@POST
@Path("/data2")
public String getData2(@QueryParam("n1") String s1,@QueryParam("n2") String s2)
{

	return s1.toUpperCase()+""+s2.toUpperCase();
	
}


@POST
@Path("/data3")
public String getData3(@QueryParam("rollno") int rollNo) throws JSONException
{

	JSONObject j = new JSONObject();
	j.put("name", "rahul");
	j.put("phone", "789456120");
	j.put("adhar", "122113322");
	j.put("add", "Allahabad");
	j.put("pin", "211001");
	j.put("age", "30");
	j.put("rollno", rollNo);
	return j.toString();
	
}


@POST
@Path("/data4")
public String getData77(String h) throws JSONException
{ 
	return h.toString()+"JSON aa gaya ha....";
	
}


//http://localhost:8080/Z1_RestFul_Services_Server/ok/rh/stateData1
@POST
@Path("/stateData1")
public String getStateList1() throws JSONException
{ 
	JSONArray ja = new JSONArray();
	
	LocationDAO locationDAO=new LocationDAO();
	List<StateDTO> list = locationDAO.getStateList();
	
	for(StateDTO p:list)
	{
		JSONObject j = new JSONObject();
		j.put("state_Code", p.getState_Code());
		j.put("state_Name", p.getState_Name());
		j.put("short_Name", p.getShort_Name());
		ja.put(j);
		
	}
	
	return ja.toString();
	
}


@POST
@Path("/stateData2")
public String getStateList2() throws JSONException, JsonGenerationException, JsonMappingException, IOException
{ 
	LocationDAO locationDAO=new LocationDAO();
	List<StateDTO> list = locationDAO.getStateList();
	
	 ObjectMapper om = new ObjectMapper();
	 String js_String=om.writeValueAsString(list);
	 
	return js_String;
	
}


@POST
@Path("/stateDataBySOA")
public String getStateListBySOA() throws JSONException, JsonGenerationException, JsonMappingException, IOException
{ 
	RequestHandlerSOAProxy ob = new RequestHandlerSOAProxy();
	String xml = ob.getStateData();
	 
	JSONObject jo = XML.toJSONObject(xml);
	
	return jo.toString();
	
}
}
