package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.MemberDao;

public class BWriteCommand implements BCommand 
{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");

		MemberDao dao = new MemberDao();
		dao.join(bName, bTitle, bContent);
	}

}
