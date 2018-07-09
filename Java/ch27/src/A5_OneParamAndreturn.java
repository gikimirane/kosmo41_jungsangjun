interface HowLong {
	int len(String s);	// 값을 반환하는 메소드
}
class A5_OneParamAndreturn {
	public static void main(String[] args) {
		HowLong h1 = s -> s.length();
		System.out.println(h1.len("I am so happy"));
	}
}
// 글자 갯수 출력(띄어쓰기 포함!!!)