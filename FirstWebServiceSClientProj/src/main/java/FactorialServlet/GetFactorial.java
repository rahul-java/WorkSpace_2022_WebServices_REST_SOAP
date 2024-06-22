package FactorialServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DefaultNamespace.RequestHandlerSOAProxy;

/**
 * Servlet implementation class GetFactorial
 */
@WebServlet("/GetFactorial")
public class GetFactorial extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		String fn=request.getParameter("fn");
		PrintWriter out =response.getWriter();
		RequestHandlerSOAProxy b=new RequestHandlerSOAProxy();
		String s=b.getFactorial(fn);
		//System.out.println(s);
		out.println(s);
	}


}
