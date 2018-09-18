<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 자바빈 클래스 import --%>      
<%@ page import="jsp.member.model.MemberDto" %>
<%-- Dao import --%>   
<%@ page import="jsp.member.model.MemberDao" %> 

<!DOCTYPE html> 
<html>
<head>
    <title>회원가입 처리 JSP</title>

</head>
<body>
    <%-- Join_view.jsp에서 입력한 정보를 넘겨 받아 처리한다. --%>
    <% 
        // 한글 깨짐을 방지하기 위한 인코딩 처리
        request.setCharacterEncoding("UTF-8"); 
    %>
    
    <%-- 자바빈 관련 액션태그 사용 --%>
    <jsp:useBean id="MemberDto" class="jsp.member.model.MemberDto" />
    <jsp:setProperty property="*" name="MemberDto"/>    
    <%
        MemberDao dao = MemberDao.getInstance();
    
        // 회원정보를 담고있는 MemberDto을 dao의 insertMember() 메서드로 넘긴다.
        // insertMember()는 회원 정보를 JSP_MEMBER 테이블에 저장한다.
        dao.insertMember(MemberDto);
    %>
  
    <div id="wrap">
        <br><br>
        <b><font size="5" color="gray">회원가입 정보를 확인하세요.</font></b>
        <br><br>
        <font color="blue"><%=MemberDto.getName() %></font>님 가입을 축하드립니다.
        <br><br>
        
        <%-- 자바빈에서 입력된 값을 추출한다. --%>
        <table>
            <tr>
                <td id="title">아이디</td>
                <td><%=MemberDto.getId() %></td>
            </tr>
                        
            <tr>
                <td id="title">비밀번호</td>
                <td><%=MemberDto.getPw() %></td>
            </tr>
                    
            <tr>
                <td id="title">이름</td>
                <td><%=MemberDto.getName() %></td>
            </tr>
                    
            <tr>
                <td id="title">생일</td>
                <td>
                    <%=MemberDto.getBirthyy() %>년 
                    <%=MemberDto.getBirthmm() %>월 
                    <%=MemberDto.getBirthdd() %>일
                </td>
            </tr>
                    
            <tr>
                <td id="title">이메일</td>
                <td>
                    <%=MemberDto.geteMail1() %>@<%=MemberDto.geteMail2() %>
                </td>
            </tr>
                    
            <tr>
                <td id="title">휴대전화</td>
                <td>
                	<%=MemberDto.getPhone1() %>
                	<%=MemberDto.getPhone2() %>
                	<%=MemberDto.getPhone3() %>
                </td>
            </tr>
         
        </table>
        
        <br>
        <input type="button" value="확인">
    </div>
</body>
</html>
