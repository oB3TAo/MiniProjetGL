package controler;

import java.util.List;

public interface CalculatorControlerInterface {
	
	/**
	 * @param accu
	 */
	public void change(String accu) ;
	
	/**
	 * @param stackData
	 */
	public void change(List<Double> stackData);
	
	/**
	 * 
	 */
	public void run();
	
}
