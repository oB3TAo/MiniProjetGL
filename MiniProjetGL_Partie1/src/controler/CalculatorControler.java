package controler;

import java.util.List;

import javafx.stage.Stage;
import model.CalculatorModel;
import model.CalculatorModelInterface;
import view.CalculatorGUI;
import view.CalculatorGUIInterface;

public class CalculatorControler implements CalculatorControlerInterface {
	private CalculatorModelInterface calc;
	private CalculatorGUIInterface gui;
	private Stage stage;
	
	public CalculatorControler(Stage primaryStage) {
		
		stage = primaryStage;
		gui = new CalculatorGUI(stage);
		calc = new CalculatorModel();
		
	}

	
	public void change(String accu) {
		
	}

	
	public void change(List<Double> stackData) {
		
	}
	
}
