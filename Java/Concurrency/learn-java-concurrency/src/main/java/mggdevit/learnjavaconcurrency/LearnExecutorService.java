package mggdevit.learnjavaconcurrency;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LearnExecutorService {

	public LearnExecutorService() {
	}

	public void learn() {
		System.out.println("");
		System.out.println("Learning ExecutorService");
		System.out.println("");

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 1";
			}
		});
		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 2";
			}
		});
		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 3";
			}
		});

		List<Future<String>> futures;
		try {
			futures = executorService.invokeAll(callables);
			for (Future<String> future : futures) {
				System.out.println("future.get = " + future.get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		executorService.shutdown();
	}

}
