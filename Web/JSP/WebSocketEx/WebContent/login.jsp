<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<script>
		function form_check() {
			submit();
		}
		function submit() {	
			document.login_form.submit();
	}
</script>
<body>
	
	<form name=login_form action="client.jsp" method="post">
		아이디 : <input type="text" name="id" 
						value="<%if(session.getAttribute("id") != null)
							out.println(session.getAttribute("id"));
							%>"> <br>
				
		비밀번호 : <input type="password" name="pw"><br><p>
		
		<input type="button" value="로그인" onclick="form_check()">&nbsp;&nbsp;
		<input type="button" value="회원가입" >
	</form>
	
</body>
</html>