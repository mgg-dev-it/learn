package mggdevit.learnjavaconcurrency;

public class LearnJavaConcurrency {

	public static void main(String[] args) {
		LearnJavaConcurrency.learn();
	}

	public static void learn() {
		System.out.println("");
		System.out.println("LEARNING CONCURRENCY");
		System.out.println("");
		new LearnThread().learn();
		System.out.println("");
	}
}
