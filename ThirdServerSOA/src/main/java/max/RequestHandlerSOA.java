package max;

import read.ReadXML;

public class RequestHandlerSOA {

	public String getPay(String xml)
	{
		ReadXML readXML=new ReadXML();
		readXML.readXML(xml);
		System.out.println("Inside Server....");
		return "Successful..."+readXML.readXML(xml);
		
	}
}
