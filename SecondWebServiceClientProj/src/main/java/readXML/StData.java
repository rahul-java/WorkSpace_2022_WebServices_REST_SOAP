package readXML;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="AllState")
@XmlAccessorType(XmlAccessType.FIELD)
public class StData 
{
	@XmlElement(name="State")
	List<StBean> list;

	public List<StBean> getList() {
		return list;
	}

	public void setList(List<StBean> list) {
		this.list = list;
	}

	
}
