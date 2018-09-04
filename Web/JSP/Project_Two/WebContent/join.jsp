<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="JavaScript" src="members.js"></script>
</head>
<body>
	<form action="joinOk.do" method="post" name="reg_frm">
		아이디 <br> <input type="text" name="id" size="20"><br>
		
		비밀번호 <br> <input type="password" name="pw" size="20"><br>
		
		비밀번호 재확인 <br> <input type="password" name="pw_check" size="20"><br>
		
		이름 <br> <input type="text" name="name" size="20"><br>
		
		생년월일 <br> <input type="text" name="birth1" size="2"> - 
				<select name="birth2">
				<option value="월">월</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				</select> -
				<input type="text" name="birth3" size="2"> <br>
		
		성별 <br> <select name="gender">
			<option value="성별">성별</option>
			<option value="남자">남자</option>
			<option value="여자">여자</option>
			</select> <br>
				
		메일 <br> <input type="text" name="eMail" size="30"><br>
		
		전화번호 <br> <select name="phone1">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="017">017</option>
			<option value="016">016</option>
			<option value="018">018</option>
			</select> - 
		<input type="text" name="phone2" size="2"> - 
		<input type="text" name="phone3" size="2"> <br>
		
		주소 <br> <input type="text" name="address" size="30"><br><p>
		
		<input type="button" value="회원가입" onclick="infoConfirm()">&nbsp;&nbsp;&nbsp;
		<input type="reset" value="로그인" onclick="javascript:window.location='login.jsp'">
	</form>
</body>
</html>