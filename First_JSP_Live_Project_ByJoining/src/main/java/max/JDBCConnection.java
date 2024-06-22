package max;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCConnection {
	
	private JDBCConnection(){}
	
	static Connection con=null;
      
	public static Connection getConnn()
	{
		return con;
	}
	
	static
	{
		try {
			
			Class.forName("org.postgresql.Driver");
  con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/abc", "postgres", "postgres");
		
   
} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	public static int countWrongTimePass(Connection com,String uid)
	{
		try {
			PreparedStatement ps = com.prepareStatement("select  max(logcount) as lc from lgn_mst where uid=?");
		   ps.setString(1, uid);
			ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			String t=rs.getString("lc");
			return Integer.parseInt(t)+1;
		}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public static int getMaxCID(Connection con)
	{
		try {
			PreparedStatement ps = con.prepareStatement("select  max(cid) as cd from child_details1");
		  
			ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			String t=rs.getString("cd");
			return Integer.parseInt(t)+1;
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
	

}
