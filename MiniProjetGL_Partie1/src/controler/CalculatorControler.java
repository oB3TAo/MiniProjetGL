package controler;



import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.CalculatorModelInterface;
import view.CalculatorGUIInterface;

public class CalculatorControler implements CalculatorControlerInterface {
	
	private CalculatorModelInterface model;
	private CalculatorGUIInterface view;
	
	public CalculatorControler(CalculatorModelInterface model,CalculatorGUIInterface view) {
		this.view = view;
		this.model = model;
	}
	
	
	
	
	public void run() {
		view.affiche();
		for (int i = 0; i < 20; i++) {
			view.getButton(i).setOnAction(new ButtonHandler());
		}
	}
	
	public void change(String accumulateur) {
		view.change(accumulateur);
	}

	
	public void change(List<Double> stackData) {		
		view.change(stackData);			
	}
	
	
	private class ButtonHandler implements EventHandler<ActionEvent> {
		
		
		@Override
		public void handle(ActionEvent event) {
			Button source = (Button) event.getSource();
			String buttonText = source.getText();
			String accumulateur = view.getAccumulateur();
			
			switch(buttonText) {
		    case "1":
		    case "2":
		    case "3":
		    case "4":
		    case "5":
		    case "6":
		    case "7":
		    case "8":
		    case "9":
		    case "0":
		    case ".":
		        change(buttonText);
		        break;
		        
		    case "push":
		    	
		    	if (!accumulateur.isEmpty()) {
		        	model.push(Double.parseDouble(accumulateur));
		        	view.clearAccumulateur();
		        	change(model.getOperandStack());
		        }
		        break;
		        
		    case "+":
		        model.add();
		        change(model.getOperandStack());
		        break;
		        
		    case "-":
		        model.subtract();
		        change(model.getOperandStack());
		        break;
		        
		    case "*":
		        model.multiply();
		        change(model.getOperandStack());
		        break;
		        
		    case "/":
		        model.divide();
		        change(model.getOperandStack());
		        break;
		        
		    case "<>":
		        model.swap();
		        change(model.getOperandStack());
		        break;
		        
		    case "drop":
		        if (!model.getOperandStack().isEmpty()) {
		            model.drop();
		            change(model.getOperandStack());
		        }
		        break;
		        
		    case "C":
		        if (!model.getOperandStack().isEmpty()) {
		            model.clearStack();
		            change(model.getOperandStack());
		        }
		        break; 
		    
		    case "<-":
		    	if (!accumulateur.isEmpty()) {
		        	String newAccumulateur = accumulateur.substring(0, accumulateur.length()-1);
		        	view.clearAccumulateur();
		        	change(newAccumulateur);
		        }
			}
		}
	}
		
	
}
