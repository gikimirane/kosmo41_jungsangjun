import java.util.Scanner;

public class Quiz문제5_1 {

	public static void main(String[] args) {
		int x = 0;
		int sum = 0;
		int num = 0;
		do {
			Scanner s = new Scanner(System.in);
			System.out.println("숫자를 입력하세요");
			num = s.nextInt();
			sum = sum + num;
			x++;
		}while(num != 0);
		System.out.println("sum: "+sum);
	}
}
