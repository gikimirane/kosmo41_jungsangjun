package 파트7_상속;

public class BusExam3 {

	public static void main(String[] args) {
		
		Car3 c = new Bus3();
		c.run();
	//	c.ppap();	// 컴파일 오류 발생
		
		Bus3 bus = (Bus3)c;	// 부모타입을 자식타입으로 형변환
		bus.run();
		bus.ppap();
	}
	
}
