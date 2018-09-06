<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
	<meta charset="UTF-8">
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<style>
	.test1{ 
	
	}
	
</style>
</head>
<body>
<center>
	<table class="table table-striped" width="500" >
		<tr>
			 <th scope="col">번호</th>
     		 <th scope="col">이름</th>
      		 <th scope="col">제목</th>
     		 <th scope="col">날짜</th>
     		 <th scope="col">히트</th>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.bId}</td>
			<td>${dto.bName}</td>
			<td>
				<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
				<a href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a></td>
			<td>${dto.bDate}</td>
			<td>${dto.bHit}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="write_view.do">글작성</a> </td>
			</tr>
		<tr>
			<td colspan="5">
			<nav aria-label="Page navigation example">
			 <ul class="pagination">
			<!-- 처음 -->
			<c:choose>
				<c:when test="${(page.curPage - 1) < 1}">
					<li class="page-item"><a class="page-link" href="list.do?page=1">First</a></li>
				</c:when>
				<c:otherwise>
					 <li class="page-item"><a class="page-link" href="list.do?page=1">First</a></li>
				</c:otherwise>
			</c:choose>
			
			<!-- 이전 -->
			<c:choose>
				<c:when test="${(page.curPage - 1) < 1}">
					 <li class="page-item"><a class="page-link" href="list.do?page=${page.curPage - 1}">Prev</a></li>
				</c:when>
				<c:otherwise>
					 <li class="page-item"><a class="page-link" href="list.do?page=${page.curPage - 1}">Prev</a></li>
				</c:otherwise>
			</c:choose>
			
			<!-- 개별 페이지 -->
			<c:forEach var="fEach" begin="${page.startPage}" end="${page.endPage}" step="1">
				<c:choose>
					<c:when test="${page.curPage == fEach}">
						[${fEach}] &nbsp;
					</c:when>
					<c:otherwise>
						 <li class="page-item"><a class="page-link" href="list.do?page=${fEach}">${fEach}</a></li>&nbsp;
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<!-- 다음 -->
			<c:choose>
				<c:when test="${(page.curPage + 1) > page.totalPage}">
					 <li class="page-item"><a class="page-link" href="list.do?page=${page.curPage + 1}">Next</a></li>
				</c:when>
				<c:otherwise>
					 <li class="page-item"><a class="page-link" href="list.do?page=${page.curPage + 1}">Next</a></li>
				</c:otherwise>
			</c:choose>
			<!-- 끝 -->
			<c:choose>
				<c:when test="${page.curPage == page.totalPage}">
					 <li class="page-item"><a class="page-link" href="list.do?page=${page.totalPage}">End</a></li>
				</c:when>
				<c:otherwise>
					 <li class="page-item"><a class="page-link" href="list.do?page=${page.totalPage}">End</a></li>
				</c:otherwise>
			</c:choose>
			</ul>
			</nav>
				<input type="submit" value="로그아웃">  
			</td>
		</tr>
	</table>
	</center>
	총게시물 수 : ${page.totalCount}<br>
	목록 수 : ${page.listCount}<br>
	총 페이지 : ${page.totalPage}<br>	
	현재 페이지 : ${page.curPage}<br>		
	페이지 카운터 : ${page.pageCount}<br>	
	처음 페이지 : ${page.startPage}<br>		
	끝 페이지 : ${page.endPage}<br>		
		
 	<!-- Optional JavaScript -->
 	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script> 
 	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script> 

</body>
</html>