class MyBook
{
	int price;
	String title;
	
	MyBook(String t, int p)
	{
		title = t;
		price = p;
	}
	//복제 생성자
	MyBook(MyBook copy)
	{
		title = copy.title;
		price = copy.price;
	}
	
	void print()
	{
		System.out.println("제    목 : " + title);
		System.out.println("가    격 : " + price);
		
	}
}

class Books
{
	public static void main(String[] args)
	{
		MyBook book1 = new MyBook("게임스쿨", 10000);
		book1.print();
		
	//	MyBook book2 = new Mybook(book1);
	//	book2.title = "모바일게임";
//		book2.print();
	}
}

