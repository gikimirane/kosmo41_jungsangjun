import java.util.Scanner;
public class 가위바위보 {
//가위바위보 게임 -> 컴퓨터(난수 발생)와 인간(키보드 입력)의 가위바위보 게임
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<3; i++) {
			//컴퓨터가 발생하는 가위바위보를 얻어와 저장
			// ->1: 가위, 2:바위, 3:보
			int com = (int)(Math.random()*10)%3+1; // 1~3 범위의 난수 발생
			//키보드로 가위바위보를 입력 받아 저장
			int user;
			while(true) {
				System.out.println("입력[1:가위,2:바위,3:보]>>");
				user = scanner.nextInt();
				if(user>=1 && user<=3) 
					break;
				System.out.println("가위,바위,보 중 하나만 선택해주세요.");
			}
			System.out.println();
			if(com==1) System.out.println("컴퓨터:가위"); 
			else if(com==2) System.out.println("컴퓨터:바위"); 
			else System.out.println("컴퓨터:보");
			
			if(user==1) System.out.println("사람:가위"); 
			else if(user==2) System.out.println("사람:바위"); 
			else System.out.println("사람:보");
			
			System.out.println("<<결과>>");
			if(com==user) {
				System.out.println("비김");
			} else if (com==1 && user==2 || com==2 && user==3 || com==3 && user==1) {
				System.out.println("사람 WIN");
			} else {
				System.out.println("컴퓨터 WIN");
			}
			System.out.println("==============================");
		}
			scanner.close();
		}
	}

