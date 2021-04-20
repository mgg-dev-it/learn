package mggdevit.scope.bean;

import org.springframework.stereotype.Component;

@Component
public class Bean1 {

	private int iCounter = 0;

	public Bean1() {
	}

	public int getCounter() {
		return iCounter;
	}

	public int getNextCounter() {
		return ++iCounter;
	}
	
}
