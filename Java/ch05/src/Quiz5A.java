import java.util.Scanner;

public class Quiz5A {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("�� ���� ������ �Է��Ұ��ΰ�");
		int nCount = s.nextInt();
		float nSum = 0;
		
		for(int i=0; i < nCount; i++) {
			System.out.println("�����Է�");
			int nInputNum = s.nextInt();
			nSum = nSum + nInputNum;
			
			System.out.println(nSum / nCount);
			
		
		
		
		
		}
	}
	
}
		
		
		


