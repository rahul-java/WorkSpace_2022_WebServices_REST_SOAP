package max;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utility.JDBCUtility;

public class EmpDAO {
	Connection con=null;
	
	public int insertData(EmpBean emp)
	{
		con=JDBCUtility.getConn();
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into emp_jsp values(?,?,?,?)");
			ps.setString(1, emp.getEmail());
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getPhone());
			ps.setString(4, emp.getAddress());
			return ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
		
	}

	
	public List<String> getEmailList()
	{
		con=JDBCUtility.getConn();
		List<String> list = new ArrayList<String>();
		
		try {
			PreparedStatement ps = con.prepareStatement("select email from emp_jsp");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String email=rs.getString(1);
				list.add(email);
			}
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public List<EmpBean> getDetails(String email)
	{
		con=JDBCUtility.getConn();
		PreparedStatement ps;
		List<EmpBean> l=new ArrayList<EmpBean>();
		
		try {
			
			if(email.equalsIgnoreCase("all"))
			{
			 ps = con.prepareStatement("select * from emp_jsp");
			}
			else
			{
			 ps = con.prepareStatement("select * from emp_jsp where email =?");
			 ps.setString(1, email);
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				EmpBean e=new EmpBean();
				e.setEmail(rs.getString("email"));
				e.setName(rs.getString("name"));
				e.setPhone(rs.getString("phone"));
				e.setAddress(rs.getString("add"));
				l.add(e);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return l;
	}
}
