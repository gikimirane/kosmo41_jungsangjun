package 파트7_상속;

public class AccessObj {
	
	public int p = 3;		// 전체 클레스 공유
	protected int p2 = 4;	// 자기 자신, 같은 패키지, 상속 받은 자식 클래스
	int k = 2;				// default 접근 지정자
	private int i = 1;		// 자기 자신과 같은 패키지
	
}
