package com.study.jsp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.MemberDao;
import com.study.jsp.MemberDto;

public class BListCommand implements BCommand 
{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		MemberDao dao = new MemberDao();
		ArrayList<MemberDto> dtos = dao.list();
		request.setAttribute("list", dtos);
	}

}
