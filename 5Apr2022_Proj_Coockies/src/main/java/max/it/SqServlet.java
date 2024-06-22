package max.it;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SqServlet extends HttpServlet
{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter out=res.getWriter();
		out.println("Hello ");
		int n=0;
		Cookie cookies[]=req.getCookies();
		
		for(Cookie c:cookies)
		{
		   if(c.getName().equals("k"))
		   {
			   n=Integer.parseInt(c.getValue()) ;
		   }
		}
		n=n*n;
		out.println("Result is : "+n);
		
	}
}
