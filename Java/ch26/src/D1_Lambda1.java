interface Printable9 {
	void print(String s);
}
class Printer implements Printable9 {
	public void print(String s) {
		System.out.println(s);
	}
}
class D1_Lambda1 {
	public static void main(String[] args) {
		Printable9 prn = new Printer();
		prn.print("what is Lambda?");

	}
}
