<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="UTF-8">
</head>
<body class="container">
<center>
	<table width="500" cellpadding="0" cellspacing="0" border="1">	
			<tr>
				<td> 번호 </td>
				<td>${content_view.bId}</td>
			</tr>
			<tr>
				<td> 히트 </td>
				<td>${content_view.bHit}</td>
			</tr>
			<tr>
				<td> 이름 </td>
				<td>${content_view.bName}</td>
			</tr>
			<tr>
				<td> 제목 </td>
			<td>${content_view.bTitle}</td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td>${content_view.bContent}</td>
			</tr>
			<tr>
				<td colspan="2"> 
				<a href="modify_view.do?bId=${content_view.bId}">수정</a>&nbsp;&nbsp;
				<a href="list.do?page=<%= session.getAttribute("cpage") %>">목록보기</a>&nbsp;&nbsp;	
				<a href="delete.do?bId=${content_view.bId}">삭제</a>&nbsp;&nbsp;
				<a href="reply_view.do?bId=${content_view.bId}">답변</a>
				</td>
			</tr>
	</table>	
  <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
 	 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script> 
     <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script> 
</center>  
  </body>
</html>