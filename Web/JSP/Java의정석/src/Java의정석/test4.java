package Java의정석;

public class test4 {

	public static void main(String[] args) {
		for (int i=2; i<=9; i++)
		{
			if (i%2 ==0) {
				for (int j=1; j<=i; j++)
				{
					System.out.println(i+"*"+j+"="+i*j);
				}
			}
		}
	}
}
