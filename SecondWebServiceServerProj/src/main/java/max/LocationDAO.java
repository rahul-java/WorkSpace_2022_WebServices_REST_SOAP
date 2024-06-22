package max;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import hib.SessionUtility;
import hib.StateDTO;

public class LocationDAO 
{
	public List<StateDTO> getStateList()
	{
		
		try 
		{
			Session session =SessionUtility.getSessss();
			Transaction tx=session.beginTransaction();
			Criteria cr=session.createCriteria(StateDTO.class);
			tx.commit();
			List<StateDTO> list=cr.list();
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
