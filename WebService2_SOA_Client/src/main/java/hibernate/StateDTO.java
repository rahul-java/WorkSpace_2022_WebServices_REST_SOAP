package hibernate;

public class StateDTO {
  String state_code;
  String state_name;
  String state_short_name;
  
public String getState_code() {
	return state_code;
}
public void setState_code(String state_code) {
	this.state_code = state_code;
}
public String getState_name() {
	return state_name;
}
public void setState_name(String state_name) {
	this.state_name = state_name;
}
public String getState_short_name() {
	return state_short_name;
}
public void setState_short_name(String state_short_name) {
	this.state_short_name = state_short_name;
}
@Override
public String toString() {
	return state_code+" : "+state_name+" : "+state_short_name;
}

  
}
