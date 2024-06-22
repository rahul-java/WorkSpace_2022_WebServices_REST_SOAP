<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="max.dto.FatherDTO" %>
    <%@ page import="max.dto.ChildDTO" %>
    
    <%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="3" bgcolor="cyan">
<%
List<ChildDTO> cl=(List<ChildDTO>)request.getAttribute("c");
List<FatherDTO> fl=(List<FatherDTO>)request.getAttribute("f");
 for(FatherDTO f : fl)
 {
%>


<tr bgcolor="orange"><th align="center" colspan="7" >Father's Details</th></tr>
<tr bgcolor="yellow"><th>F_ID</th><th>Account No</th><th>Father Name</th><th>DOB</th><th>Gender</th><th>State</th><th>District</th></tr>
<tr><td><%=f.getFid() %></td><td><%=f.getAcctno() %></td><td><%=f.getName() %></td><td><%=f.getDob() %></td><td><%=f.getGndr() %></td><td><%=f.getStName() %></td><td><%=f.getDistName() %></td></tr>
<tr bgcolor="orange"><th colspan="5" align="center"> Child Details</th></tr>
<tr bgcolor="yellow"><th>C_ID</th><th>Name</th><th>Adhar No</th><th>Age</th><th>F_ID</th></tr>
<%
for(ChildDTO c:cl)
{
	
  if(c.getFid()==f.getFid())
  {
%>
<tr><td><%= c.getCid() %></td><td><%= c.getName() %></td><td><%= c.getAdhar() %></td><td><%=c.getAge() %></td><td><%= c.getFid() %></td></tr>
 <% 
   }
 }
} 
    %>
</table>
</body>
</html>