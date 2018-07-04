import java.util.Scanner;

public class 연습 {

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("1정수 입력");
		int num1 = s.nextInt();
		System.out.println("2정수 입력");
		int num2 = s.nextInt();
		int sum = 0;
		if(num1 > num2) {
			for(int i = num1; i > num2;) {
				sum = sum + i;
				i--;
			}
		}
		else
		{
			for(int i = num1; i < num2;) {
				sum = sum + i;
				i++;
			}
		}
		System.out.println("총 합 : " + sum);	
	}
}
