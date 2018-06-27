class InstCnt {
	static int instNum = 0;	// 클래수 변수 (static 변수)
	
	InstCnt() {
		instNum++;
		System.out.println("인스턴스 생성 : " + instNum);
	}
}
public class A1ClassVar {
	public static void main(String[] args) {
		InstCnt cnt1 = new InstCnt();
		InstCnt cnt2 = new InstCnt();
		InstCnt cnt3 = new InstCnt();
	}
}
