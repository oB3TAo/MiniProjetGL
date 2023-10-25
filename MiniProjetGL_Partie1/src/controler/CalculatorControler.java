package controler;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
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
		stackData.add(0.0);
		stackData.add(0.0);
		stage = primaryStage;
		gui = new CalculatorGUI(stage);
		calc = new CalculatorModel();
		gui.affiche();
		gui.change(accu);
		gui.change(stackData);
		for (int i = 0; i < 10; i++) {
			gui.getButton(i).setOnAction(new ButtonHandler());
		}
		
	}
	
	
	
	
	
	
	public void change(String accu) {
		gui.change(accu);
	}

	
	public void change(List<Double> stackData) {		
		gui.change(stackData);			
	}
	
	
	private class ButtonHandler implements EventHandler<ActionEvent> {
		
		
		@Override
		public void handle(ActionEvent event) {
			Button source = (Button) event.getSource();
			String buttonText = source.getText();
			
			if (buttonText.equals("1")) {
				stackData.add(0,1.0);
				change(stackData);
				calc.push(1.0);
			} else {
				stackData.add(2.0);
				change(stackData);
			}
		}
	}
		
	
}
