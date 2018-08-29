<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id == null) {
	%>
	<jsp:forward page="login.jsp" />

	<%
	}else{
		session.setAttribute("uid", id);
	}
	%>
	<div>
		사용자 아이디 : <%= id %>
	</div>
	<div>
		<input type="text" id="messageinput" />
	</div>
	<div>
		<button type="button" onclick="openSocket();">Open</button>
		<button type="button" onclick="send();">Send</button>
		<button type="button" onclick="closeSocket();">Close</button>
	</div>
	<!--  -->
	<div id="messages"></div>
	
	<!--  -->
	<script type="text/javascript">
		var webSocket;
		var messages = document.getElementById("messages");
		
		function openSocket() {
			//
			if (webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED) {
				writeResponse("WebSocket is already opened.");
				return;
			}
			
			webSocket = new WebSocket("ws://localhost:8081/WebSocketEx/websocketendpoint2")
						// localhost 주소 수정~~ 예)192.168.0.113:8081 이렇게 해야 멀티 가능
			webSocket.onopen = function(event) {
				if(event.data === undefined)
					return;
				
				writeResponse(event.data);
			};
			
			webSocket.onmessage = function(event) {
				writeResponse(event.data);
			};
			webSocket.onclose = function(event) {
				writeResponse("Conncetion closed");
			};
		}
		
		function send() {
			var id = "<%= id %>";
			var text = document.getElementById("messageinput").value;
			webSocket.send(id + "|" + text);
		}
		
		function closeSocket() {
			webSocket.close();
		}
		
		function writeResponse(text) {
			messages.innerHTML += "<br/>" + text;
		}
		
	</script>
</body>
</body>
</html>