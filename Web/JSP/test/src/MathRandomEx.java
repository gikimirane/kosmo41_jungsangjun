

public class MathRandomEx {
	public static void main(String[] args) {
		int[] lotto = new int[6]; // 6개의 당첨번호 보관을 위한 정수형 배열 생성
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45)+1; // 1~45까지의 정수형 난수 생성
			for(int j=0; j<i; j++){	// 중복값 제거
				if(lotto[i]==lotto[j]){
					i--;
					break;
				}
			}
		}
		for(int i=0; i < lotto.length; i++)
			System.out.println(i+1+"번 당첨번호:"+lotto[i]); // 저장된 배열값 출력
	}
}
