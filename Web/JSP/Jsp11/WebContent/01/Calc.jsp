<%@page import="java.util.Arrays" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		String num1, num2, mat, sNum1, sNum2;
	%>
	
	<%
		String sType = request.getMethod();
	
		if(sType.equals("POST")) {
			request.setCharacterEncoding("UTF-8");
	
			sNum1 = request.getParameter("num1");
			sNum2 = request.getParameter("num2");
			mat = request.getParameter("mat");
			
			int nNum1 = 0;
			int nNum2 = 0;
			int nResult = 0;
			try {
			nNum1 = Integer.parseInt(sNum1);
			nNum2 = Integer.parseInt(sNum2);
			//int nResult = 0;
		
			if(mat.equals("+")) {
				nResult = nNum1 + nNum2;
			}else if(mat.equals("-")) {
				nResult = nNum1 - nNum2;
			}else if(mat.equals("*")) {
				nResult = nNum1 * nNum2;
			}else if(mat.equals("/")) {
				nResult = nNum1 / nNum2;
			}
			}catch(Exception e) {
			}
	
	%>
	
	<%--
		out.println("num1 : " + nNum1 + "<br>");
		out.println("num2 : " + nNum2 + "<br>");
		out.println(sNum1 + " " + mat + " " + sNum2 + " = " + nResult + "입니다.");
	--%>
	<%=sNum1%> <%=mat%> <%=sNum2%>=<%=nResult%> 


	<%
		} else {
	%>
	<h1>허용된 요청방식이 아닙니다.</h1>
	<%
		}
	%>
	
</body>
</html>