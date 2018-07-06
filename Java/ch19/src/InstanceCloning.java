class Point3 implements Cloneable {
	private int xPos;
	private int yPos;
	
	public Point2(int x, int y) {
		xPos = x;
		yPos = y;
	}
	public void showPosition() {
		System.out.printf("[%d, %d]", xPos, yPos);
		System.out.println();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();  //Object 클래스의 clone 메소드 호출
	}
}
class InstanceCloning {
	public static void main(String[] args) {
		Point2 org = new Point2(3, 5);
		Point2 cpy;
		
		try {
			cpy = (Point2)org.clone();
			org.showPosition();
			cpy.showPosition();
			
			if(org.equals(cpy))
				System.out.println("aaaa");
			else
				System.out.println("bbbb");
		}
		catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
//접근 수준 지시자를 protected에서 public으로 바꾸기 위한 메소드 오버라이딩