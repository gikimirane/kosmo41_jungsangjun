// 파라미터가 여러 개일 때
interface PrintableC {
	void print(String s, int n);
}
class D5_Lambda5 {
	public static void main(String[] args) {
		PrintableC prn = (s, n) -> {System.out.println(s + " : " + n); };
		prn.print("What is Lambda?", 5);
	}
}
