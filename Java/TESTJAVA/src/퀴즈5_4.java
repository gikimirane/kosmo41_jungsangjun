import java.util.Scanner;

public class 퀴즈5_4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("정수 입력");
		int i = s.nextInt();
		int x = s.nextInt();
		
		if(i>x)
			System.out.println("차: " + (i-x));
		else
			System.out.println("차: " + (x-i));

	}

}
