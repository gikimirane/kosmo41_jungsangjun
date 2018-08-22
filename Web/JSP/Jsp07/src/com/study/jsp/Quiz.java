package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz
 */
@WebServlet("/Quiz")
public class Quiz extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("doPost");
		
		String sNum1 = request.getParameter("num1");
		String sNum2 = request.getParameter("num2");
		String mat = request.getParameter("mat");
		
//		if(예외체크) {
//			doFail(request, response, 에러내용)
//			return;
//		}
		int nNum1 = 0;
		int nNum2 = 0;
		int nResult = 0;
		try {
		nNum1 = Integer.parseInt(sNum1);
		nNum2 = Integer.parseInt(sNum2);
		//int nResult = 0;
	
		if(mat.equals("+")) {
			nResult = nNum1 + nNum2;
		}else if(mat.equals("-")) {
			nResult = nNum1 - nNum2;
		}else if(mat.equals("*")) {
			nResult = nNum1 * nNum2;
		}else if(mat.equals("/")) {
			nResult = nNum1 / nNum2;
		}
		}catch(Exception e) {
		}
		//doSuccess(request, response, sNum1, sNum2, mat, nResult);
	//}
		

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		writer.println("<html><head></head><body>");
		writer.println(sNum1 + " " + mat + " " + sNum2 + " = " + nResult + "입니다.");
		writer.println("</body></html>");
	}

}
