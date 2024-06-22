package max;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import hibernate.SessUtility;
import hibernate.StateDTO;

public class LoactionDAO {
	public List<StateDTO> getStateList()
	{
		try {
			Session session = SessUtility.getSesss();
			Transaction tx = session.beginTransaction();
			Criteria cr = session.createCriteria(StateDTO.class);
			cr.addOrder(Order.asc("state_name"));
			List<StateDTO> list=cr.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
