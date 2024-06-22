package max;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.dao.FatherChildDAO;
import max.dto.ChildDTO;
import max.dto.FatherDTO;


@WebServlet("/ViewChildParentDetailsServlet")
public class ViewChildParentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		FatherChildDAO fatherChildDAO=new FatherChildDAO();
		Map<String, Object> m = fatherChildDAO.viewFatherChilddetails();
		List<ChildDTO>  clst=(ArrayList<ChildDTO>)m.get("clst");
		List<FatherDTO>  flst=(ArrayList<FatherDTO>)m.get("flst");
		
		request.setAttribute("f", flst);
		request.setAttribute("c", clst);
		request.getRequestDispatcher("ViewChildParentDetails.jsp").forward(request, response);
	
	}

}
