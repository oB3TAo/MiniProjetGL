package view;

import java.util.List;

import javafx.scene.control.Button;





public interface CalculatorGUIInterface{
	
	public void affiche();
	public void change(String accu) ;
	public void change(List<Double> stackData) ;
	public Button getButton(int i);
	public String getAccumulateur();
	public void clearAccumulateur();
}	
