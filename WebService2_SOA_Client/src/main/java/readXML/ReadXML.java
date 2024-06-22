package readXML;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class ReadXML {
	public List<StateBean> readXML(String xml)
	{
		try {
			JAXBContext jc = JAXBContext.newInstance(StateDATA.class);
			Unmarshaller cum = jc.createUnmarshaller();
			StringReader sr = new StringReader(xml);
			StateDATA d = (StateDATA)cum.unmarshal(sr);
			List<StateBean> list = d.getList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
