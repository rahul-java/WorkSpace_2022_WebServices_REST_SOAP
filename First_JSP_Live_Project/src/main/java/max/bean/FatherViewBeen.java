package max.bean;

import java.util.Comparator;

public class FatherViewBeen implements Comparator<FatherViewBeen>{
	
	String fAcctNo;
	String fName;
	String dob;
	String gender;
	String stateName;
	String districtName;
	public String getfAcctNo() {
		return fAcctNo;
	}
	public void setfAcctNo(String fAcctNo) {
		this.fAcctNo = fAcctNo;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	@Override
	public int compare(FatherViewBeen o1, FatherViewBeen o2) {
		if(Integer.parseInt(o1.getfAcctNo())>Integer.parseInt(o2.getfAcctNo()))
			return 1;
		else
			if(Integer.parseInt(o1.getfAcctNo())<Integer.parseInt(o2.getfAcctNo()))
				return -1;
			else
		       return 0;
	}
	
	

}
