// 파라미터로 람다식을 넘길 때
interface PrintableB {
	void print(String s);
}
class D4_Lambda4 {
	public static void ShowString(PrintableB p, String s) {
		p.print(s);
	}
	public static void main(String[] args) {
		ShowString((s) -> {System.out.println(s); },"what is Lambda?");	
	}
}