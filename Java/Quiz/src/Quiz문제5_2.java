import java.util.Scanner;

public class Quiz문제5_2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("첫 번째 정수입력");
		int nCount = s.nextInt();
		float nSum = 0;
		
		for(int i = 0; i < nCount; i++);{
			System.out.println("두 번째 정수입력.");
			int nInputNum = s.nextInt();
			nSum = nSum + nInputNum;
		}
		System.out.println(nSum / nCount);
	}
}
	


