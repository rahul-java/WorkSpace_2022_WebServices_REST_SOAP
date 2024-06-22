package max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import max.JDBCConnection;
import max.bean.ChildBean;
import max.bean.ChildViewBeen;
import max.bean.FatherBean;
import max.bean.FatherViewBeen;

public class FatherChildDAO {
	
	static Connection con=null;
	static PreparedStatement ps=null;
	
	public boolean insertFatherChildDetails(FatherBean fatherBean , ChildBean childBean)
	{
		con=JDBCConnection.getConnn();
		
		try {
			 
			 con.setAutoCommit(false);
			 ps = con.prepareStatement("insert into father_details values(?,?,?,?,?,?)");
			 ps.setString(1, fatherBean.getfAcctNo());
			 ps.setString(2, fatherBean.getFname());
			 ps.setString(3, fatherBean.getDob());
			 ps.setString(4, fatherBean.getGender());
			 ps.setString(5, fatherBean.getStCode());
			 ps.setString(6, fatherBean.getDistrictCode());
			 
			 int i=ps.executeUpdate();
			 if(i>0)
			 {
				 ps=con.prepareStatement("insert into child_details values(?,?,?,?)");
				 
				 String[] adhar=childBean.getAdhar();
				 String[] name=childBean.getName();
				 String[] age=childBean.getAge();
				 
				 int n=0;
				 
				 for(int j=0;j<adhar.length;j++)
				 {
					 ps.setString(1, adhar[j]);
					 ps.setString(2, name[j]);
					 ps.setString(3, age[j]);
					 ps.setString(4, fatherBean.getfAcctNo());
					 
					 n=n+ps.executeUpdate();
				 }
				 
				 if(n==adhar.length)
				 {
					 con.commit();
					 System.out.println("Inserted Successfully...");
					// con.close();
					 return true;
				 }
			 }
			
		} catch (Exception e) {
			
			try {
				
				con.rollback();
				System.out.println("Something went wrong.....RollBack is called.....");
				//con.close();
				return false;
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
		return false;
	}
	
	public Map<FatherViewBeen, Set<ChildViewBeen>> getFatherChildDetails()
	{
		Map<FatherViewBeen, Set<ChildViewBeen>> mapFatherChild = new TreeMap<FatherViewBeen , Set<ChildViewBeen>>(new FatherViewBeen());
		try {
			con=JDBCConnection.getConnn();
		
			ps=con.prepareStatement("select * from father_details");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				FatherViewBeen fatherViewBeen=new FatherViewBeen();
				fatherViewBeen.setfAcctNo(rs.getString("accountno"));
				fatherViewBeen.setfName(rs.getString("fname"));
				fatherViewBeen.setDob(rs.getString("dob"));;
				fatherViewBeen.setGender(rs.getString("gender"));
				fatherViewBeen.setStateName(getState(con,rs.getString("stCode")));;
				fatherViewBeen.setDistrictName(getDistrict(con,rs.getString("districtCode")));;
				
				Set<ChildViewBeen> hashSet_Child = new HashSet<ChildViewBeen>();
				ps=con.prepareStatement("select * from child_details where accountno=?");
				ps.setString(1, rs.getString("accountno"));
				ResultSet rs_child = ps.executeQuery();
				
				while(rs_child.next())
				{
					ChildViewBeen childViewBeen=new ChildViewBeen();
					childViewBeen.setAdharNo(rs_child.getString(1));
					childViewBeen.setName(rs_child.getString(2));
					childViewBeen.setAge(rs_child.getString(3));
					childViewBeen.setfAcctNo(rs_child.getString(4));
					
					hashSet_Child.add(childViewBeen);
				}
				mapFatherChild.put(fatherViewBeen, hashSet_Child);
				
			}
			return mapFatherChild;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	private static String getState(Connection con,String stcode)
	{
		try {
			con=JDBCConnection.getConnn();
			ps=con.prepareStatement("select * from mst_state where state_code=?");
			ps.setString(1, stcode);
			
			 ResultSet rs = ps.executeQuery();
			 while(rs.next())
			 {
				 return rs.getString("state_name");
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "Invalid State";
		
	}
	
	private static String getDistrict(Connection con,String dist_code)
	{
		try {
			con=JDBCConnection.getConnn();
			ps=con.prepareStatement("select * from mst_district where district_code=?");
			ps.setString(1, dist_code);
			
			 ResultSet rs = ps.executeQuery();
			 while(rs.next())
			 {
				 return rs.getString("district_name");
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Invalid District";
		
	}
	

}
