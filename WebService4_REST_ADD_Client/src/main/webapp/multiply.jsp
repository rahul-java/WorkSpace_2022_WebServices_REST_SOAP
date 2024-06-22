<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function getData() {
	 var fn=document.getElementById("fnID").value;
	 var sn=document.getElementById("snID").value;
	 var h;
	// alert(fn+" "+sn);
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
	   
	     h.open("GET","MultiplyServlet?fn="+fn+"&sn="+sn,true);
		 h.send();
	
	 
}

</script>
</head>
<body>
<table border="3" bgcolor="cyan" align="center">
<tr><th colspan="2" align="center" bgcolor="yellow">Multiplication</th></tr>
<tr><th>First Number :</th><td><input type="text" name="fn" id="fnID"></td></tr>
<tr><th>Second Number :</th><td><input type="text" name="sn" id="snID" ></td></tr>
<tr><th align="center"><input type="button" value="Multiply" onclick="getData()"></th>
<th><a href=add.jsp>Addition</a></th></tr>
<tr><td id="t" bgcolor="yellow" colspan="2" align="center"></td></tr>
</table>
</body>
</html>