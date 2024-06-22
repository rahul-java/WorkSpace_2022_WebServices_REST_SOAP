package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		ServletContext ctx = getServletContext();
		String amt=(String)ctx.getAttribute("amount");
		out.println("...............Welcome to Second Servlet..................");
		out.println("...........By Servlet Context Amount = "+amt);
		
		HttpSession session = request.getSession();
		String str=(String)session.getAttribute("amt");
		out.println("............Amount by session "+str);
		
		String a=request.getParameter("ab");
		out.println("............Amount by URL Rewrite amount = "+a);
	}

}
