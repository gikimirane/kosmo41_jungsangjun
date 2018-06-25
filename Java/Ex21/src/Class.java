
class Wdate
{
	int month;
	int day;
	String sky;
}

class Class
{
	public static void main(String[] args)
	{	
		Wdate today = new Wdate();
		today.month = 10;
		today.day = 5;
		today.sky = "맑음";
		
		System.out.println(today.month + "월" +
						   today.day + "일 " +
						   today.sky);

		
	}	
}


