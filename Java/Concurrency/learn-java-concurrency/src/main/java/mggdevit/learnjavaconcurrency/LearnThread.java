package mggdevit.learnjavaconcurrency;

public class LearnThread {

	private final static int CYCLE = 1000;
	private static int iCount = 0;

	class A implements Runnable {

		public void run() {
			for (int i = 0; i < CYCLE; i++) {
				++iCount;
			}

		}
	}

	public LearnThread() {
	}

	public void learn() {
		System.out.println("");
		System.out.println("Learning Threads");
		System.out.println("");
		System.out.println("The wrong increment:");
		System.out.println("");
		A a = new A();
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(a);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("iCount = " + iCount + " (it should be " + 2 * CYCLE + ")");
	}
}
