//문제 1
//길이가 5인 int형 배열을 선언해서 사용자로부터 5개의 정수를 입력받는다.	
//그리고 최대값, 최소값, 모든 수의 합을 구하라. 함수(최대,최소,합)를 정의하여 구현하시오.
import java.util.Scanner;
public class Quiz13문제1 {
	public static void main(String[] args) {
		int[] num = new int[5]; // 길이가 5인 int형 배열 
		int max;
		int min;
		int sum;		
		Scanner s = new Scanner(System.in);
		System.out.println("정수 5개 입력");
		for(int i = 0; i < 5; i++) {
			num[i] = s.nextInt();
		}
		max = num[0];
		min = num[0];
		sum = num[0];
		for(int i = 0; i < 5; i++) {
			if(max < num[i]) {
			   max = num[i];
			}
			if(min > num[i]) {
			   min = num[i];
			}			
		 }
		for(int i = 0; i < 5; i++) {
			sum += i;
		}
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		System.out.println("정수총합 : " + sum);
		}
	}
