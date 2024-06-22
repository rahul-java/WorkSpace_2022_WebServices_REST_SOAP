package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StateDAO;
import hibernate.StateDTO;


@WebServlet("/UploadOnDB")
public class UploadOnDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		String[] stName = request.getParameterValues("stName");
		String[] stCode = request.getParameterValues("stCode");
		String[] stShortName = request.getParameterValues("stShortName");
		
        List<StateDTO> state_list=new ArrayList<StateDTO>();
        System.out.println("Length "+stName.length);
		for(int i=0;i<stName.length;i++)
		{
			StateDTO stateDTO=new StateDTO();
			stateDTO.setState_code(stCode[i]);
			stateDTO.setState_name(stName[i]);
			stateDTO.setState_short_name(stShortName[i]);
			System.out.println(stateDTO.toString());
			state_list.add(stateDTO);
		}
		StateDAO stateDAO=new StateDAO();
		if(stateDAO.insertIntoDB(state_list))
		{
			out.println("Inserted Successfully....");
		}
		else
		{
			out.println("Failed......");
		}

		
	}
	

}
