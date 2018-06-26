class Calc
{
	void Add(int n1, int n2)
	{
	int nResult = n1 + n2;
	System.out.println(nResult);
	}
}
public class Exam01 {

	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 7;
		
		Calc myCal = new Calc();
		myCal.Add(num1, num2);
		
	
	}

}
