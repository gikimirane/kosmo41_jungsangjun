<%@page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

	Object obj1 = session.getAttribute("id");
	String sId = (String)obj1;
	
	//Object obj2 = session.getAttribute("name");
//	String sname = (String)obj2;
	
	if(sId == null) {
		response.sendRedirect("login.html");
	} else {
		out.println(sId + "님 안녕하세요." + "<br>" );
	}

%>
	<a href="logout.jsp">로그아웃</a> <br><p>
	
	<a href="sessiontest.jsp">세션 테스트</a>
</body>
</html>