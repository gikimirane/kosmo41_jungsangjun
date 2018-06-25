class Calc3
{
	int add(int a, int b)
	{
		return a + b;
	}
	
	int add(int a)
	{
		return a + 1;
	}
	
	double add(double a, double b)
	{
		return a + b;
	}
}
 class Calculation2 
{
	public static void main(String[] args)
	{
		Calc3 x = new Calc3();
		int nRtn1 = x.add( 3, 9);
		int nRtn2 = x.add( 3 );
		double nRtn3 =x.add( 3.0, 9.0 );
		
		System.out.println("nRtn1 = " + nRtn1);
		System.out.println("nRtn2 = " + nRtn2);
		System.out.println("nRtn3 = " + nRtn3);
	}
}

