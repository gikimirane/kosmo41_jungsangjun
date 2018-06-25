
public class MethodDef {

	public static void main(String[] args) {
		System.out.println("프로그램의 시작");
		hiEveryone(12); //12를 전달하며 hiEveryone 호출
		hiEveryone(13); //13를 전달하며 hiEveryone 호출
		System.out.println("프로그램의 끝");
	}
				//	매개변수가 하니인 메소드의 정의
		public static void hiEveryone(int age) {
			System.out.println("좋은 아침입니다.");
			System.out.println("제 나이는 " + age + "세 입니다.");
			
		}

	}


