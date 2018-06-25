
public class 변수 {

	public static void main(String[] args) {
		boolean sts = true;
		int num1 = 11;
		
		if(sts) {
		//	int num1 = 22; // 주석 해체하면 컴파일 오류 발생
			num1++;
			System.out.println(num1);
		}
		{
			
			int num2 = 33;
			num2++;
			System.out.println(num2);
	
		}
		// System.err.println(num2); 	//주석 해체하면 컴파일 오류 발생
	}
	

}