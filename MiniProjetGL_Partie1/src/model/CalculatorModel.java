//Clément GABON et Loïc Lainé
package model;

import java.util.Stack;

//Modèle de la calculatrice
public class CalculatorModel implements CalculatorModelInterface {
	private double accumulator; // L'accumulateur
	private Stack<Double> operandStack; // La pile d'opérandes

	public CalculatorModel() {
		accumulator = 0.0;
		operandStack = new Stack<>();
	}

	// Méthode pour effectuer une opération d'addition
	public void add() {
		// Si la pile n'est pas vide, on peut prendre le premier élément
		if (!operandStack.isEmpty()) {
			double operand1 = operandStack.pop();
			// Si la pile n'est toujours pas vide, on prend le nouveau premier élément
			if (!operandStack.isEmpty()) {
				double operand2 = operandStack.pop();
				operandStack.push(operand1 + operand2);
				accumulator = operand1 + operand2;
			}
			// Si elle est vide, on remet le premier élément retiré dans la pile
			else { operandStack.push(operand1); }
		}
	}

	// Méthode pour effectuer une opération de soustraction
	public void subtract() {
		if (!operandStack.isEmpty()) {
			double operand1 = operandStack.pop();
			if (!operandStack.isEmpty()) {
				double operand2 = operandStack.pop();
				operandStack.push(operand2 - operand1);
				accumulator = operand2 - operand1;
			} else { operandStack.push(operand1); }
		}
	}

	// Méthode pour effectuer une opération de multiplication
	public void multiply() {
		if (!operandStack.isEmpty()) {
			double operand1 = operandStack.pop();
			if (!operandStack.isEmpty()) {
				double operand2 = operandStack.pop();
				operandStack.push(operand1 * operand2);
				accumulator = operand1 * operand2;
			} else { operandStack.push(operand1); }	
		}
	}

	// Méthode pour effectuer une opération de division
	public void divide() {
		if (!operandStack.isEmpty()) {
			double operand1 = operandStack.pop();
			if (!operandStack.isEmpty()) {
				double operand2 = operandStack.pop();
				if (operand1 != 0) {
					operandStack.push(operand2 / operand1);
					accumulator = operand2 / operand1;
				} else {
					operandStack.push((double) 0);
					accumulator = 0.0;
				}
			} else { operandStack.push(operand1); }
		}
	}

	// Méthode pour empiler un nombre sur la pile
	public void push(double value) {
		operandStack.push(value);
	}
	
	// Méthode pour enlever et retourner le dernier opérande de la pile
	public void pop() {
		operandStack.pop();
	}
	
	// Méthode pour éliminé le dernier opérande de la liste
	public void drop() {
		operandStack.pop();
	}
	
	// Méthode pour échanger les 2 derniers opérandes de la pile, il faut s'assurer d'avoir au moins 2 opérandes dans la pile
	public void swap() {
		if (operandStack.size() >= 2) {
			double top = operandStack.pop();
			double new_top = operandStack.pop();
			operandStack.push(top);
			operandStack.push(new_top);
		}
	}

	// Méthode pour vider la pile
	public void clearStack() {
		operandStack.clear();
	}

	// Méthode pour vider l'accumulateur
	public void clearAccumulator() {
		accumulator = 0.0;
	}

	// Méthode pour obtenir la valeur actuelle de l'accumulateur
	public double getAccumulator() {
		return accumulator;
	}

	// Méthode pour obtenir la pile d'opérandes (pour des besoins de débogage, par
	// exemple)
	public Stack<Double> getOperandStack() {
		return operandStack;
	}
}
