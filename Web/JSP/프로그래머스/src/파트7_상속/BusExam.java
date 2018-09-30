 package 파트7_상속;

public class BusExam {

	public static void main(String[] args) {
		
		Bus bus = new Bus();
		bus.run();
		bus.ppap();
		
		Car2 car = new Car2();
		car.run();
		
	//	car.ppap();  부모클래스는 자식이 가지고 있는 것을 사용할 수 없다.
	}
}
