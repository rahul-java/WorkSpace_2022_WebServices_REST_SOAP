package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String add = req.getParameter("add");
		
		 PrintWriter out = resp.getWriter();
		 out.println("Hello My First Servlet......");
		 out.println("Name : "+name+" Address : "+add);
		 
		 if(name.equals("max"))
		 {
			 HttpSession s = req.getSession();
			 s.setAttribute("n", name);
			 req.getRequestDispatcher("SecondServlet").forward(req, resp);
		 }
		 else if(name.equals("maxit"))
		 {
			 int amount=1000;
			// resp.sendRedirect("home.html");
			 resp.sendRedirect("https://www.facebook.com/?amt="+amount);
		 }
		 else
		 {
			 req.getRequestDispatcher("ThirdServlet").include(req, resp);
		 }
	}
}
