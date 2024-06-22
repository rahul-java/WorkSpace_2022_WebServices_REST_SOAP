package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utility.JDBCUtility;

public class Bank_DAO {

	 Connection con;
	 
	 public int insertDetail(BankBean bb)
	 {
		 try {
			 con=JDBCUtility.getConn();
			 PreparedStatement ps = con.prepareStatement("insert into pay_details values (?,?,?,?,?)");
			 ps.setString(1, bb.getAmount());
			 ps.setString(2, bb.getName());
			 ps.setString(3, bb.getIfsc());
			 ps.setString(4, bb.getAddress());
			 ps.setString(5, generateTid());
			 return ps.executeUpdate();
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	 }
	 
	 private String generateTid()
	 {
		 StringBuffer sb = new StringBuffer();
		 for(int i=0;i<=9;i++)
		 {
			 sb.append(new Random().nextInt(10));
		 }
		return "TX"+sb.toString();
	 }
	 
	 public List<BankBean> viewPayDetails()
	 {
		 List<BankBean> list = new ArrayList<BankBean>();
		 
		 try {
			 con=JDBCUtility.getConn();
			 PreparedStatement ps = con.prepareStatement("select * from pay_details");
			 ResultSet rs = ps.executeQuery();
			 while(rs.next())
			 {
				 BankBean bankBean = new BankBean();
				 bankBean.setAmount(rs.getString(1));
				 bankBean.setName(rs.getString(2));
				 bankBean.setIfsc(rs.getString(3));
				 bankBean.setAddress(rs.getString(4));
				 bankBean.setTid(rs.getString(5));
				 list.add(bankBean);
			 }
			 
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return list;
	 }
	public String getBankDetail(String ifsc)
	{
		try {
			
			con=JDBCUtility.getConn();
			PreparedStatement ps = con.prepareStatement("select * from bank_details where ifsc=?");
			ps.setString(1, ifsc);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String bank_name=rs.getString("bank_name");
				String branch_add=rs.getString("branch_address");
				return bank_name+"  "+branch_add;
			}
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				
				// TODO: handle exception
			}
		}
		return null;
	}
}
