import java.util.Scanner;

public class A2_ExceptionCase {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		try {
			System.out.println("a/b...b?");
			int n1 = kb.nextInt();	// int형 정수 입력
			System.out.println("a.b...b?");
			int n2 = kb.nextInt();	// int형 정수 입력
			System.out.printf("%d / %d = %d \n", n1, n2, n1 / n2);	//예외 발생 지점
		}
		
		catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Good bye~~!");
	}
}
