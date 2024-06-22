package bank;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PayDetails")
public class PayDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		BankBean bankBean = new BankBean().getBankDetail(request);
		Bank_DAO bank_DAO=new Bank_DAO();
		if(bank_DAO.insertDetail(bankBean)>0)
		{
			out.print("Inserted Successfully....");
		}
		else
		{
			out.print("Something went wrong...");
		}
	}

}
