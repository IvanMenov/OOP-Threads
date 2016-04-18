package threads;

import java.util.concurrent.Callable;

public class FirstTaskPool implements Callable<Integer>{
	private StringBuilder firstPart;
	private Integer commas=new Integer(0);
	public FirstTaskPool(StringBuilder firstPart) {
		this.firstPart=firstPart;
	}
	@Override
	public Integer call() throws Exception {
		for (int i = 0; i < firstPart.length(); i++) {
			if(firstPart.charAt(i)==','){
				commas++;
			}
		}return commas;
	}

}
