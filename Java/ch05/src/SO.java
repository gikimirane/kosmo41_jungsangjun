
public class SO {

	public static void main(String[] args) {
		for(int i = 1; i <100; i++)
		if (((i % 7) == 0) || ((i % 9) == 0)) {	
			System.out.println(i);
			
		
		
			
		}

	}
}
//1이상 100미만의 정수 출력
//7의 배수와 9의 배수 출력
//단 7의 배수이면서 동시에 9의 배수인 정수는 한번만 출력
//뭐(x)부터 뭐(y)까지(미만까지) --> 반복문 : for (int i=x; i < y; i++)
//계속  --> 반목문
//n의 배수  --> (숫자 % n == 0)