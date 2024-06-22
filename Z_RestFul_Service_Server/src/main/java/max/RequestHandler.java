package max;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.json.JSONException;
import org.json.JSONObject;
//http://localhost:8080/Z_RestFul_Service_Server/ok/rh/data

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



//http://localhost:8080/Z_RestFul_Service_Server/ok/rh/data1?n=raja
@POST
@Path("/data1")
public String getData1(@QueryParam("n") String s)
{

	return s.toUpperCase()+"is the best...";
	
}


//http://localhost:8080/Z_RestFul_Service_Server/ok/rh/data2?n1=rahul&n2=pandey
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

//http://localhost:8080/Z_RestFul_Service_Server/ok/rh/data4
@POST
@Path("/data4")
public String getData77(String h) throws JSONException
{ 
	return h.toString()+"JSON aa gaya ha....";
	
}

}
