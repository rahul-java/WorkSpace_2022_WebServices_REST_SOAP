package pay.xml;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import pay.Bank;

public class GenerateXML {

	public String generateXML(Bank bank)
	{
		
		try {
			
			JAXBContext jc = JAXBContext.newInstance(Bank.class);
			Marshaller cm = jc.createMarshaller();
			StringWriter sw = new StringWriter();
			cm.marshal(bank, sw);
			return sw.toString();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return null;
		
	}
}
