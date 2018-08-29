package com.study.jsp.command;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BCommand 
{
	public void execute(HttpServletRequest request,
						HttpServletResponse response)
					throws ServerException, IOException;
}
