import java.util.Random;
import java.util.Scanner;
public class TEST {

	public static void main(String[] args) 
	{
		for(;;) {
		Random randomV1 = new Random();		

		int Z = randomV1.nextInt(897)+102;
		int A = (Z/100);
		int B = (Z -A*100) /10;
		int C = (Z - (A*100) - (B*10));
		if((A!=B) && (B!=C) && (A!=C))
		{
			System.out.println(Z);
			break;
		}
	}
		Scanner s = new Scanner(System.in);
}		
}