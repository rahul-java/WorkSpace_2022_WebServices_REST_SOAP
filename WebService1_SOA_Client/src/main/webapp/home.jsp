<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function getFactorial()
{
	var no=document.getElementById("fnID").value;
	var req;
	alert(no);
	if (window.XMLHttpRequest)
  	{
  	     // code for IE7+, Firefox, Chrome, Opera, Safari
  	     req=new XMLHttpRequest();
  	}
  	else
  	{    // code for IE6, IE5
  	     req=new ActiveXObject("Microsoft.XMLHTTP");
  	 }
	  
	  req.onreadystatechange = function() 
	  {
		  //alert(req.readyState);
	    if (req.readyState == 4 && req.status == 200) 
	    {
	      document.getElementById("resultID").innerHTML = req.responseText;
	    }
	  };
	  req.open("GET", "MyServlet?no="+no, true);
	  req.send();
  }
</script>

</head>
<body>

<table bgcolor="cyan" border="3">
<tr><td>Factorial NO : </td><td><input type="text" name="fn" id="fnID"></td></tr>
<tr><td><input type="submit" value="Call" onclick="getFactorial()"></td></tr>
</table>
<span id="resultID"> </span> 
<div id="xxx"></div>
</body>
</html>