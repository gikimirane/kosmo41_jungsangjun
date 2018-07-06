interface Printable2 {
	void print(String s);
}
class D2_Lambda2 {
	public static void main(String[] args) {
		Printable2 prn = new Printable2() { // 익명 클래스
		public void print(String s ) {
			System.out.println(s);
		}
	};
	prn.print("what is Lambda?");
  }
}
