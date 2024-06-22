<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<div align="center">
<form action="save.jsp" >
<table bgcolor="cyan" border="3">
<tr><td>Name : </td><td><input type="text" name="name" /></td></tr>
<tr><td>Email Id : </td><td><input type="text" name="email" /></td></tr>
<tr><td>Phone : </td><td><input type="text" name="phone" /></td></tr>
<tr><td>Address : </td><td><input type="text" name="address" /></td></tr>
<tr><td align="center"><input type="submit" value="Submit" /></td><td align="center"><a href="view.jsp">View</a></td></tr>
</table>
</form>
</div>
</body>
</html>