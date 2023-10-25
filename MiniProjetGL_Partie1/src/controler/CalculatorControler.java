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
		stackData.add(0.0);
		stackData.add(0.0);
		stage = primaryStage;
		gui = new CalculatorGUI(stage);
		calc = new CalculatorModel();
		gui.affiche();
		gui.change(accu);
		gui.change(stackData);
		for (int i = 0; i < 16; i++) {
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
				System.out.println(calc.getOperandStack());
			} else if (buttonText.equals("2")){
				stackData.add(0,2.0);
				change(stackData);
				calc.push(2.0);
				System.out.println(calc.getOperandStack());
			} else if (buttonText.equals("3")){
				stackData.add(0,3.0);
				change(stackData);
				calc.push(3.0);
				System.out.println(calc.getOperandStack());
			} else if (buttonText.equals("4")){
				stackData.add(0,4.0);
				change(stackData);
				calc.push(4.0);
				System.out.println(calc.getOperandStack());
			} else if (buttonText.equals("5")){
				stackData.add(0,5.0);
				change(stackData);
				calc.push(5.0);
				System.out.println(calc.getOperandStack());
			} else if (buttonText.equals("6")){
				stackData.add(0,6.0);
				change(stackData);
				calc.push(6.0);
				System.out.println(calc.getOperandStack());
			} else if (buttonText.equals("7")){
				stackData.add(0,7.0);
				change(stackData);
				calc.push(7.0);
				System.out.println(calc.getOperandStack());
				
			} else if (buttonText.equals("8")){
				stackData.add(0,8.0);
				change(stackData);
				calc.push(8.0);
				System.out.println(calc.getOperandStack());
			} else if (buttonText.equals("9")){
				stackData.add(0,9.0);
				change(stackData);
				calc.push(9.0);
				System.out.println(calc.getOperandStack());
			} else if (buttonText.equals("+")) {
				calc.add();
				Double somme = calc.pop();
				stackData.remove(0);
				stackData.remove(0);
				stackData.add(0,somme);
				calc.push(somme);
				change(stackData);
				change(Double.toString(calc.getAccumulator()));
				
			} else if (buttonText.equals("-")) {
				calc.subtract();
				Double diff = calc.pop();
				stackData.remove(0);
				stackData.remove(0);
				stackData.add(0,diff);
				calc.push(diff);
				change(stackData);
				change(Double.toString(calc.getAccumulator()));
				
			} else if (buttonText.equals("*")) {
				calc.multiply();
				Double produit = calc.pop();
				stackData.remove(0);
				stackData.remove(0);
				stackData.add(0,produit);
				calc.push(produit);
				change(stackData);
				change(Double.toString(calc.getAccumulator()));
				
			} else if (buttonText.equals("/")) {
				calc.divide();
				Double quotient = calc.pop();
				stackData.remove(0);
				stackData.remove(0);
				stackData.add(0,quotient);
				calc.push(quotient);
				change(stackData);
				change(Double.toString(calc.getAccumulator()));
				
			} else if (buttonText.equals("<>")) {
				calc.swap();
				stackData.remove(0);
				stackData.remove(0);
				Double one = calc.pop();
				Double two = calc.pop();
				stackData.add(0,two);
				stackData.add(0,one);
				calc.push(two);
				calc.push(one);
				change(stackData);
				System.out.println(calc.getOperandStack());
			} else if (buttonText.equals("del")){
				if (!calc.getOperandStack().isEmpty()) {
					calc.drop();
					stackData.remove(0);
					change(stackData);
					System.out.println(calc.getOperandStack());
				} else {
					change("error");
				}
			}
		}
	}
		
	
}
