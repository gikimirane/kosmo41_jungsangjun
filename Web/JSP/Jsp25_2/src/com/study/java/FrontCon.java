package com.study.java;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.do")
public class FrontCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontCon() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("doGet");
		actionDo(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("actionDo");
		
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);
		String conPath = request.getContextPath();
		System.out.println("conPath : " + conPath);
		String command = uri.substring(conPath.length());
		System.out.println("command : " + command);
		
		if(command.equals("/loginok.do")) {
			loginok(request, response);
		} else if (command.equals("/modifyok.do")) {
			modifyok(request, response);
		} else if (command.equals("/joinok.do")) {
			joinok(request, response);
		} else if (command.equals("/logout.do")) {
			logout(request, response);
		} 
	}
	
	public void loginok (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("loginok");	
		
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDao dao = MemberDao.getInstance();
		int checkNum = dao.userCheck(id, pw);
		if(checkNum == -1) {
			// html 출력
			writer.println("");
			writer.close();
			
		} else {
		} else if(checkNum == 0) {
		}else if (checkNum == 1) {
			MemberDto dto = dao.getMember(id);
			
			if(dto == null) {
			String name = dto.getName();
			ServletRequest session;
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("ValidMem", "yes");
			response.sendRedirect("main.jsp");
		
		
	}
	
	public void modifyok (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("modifyok");	
		
		request.setCharacterEncoding("UTF-8");
		String pw = request.getParameter("pw");
		String eMail = request.getParameter("eMail");
		String address = request.getParameter("address");
		
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		MemberDto dto = new MemberDto();
		dto.setId(id);
		dto.setPw(pw);
		dto.seteMail(eMail);
		dto.setAddress(address);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		writer.println("");
		writer.close();
		
	
	public void joinok (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("joinok");	
		
		
	}
	
	public void logout (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("logout");	
		
		
	}
}
