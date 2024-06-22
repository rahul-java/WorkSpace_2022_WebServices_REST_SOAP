package max.it;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		int n1=Integer.parseInt(req.getParameter("num1"));
		int n2=Integer.parseInt(req.getParameter("num2"));
		int r=n1+n2;
		PrintWriter out=res.getWriter();
		out.println("Result is : "+r);
		
		r=r*r;
		
		req.setAttribute("seq", r);
		RequestDispatcher rd=req.getRequestDispatcher("sq");
		rd.forward(req, res);
	}

}
