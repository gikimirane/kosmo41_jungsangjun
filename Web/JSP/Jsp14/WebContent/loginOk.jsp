<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	String name, id, pw;
%>

<%
	request.setCharacterEncoding("UTF-8");

	name = request.getParameter("name");
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	
	if(id.equals("abcde") && pw.equals("12345")) {
		session.setAttribute("id", id);
		session.setAttribute("name", name);
		
		session.setMaxInactiveInterval(60*60);
	
		response.sendRedirect("welcome.jsp");
	} else {
		response.sendRedirect("login.html");
	}
%>
<%-- 참고 : 365일로 설정
cookie.setMaxAge(365*24*60*60);
--%>

</body>
</html>