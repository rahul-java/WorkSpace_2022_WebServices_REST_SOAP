<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pay Here...</title>
</head>
<body>
<form action="PayServlet">
<table bgcolor="cyan" border="3">
<tr><td>Account No :</td><td><input type="text" name="account"></td></tr>
<tr><td>IFSC Code :</td><td><input type="text" name="ifsc"></td></tr>
<tr><td>Enter Name :</td><td><input type="text" name="name"></td></tr>
<tr><td>Amount :</td><td><input type="text" name="amount"></td></tr>
<tr><td><input type="submit" value="Pay Now"></td></tr>
</table>
</form>
</body>
</html>