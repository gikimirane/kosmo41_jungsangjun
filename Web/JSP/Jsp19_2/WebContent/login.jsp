<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
		function form_check() {
			submit_ajax();
		}
		function submit_ajax() {	
			var queryString = $("#LoginProcess").serialize();
						
			$.ajax({
				url : '/Jsp19_2/LoginProcess',
				type : 'POST',
				data : queryString,
				datatype : 'json',
				success : function(json){
					var results = eval(json);
					if(results[0].result=="ok") {
						alert("정상 가입되었습니다.")
						window.location.replace("modify.jsp");
					}else{
						alert(results[0].desc);
					}					
				}
			});
		}
	</script>
</head>
<body>

	<form name="LoginProcess" id="LoginProcess">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="text" name="pw"><br>
		<input type="button" value="로그인" onclick="form_check()" />
	</form>
	
</body>
</html>