<%@page import="com.study.jsp.MemberDto" %>
<%@page import="com.study.jsp.MemberDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% 
	String id = (String)session.getAttribute("id");
	MemberDao dao = MemberDao.getInstance();
	MemberDto dto = dao.getMember(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="JavaScript" src="members.js"></script>
</head>
<body>
	<form action="modifyOk.do" method="post" name="reg_frm">
		아이디 : <%=dto.getId() %><br>
		비밀번호 : <input type="password" name="pw" size="20"><br>
		비밀번호 확인 : <input type="password" name="pw_check" size="20"><br>
		이름 : <%=dto.getName() %><br>
		생년월일 : <%=dto.getBirth() %><br>
		성별 : <%=dto.getGender() %><br>
		메일 : <input type="text" name="eMail" size="30" value="<%= dto.geteMail() %>"><br>
		전화번호 <br> <select name="phone1">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="017">017</option>
			<option value="016">016</option>
			<option value="018">018</option>
			</select> - 
		<input type="text" name="phone2" size="2"> - 
		<input type="text" name="phone3" size="2"> <br>
		주소 : <input type="text" name="address" size="30"<%= dto.getAddress() %>"><br><p>
		<input type="button" value="수정" onclick="updateInfoConfirm()">&nbsp;&nbsp;&nbsp;
		<input type="reset" value="취소" onclick="javascript:window.location='main.jsp'">
	</form>
</body>
</html>