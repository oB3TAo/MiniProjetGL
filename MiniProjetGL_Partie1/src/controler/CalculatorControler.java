/**
 * Partie controller du programme 
 */
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

	/**
	 * méthode permettant de lancer les différentes méthodes gérant les actions et
	 * l'affichage de la calculatrice
	 */
	public void run() {
		view.affiche();
		for (int i = 0; i < 20; i++) {
			view.getButton(i).setOnAction(new ButtonHandler());
		}
	}

	// méthode permettant de changer la valeur de l'accumulateur
	public void change(String accumulateur) {
		view.change(accumulateur);
	}

	// méthode permettant de changer la valeur de l'accumulateur
	public void change(List<Double> stackData) {
		view.change(stackData);
	}

	private class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		/**
		 * La méthode handle permet de gérer les interactions sur chaque boutons, pour
		 * effectuer les bonnes actions
		 */
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


			// Le switch permet de différencier les actions de chaque boutons
			switch (buttonText) {

			/**
			 * pour les boutons des numéros de 0 à 9 et du point symbolisant la virgule,
			 * réalise la même action. Qui va transformer la valeur du bouton en texte et
			 * rajouter à la suite chaque valeur
			 */
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

			/**
			 * L'action réaliser est de push dans l'accumulateur les valeurs rentrer avec
			 * les boutons précédent
			 */
			case "<-":
				Double accu = Double.parseDouble(view.getAccumulateur());
				model.push(accu);
				change(model.getOperandStack());
				break;

			// L'action réaliser est l'addition
			case "+":
				model.add();
				change(model.getOperandStack());
				break;

			// L'action réaliser est la soustraction
			case "-":
				model.subtract();
				change(model.getOperandStack());
				break;

			// L'action réaliser est la multiplication
			case "*":
				model.multiply();
				change(model.getOperandStack());
				break;

			// L'action réaliser est la division
			case "/":
				model.divide();
				change(model.getOperandStack());
				break;

			/**
			 * L'action réaliser est d'échanger la derniere valeur ajouter dans la pile avec
			 * l'avant derniere
			 */
			case "<>":
				model.swap();
				change(model.getOperandStack());
				break;

			// L'action réaliser est de supprimer la derniere valeur ajouter dans la pile
			case "del":
				if (!model.getOperandStack().isEmpty()) {
					model.drop();
					change(model.getOperandStack());
				}
				break;

			// L'action réaliser est de vider totalement la pile
			case "C":
				if (!model.getOperandStack().isEmpty()) {
					model.clearStack();
					change(model.getOperandStack());
				}
				break;

			}
		}
	}
	}

}
