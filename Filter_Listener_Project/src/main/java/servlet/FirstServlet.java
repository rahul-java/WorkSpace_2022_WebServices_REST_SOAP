package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/PayServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String amount = request.getParameter("amount");
		HttpSession session = request.getSession(true);
		session.setAttribute("amt", amount);
		//session.invalidate();  // forcefully killing the session.
		//session.setMaxInactiveInterval(30);   //killing session after 30 sec you are idle or active does'nt matter

		ServletConfig config = getServletConfig(); //creates the object of the servlet.
		ServletContext contx = getServletContext(); // it creates the object of the whole application.
		contx.setAttribute("amount", amount);
		
		out.print("..............Servlet Called...........");
		out.println("<a href=SecondServlet?ab="+amount+">Nexxxxxxxxxxxxxxxxttttt</a>");
	}

}
