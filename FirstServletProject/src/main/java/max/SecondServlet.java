package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String add = request.getParameter("add");
		
		 PrintWriter out = response.getWriter();
		 
		 out.println("Second Servlet......      "+name+"   "+add);
		 
		 HttpSession s = request.getSession(false);
		 String str = (String)s.getAttribute("n");
		 out.println("session    :   "+str);
	}

}
