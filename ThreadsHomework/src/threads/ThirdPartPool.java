package threads;

import java.util.concurrent.Callable;

public class ThirdPartPool implements Callable<Integer>{
	private StringBuilder thirdPart;
	private Integer commas=new Integer(0);
	
	public ThirdPartPool(StringBuilder text) {
		this.thirdPart=text;
	}
	@Override
	public Integer call() throws Exception {
		for (int i = 0; i < thirdPart.length(); i++) {
			if(thirdPart.charAt(i)==','){
				commas++;
			}
		}return commas;
	}

}
