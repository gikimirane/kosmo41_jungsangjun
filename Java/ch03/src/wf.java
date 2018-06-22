import java.util.Scanner;

public class wf {

	public static void main(String[] args) {
		
		     Scanner s = new Scanner(System.in); 
		     
		     int num = 0;
		     int sum = 0;
		     
		     while(true) {
		      System.out.print("값을입력해주세요 : ");
		      num = s.nextInt();
		      
		      if(num == 0) break;
		      sum += num;
		     }
		     System.out.println("입력한값의합 : " + sum);
		 }

	}