import java.util.Scanner;
/*
 * 	전화번호 관리 프로그램 구현 프로젝트
 *  Version 0.5
 */
interface INIT_MENU
{
	int INPUT=1, SEARCH=2, DELETE=3, EXIT=4;
}

interface INPUT_SELECT
{
	int NORMAL=1, UNIV=2, COMPANY=3;
}

class PhoneInfo5
{
	// Version 0.4와 동일하므로 생략합니다.	
}

class PhoneUnivInfo extends PhoneInfo
{
	// Version 0.4와 동일하므로 생략합니다.	
}

class PhoneCompanyInfo extends PhoneInfo
{
	// Version 0.4와 동일하므로 생략합니다.	
}

class PhoneBookManager5
{
	final int MAX_CNT=100;
	PhoneInfo5[] infoStorage=new PhoneInfo5[MAX_CNT];
	int curCnt=0;
	
	static PhoneBookManager5 inst=null;
	public static PhoneBookManager5 createManagerInst()
	{
		if(inst==null)
			inst=new PhoneBookManager5();
		
		return inst;
	}
	
	private PhoneBookManager5() {}
	
	private PhoneInfo5 readFriendInfo()
	{
		// Version 0.4와 동일
	}
	
	private PhoneInfo5 readUnivFriendInfo()
	{
		// Version 0.4와 동일
	}
	
	private PhoneInfo5 readCompanyFriendInfo()
	{
		// Version 0.4와 동일
	}
	
	public void inputData()
	{
		System.out.println("데이터 입력을 시작합니다...");
		System.out.println("1. 일반, 2. 대학, 3. 회사");
		System.out.println("선택 >> ");
		int choice=MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		PhoneInfo info=null;
		
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
		
		infoStorage[curCnt++]=info;
		System.out.println("데이터 입력이 완료되었습니다. \n");
	}
	
	public void searchData()
	{
		// Version 0.4와 동일
	}
	
	public void deleteData()
	{
		// Version 0.4와 동일
	}
	
	private int search(String name)
	{
		// Version 0.4와 동일
	}
}

class MenuViewer2
{
	// Version 0.4와 동일하므로 생략합니다.
}

class PhoneBookVer05 
{
	public static void main(String[] args) 
	{
		PhoneBookManager manager=PhoneBookManager.createManagerInst();
		int choice;
		
		while(true)
		{
			MenuViewer.showMenu();
			choice=MenuViewer.keyboard.nextInt();
			MenuViewer.keyboard.nextLine();
			
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
			case INIT_MENU.EXIT :
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}

	}

}
