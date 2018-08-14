import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.sql.*;

interface INIT_MENU
{
	int INPUT=1, SEARCH=2, DELETE=3, CHANGE=4, EXIT=5;
}

interface INPUT_SELECT
{
	int NORMAL=1, UNIV=2, COMPANY=3;
}

class MenuChoiceException extends Exception
{
	int wrongChoice;
	
	public MenuChoiceException(int choice)
	{
		super("잘못된 선택이 이뤄졌습니다.");
		wrongChoice=choice;		
	}
	
	public void showWrongChoice()
	{
		System.out.println(wrongChoice+ " 에 해당하는 선택은 존재하지 않습니다.");
	}
}

class ChangeChoiceException extends Exception
{
	int wrongChoice;
	
	public ChangeChoiceException(int choice)
	{
		super("잘못된 선택이 이뤄졌습니다.");
		wrongChoice=choice;		
	}
	
	public void showWrongChoice()
	{
		System.out.println(wrongChoice+ " 에 해당하는 선택은 존재하지 않습니다.");
	}
}

class PhoneInfo implements Serializable
{
	String name;
	String phoneNumber;
	String birth;
	
	public PhoneInfo(String name, String num, String birth)
	{
		this.name=name;
		phoneNumber=num;
		this.birth=birth;
	}
	public void showPhoneInfo()
	{
		System.out.println("name : " + name);
		System.out.println("phone : " + phoneNumber);
		if(birth!=null)
			System.out.println("birth : " + birth);
	}
	
	public int hashCode()
	{
		return name.hashCode();
	}
	
	public boolean equals(Object obj)
	{
		PhoneInfo cmp=(PhoneInfo)obj;
		if(name.compareTo(cmp.name)==0)
			return true;
		else
			return false;	
	}
}
class PhoneUnivInfo extends PhoneInfo
{
	String major;
	int year;
	
	public PhoneUnivInfo(String name, String num, String birth, String major, int year)
	{
		super(name, num, birth);
		this.major=major;
		this.year=year;
	}
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("major : " + major);
		System.out.println("year : " + year);
	}
}

class PhoneCompanyInfo extends PhoneInfo
{
	String company;
	
	public PhoneCompanyInfo(String name, String num, String birth, String company)
	{
		super(name, num, birth);
		this.company=company;
	}
	
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("company : " + company);
	}
}

class PhoneBookManager
{
	private final File dataFile=new File("PhoneBook.dat");
	HashSet<PhoneInfo> infoStorage=new HashSet<PhoneInfo>();
	
	static PhoneBookManager inst=null;
	public static PhoneBookManager createManagerInst()
	{
		if(inst==null)
			inst=new PhoneBookManager();
		
		return inst;
	}
	
	private PhoneBookManager() 
	{
		readFromFile();
	}
	
	private PhoneInfo readFriendInfo()
	{
		
		System.out.print("이름 : ");
		String name=MenuViewer.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone=MenuViewer.keyboard.nextLine();
		System.out.print("생년월일 : ");
		String birth=MenuViewer.keyboard.nextLine();
		return new PhoneInfo(name, phone, birth);		
	}
	
	private PhoneInfo readUnivFriendInfo()
	{
		System.out.print("이름 : ");
		String name=MenuViewer.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone=MenuViewer.keyboard.nextLine();
		System.out.print("생년월일 : ");
		String birth=MenuViewer.keyboard.nextLine();
		System.out.print("전공 : ");
		String major=MenuViewer.keyboard.nextLine();
		System.out.print("학년 : ");
		int year=MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		return new PhoneUnivInfo(name, phone, birth, major, year);
	}
	
	private PhoneInfo readCompanyFriendInfo()
	{
		System.out.print("이름 : ");
		String name=MenuViewer.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone=MenuViewer.keyboard.nextLine();
		System.out.print("생년월일 : ");
		String birth=MenuViewer.keyboard.nextLine();
		System.out.print("회사 : ");
		String company=MenuViewer.keyboard.nextLine();
		return new PhoneCompanyInfo(name, phone, birth, company);
	}
	
	public void inputData() throws MenuChoiceException
	{
		System.out.println("데이터 입력을 시작합니다...");
		System.out.println("1.일반, 2.대학, 3.회사");
		System.out.print("선택>> ");
		int choice=MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		PhoneInfo info=null;
		
		if(choice<INPUT_SELECT.NORMAL || choice>INPUT_SELECT.COMPANY)
			throw new MenuChoiceException(choice);
		
		switch(choice)
		{
		case INPUT_SELECT.NORMAL :
			info=readFriendInfo();
			break;
		case INPUT_SELECT.UNIV :
			info=readUnivFriendInfo();
			break;
		case INPUT_SELECT.COMPANY :
			info=readCompanyFriendInfo();
			break;
		}
		
		boolean isAdded=infoStorage.add(info);
		if(isAdded==true)
			System.out.println("데이터 입력이 완료되었습니다. \n");
		else
			System.out.println("이미 저장된 데이터입니다. \n");		
	}
	
	public void searchData()
	{
		System.out.println("데이터 검색을 시작합니다...");
		
		System.out.print("이름 : ");
		String name=MenuViewer.keyboard.nextLine();
		
		PhoneInfo info=search(name);
		if(info==null)
		{
			System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
		}
		else
		{
			info.showPhoneInfo();
			System.out.println("데이터 검색이 완료되었습니다. \n");			
		}
	}
	public void deleteData()
	{
		System.out.println("데이터 삭제를 시작합니다...");
		
		System.out.print("이름 : ");
		String name=MenuViewer.keyboard.nextLine();
		
		Iterator<PhoneInfo> itr=infoStorage.iterator();
		while(itr.hasNext())
		{
			PhoneInfo curInfo=itr.next();
			if(name.compareTo(curInfo.name)==0)
			{
				itr.remove();
				System.out.println("데이터 삭제가 완료되었습니다. \n");
				return;
			}
		}
		
		System.out.println("해당하는 데이터가 존재하지 않습니다 . \n");
	}
	
	public void changeData() throws ChangeChoiceException
	{
		System.out.println("데이터 수정을 시작합니다...");
		
		System.out.print("이름 : ");
		String name=MenuViewer.keyboard.nextLine();
		PhoneInfo info=search(name);
		if(info==null)
		{
			System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
			return;
		}
		else
		{
			info.showPhoneInfo();
		}
		
		
				
		System.out.println("수정할 데이터를 선택하세요...");		
		System.out.println("1.전화번호, 2.학과, 3.학년, 4.회사, 5.나가기");
		System.out.print("선택>> ");
		int choice=MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		PhoneInfo info1=null;
		
		if(choice< 1|| choice>5)		
		throw new ChangeChoiceException(choice);
		switch(choice)
		{
		case 1 :
			String phone=MenuViewer.keyboard.nextLine();
			break;
		case 2 :
			String major=MenuViewer.keyboard.nextLine();
			break;
		case 3 :
			int year=MenuViewer.keyboard.nextInt();
			break;
		case 4 :
			String company=MenuViewer.keyboard.nextLine();
			break;
		case 5 :
			
			return;
//			PhoneBookManager manager = null;
//			manager.storeToFile();
//			System.out.println("메인 화면으로 돌아갑니다.");

		}
		System.out.println("데이터 수정이 완료되었습니다. \n");
		}
		


			
	
	
	
	private PhoneInfo search(String name)
	{
		Iterator<PhoneInfo> itr=infoStorage.iterator();
		while(itr.hasNext())
		{
			PhoneInfo curInfo=itr.next();
			if(name.compareTo(curInfo.name)==0)
				return curInfo;
		}
		return null;
	}
	
	public void storeToFile()
	{
		try
		{
			FileOutputStream file=new FileOutputStream(dataFile);
			ObjectOutputStream out=new ObjectOutputStream(file);
			
			Iterator<PhoneInfo> itr=infoStorage.iterator();
			while(itr.hasNext())
				out.writeObject(itr.next());
			
			out.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void readFromFile()
	{
		if(dataFile.exists()==false)
			return;
		try
		{
			FileInputStream file=new FileInputStream(dataFile);
			ObjectInputStream in=new ObjectInputStream(file);
			
			while(true)
			{
				PhoneInfo info=(PhoneInfo)in.readObject();
				if(info==null)
					break;
				infoStorage.add(info);
			}
			
			in.close();	
		}
		catch(IOException e)
		{
			return;
		}
		catch(ClassNotFoundException e)
		{
			return;
		}
	}
}
	
class MenuViewer
{
	public static Scanner keyboard=new Scanner(System.in);
	
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
	
class PhoneBookVer10
{		
	public static void main(String[] args) throws ChangeChoiceException 
	{	
		PhoneBookManager manager=PhoneBookManager.createManagerInst();
		int choice;
		
		while(true)
		{
			try 
			{ 
				MenuViewer.showMenu();
				choice=MenuViewer.keyboard.nextInt();
				MenuViewer.keyboard.nextLine();
				
				if(choice<INIT_MENU.INPUT || choice>INIT_MENU.EXIT)
					throw new MenuChoiceException(choice);
				if(choice< 1 || choice>5)		
					throw new ChangeChoiceException(choice);
	
				switch(choice)
				{
				case INIT_MENU.INPUT :
					manager.inputData();
					break;
				case INIT_MENU.SEARCH :
					manager.searchData();
					break;
				case INIT_MENU.DELETE :
					manager.deleteData();
					break;
				case INIT_MENU.CHANGE :
					manager.changeData();
					break;
				case INIT_MENU.EXIT :
					manager.storeToFile();
					System.out.println("프로그램을 종료합니다.");
					return;
				}
			}
			catch(MenuChoiceException e)
			{
				e.showWrongChoice();
				System.out.println("메뉴 선택을 처음부터 다시 진행합니다. \n");
			}
		}
	}
}

