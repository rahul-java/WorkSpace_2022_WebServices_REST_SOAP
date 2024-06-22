package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/PayServlet")
public class FilterClass implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {


		PrintWriter out = response.getWriter();
		String amount = request.getParameter("amount");
		int amt=Integer.parseInt(amount);
		
		out.print("Filter Request.......");
		if(amt<10)
		{
			out.println("Please Recharge Your Card....must be greater than 9");
		}
		else
		{
			chain.doFilter(request, response);
		}
		
		out.print("Filter Response.......");
	}

	

}
