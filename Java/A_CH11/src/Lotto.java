import java.util.Random;

public class Lotto 
{
	public static void main(String[] args)
	{
		int i, j, t;
		
		Random rand = new Random();
		
		int[] lotto = new int[6];
		
		for(i=0; i<6; i++)
		{
			lotto[i] = rand.nextInt(45)+1;
			for(j=i-1; j>0; j--)
				if(lotto[i]==lotto[j])
					i--;
		}
		System.out.println();
		
		//크기비교후 정렬
		
		for(j=0; j<5; j++)
			for(i=0; i<5; i++)
				if(lotto[i]>lotto[i+1])
				{
					t=lotto[i];
					lotto[i]=lotto[i+1];
					lotto[i+1]=t;
				}
		for(j=0; j<6; j++)
			System.out.printf("%d\t", lotto[j]);
		System.out.println();
		
	}
}
