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
		
		accu = "";
		stackData = new ArrayList<Double>();
		
		stage = primaryStage;
		gui = new CalculatorGUI(stage);
		calc = new CalculatorModel();
		gui.affiche();
		gui.change(accu);
		gui.change(stackData);
		for (int i = 0; i < 20; i++) {
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
				change("1");
			} else if (buttonText.equals("2")){
				change("2");
			} else if (buttonText.equals("3")){
				change("3");
			} else if (buttonText.equals("4")){
				change("4");
			} else if (buttonText.equals("5")){
				change("5");
			} else if (buttonText.equals("6")){
				change("6");
			} else if (buttonText.equals("7")){
				change("7");
			} else if (buttonText.equals("8")){
				change("8");
			} else if (buttonText.equals("9")){
				change("9");
			} else if (buttonText.equals("0")){
				change("0");
			} else if (buttonText.equals(".")){
				change(".");
			} else if (buttonText.equals("<-")){
				Double add = Double.parseDouble(gui.getAccu());
				calc.push(add);
				change(calc.getOperandStack());
				
			} else if (buttonText.equals("+")) {
				calc.add();
				change(calc.getOperandStack());
				
				
			} else if (buttonText.equals("-")) {
				calc.subtract();
				change(calc.getOperandStack());
				
			} else if (buttonText.equals("*")) {
				calc.multiply();
				change(calc.getOperandStack());
				
			} else if (buttonText.equals("/")) {
				calc.divide();
				change(calc.getOperandStack());
				
			} else if (buttonText.equals("<>")) {
				calc.swap();
				change(calc.getOperandStack());
				
			} else if (buttonText.equals("del")){
				if (!calc.getOperandStack().isEmpty()) {
					calc.drop();
					change(calc.getOperandStack());
				}
			} else if (buttonText.equals("C")){
				if (!calc.getOperandStack().isEmpty()) {
					calc.clearStack();
					change(calc.getOperandStack());
				}
			} 
		}
	}
		
	
}
