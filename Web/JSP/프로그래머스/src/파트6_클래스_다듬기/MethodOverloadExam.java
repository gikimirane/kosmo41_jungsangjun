package 파트6_클래스_다듬기;

public class MethodOverloadExam {

	public static void main(String[] args) {
		
		MyClass m = new MyClass();
		
		System.out.println(m.plus(4, 5));
		
		System.out.println(m.plus(4, 5, 6));
		
		System.out.println(m.plus("hello", "world"));

	}

}
