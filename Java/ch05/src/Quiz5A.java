import java.util.Scanner;

public class Quiz5A {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("몇 개의 정수를 입력할것인가");
		int nCount = s.nextInt();
		float nSum = 0;
		
		for(int i=0; i < nCount; i++) {
			System.out.println("정수입력");
			int nInputNum = s.nextInt();
			nSum = nSum + nInputNum;
			
			System.out.println(nSum / nCount);
			
		
		
		
		
		}
	}
	
}
		
		
		


