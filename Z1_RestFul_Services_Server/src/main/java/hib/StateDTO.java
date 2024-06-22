package hib;

public class StateDTO 
{
	int state_Code;
	String state_Name;
	String short_Name;
	

	public int getState_Code() {
		return state_Code;
	}
	public void setState_Code(int state_Code) {
		this.state_Code = state_Code;
	}
	public String getState_Name() {
		
		return state_Name;
	}
	public void setState_Name(String state_Name) {
		
		this.state_Name = state_Name;
	}
	public String getShort_Name() {
		return short_Name;
	}
	public void setShort_Name(String short_Name) {
		this.short_Name = short_Name;
	}
	
}
