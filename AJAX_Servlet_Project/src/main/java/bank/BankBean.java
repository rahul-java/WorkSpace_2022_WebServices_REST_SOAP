package bank;

import javax.servlet.http.HttpServletRequest;

public class BankBean {
	
	String tid;
	String amount;
	String name;
	String ifsc;
	String address;
	
	
	
	public String getTid() {
		return tid;
	}



	public void setTid(String tid) {
		this.tid = tid;
	}



	public String getAmount() {
		return amount;
	}



	public void setAmount(String amount) {
		this.amount = amount;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getIfsc() {
		return ifsc;
	}



	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public BankBean getBankDetail(HttpServletRequest request)
	{
		BankBean bb = new BankBean();
		bb.setAmount(request.getParameter("amount"));
        bb.setName(request.getParameter("name"));
		bb.setIfsc(request.getParameter("ifsc"));
		bb.setAddress(request.getParameter("address"));
		return bb;
		
	}

}
