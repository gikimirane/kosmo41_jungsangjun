import java.util.Scanner;
/*
 * 	전화번호 관리 프로그램 구현 프로젝트
 *  Version 0.6
 */
interface INIT_MENU
{
	int INPUT=1, SEARCH=2, DELETE=3, EXIT=4;
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
			System.out.println(wrongChoice + "에 해당하는 선택은 존재하지 않습니다.");
		}
	}
	
class PhoneInfo
{
	// Version 0.5와 동일하므로 생략합니다.	
}

class PhoneUnivInfo extends PhoneInfo
{
	// Version 0.5와 동일하므로 생략합니다.	
}

class PhoneBookManager
{
	// Version 0.5와 동일하므로 생략합니다.	
}

class PhoneBookManager
{
	final int MAX_CNT=100;
	PhoneInfo[] infoStorage=new PhoneInfo[MAX_CNT];
	int curCnt=0;
	
	static PhoneBookManager inst=null;
	public static PhoneBookManager createManagerInsr()
	{
		// Version 0.5와 동일
	}
	
	private PhoneBookManager() {}
	
	private PhoneInfo readFriendInfo()
	{
		// Version 0.5와 동일
	}
	
	private PhoneInfo readUnivFriendInfo()
	{
		// Version 0.5와 동일
	}
	
	private PhoneInfo readCompanyFriendInfo()
	{
		// Version 0.5와 동일
		syso
	}

}








public class PhoneBookVer06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
