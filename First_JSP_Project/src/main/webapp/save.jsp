<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="empBean" class="max.EmpBean"></jsp:useBean>
    <jsp:setProperty property="*" name="empBean"/>
    <jsp:useBean id="empDAO" class="max.EmpDAO"></jsp:useBean>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(empDAO.insertData(empBean)>0)
{
	out.print("Inserted Successfully........");
	request.getRequestDispatcher("index.jsp").include(request,response);
}
else
{
	out.print("Something went WRONG........");
	request.getRequestDispatcher("index.jsp").include(request,response);
}
%>
</body>
</html>