
public class Deadlock {
	static Object o=new Object();
	static Object o1=new Object();
	public Deadlock() {
		new task1();
		new task2();
	}
	
	public static void main(String[] args) {
		new Deadlock();
	}
	
	class task1 extends Thread{
		public task1() {
			this.start();
		}
		@Override
		public void run() {
			synchronized (o) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println("task 1 is running");
				}
			}
		}
	}

		class task2 extends Thread{
			public task2() {
				this.start();
			}
			@Override
			public void run() {
				synchronized (o1) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (o) {
						System.out.println("task 2 is running");
					}
				}
			}
	}
	
}
