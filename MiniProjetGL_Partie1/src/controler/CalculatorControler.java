package controler;

import java.util.ArrayList;
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
	private List <Double> stackData;
	private String accu;
	
	public CalculatorControler(Stage primaryStage) {
		
		accu = " ";
		stackData = new ArrayList<Double>();
		stage = primaryStage;
		gui = new CalculatorGUI(stage);
		calc = new CalculatorModel();
		gui.affiche();
		gui.change(accu);
		gui.change(stackData);
		
		
	}
	
	public void run () {
		
		for (int i = 0; i < 10; i++) {
			double j = i + 0.0;
			gui.getButton(i).setOnAction(e -> stackData.add(0,j));
			change(stackData);
		}
		
	}
	
	public void change(String accu) {
		gui.change(accu);
	}

	
	public void change(List<Double> stackData) {		
		gui.change(stackData);			
	}
	
}
