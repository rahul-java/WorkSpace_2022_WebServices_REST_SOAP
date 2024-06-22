package bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		Bank_DAO bank_DAO=new Bank_DAO();
		List<BankBean> list = bank_DAO.viewPayDetails();
		request.getRequestDispatcher("payment.html").include(request, response);
		
		out.println("<html><body>");
		out.println("<table border='3' bgcolor='yellow'>");
		out.println("<tr bgcolor='cyan'><th align='center'>Amount</th><th align='center'>Name</th><th align='center'>IFSC</th><th align='center'>Address</th><th align='center'>Transaction ID</th></tr>");
		for(BankBean p:list)
		{
     out.println("<tr><td>"+p.getAmount()+"</td><td>"+p.getName()+"</td><td>"+p.getIfsc()+"</td>"
		+ "<td>"+p.getAddress()+"</td><td><a href=UpdateServlet?tid="+p.getTid()+">"+p.getTid()+"</a></td></tr>");
				
		}
		out.println("</table>");
		out.print("</body></html>");
	}

}
