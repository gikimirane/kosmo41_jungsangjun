import java.util.*;
public class Add_1 {
	public static void main(String[] args) {
		StringTokenizer v = new StringTokenizer("a b c");
		StringTokenizer n = new StringTokenizer("1 2 3");
		
		String s = v.nextToken();
		int num = Integer.parseInt(n.nextToken());
		
		while(v.hasMoreTokens())
		{
			String str = v.nextToken();
			System.out.println(str);
			s = s + " + " + str;
			num = num + Integer.parseInt(n.nextToken());
		}
		System.out.println(s + " = " + num);
	}
}
