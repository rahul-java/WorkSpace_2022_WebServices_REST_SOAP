<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="readXML.StateBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UploadOnDB">
<table border="3" bgcolor="cyan">
<tr><th colspan="3" align="center" bgcolor="yellow" >All State</th></tr>
<tr bgcolor="yellow"><th>State Code</th><th>State Name</th><th>State Short Name</th></tr>

<%
List<StateBean> list= (List<StateBean>)request.getAttribute("lst");
 for(StateBean p:list)
 {
%>
<tr><td><input type="text" name="stName" readonly="readonly" value="<%=p.getState_code()%>"></td>
<td><input type="text" name="stCode" readonly="readonly" value="<%=p.getState_name()%>"></td>
<td><input type="text" name="stShortName" readonly="readonly" value="<%=p.getState_short_name()%>"></td></tr>
<%} %>

<tr bgcolor="yellow"><td colspan="3" align="center"><input type="submit" value="Upload ON Server"></td></tr>
</table>
</form>
</body>
</html>