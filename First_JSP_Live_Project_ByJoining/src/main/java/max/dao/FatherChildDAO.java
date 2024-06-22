package max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
import max.dto.ChildDTO;
import max.dto.FatherDTO;

public class FatherChildDAO {

	static Connection con = null;
	static PreparedStatement ps = null;

	public boolean insertFatherChildDetails(FatherBean fatherBean, ChildBean childBean) {
		con = JDBCConnection.getConnn();
		int cid = JDBCConnection.getMaxCID(con);
		try {

			con.setAutoCommit(false);
			ps = con.prepareStatement("insert into father_details1 values(?,?,?,?,?,?,?)");
			ps.setInt(1, cid);
			ps.setString(2, fatherBean.getfAcctNo());
			ps.setString(3, fatherBean.getFname());
			ps.setString(4, fatherBean.getDob());
			ps.setString(5, fatherBean.getGender());
			ps.setString(6, fatherBean.getStCode());
			ps.setString(7, fatherBean.getDistrictCode());

			int i = ps.executeUpdate();
			if (i > 0) {
				ps = con.prepareStatement("insert into child_details1 values(?,?,?,?,?)");

				String[] adhar = childBean.getAdhar();
				String[] name = childBean.getName();
				String[] age = childBean.getAge();

				int k = cid;

				for (int j = 0; j < adhar.length; j++) {
					ps.setInt(1, ++k);
					ps.setString(2, adhar[j]);
					ps.setString(3, name[j]);
					ps.setString(4, age[j]);
					ps.setInt(5, cid);

					// n=n+ps.executeUpdate();

					ps.addBatch();
				}

				int[] n = ps.executeBatch();

				if (n.length == adhar.length) 
				{
					con.commit();
					System.out.println("Inserted Successfully...");

					return true;
				} else 
				{
					con.rollback();
					System.out.println("Roll Back is called.........");
				}
			}

		} catch (Exception e) {

			try {

				con.rollback();
				System.out.println("Something went wrong.....RollBack is called.....");
				return false;
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				//con.close();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return false;
	}

	
	
	
	public  Map<String , Object> viewFatherChilddetails()
	{
		Connection con = JDBCConnection.getConnn();
		List<FatherDTO> flist = new ArrayList<FatherDTO>();
		List<ChildDTO> clist = new ArrayList<ChildDTO>();
		
	  Map<String , Object> m=new	HashMap<String, Object>();
		try {
			  //PreparedStatement ps = con.prepareStatement("select f.fid, f.accountno, f.fname,f.gender,f.dob,s.state_name,d.district_name from father_details1 as f inner join mst_state as s on f.'stCode'::int=s.state_code inner join mst_district as d on f.'districtCode'=d.district_code");
			PreparedStatement ps = con.prepareStatement("select f.fid,f.accountno,f.fname,f.gender,f.dob,s.state_name,d.district_name from father_details1 as f inner join mst_state as s on f.st_code=s.state_code inner join mst_district as d on f.district_code=d.district_code");
		  ResultSet rs = ps.executeQuery();
		  while(rs.next())
		  {
			  FatherDTO f = new FatherDTO();
			  f.setAcctno(rs.getString("accountno"));
			  f.setName(rs.getString("fname"));
			  f.setDistName(rs.getString("district_name"));
			  f.setDob(rs.getString("dob"));
			  f.setFid(rs.getInt("fid"));
			  f.setGndr(rs.getString("gender"));
			  f.setStName(rs.getString("state_name"));
			  flist.add(f);
			  //System.out.println("Fid#############"+f.getFid());
		  }
		  
		  if(flist.size()>0)
		  {
			ps=  con.prepareStatement("select * from child_details1");
			rs=ps.executeQuery();
			while(rs.next())
			{
				ChildDTO childDTO=new ChildDTO();
				childDTO.setAdhar(rs.getString("adharno"));
				childDTO.setAge(rs.getString("age"));
				childDTO.setCid(rs.getInt("cid"));
				childDTO.setFid(rs.getInt("fid"));
				childDTO.setName(rs.getString("name"));
				clist.add(childDTO);
				//System.out.println("CID+++++++++++++++"+childDTO.getCid());
			}
		  }
		  m.put("flst", flist);
		  m.put("clst", clist);
		  
		} catch (Exception e) {
			// TODO: handle exception
		}
		return m;
	}
	
	
}
