class Outer {
	private static int num = 0;
	static class Nested1 {	// Static 네스티드 클래스
		void add(int n) {num += n; }	// Outer 클래스의 Static 변수 공유!
	}
	static class Nested2 {	// Static 네스티드 클래스
		int get() { return num;}
	}
}
class A1_StaticNseted {
	public static void main(String[] args) {
		Outer.Nested1 nst1 = new Outer.Nested1();	// 인스턴스 생성 방법!
		nst1.add(5);
		Outer.Nested2 nst2 = new Outer.Nested2();
		System.out.println(nst2.get());
	}
}
// Static 네스티드 클래스는 static 선언이 갖는 특성이 반영된 클래스이다. 따라서 자신을 감싸는 외부
// 클래스의 인스턴스와 상관없이 Static 네스티드 클래스의 인스턴스 생성이 가능하다.