class Counter2 {
	int count = 0;	// 공유되는 변수
	
	synchronized public void increment() {
		count++;	// 동기화 블록
	}
	synchronized public void decrement() {
		count--;	// 동기화블록
	}
	public int getCount2() { return count; }	
}

class B2_MutualAcoessSynchronization {
	public static Counter2 cnt = new Counter2();
	public static void main(String[] args) throws InterruptedException {
		Runnable task1 = () -> {
			for(int i = 0; i < 1000; i++)
				cnt.increment();    // 값을 1증가			
		};
		Runnable task2 = () -> {
			for(int i = 0; i < 100; i++)
				cnt.decrement();    // 값을 1감소	
	};
	Thread t1 = new Thread(task1);
	Thread t2 = new Thread(task2);
	t1.start();
	t2.start();
	t1.join();	// t1이 참고하는 쓰레드의 종료를 기다림
	t2.join();	// t2이 참고하는 쓰레드의 종료를 기다림
	//쓰레드가 종료되면 출력을 진행함. 위join의 명함
	System.out.println(cnt.getCount2());
	}
}
