<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script>

function onDownload(bid) {var o = document.getElementById("ifrm_filedown");	
o.src = "download.do?idx="+bid;}
</script>	

<meta charset="UTF-8"> 
</head>
<body>
<iframe id="ifrm_filedown" style="position:absolute; 
z-index:1; visibility:hidden;"></iframe>         
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
				<th colspan="2">첨부파일</th>
				<td colspan="2">
				<a href="#" onclick="onDownload('${content_view.bid}')">${content_view.filename}</a>&nbsp;
				<a href="modify_view.do?bId=${content_view.bId}">[수정]</a>&nbsp;
				<a href="list.do?page=<%= session.getAttribute("cpage") %>">[목록보기]</a>&nbsp;	
				<a href="delete.do?bId=${content_view.bId}">[삭제]</a>&nbsp;
				<a href="reply_view.do?bId=${content_view.bId}">[답변]</a>
				</td>
			</tr>
	</table>		
</center>
</body>
</html>