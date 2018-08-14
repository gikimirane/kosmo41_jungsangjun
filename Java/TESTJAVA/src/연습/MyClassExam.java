package 연습;

public class MyClassExam {
	public static void main(String args[]){
        MyClass my1 = new MyClass(); //메소드가 정의된 클래스 생성 

        my1.method1();   //MyClass에서 정의해 놓은 메소드 method1() 를 호출한다.       

        my1.method2(10);

        int x = my1.method3();

        System.out.println("method3 이 리턴한 " + x + " 입니다.");

        my1.method4(10,100);

        int x2 = my1.method5(50);

        System.out.println("method5 가 리턴한 " + x2 + " 입니다.");

    }
}

