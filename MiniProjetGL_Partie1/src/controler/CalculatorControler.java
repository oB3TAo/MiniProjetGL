package controler;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.CalculatorModelInterface;
import view.CalculatorGUIInterface;

public class CalculatorControler implements CalculatorControlerInterface {

	private CalculatorModelInterface model;
	private CalculatorGUIInterface view;
	private List<Double> stackData;
	private String accumulateur;

	public CalculatorControler(CalculatorModelInterface model, CalculatorGUIInterface view) {
		// à passer dans le modele ???
		accumulateur = "";
		stackData = new ArrayList<Double>();

		this.view = view;
		this.model = model;

	}

	/**
	 * méthode permettant de lancer les différentes méthodes gérant les actions et
	 * l'affichage de la calculatrice
	 */
	public void run() {
		view.affiche();
		view.change(accumulateur);
		view.change(stackData);
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

		/**
		 * La méthode handle permet de gérer les interactions sur chaque boutons, pour
		 * effectuer les bonnes actions
		 */
		public void handle(ActionEvent event) {
			Button source = (Button) event.getSource();
			String buttonText = source.getText();

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
				Double accu = Double.parseDouble(view.getAccu());
				model.push(accu);
				change(model.getOperandStack());
				break;

			// L'action réaliser est l'addition
			case "+":
				// Réalise l'addition
				model.add();
				// change la valeur dans l'accumulateur avec le résultat de l'addition
				change(model.getOperandStack());
				break;
			// Les actions suivantes (-,*,/) sont similaires à celle de l'addition
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
