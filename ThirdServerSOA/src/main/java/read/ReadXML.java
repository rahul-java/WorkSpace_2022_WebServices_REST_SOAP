package read;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ReadXML {
	
	public String readXML(String xml)
	{
		
		try {
			
			JAXBContext jb = JAXBContext.newInstance(UserDetail.class);
			Unmarshaller cu = jb.createUnmarshaller();
			StringReader sr = new StringReader(xml);
			UserDetail userDetail=(UserDetail)cu.unmarshal(sr);
			
			System.out.println(userDetail.getAccount()+"\t"+userDetail.getIfsc()+"\t"+userDetail.getName()+"\t"+userDetail.getAmount());
			
			String s = userDetail.getAmount();
			int amt=Integer.parseInt(s);
			
			VerifyBankBean bankVerify = new VerifyBankBean();
			
			bankVerify.setAmount(userDetail.getAccount());
			bankVerify.setIfsc(userDetail.getIfsc());
			bankVerify.setName(userDetail.getName());
			bankVerify.setAmount(userDetail.getAmount());
			
			if(amt<100)
			{
				
				bankVerify.setRemark("Your Amount less than 100");
			}
			else
			{
				bankVerify.setRemark("Your Transaction is Successful");
			}
			
			return generateXML(bankVerify);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String generateXML(VerifyBankBean verifyBankBean)
	{
		try {
			JAXBContext jc = JAXBContext.newInstance(VerifyBankBean.class);
			Marshaller cm = jc.createMarshaller();
			StringWriter sw = new StringWriter();
			cm.marshal(verifyBankBean, sw);
			
			return sw.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
