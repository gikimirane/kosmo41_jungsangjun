package com.study.java;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Service {

	public interface Service {
		
		public void execute(HttpServletRequest request, 
				HttpServletResponse response)
				throws ServletException, IOException ;
	}
}
