<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.controller.Employee"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="org.codehaus.jackson.map.ObjectMapper"%>

<html>
<head>

<title>Empdetails</title>
</head>

<body>
	<% 

String empjson=(String)request.getAttribute("el");
out.println(empjson);

%>
</body>
</html>
