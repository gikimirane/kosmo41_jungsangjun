package Java의정석;

import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("첫 번째 숫자 입력");
		int num1 = s.nextInt();
		
		System.out.println("두 번째 숫자 입력");
		int num2 = s.nextInt();
		
		System.out.println("당신이 입력한 숫자는 "+ num1 + ", " + num2);
		System.out.println("num1 / num2 = " + (num1 / num2));
		System.out.println("num1 % num2 = " + (num1 % num2));
	}

}
