package com.study.jsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class BDao {

	private static BDao instance = new BDao();
	DataSource dataSource = null;
	
	int listCount = 10;		//	한페이지당 보여줄 게시물의 갯수
	int pageCount = 10;		//하단에 보여줄 페이지 리스트의 갯수
	
	private BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static BDao getInstance() {
		return instance;
	}
	
	public void write(String bName, String bTitle, String bContent, String filename, String bBoard) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = 	"insert into mvc_board " +
						"(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent, filename, bBoard)" +
						"values "+
						"(mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0, ?, ?)";
	
		try 
			{		
			con = dataSource.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, filename);
			pstmt.setString(5, bBoard);
			int rn = pstmt.executeUpdate();		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	// 게시물 작성
		
	public ArrayList<BDto> list(int curPage,String keyfield, String keyword, HttpServletRequest request)

	{
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
			
		int nStart = (curPage - 1) * listCount + 1;
		int nEnd = (curPage - 1) * listCount + listCount;
			
		try
			{
			con = dataSource.getConnection();
			
			if(keyfield == null) {
				String query ="select * " +
						  	  "  from ( " +
							  "	   select rownum num, A.* " +
							  "	     from ( " +
							  "	        select * " +
							  "	          from mvc_board " +
							  "	         order by bgroup desc, bstep asc ) A " +
							  "	    where rownum <= ? ) B " +
							  "	where B.num >= ? ";

				pstmt=con.prepareStatement(query);
				pstmt.setInt(1, nEnd);
				pstmt.setInt(2, nStart);
				}
				else if(keyfield.equals("1")) //이름 검색
				{	
					String query ="select * " +
						  	  "  from ( " +
							  "	   select rownum num, A.* " +
							  "	     from ( " +
							  "	        select * " +
							  "	          from mvc_board " +
							  "				where bName like ?" +
							  "	         order by bgroup desc, bstep asc ) A " +
							  "	    where rownum <= ? ) B " +
							  "	where B.num >= ? ";

				pstmt=con.prepareStatement(query);
				pstmt.setString(1, "%"+keyword+"%");
				pstmt.setInt(2, nEnd);
				pstmt.setInt(3, nStart);
				}
				else if (keyfield.equals("2"))	//제목 검색
				{
					String query ="select * " +
						  	  "  from ( " +
							  "	   select rownum num, A.* " +
							  "	     from ( " +
							  "	        select * " +
							  "	          from mvc_board " +
							  "             where bTitle like ? " +
							  "	         order by bgroup desc, bstep asc ) A " +
							  "	    where rownum <= ? ) B " +
							  "	where B.num >= ? ";

				pstmt=con.prepareStatement(query);
				pstmt.setString(1, "%"+keyword+"%");
				pstmt.setInt(2, nEnd);
				pstmt.setInt(3, nStart);				
				}				
				else if (keyfield.equals("3"))	//내용 검색
				{
					String query ="select * " +
						  	  "  from ( " +
							  "	   select rownum num, A.* " +
							  "	     from ( " +
							  "	        select * " +
							  "	          from mvc_board " +
							  "             where bContent like ? " +
							  "	         order by bgroup desc, bstep asc ) A " +
							  "	    where rownum <= ? ) B " +
							  "	where B.num >= ? ";

				pstmt=con.prepareStatement(query);
				pstmt.setString(1, "%"+keyword+"%");
				pstmt.setInt(2, nEnd);
				pstmt.setInt(3, nStart);				
				}
				else if (keyfield.equals("4"))	//제목 + 내용 검색
				{
					String query ="select * " +
						  	  "  from ( " +
							  "	   select rownum num, A.* " +
							  "	     from ( " +
							  "	        select * " +
							  "	          from mvc_board " +
							  "             where bTitle like ? or bContent like ? " +
							  "	         order by bgroup desc, bstep asc ) A " +
							  "	    where rownum <= ? ) B " +
							  "	where B.num >= ? ";

				pstmt=con.prepareStatement(query);
				pstmt.setString(1, "%"+keyword+"%");
				pstmt.setString(2, "%"+keyword+"%");
				pstmt.setInt(3, nEnd);
				pstmt.setInt(4, nStart);
				}		
				resultSet = pstmt.executeQuery();
						
			while(resultSet.next())
			{
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				String filename = resultSet.getString("filename");
				String bBoard = resultSet.getString("bBoard");
				
				BDto dto= new BDto(bId, bName, bTitle, bContent, bDate, 
									bHit, bGroup, bStep, bIndent, filename, bBoard);
				
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try 
				{
				if(resultSet !=null) resultSet.close();
				if(pstmt != null) pstmt.close();
				if(con!=null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	// 게시물 목록
	
	public BPageInfo articlePage(int curPage, String keyfield, String keyword, HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		HttpSession session = request.getSession();
		
		//총 게시물의 갯수
		int totalCount = 0;
		try {
			con = dataSource.getConnection();
								
			if(keyfield == null) //전체글의 개수
			{		
				String query = "select count(*) as total from mvc_board";
				pstmt=con.prepareStatement(query);				
			}			
			else if(keyfield.equals("1")) 	// 이름으로 검색한 글의 개수
			{
				String query = "select count(*) as total from mvc_board where bName like ?";
				pstmt=con.prepareStatement(query);
				pstmt.setString(1, "%"+keyword+"%");								
			}
			else if(keyfield.equals("2"))  // 제목으로 검색한 글의 개수
			{
				String query = "select count(*) as total from mvc_board where bTitle like ?";
				pstmt=con.prepareStatement(query);
				pstmt.setString(1, "%"+keyword+"%");		
			}			
			else if(keyfield.equals("3")) // 내용으로 검색한 글의 개수
			{
				String query = "select count(*) as total from mvc_board where bContent like ?";
				pstmt=con.prepareStatement(query);
				pstmt.setString(1, "%"+keyword+"%");				
			}			
			else if(keyfield.equals("4")) // 제목 + 내용으로 검색한 글의 개수
			{
				String query = "select count(*) as total from mvc_board where bTitle like ? or bContnet like ?";
				pstmt=con.prepareStatement(query);
				pstmt.setString(1, "%"+keyword+"%");	
				pstmt.setString(2, "%"+keyword+"%");	
			}					
			resultSet = pstmt.executeQuery();					
			if(resultSet.next()) {
				totalCount = resultSet.getInt("total");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
		// 총 페이지 수
		int totalPage = totalCount / listCount;
		if (totalCount % listCount > 0)
		    totalPage++;
		
		// 현재 페이지 번호
		int myCurPage = curPage;
		if (myCurPage > totalPage)
			myCurPage = totalPage;
		if (myCurPage < 1)
			myCurPage = 1;
		
		// 시작 페이지 번호
		int startPage = ((myCurPage - 1) / pageCount) * pageCount + 1;
		
		//끝 페이지 번호
		int endPage = startPage + pageCount - 1;
		if (endPage > totalPage) 
		    endPage = totalPage;
			
		BPageInfo pinfo = new BPageInfo();
		pinfo.setTotalCount(totalCount);
		pinfo.setListCount(listCount);
		pinfo.setTotalPage(totalPage);
		pinfo.setCurPage(myCurPage);
		pinfo.setPageCount(pageCount);
		pinfo.setStartPage(startPage);
		pinfo.setEndPage(endPage);
		
		return pinfo;
	}
	// 게시물 페이지
	
	public BDto contentView(String strID, HttpServletRequest request) {
		//upHit(strId)
		
		BDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		try {
			con = dataSource.getConnection();
			
			String query = 	"select * from mvc_board where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(strID));
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				String filename = resultSet.getString("filename");
				String bBoard = resultSet.getString("bBoard");
				
				dto= new BDto(bId, bName, bTitle, bContent, bDate, 
						bHit, bGroup, bStep, bIndent, filename, bBoard);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	// 게시물 보기
	
	public void modify(String bId, String bName, String bTitle, String bContent, String filename, String bBoard) {
	
		Connection con = null;
		PreparedStatement pstmt = null;
		
		System.out.println("bId : " + bId);
		System.out.println("bName : " + bName);
		System.out.println("bTitle : " + bTitle);
		System.out.println("bContent : " + bContent);
		System.out.println("filename : " + filename);
		System.out.println("bBoard : " + bBoard);
			
		String query = 	"update MVC_BOARD " +
						" set BNAME = ?, " +
						"     BTITLE = ?, " +
						"	  BCONTENT = ?, " +
						"     FILENAME = ?,  " +
						"	  BBOARD = ? " +	
						"     where bId = ?";
		try 
			{		
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, filename);
			pstmt.setString(5, bBoard);
			pstmt.setString(6, bId);
			int rn = pstmt.executeUpdate();		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	// 게시물 수정
	
	private void upHit(String bId) {
		Connection con = null;
		PreparedStatement pstmt = null;	
		
		try {
			con = dataSource.getConnection();
			String query = 	"update mvc_board set bHit = bHit + 1 where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bId);
			
			int rn = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}		
	}
	// 게시물 조회
	
	public void delete(String bId) {
		Connection con = null;
		PreparedStatement pstmt = null;	
		
		try {
			con = dataSource.getConnection();
			String query = 	"delete from mvc_board where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bId));
			int rn = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}		
	}
	// 게시물 삭제
	
	public BDto reply_view(String str, HttpServletRequest request) {
		BDto dto = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			con = dataSource.getConnection();
			String query = 	"select * from mvc_board where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(str));
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				String filename = resultSet.getString("filename");
				String bBoard = resultSet.getString("bBoard");
				
				dto= new BDto(bId, bName, bTitle, bContent, bDate, 
						bHit, bGroup, bStep, bIndent, filename, bBoard);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	// 게시물 답변 보기
	
	public void reply(String bId, String bName, String bTitle, String bContent, 
			String bGroup, String bStep, String bIndent, String filename, String bBoard) 
	{
		replyShape(bGroup, bStep);
		
		Connection con = null;
		PreparedStatement pstmt = null;
	
		try 
			{		
			con = dataSource.getConnection();
			String query = 	"insert into mvc_board " +
						"(bId, bName, bTitle, bContent, bGroup, bStep, bIndent, filename, bBoard)" +
					"values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, filename);
			pstmt.setString(5, bBoard);
			pstmt.setInt(6, Integer.parseInt(bGroup));
			pstmt.setInt(7, Integer.parseInt(bStep) + 1);
			pstmt.setInt(8, Integer.parseInt(bIndent) + 1);
			
			int rn = pstmt.executeUpdate();		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	// 게시물 답변
	private void replyShape(String strGroup, String strStep) 
		{
			Connection con = null;
			PreparedStatement pstmt = null;

			try 
				{		
				con = dataSource.getConnection();
				String query = 	"update mvc_board " +
								" set bStep = bStep + 1 " +
								" where bGroup = ? and bStep > ?";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, Integer.parseInt(strGroup));
				pstmt.setInt(2, Integer.parseInt(strStep));
		
				int rn = pstmt.executeUpdate();		
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(Exception e2) {
					e2.printStackTrace();
			}
		}
	}
	// 게시물 그룹
}
