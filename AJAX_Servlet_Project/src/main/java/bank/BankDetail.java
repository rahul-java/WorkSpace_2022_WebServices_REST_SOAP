package bank;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BankDetail")
public class BankDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String ifsc=request.getParameter("ifscCode");
		Bank_DAO bankDAO = new Bank_DAO();
		String bank_Detail=bankDAO.getBankDetail(ifsc);
		System.out.println(bank_Detail);
		out.println(bank_Detail);
	}

}
