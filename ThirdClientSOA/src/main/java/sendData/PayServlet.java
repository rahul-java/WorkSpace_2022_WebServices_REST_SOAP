package sendData;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import max.RequestHandlerSOAProxy;
import pay.Bank;
import pay.xml.GenerateXML;

/**
 * Servlet implementation class PayServlet
 */
@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		PrintWriter out = resp.getWriter();
		
		String account=req.getParameter("account");
		String ifsc=req.getParameter("ifsc");
		String name=req.getParameter("name");
		String amount=req.getParameter("amount");
		
		Bank bank = new Bank();
		bank.setAccount(account);
		bank.setIfsc(ifsc);
		bank.setName(name);
		bank.setAmount(amount);
		
		GenerateXML obj = new GenerateXML();
		String xml = obj.generateXML(bank);
		System.out.println(xml);
		out.println("Success....");
		
		RequestHandlerSOAProxy ob = new RequestHandlerSOAProxy();
		String res=ob.getPay(xml);
		System.out.println("XML Response.class..."+res);
		}

}
