package com.study.jsp.command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.BDao;
import com.study.jsp.BDto;
 
public class BDownloadCommand implements BCommand {
 
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	{
		String bId =request.getParameter("bId");
		BDao dao = BDao.getInstance();
		BDto dto = dao.contentView(bId, request);
		
		String filename = dto.getFilename();
		
		String uploadFileName = request.getSession().getServletContext().getRealPath("/fileFolder") +"/"+ filename;
		File downFile = new File(uploadFileName);
		
		if(downFile.exists() && downFile.isFile())		// 다운로드
		{
			try
			{
				long filesize = downFile.length();
				response.setContentType("application/x-msdownload");
				response.setContentLength((int)filesize);
				String strClient = request.getHeader("user-agent");

				if(strClient.indexOf("MSIE 5.5")!=-1)
				{
					response.setHeader("Content-Disposition", "filename=" + filename + ";" );
				} else {
					response.setHeader("Content-Disposition", "attachment; filename=" + filename + ";" );
				}
				
				response.setHeader("Content-Length", String.valueOf(filesize));
				response.setHeader("Content-Transfer-Encoding", "binary;");
				response.setHeader("Pragma", "no-cache");
				response.setHeader("Cache-Control", "private");

				byte b[] = new byte[1024];

				BufferedInputStream fin = new BufferedInputStream(new FileInputStream(downFile));
				BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());

				int read = 0;

				while((read=fin.read(b)) != -1)
				{
					outs.write(b, 0, read);
				}
				outs.flush();
				outs.close();
				fin.close();

			} catch(Exception e) {
				System.out.println("Download Exception : " + e.getMessage());
			}
		} else {
			System.out.println("Download Error : downFile Error [" + downFile + "]");
		}
		return;
	}
}

		