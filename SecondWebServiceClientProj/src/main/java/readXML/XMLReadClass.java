package readXML;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XMLReadClass 
{

	public void readXML(String xml)
	{
		try 
		{
			JAXBContext jb = JAXBContext.newInstance(StData.class);
			Unmarshaller um = jb.createUnmarshaller();
			StringReader sr=new StringReader(xml);
			StData st=(StData)um.unmarshal(sr);
			List<StBean> list = st.getList();
			
			for(StBean s:list)
			{
				
				System.out.println(s.getState_Code()+"   "+s.getState_Name()+"   "+s.getShort_Name());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
