<%@page import="com.study.jsp.MemberDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
	<title>탈퇴 화면</title>
	<script type="text/javascript">
		// 비밀번호 미입력시 경고창
		function checkValue(){
			if(!document.bdelete.pw.value){
				alert("비밀번호를 입력하지 않았습니다.");
				return false;
			}
		}
	</script>
	
</head>
<body>

	<br><br>
	<b><font size="6" color="gray">회원탈퇴</font></b>
	<br><br><br>

	<form name="delete" method="post" action="deleteOk.jsp"
		onsubmit="return checkValue()">

		<table>
			<tr>
				<td bgcolor="skyblue">비밀번호</td>
				<td><input type="password" name="pw" maxlength="50"></td>
			</tr>
		</table>
		
		<br> 
		<input type="button" value="취소" onclick="javascript:window.location='main.jsp'">
		<input type="submit" value="탈퇴" /> 
	</form>
</body>
</html>