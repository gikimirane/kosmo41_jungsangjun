class Boxa<T extends Number> {
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	public T get() {
		return ob;
	}
}
public class BoundedBox {
	public static void main(String[] args) {
		Boxa<Integer> iBoxa = new Boxa<>();
		iBoxa.set(24);
		
		Boxa<Double> dBoxa = new Boxa<>();
		dBoxa.set(5.97);
		
		System.out.println(iBoxa.get());
		System.out.println(dBoxa.get());
	}
}
