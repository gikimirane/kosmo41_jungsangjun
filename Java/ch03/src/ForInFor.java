
public class ForInFor {

	public static void main(String[] args) {
		for(int i = 2; i < 10; i++) {	//바깥쪽 for문
			System.out.println("----------------");
			for(int j = 1; j < 10; j++) {	// 안쪽 for문
				System.out.print("[" + i + ", " + j + "] ");
				
			}
		}	System.out.print('\n');

	}

}
	


 