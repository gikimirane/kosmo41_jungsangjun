interface Viewable1 {
	public void showIt(String str);
}
class Viewer1 implements Viewable1 {
	@Override
	public void showIt(String str) {
	System.out.println(str);
	}
};
class D1_AtOverride {
	public static void main(String[] args) {
		Viewable1 view = new Viewer1();
		view.showIt("Hello Annotations");
	}
}
// 어노테이션은 자바 5에서 소개되었다.