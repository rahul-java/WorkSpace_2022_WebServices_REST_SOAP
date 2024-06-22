package max.it;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		//int n=(int)req.getAttribute("seq");
		//int n=Integer.parseInt(req.getParameter("k"));
		
		HttpSession session=req.getSession();
		int n=(int)session.getAttribute("k");
		n=n*n;
		out.println("Result is : "+n);
		
		session.removeAttribute("k");
	}
}
