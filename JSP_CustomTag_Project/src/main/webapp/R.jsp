<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/WEB-INF/subtract.tld" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String num1=request.getParameter("firstNo");
String num2=request.getParameter("secondNo");
%>
<s:subtraction n2="<%=num2 %>" n1="<%=num1 %>"></s:subtraction>
</body>
</html>