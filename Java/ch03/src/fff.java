import java.util.Scanner;

public class fff {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		long num1;
		long num2 = 0;
		
		do {
			System.out.println("몇 개의 정수를 입력할건가");
			
			num1 = s.nextInt();
			num2 = num2 + num1; 
			
		}while(num1 != 0);
		System.out.println(num2);		
	} 
}	
