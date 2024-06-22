<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="empDAO" class="max.EmpDAO"></jsp:useBean>
    <%@ page import="java.util.List" %>
    <%@ page import="max.EmpBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="view.jsp"></jsp:include>
<table bgcolor="yellow" border="3">
<tr bgcolor="cyan"><th>Email Id</th><th>Name</th><th>Phone No</th><th>Address</th></tr>
<%
String email=request.getParameter("selectEmail");
List<EmpBean> list=empDAO.getDetails(email);
for(EmpBean e:list)
{
%>
<tr>
<td><%=e.getEmail() %></td>
<td><%=e.getName() %></td>
<td><%=e.getPhone() %></td>
<td><%=e.getAddress() %></td>
</tr>
<%} %>

</table>

</body>
</html>