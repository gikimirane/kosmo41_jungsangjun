
public class A2_MakeThreadDemo {

	public static void main(String[] args) {
		Runnable task = () -> {	// 쓰레드가 실행하게 할 내용
			try {
				Thread.sleep(3000);
			}catch (Exception e) {
			}
			
			int n1 = 10;
			int n2 = 20;
			String name = Thread.currentThread().getName();
			System.out.println(name + " : " + (n1 + n2));
		};
		Thread t = new Thread(task);
		t.start();
		System.out.println("End" + Thread.currentThread().getName());
	}
}
// Runnable   void run()
					// 1단계 Runnable을 구현한 인스턴스 생성
					// 2단계 Thread 인스턴스 생성
					// 3단계  start 메소드 호출
// 모든 쓰레드가 일을 마쳐야 프로그램 종료