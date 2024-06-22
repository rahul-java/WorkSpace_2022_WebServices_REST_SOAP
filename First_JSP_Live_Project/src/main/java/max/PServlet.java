package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.bean.ChildBean;
import max.bean.FatherBean;
import max.dao.FatherChildDAO;

@WebServlet("/PServlet")
public class PServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		FatherBean fatherBean=new FatherBean();
		fatherBean.setfAcctNo(request.getParameter("fAcctNo"));
		fatherBean.setFname(request.getParameter("fname"));
		fatherBean.setDob(request.getParameter("dob"));
		fatherBean.setGender(request.getParameter("gender"));
		fatherBean.setStCode(request.getParameter("stCode"));
		fatherBean.setDistrictCode(request.getParameter("districtCode"));
		
		ChildBean childBean=new ChildBean();
		childBean.setAdhar(request.getParameterValues("cadhar"));
		childBean.setName(request.getParameterValues("cname"));
		childBean.setAge(request.getParameterValues("age"));
		
		FatherChildDAO fatherChildDAO=new FatherChildDAO();
		if(fatherChildDAO.insertFatherChildDetails(fatherBean,childBean))
		  {
			out.print("Inserted Successfully");
		  }
		else
		{
			out.print("Error in insertion....Something Went WRONG..............");
		}
		
	}

}
