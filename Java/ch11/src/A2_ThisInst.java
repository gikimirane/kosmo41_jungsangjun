//
// 키워드 this를 이용한 인스턴스 변수의 접근
//
class SimpleBox {
	private int data;
	
	SimpleBox(int date) {
		this.data = date;
	}
	void setData(int date) {
		this.data = date;
	}
	int getData() {
		return this.data;
	}
}

public class A2_ThisInst {
	public static void main(String[] args) {
		SimpleBox box = new SimpleBox(99);
		System.out.println(box.getData());
		
		box.setData(77);
		System.out.println(box.getData());
	}

}
