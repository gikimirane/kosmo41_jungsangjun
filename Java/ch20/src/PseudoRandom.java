import java.util.Random;

public class PseudoRandom {

	public static void main(String[] args) { // 실행할 때마다 다른 결과를 보인다.
		Random rand = new Random();
		for(int i = 0; i < 7; i++)
		System.out.println(rand.nextInt(1000));
	
	}
	
//	public static void main(String[] args) {  // 실행할 때마다 같은 결과를 보인다.
//		Random rand = new Random(12);
//		for(int i = 0; i < 7; i++)
//			System.out.println(rand.nextInt(1000));
//	}
}
