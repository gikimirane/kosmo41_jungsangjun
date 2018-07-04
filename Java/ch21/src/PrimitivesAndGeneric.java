class Box<T> {
	private T ob;
	
	public void set(T o) {
	ob = o;
}
public T get() {
	return ob;
	}	
}
public class PrimitivesAndGeneric {

	public static void main(String[] args) {
		Box<Integer> iBox = new Box<Integer>();
		iBox.set(125);	//오토 박싱 진행
		int num = iBox.get();	// 오토 언박싱 진행
		System.out.println(num);
	}
}

// 타입 인지로 기본 자료형이 올 수 없으므로 오류 발생
// 래퍼 클래스가 필요한 이유!!!