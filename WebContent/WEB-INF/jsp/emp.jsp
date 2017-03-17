
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import= "java.util.ArrayList" %>
<%@page import="com.controller.Employee" %>
 <%@page import="javax.servlet.http.HttpServletRequest"%> 
 <%@page import="org.codehaus.jackson.map.ObjectMapper"%>
    

<html>
<head>
     
  <title>Tasks</title>
 </head>
 
<body>
<% 

String empjson=(String)request.getAttribute("el");
out.println(empjson);

%>
</body>
</html> 
