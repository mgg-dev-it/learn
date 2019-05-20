package mggdevit.learnjavaconcurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class LearnThread {

	private final static int CYCLE = 1000;
	private static int iCount = 0;
	private static AtomicInteger ai;

	class A implements Runnable {

		public void run() {
			for (int i = 0; i < CYCLE; i++) {
				++iCount;
			}

		}
	}

	class B implements Runnable {

		public void run() {
			for (int i = 0; i < CYCLE; i++) {
				ai.incrementAndGet();
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
			e.printStackTrace();
		}
		System.out.println("iCount = " + iCount + " (it should be " + 2 * CYCLE + " !)");

		System.out.println("");

		ai = new AtomicInteger(0);
		B b = new B();
		Thread t11 = new Thread(b);
		Thread t12 = new Thread(b);
		t11.start();
		t12.start();
		try {
			t11.join();
			t12.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ai.intValue() = " + ai.intValue() + " (it must be " + 2 * CYCLE + " :)");

	}
}
