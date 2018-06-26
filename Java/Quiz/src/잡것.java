import java.util.Scanner;
public class 잡것 {
	public static void main(String[] args) {
		int[] num = new int[5]; // 길이가 5인 int형 배열 
				
		Scanner s = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++) {
		System.out.println("정수 5개 입력");
		num[i] = s.nextInt();
		}
		int max = 0;		//최대값 보관
		int min = 1000;		//최소값 보관
		
		for(int i = 0; i < 5; i++) {
			if(max < num[0]) {
			   max = num[0];
			}
			if(max < num[1]) {
				max = num[1];
			}
			if(max < num[2]) {
				max = num[2];
			}
			if(max < num[3]) {
				max = num[3];
			}
			if(max < num[4]) {
				max = num[4];
			}
			if(max < num[5]) {
				max = num[5];
			}
		}
	}
}
		