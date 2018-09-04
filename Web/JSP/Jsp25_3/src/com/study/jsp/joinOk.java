package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class joinOk implements Service {

	public joinOk() {
	
	}

	@Override
	public void execute(HttpServletRequest request,
						HttpServletResponse response) 
			throws ServletException, IOException {
		
			System.out.println("loginOk");
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			HttpSession session = request.getSession();
			
			request.setCharacterEncoding("UTF-8");
			String pw = request.getParameter("pw");
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String eMail = request.getParameter("eMail");
			String address = request.getParameter("address");		
			
			MemberDto dto = new MemberDto();
		
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.seteMail(eMail);
			dto.setAddress(address);
			dto.setrDate(new Timestamp(System.currentTimeMillis()));
			MemberDao dao = MemberDao.getInstance();
			if(dao.confirmId(dto.getId()) == MemberDao.MEMBER_EXISTENT) {
				writer.println("<script language=\"javascript\">");
				writer.println("alert(\"아이디가 이미 존재합니다.\");");
				writer.println("history.back();");
				writer.println("</script>");
				writer.close();
			} else {
				int ri = dao.insertMember(dto);
				if(ri == MemberDao.MEMBER_JOIN_SUCCESS) {
					writer.println("<script language=\"javascript\">");
					writer.println("alert(\"회원가입을 축하 합니다.\");");
					writer.println("document.location.href=\"login.jsp\";");
					writer.println("</script>");
					writer.close();
				
				} else {
					writer.println("<script language=\"javascript\">");
					writer.println("alert(\"회원가입에 실패했습니다.\");");
					writer.println("document.location.href=\"login.jsp\";");
					writer.println("</script>");
					writer.close();
				}
			}
		

	}

}
