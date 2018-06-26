
public class Quiz13 {

	public static void main(String[] args) {
		for(int i = 2; i < 10; i++) {	// 2단부터 9단까지의 진행 위한 바깥쪽 for문
			for(int j = 1; j < 10; j++) // 1단부터 9까지의 곱을 위한 안쪽 for문
				System.out.println(i + " x " + j + " = " + (i * j));
		}
	}

}
