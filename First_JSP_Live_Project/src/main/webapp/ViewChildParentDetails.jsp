<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="max.dao.FatherChildDAO" %>
    <%@ page import="max.bean.FatherViewBeen" %>
    <%@ page import="max.bean.ChildViewBeen" %>
    
    <%@ page import="java.util.Map" %>
    <%@ page import="java.util.TreeMap" %>
    <%@ page import="java.util.Set" %>
    <%@ page import="java.util.HashSet" %>
    <%@ page import="java.util.Map.Entry" %>
    
    <jsp:useBean id="fatherChildDAO" class="max.dao.FatherChildDAO"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="3" bgcolor="cyan">
<%
Map<FatherViewBeen, Set<ChildViewBeen>> fatherChild_map=fatherChildDAO.getFatherChildDetails();
System.out.println("TreeMap=================="+fatherChild_map);
Set<Entry<FatherViewBeen,Set<ChildViewBeen>>> es=fatherChild_map.entrySet();
for(Entry<FatherViewBeen,Set<ChildViewBeen>> e:es)
{
%>


<tr><th bgcolor="orange" align="center" colspan="6" >Father's Details</th></tr>
<tr bgcolor="yellow"><th>Account No</th><th>Father Name</th><th>DOB</th><th>Gender</th><th>State</th><th>District</th></tr>
<tr><td><%=e.getKey().getfAcctNo() %></td><td><%=e.getKey().getfName() %></td><td><%=e.getKey().getDob() %></td><td><%=e.getKey().getGender() %></td><td><%=e.getKey().getStateName() %></td><td><%=e.getKey().getDistrictName() %></td></tr>
<tr><th bgcolor="orange" colspan="4" align="center"> Child Details</th></tr>
<tr bgcolor="yellow"><th>Adhar No</th><th>Name</th><th>Age</th><th>Father Acct No</th></tr>
<%
for(ChildViewBeen ch:e.getValue())
{
%>
<tr><td><%= ch.getAdharNo() %></td><td><%= ch.getName() %></td><td><%= ch.getAge() %></td><td><%=ch.getfAcctNo() %></td></tr>
<%

}
}
%>
</table>
</body>
</html>