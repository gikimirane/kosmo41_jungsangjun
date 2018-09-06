package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.study.jsp.BDao;

public class BModifyCommand implements BCommand 
{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		 MultipartRequest multi = null;
	        int sizeLimit = 10 * 1024 * 1024;
	        String savePath = request.getSession().getServletContext().getRealPath("/fileFolder"); 
	      
	        try{
	            multi=new MultipartRequest(
	                    request,
	                    savePath,
	                    sizeLimit,
	                    "UTF-8",
	                    new DefaultFileRenamePolicy()); 
	 
	         } catch (Exception e) {
	                e.printStackTrace();
	         } 
	        String fileName = multi.getFilesystemName("fileName");	 
		
	        String bId = multi.getParameter("bId");
	        String bName = multi.getParameter("bName");
	        String bTitle = multi.getParameter("bTitle");
	        String bContent = multi.getParameter("bContent");
		
		BDao dao = BDao.getInstance();
		dao.modify(bId, bName, bTitle, bContent);
	}

}