<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("ValidMem") == null) {
%>
	<jsp:forward page="login.jsp" />
<%
	}

	String name = (String)session.getAttribute("name");
	String id = (String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1><%= name %>님 안녕하세요.</h1><br>
	<form action="logout.do" method="post">
	 
		<input type="button" value="게시판GO" onclick="javadcript:window.location='list.do'"> &nbsp;
		<input type="button" value="정보수정" onclick="javadcript:window.location='modify.jsp'"> &nbsp;
		<input type="submit" value="로그아웃">  
	</form>	
</center>
</body>
</html>