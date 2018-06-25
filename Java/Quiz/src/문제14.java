public class 문제14
{
     public static void main(String[] args)
    {
        for(int A=1; A < 10; A++) 
        {
        	for(int Z=1; Z < 10; Z++) 
        	{
        		if(99 == A * 10 + Z + Z * 10 + A && A!=Z)
        		{
        			System.out.println("----------------");
        			System.out.println(A+","+Z);
        			System.out.println(Z+","+A);       			
            	}       		
        	}        	
        }        	
    }
}
      