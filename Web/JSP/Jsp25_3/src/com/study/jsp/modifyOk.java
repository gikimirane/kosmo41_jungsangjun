package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class modifyOk implements Service {

	public modifyOk() {
		
	}

	@Override
	public void execute(HttpServletRequest request,
						HttpServletResponse response)
		throws ServletException, IOException {
		
			System.out.println("modifyOk");
					
			request.setCharacterEncoding("UTF-8");
			String pw = request.getParameter("pw");
			String eMail = request.getParameter("eMail");
			String address = request.getParameter("address");		
			
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("id");
			
			MemberDao dao = MemberDao.getInstance();
			MemberDto dto = new MemberDto();
			dto.setId(id);
			dto.setPw(pw);
			dto.seteMail(eMail);
			dto.setAddress(address);
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			
			int ri = dao.updateMember(dto);
			
			if(ri ==1) { 
				writer.println("<script language=\"javascript\">");
				writer.println("alert(\"정보가 수정되었습니다.\");");
				writer.println("document.location.href=\"main.jsp\";");
				writer.println("</script>");
				writer.close();
				
			} else {
				writer.println("<script language=\"javascript\">");
				writer.println("\"정보수정에 실패했습니다.\"");
				writer.println("history.go(-1);");
				writer.close();
				
			}
			
		

	}

}
