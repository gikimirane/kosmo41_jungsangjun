class Outer1 {
	private int num = 0;
	
	class Member {	// 멤버 클래스의 정의
		void add(int n) { num += n; }
		int get() { return num; }
	}
}
class A2_MemberInner {
	public static void main(String[] args) {
		Outer1 o1 = new Outer1();
		Outer1 o2 = new Outer1();
		
		// o1 기반으로 두 인스턴스 생성
		Outer1.Member o1m1 = o1.new Member();
		Outer1.Member o1m2 = o1.new Member();
		
		// o2 기반으로 두 인스턴스 생성
		Outer1.Member o2m1 = o2.new Member();
		Outer1.Member o2m2 = o2.new Member();
		
		// o1 기반으로 생성된 두 인스턴스의 메소드 호출
		o1m1.add(5);
		System.out.println(o1m2.get());
		
		// o2기반으로 생성된 두 인스턴스의 메소드 호출
		o2m1.add(7);
		System.out.println(o2m2.get());
	}
}
// 멤버 클래스의 인스턴스는 외부 클래스의 인스턴스에 종속적이다.