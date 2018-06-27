class InstCnt {
	static int instNum = 100;
				//	클래스 변수의 적절한 초기화 위치
	InstCnt() {
		instNum++;
		System.out.println("인스턴스 생성: " + instNum);
	}
}
class OnlyClassNoInstance {
	public static void main(String[] args) {
		InstCnt.instNum -= 15;	// 인스턴스 생성 없이 instNum에 접근
		System.out.println(InstCnt.instNum);
	}
}
