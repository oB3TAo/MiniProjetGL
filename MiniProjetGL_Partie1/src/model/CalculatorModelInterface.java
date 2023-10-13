package model;

import java.util.Stack;

public interface CalculatorModelInterface {

	// Méthode pour effectuer une opération de soustraction
	public void add();

	// Méthode pour effectuer une opération de soustraction
	public void subtract();

	// Méthode pour effectuer une opération de multiplication
	public void multiply();

	// Méthode pour effectuer une opération de division
	public void divide();

	// Méthode pour empiler un nombre sur la pile
	public void push(double value);

	// Méthode pour prendre le premier élémenet de la pile
	public void pop();

	// Méthode drop
	public void drop();

	// Méthode swap
	public void swap();

	// Méthode pour vider la pile
	public void clearStack();

	// Méthode pour vider l'accumulateur
	public void clearAccumulator();

	// Méthode pour obtenir la valeur actuelle de l'accumulateur
	public double getAccumulator();

	// Méthode pour obtenir la pile d'opérandes (pour des besoins de débogage, par
	// exemple)
	public Stack<Double> getOperandStack();

}
