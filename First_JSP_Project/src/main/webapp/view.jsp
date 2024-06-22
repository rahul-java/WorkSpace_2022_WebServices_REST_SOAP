<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="empDAO" class="max.EmpDAO"></jsp:useBean>
    <%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="viewDetail.jsp">
<table bgcolor="cyan" border="3">
<tr><td>Select Email Id :</td>
<td><select name="selectEmail">
<option value="all">---Select ALL---</option>
<%
List<String> list=empDAO.getEmailList();
for(String email:list)
{
%>
<option value="<%=email%>"><%=email%></option>
<%} %>
</select></td></tr>
<tr><td align="center"><input type="submit" value="View" /></td><td><a href="index.jsp">Home</a></td></tr>
</table>
</form>
</body>
</html>