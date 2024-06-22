package max;

import hibernate.StateDTO;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="all_state")
@XmlAccessorType(XmlAccessType.FIELD)

public class StateList {
	@XmlElement(name="state")
	List<StateDTO> list;

	public List<StateDTO> getList() {
		return list;
	}

	public void setList(List<StateDTO> list) {
		this.list = list;
	}

}
