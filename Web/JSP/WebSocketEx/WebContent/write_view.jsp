<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="//code.jquery.com/jquery-1.9.1.min.js"></script> 
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
</head>
<body>
	<table cellpadding="0" cellspacing="0" border="1">
		<form action="write.do" method="post">
			<tr>
				<td> 이름 </td>
				<td> <input type="text" name="bName" size="50"> </td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" name="bTitle" size="50"> </td>
			</tr>
			<tr>
				<th class="text=center">내용</th>
				<td><textarea name="contents" id="summernote"></textarea></td>
				<script>
				$(document).ready(function(){
					$('#summernote').summernote({
						options: {disableDragAndDrop: false},
						lang: 'ko-KR',
						height: 500,
						toolbar: [
							['style', ['style']],
							['style', ['bold', 'italic', 'underline', 'strikethrough', 'clear']],
							['fontface', ['fontname']],
							['textsize', ['fontsize']],
							['color', ['color']],
							['alignment', ['ul', 'ol', 'paragraph', 'lineheight']],
							['height', ['height']],
							['table', ['table']],
							['insert', ['link']]
						]
		
					});
				});
</script>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="입력"> &nbsp;&nbsp;
					<a href="list.do">목록보기</a>
				</td>
			</tr>
		</form>
	</table>		
</body>
</html>