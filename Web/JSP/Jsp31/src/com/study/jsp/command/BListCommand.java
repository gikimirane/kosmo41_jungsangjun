package com.study.jsp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.BDao;
import com.study.jsp.BDto;
import com.study.jsp.BPageInfo;

public class BListCommand implements BCommand 
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		// 현재 페이지 번호 만들기
		int nPage = 1;
		try {
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
		} catch (Exception e) {

		}
		// 검색조건과 검색내용을 가져온다.
		String keyfield = request.getParameter("keyfield");
		String keyword = request.getParameter("keyword");
		
		// 검색어의 처리
		if(request.getParameter("keyfield") !=null)
		{
		keyfield = request.getParameter("keyfield");
		keyword = request.getParameter("keyword");
						
		// 검색한 정보를 session에 실어 상태유지 시킨다.
		request.getSession().setAttribute("keyfield", keyfield);
		request.getSession().setAttribute("keyword", keyword);
		}
		else if(request.getSession().getAttribute("keyfield") != null)
		{ // 만약에 session에 keyfield의 값이 
		  // 실렸다면 변수에 저장하여 BDao에게 전달해준다.
		keyfield = (String)request.getSession().getAttribute("keyfield");
		keyword = (String)request.getSession().getAttribute("keyword");
		}
		
		BDao dao = BDao.getInstance();
		BPageInfo pinfo = dao.articlePage(nPage, keyfield, keyword, request);
		request.setAttribute("page", pinfo);
		request.setAttribute("keyfield", keyfield);
		request.setAttribute("keyword", keyword);
		
		nPage = pinfo.getCurPage();
		
		HttpSession session = null;
		session = request.getSession();		
		session.setAttribute("cpage", nPage);
		session.setAttribute("keyfield", keyfield);
		session.setAttribute("keyword", keyword);
		
		ArrayList<BDto> dtos = dao.list(nPage, keyfield, keyword, request);
		request.setAttribute("list", dtos);
	
	}

}

