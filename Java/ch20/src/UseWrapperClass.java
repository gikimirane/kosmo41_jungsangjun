//기본 저료형의 값을 감싸는 래퍼클래스						// 인스턴스를 요구하는 메소드
public class UseWrapperClass {					// 이 메소드를 통해서 정수나 실수를 출력하려면 해당 값을
	public static void showData(Object obj ) {	// 인스턴스화 해야 한다.
		System.out.println(obj);				//
	}
	
	public static void main(String[] args) {
		Integer iInst = new Integer(3);
		showData(iInst);
		showData(new Double(7.15));
	}
}
// 이렇듯 기본 자료형의 값을 인스턴스로 감싸는 목적의 클래스를 가리켜 래퍼 클래스라 한다.