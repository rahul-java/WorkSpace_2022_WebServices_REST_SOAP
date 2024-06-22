package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


@WebServlet("/MultiplyServlet")
public class MultiplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		System.out.println("First Number : "+request.getParameter("fn"));
		int fn =Integer.parseInt(request.getParameter("fn"));
		int sn =Integer.parseInt(request.getParameter("sn"));
		try {
			JSONObject jo = new JSONObject();
			jo.put("fn", fn);
			jo.put("sn", sn);
			 Client client = Client.create();
             WebResource wr = client.resource("http://localhost:8080/WebService4_REST_Server/ok/rhr/mul");
		     ClientResponse res = wr.accept("application/text").post(ClientResponse.class,jo.toString());
			 String str = res.getEntity(String.class);
			 out.println("Result is "+str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
