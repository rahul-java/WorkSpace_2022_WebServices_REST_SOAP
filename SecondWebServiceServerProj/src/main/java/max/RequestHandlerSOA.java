package max;

import java.util.List;

import hib.StateDTO;

public class RequestHandlerSOA 
{
	/*
	 * public static void main(String[] args) { RequestHandlerSOA ob=new
	 * RequestHandlerSOA(); System.out.println(ob.getStateData()); }
	 */
	public String getStateData()
	{
		
		LocationDAO locationDAO=new LocationDAO();
		List<StateDTO> list=locationDAO.getStateList();
		StateList stateList=new StateList();
		stateList.setList(list);
		
		GenerateXML b=new GenerateXML();
		String xml=b.generateXML(stateList);
		System.out.println(xml);
		return xml;
		
		
	}
}
