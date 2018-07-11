class Counter {
	int count = 0;	// 공유되는 변수
	
	public void increment() {
		count++;	// 첫 번재 쓰레드에 의해 실행
	}
	public void decrement() {
		count--;	// 또 다른 쓰레드에 의해 실행
	}
	public int getCount() { return count; }	
}

class B1_MutualAcoess {
	public static Counter cnt = new Counter();
	public static void main(String[] args) throws InterruptedException {
		Runnable task1 = () -> {
			for(int i = 0; i < 1000; i++)
				cnt.increment();    // 값을 1증가			
		};
		Runnable task2 = () -> {
			for(int i = 0; i < 1000; i++)
				cnt.decrement();    // 값을 1감소	
	};
	Thread t1 = new Thread(task1);
	Thread t2 = new Thread(task2);
	t1.start();
	t2.start();
	t1.join();	// t1이 참고하는 쓰레드의 종료를 기다림
	t2.join();	// t2이 참고하는 쓰레드의 종료를 기다림
	//쓰레드가 종료되면 출력을 진행함. 위join의 명함
	System.out.println(cnt.getCount());
	}
}
