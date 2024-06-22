<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function getData() {
	 var fn=document.getElementById("fnID").value;
	 var sn=document.getElementById("snID").value;
	 var h;
	 //alert(fn+" "+sn);
	   if(window.XMLHttpRequest)
		{
		h=new XMLHttpRequest();
		}else
		{
			h=new ActiveXObject("Microsoft.XMLHTTP");
		}
	
	   
	   h.onreadystatechange=function()
		 {
		    
		 if (h.readyState==4 && h.status==200)
		 {
		 //document.getElementById("t").value=h.responseText;
			 document.getElementById("t").innerHTML=h.responseText; 
		 }
		 }
	   
	     h.open("GET","Add?fn="+fn+"&sn="+sn,true);
		 h.send();
	
	 
}

</script>
</head>
<body>
<form>
<table border="3" bgcolor="yellow" align="center">
<tr><th colspan="2" align="center" bgcolor="cyan">Addition</th></tr>
<tr><th>First Number :</th><td><input type="text" name="fn" id="fnID"></td></tr>
<tr><th>Second Number :</th><td><input type="text" name="sn" id="snID" ></td></tr>
<tr><th align="center"><input type="button" value="ADD" onclick="getData()"></th>
<td><a href=multiply.jsp>Multiply</a></td></tr>
<tr><td id="t" bgcolor="cyan" align="center" colspan="2"></td></tr>
</table>
</form>
</body>
</html>