import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// 전화번호 관리 프로그램 구현 프로젝트
// Version 0.9.2

interface INIT_MENU
{
	int INPUT = 1, SEARCH = 2, DLELETE = 3, UPDATE = 4, EXIT = 5; 
}

interface INPUT_SELECT
{
	int NORMAL = 1, UNIV = 2, COMPANY = 3; 
}

class MenuChoiceException extends Exception
{
	int wrongChoice;
	
	public MenuChoiceException(int choice)
	{
		super("잘못된 선택이 이뤄졌습니다.");
		wrongChoice = choice;
	}
	
	public void showWrongChoice()
	{
		System.out.println(wrongChoice + "에 해당하는 선택은 존재하지 않습니다.");
	}
}

class PhoneBookManager
{

	static PhoneBookManager inst = null;
	public static PhoneBookManager createManagerInst()
	{
		if(inst == null)
			inst = new PhoneBookManager();
		
		return inst;
	}

	//데이터의 입력
	public void inputData() throws MenuChoiceException
	{
		String name = null;
		String phone = null;
		String kind = null;
		String comp = null;
		String univ = null;
		String major = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int year = 0;
		
		
		System.out.println("데이터의 입력을 시작합니다...");
		System.out.println("1. 일반, 2. 대학, 3. 회사");
		System.out.print("선택>> ");
		int choice = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		
		if(choice < INPUT_SELECT.NORMAL || choice > INPUT_SELECT.COMPANY  )
			throw new MenuChoiceException(choice);
		
		switch(choice)
		{
		case INPUT_SELECT.NORMAL :
			System.out.print("이    름 : ");
			name = MenuViewer.keyboard.nextLine();
			System.out.print("전화번호 : ");
			phone = MenuViewer.keyboard.nextLine();
			System.out.print("분    류 : ");
			kind = MenuViewer.keyboard.nextLine();
			break;
		case INPUT_SELECT.UNIV :
			System.out.print("이    름 : ");
			name = MenuViewer.keyboard.nextLine();
			System.out.print("전화번호 : ");
			phone = MenuViewer.keyboard.nextLine();
			System.out.print("분    류 : ");
			kind = MenuViewer.keyboard.nextLine();
			System.out.print("전    공 : ");
			major = MenuViewer.keyboard.nextLine();
			System.out.print("학    년 : ");
			year = MenuViewer.keyboard.nextInt();
			MenuViewer.keyboard.nextLine();
			break;
		case INPUT_SELECT.COMPANY:
			System.out.print("이    름 : ");
			name = MenuViewer.keyboard.nextLine();
			System.out.print("전화번호 : ");
			phone = MenuViewer.keyboard.nextLine();
			System.out.print("분    류 : ");
			kind = MenuViewer.keyboard.nextLine();
			System.out.print("회    사 : ");
			comp = MenuViewer.keyboard.nextLine();
			break;
		}
		
		try
		{
			con = ConnectionPool.getConnection();
			String sql = "insert into test03 values(?,?,?,?,?,?,?)"; 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name); 
			pstmt.setString(2, phone);
			pstmt.setString(3, kind);
			pstmt.setString(4, comp);
			pstmt.setString(5, univ);
			pstmt.setString(6, major);
			pstmt.setInt(7, year);

			int re = pstmt.executeUpdate(); 

			if (re >=1)
			{
			System.out.println("전화번호 등록 완료");
			}
			else
			{
			System.out.println("전화번호 등록 실패");
			}
			
		}
		catch (Exception e)
		{
		System.out.println(e);
		} 
		finally 
		{
	         try
	         {
	         
	             if (pstmt != null)
	                pstmt.close();
	             if (con != null)
	                con.close();
	          } 
	          catch (Exception e) 
	          {
	             System.out.println("1");
	             e.printStackTrace();
	          }
	     }
	}	
	
	//데이터의 검색
	public void searchData() 
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null; 
		
		String name = null;
		String name2 = null;
		String phone = null;
		String kind= null;
		String comp = null;
		String univ = null;
		String major = null;
		int year = 0;
		
		System.out.println("데이터 검색을 시작합니다...");
		System.out.print("이    름 : ");
		name = MenuViewer.keyboard.nextLine();
		
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException cnfe) 
		{
			cnfe.printStackTrace();
		}
		try
		{
			con = ConnectionPool.getConnection();
			stmt = con.createStatement();
			sql = "select * from test03 where name like '%" + name + "%'";
			rs = stmt.executeQuery(sql);

			if (rs.next()) 
			{
				name2 = rs.getString(1);
				phone = rs.getString(2);
				kind = rs.getString(3);
				comp = rs.getString(4);
				univ = rs.getString(5);
				major = rs.getString(6);
				year = rs.getInt(7);
				System.out.println(
						name2 + ", " + phone + ", " + kind + ", " + comp + ", " + univ + ", " + major + ", " + year);
			}
			
			if (name.equals(name2)) 
			{
				System.out.println("검색 완료");
			}
			else
			{
				System.out.println("일치하는 데이터가 없습니다.");
			}

		} 
		catch (Exception e)
		{
			System.out.println(e);
		} 
		finally 
		{
			try 
			{
				if(stmt != null)
					rs.close();
				if (rs != null)
					rs.close();
				if (con != null)
					con.close();
			} 
			catch (Exception e) 
			{
				System.out.println("2");
				e.printStackTrace();
			}
		}

	}	
	
	//데이터의 삭제
    public void deleteData() 
    {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = null; 
		String name = null;
		String phone = null;
		String kind= null;
		String comp = null;
		String univ = null;
		String major = null;
		int year = 0;
		
		System.out.println("데이터 삭제를 시작합니다..");
    	System.out.print("이    름 : ");
    	name = MenuViewer.keyboard.nextLine();
		
    	try
		 {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		 }
		 catch(ClassNotFoundException cnfe) 
		 {
			cnfe.printStackTrace();
		 }
	 
			try 
			{
				con = ConnectionPool.getConnection();
				sql = "delete from test03 where name like '%"+name+"%'";
				pstmt = con.prepareStatement(sql);
			
				int re = pstmt.executeUpdate(); 
				
				if (re >= 1) 
				{
					System.out.println("전화번호 삭제 완료");
				}
				else 
				{
					System.out.println("전화번호 삭제 실패");
				}
			}
			catch(Exception e) 
			{
				System.out.println(e);
			} 
			finally 
		    {
			try 
			{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} 
			catch (Exception e) 
			{
				System.out.println("3");
				e.printStackTrace();
			}
		}
    }
   
    //데이터의 수정
    public void updateData() throws MenuChoiceException
    {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = null; 
		String name = "";
		String name2 = null;
		String phone = null;
		String phone2 = null;
		String kind= null;
		String comp = null;
		String univ = null;
		String major = null;
		int year = 0;
		
       	try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException cnfe) 
		{
			cnfe.printStackTrace();
		}    	
		try 
		{
			con = ConnectionPool.getConnection();
			System.out.println("데이터를 수정합니다.. 검색");
			System.out.print("이    름 : ");
			name2 = MenuViewer.keyboard.nextLine();

			stmt = con.createStatement();
			sql = "select * from test03 where name = '" + name2 + "'";
			rs = stmt.executeQuery(sql);

			if (rs.next()) 
			{
				name = rs.getString(1);
				phone = rs.getString(2);
				kind = rs.getString(3);
				comp = rs.getString(4);
				univ = rs.getString(5);
				major = rs.getString(6);
				year = rs.getInt(7);
			}
    	    		
			if (name.equals(name2)) 
			{
				System.out.println(
						name + ", " + phone + ", " + kind + ", " + comp + ", " + univ + ", " + major + ", " + year);
				System.out.print("바뀐번호 : ");
				phone2 = MenuViewer.keyboard.nextLine();

				sql = "update test03 set phone = '" + phone2 + "' " + "where name = '" + name + "'";
			} 
			else 
			{
				System.out.println("일치하는 데이터가 없습니다.");
			}

			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			int re = stmt.getUpdateCount();

			if(re == 1)
			{
				System.out.println("전화번호 수정 완료");
			}
			else
			{
				System.out.println("전화번호 수정 실패");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			}
			catch (Exception e)
			{
				System.out.println("2");
				e.printStackTrace();
			}
		}	
    }   
}

class MenuViewer
{
	public static Scanner keyboard = new Scanner(System.in);
	
	//쇼메뉴
	public static void showMenu()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 데이터 수정");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택 : ");
	}
}

public class PhoneBookVer11 
{
	//메인
	public static void main(String[] args) 
	{
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		int choice;
		
		while(true)
		{
			try 
			{
				MenuViewer.showMenu();
				choice = MenuViewer.keyboard.nextInt();
				MenuViewer.keyboard.nextLine();         
				
				if(choice < INIT_MENU.INPUT || choice > INIT_MENU.EXIT  )
					throw new MenuChoiceException(choice);
				
				switch(choice)
				{
				case INIT_MENU.INPUT :
					manager.inputData();
					break;
				case INIT_MENU.SEARCH :
					manager.searchData();
					break;
				case INIT_MENU.DLELETE :
					manager.deleteData();
					break;
					
				case INIT_MENU.UPDATE :
					manager.updateData();
					break;	
			
				case INIT_MENU.EXIT :
					System.out.println("프로그램을 종료합니다.");
					return;
				}
			} 
			catch (MenuChoiceException e) 
			{
				e.showWrongChoice();
				System.out.println("메뉴 선택을 처음부터 다시 진행합니다.\n");
			}

		}
	}		
}
	
	
