package threads;

import java.util.concurrent.Callable;

public class SecondTaskPool implements Callable<Integer>{
	private StringBuilder secondPart;
	private Integer commas=new Integer(0);
	 public SecondTaskPool(StringBuilder firstPart) {
		this.secondPart=firstPart;
	}
	@Override
	public Integer call() throws Exception {
		for (int i = 0; i < secondPart.length(); i++) {
			if(secondPart.charAt(i)==','){
				commas++;
			}
		}return commas;
	}

}
