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
	String max = request.getParameter("max");	
	if(max != null) {
		
		try {
			int maxValue = Integer.parseInt(max);
			
			for (int i=0; i<maxValue; i++) {
				out.println(i +"<br>");
			}
		}catch(Exception e){
			//out.println("<h1>'max' value should be NUMBER!!!</h1>");
			out.println("안됨");
		}
	}else{
		out.println("<h1>You must set 'max' parameter!!!</h1>");
	}
%>
</body>
</html>