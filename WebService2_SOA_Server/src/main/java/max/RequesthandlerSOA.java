package max;

import hibernate.StateDTO;

import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class RequesthandlerSOA {
	
	public String getstateList()
	{
		LoactionDAO d = new LoactionDAO();
		List<StateDTO> list = d.getStateList();
		StateList s = new StateList();
		s.setList(list);
		return generateXML(s);
	}
	
	private String generateXML(StateList s)
	{
		try {
			JAXBContext jc = JAXBContext.newInstance(StateList.class);
			Marshaller cm = jc.createMarshaller();
			StringWriter sw = new StringWriter();
			cm.marshal(s, sw);
			return sw.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public String getFacto(String no)
	{   int f=1;
		int n = Integer.parseInt(no);
		if(n==0 && n==1)
			return "Result is "+f;
		else
		{
			for(int i=n;i>1;i--)
			{
				f=i*f;
			}
			return "Result is "+f;
		}
	}
	
	
	public User getUserDetail()
	{
		User usr = new User();
		usr.setUid(10);
		usr.setName("bala");
		return usr;
	}
	
	public String gettt()
	{
		return "hello";
	}

}
