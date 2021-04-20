package mggdevit.scope.bean;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
//@RequestScope
@SessionScope
public class Bean1 {
	
//	@Autowired
//	private ApplicationContext applicationContext;

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
