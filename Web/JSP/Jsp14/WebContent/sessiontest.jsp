<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

 	Enumeration enumeration = session.getAttributeNames();
	int i = 0;
	while(enumeration.hasMoreElements()) {
		i++;
		
		String sName = enumeration.nextElement().toString();
		String sValue = (String)session.getAttribute(sName);
		
		out.println(sName + " : " + sValue + "<br>");	
	}
	
	if(i==0)
		out.println("해당 세션 삭제 됨");
%>
</body>
</html>