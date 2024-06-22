package max;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
//http://localhost:8080/WebService3_REST_Server/ok/rhr/data
@Path("/rhr")
public class RequestHandlerRest {
	@POST
	@Path("/data")
	public String getData(String s)
	{
		return "Call Ho Gaya "+s.toUpperCase();
	}
	@POST
	@Path("/data1")
	public String getData111111(String s)
	{
		return "Call second bhi call Ho Gaya "+s.toUpperCase();
	}

}
