// 로컬 클래스는 바로 위에서 소개한 멤버 클래스와 상당 부분 유사하다.
//									지역 내에 정의된다는 점에서만 차이를 보임

interface Printable1 { void print(); }

class Papers1 {
	private String con;
	public Papers1(String s) { con = s; }
	
	public Printable1 getPrinter() {
		class Printer implements Printable1 {
			public void print() {
				System.out.println(con);
			}
		}			// 감췄어! 더 깊이 감췄어! 메소드 안으로
		return new Printer();
	}
}
public class A4_UseLocalInner {
	public static void main(String[] args) {
		Papers1 p = new Papers1("서류 내용: 행복합니다.");
		Printable1 prn = p.getPrinter();
		prn.print();
	}
}
