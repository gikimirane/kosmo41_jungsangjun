//
// 정보의 은닉을 위한 private 선언
//
class Circle {
	private double rad = 0;	
	 final double PI = 3.14;
	 
	 public Circle(double r) {
		 setRad(r);		 
	 }
	 public void setRad(double r) {	// Setter
			 if(r < 0) {
				 rad = 0;
				 return;
			 }
			 rad = r;
		 }
		 public double getRad() {	// Getter
			 return rad;
		 }
		 public class getArea() {...}
}

		 public static void main(String[] args) {
			 Circle c = new Circle(1.5);
				System.out.println(c.getArea());
				
				c.setRad(2.5);
				System.out.println(c.getArea());
				c.setRad(-3.3);
		
				
				
				System.out.println(c.getArea());
				c.rad = -4.5;	// 컴파일 오류로 이어짐
				System.out.println(c.getArea());	

	}
}
