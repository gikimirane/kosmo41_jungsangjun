<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Print Number 2</title>
</head>
<body>
	
<%
	String max = request.getParameter("max");	
	int maxValue = Integer.parseInt(max);
	
	for (int i=0; i<maxValue; i++) {
		out.println(i +"<br>");
	}
%>
</body>
</html>