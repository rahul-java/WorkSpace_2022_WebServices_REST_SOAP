package DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.SessUtility;
import hibernate.StateDTO;

public class StateDAO {
	
	public boolean insertIntoDB(List<StateDTO> state_list)
	{
		
		try {
			
			Session session = SessUtility.getSesss();
			Transaction tx = session.beginTransaction();
			int i=0;
			for(StateDTO state:state_list)
			{
				session.save(state);
				i++;
				
				if (i % 100 == 0) 
				{
					//a batch size for safety
		            session.flush();
		            session.clear();
		        }
			}
			System.out.println("******************  i="+i+"*********  list size :"+state_list.size());
			tx.commit();
			session.close();
			if(i==state_list.size())
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
