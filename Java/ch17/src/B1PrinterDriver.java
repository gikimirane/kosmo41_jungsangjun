interface Printable
{// MS가 정의하고 제공한 인터페이스
	public void print(String doc);
}
class SPrinterDriver implements Printable
{
	@Override
	public void print(String doc)
	{
		System.out.println("Form Samsung printer");
		System.out.println(doc);
	}
}
class LPrinterDriver implements Printable
{
	@Override
	public void print(String doc)
	{
		System.out.println("Form LG orinter");
		System.out.println(doc);
	}
}
class B1PrinterDriver {
	public static void main(String[] args) {
		String myDoc = "This is a report about...";				
		
		//삼성 프린터로 출력
		Printable prn = new SPrinterDriver();
		prn.print(myDoc);
		System.out.println();		
	
		// LG프린터로 출력
		prn = new LPrinterDriver();
		prn.print(myDoc);
	}
}
