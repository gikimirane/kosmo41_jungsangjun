public class ExceptionMessage2 {

	public static void md1(int n) {
		md2(n, 0);		//이 지점으로 md2로부터 예외가 넘어온다.
	}
	public static void md2(int n1, int n2) {
		int r = n1/n2;	// 예외 발생 지점
	}
	public static void main(String[] args) {
		try {
			md1(3);		// 이 지점에서 md1으로부터 예외가 넘어온다.
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Good bye~~!");
	}
}
//md1에 3이라는 인자를 넣고 호출했어 -> md1을 갔더니 md2를 호출했어 (입력값3, 0) -> md2에서 나누기를 했더니 에러가 났어 ->
//md2가 md1한테 에러를 던지고 md1은 자신을 부른 main한테 에러를 던졌어
//에러는 거꾸로 타고 올라가면 됨 (main -> md1 -> md2)