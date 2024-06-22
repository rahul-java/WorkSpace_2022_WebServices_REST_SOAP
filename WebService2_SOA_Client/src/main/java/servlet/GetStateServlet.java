package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.RequesthandlerSOAProxy;
import readXML.ReadXML;
import readXML.StateBean;


@WebServlet("/GetStateServlet")
public class GetStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		RequesthandlerSOAProxy ob = new RequesthandlerSOAProxy();
		String xml = ob.getstateList();
		System.out.println(xml);
		
		ReadXML readXML=new ReadXML();
		List<StateBean> list = readXML.readXML(xml);
		request.setAttribute("lst", list);
		request.getRequestDispatcher("ViewStateData.jsp").forward(request, response);
		
	}

}
