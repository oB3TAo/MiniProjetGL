/**
 * Partie controller du programme 
 * par Clément Gabon & Loïc Lainé
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

	/**
	 * 
	 * @param model
	 * @param view
	 */
	public CalculatorControler(CalculatorModelInterface model, CalculatorGUIInterface view) {
		this.view = view;
		this.model = model;
	}

	
	// Méthode permettant de lancer l'affichage de la calculatrice
	public void run() {
		view.affiche();
		for (int i = 0; i < 20; i++) {
			view.getButton(i).setOnAction(new ButtonHandler());
		}
	}

	
	// Méthode permettant de changer la valeur de l'accumulateur
	public void change(String accumulateur) {
		view.change(accumulateur);
	}

	
	// Méthode permettant de changer l'affichage de la pile
	public void change(List<Double> stackData) {
		view.change(stackData);
	}

	
	// Gestion des boutons
	private class ButtonHandler implements EventHandler<ActionEvent> {

		/**
		 * La méthode handle permet de gérer les interactions sur chaque boutons, pour
		 * effectuer les bonnes actions
		 */
		public void handle(ActionEvent event) {
			Button source = (Button) event.getSource();
			String buttonText = source.getText();
			String accumulateur = view.getAccumulateur();

			
			// Le switch permet de différencier les actions de chaque bouton
			switch (buttonText) {

			/**
			 * Les boutons de 0 à 9 et du point réalisent la même action. Ils permettent de
			 * rentrer leur valeur dans l'accumulateur sous type de String.
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
				/*
				 * On ajoute à la suite chaque valeur dans l'accumulateur tant que le bouton
				 * push n'est pas cliqué
				 */
				change(buttonText);
				break;

				
			// Push
			case "push":
				// Vérification de si l'accumulateur est vide, pour éviter les erreurs
				if (!accumulateur.isEmpty()) {
					/*
					 * Changement de type de l'accumulateur (String -> Double) Puis l'opérande est
					 * push dans la pile
					 */
					model.push(Double.parseDouble(accumulateur));
					// On efface l'accumulateur pour laisser place au prochain opérande
					view.clearAccumulateur();
					// Affichage de l'opérande dans la pile
					change(model.getOperandStack());
				}
				break;

				
			// Addition
			case "+":
				// Fait appel à la méthode add() définie dans CalculatorModel
				model.add();
				// Après avoir réalisé l'opération on affiche le changement au sein de la pile
				change(model.getOperandStack());
				break;

			// Soustraction
			case "-":
				model.subtract();
				change(model.getOperandStack());
				break;

			// Multiplication
			case "*":
				model.multiply();
				change(model.getOperandStack());
				break;

			// Division
			case "/":
				model.divide();
				change(model.getOperandStack());
				break;

			// Echange la derniere valeur ajoutée dans la pile avec l'avant derniere
			case "<>":
				model.swap();
				change(model.getOperandStack());
				break;

			// Suppression de la derniere valeur ajoutée dans la pile
			case "drop":
				// vérifie si la pile est vide ou non, pour évider les erreurs
				if (!model.getOperandStack().isEmpty()) {
					model.drop();
					change(model.getOperandStack());
				}
				break;

			// Vidage de la pile
			case "C":
				if (!model.getOperandStack().isEmpty()) {
					model.clearStack();
					change(model.getOperandStack());
				}
				break;

				
			// Suppression de la derniere valeur mise dans l'accumulateur de la calculatrice
			case "<-":
				// Vérification de si l'accumulateur est vide, pour éviter les erreurs
				if (!accumulateur.isEmpty()) {
					// Création d'une nouvelle valeur de l'accumulateur en soustrayant le dernier
					// caractère ajouté
					String newAccumulateur = accumulateur.substring(0, accumulateur.length() - 1);
					// Vidage de l'accumulateur en appelant la méthode dans view
					view.clearAccumulateur();
					// Affichage de la nouvelle valeur de l'accumulateur
					change(newAccumulateur);
				}
			}
		}
	}

}
