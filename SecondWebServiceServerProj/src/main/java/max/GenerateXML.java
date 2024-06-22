package max;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class GenerateXML 
{
	public String generateXML(StateList stateList)
	{
		try 
		{
			JAXBContext jc=JAXBContext.newInstance(StateList.class);
			Marshaller cm=jc.createMarshaller();
			
			StringWriter sw=new StringWriter();
			
			cm.marshal(stateList, sw);
			
			return sw.toString();
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
