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

		callables.add(createCallable(1));
		callables.add(createCallable(2));
		callables.add(createCallable(3));
		callables.add(createCallable(4));
		callables.add(createCallable(5));
		callables.add(createCallable(6));
		callables.add(createCallable(7));
		callables.add(createCallable(8));
		callables.add(createCallable(9));
		callables.add(createCallable(10));
		
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

	private Callable<String> createCallable(final int i) {
		return (new Callable<String>() {
			public String call() throws Exception {
				return "Task " + i;
			}
		});
	}

}
