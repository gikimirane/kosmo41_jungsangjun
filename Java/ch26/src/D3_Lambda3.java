interface PrintableA {
	void print(String s);
}
class D3_Lambda3 {
	public static void main(String[] args) {
		PrintableA prn = (s) -> {System.out.println(s); };
		prn.print("what is Lambda?");	
	}
}