//Clément GABON et Loïc Lainé
package model;

import java.util.Stack;

//Modèle de la calculatrice
public class CalculatorModel {
 private double accumulator; // L'accumulateur
 private Stack<Double> operandStack; // La pile d'opérandes

 public CalculatorModel() {
	 accumulator=0.0;
     operandStack = new Stack<>();
 }

 // Méthode pour effectuer une opération d'addition
 public void add() {
     if (!operandStack.isEmpty()) {
         double operand1 = operandStack.pop();
         double operand2 = operandStack.pop();
         operandStack.push(operand1 + operand2);
         accumulator=operand1 + operand2;
     }
 }

 // Méthode pour effectuer une opération de soustraction
 public void subtract() {
     if (!operandStack.isEmpty()) {
         double operand1 = operandStack.pop();
         double operand2 = operandStack.pop();
         operandStack.push(operand2 - operand1);
         accumulator=operand2 - operand1;
     }
 }

 // Méthode pour effectuer une opération de multiplication
 public void multiply() {
     if (!operandStack.isEmpty()) {
    	 double operand1 = operandStack.pop();
         double operand2 = operandStack.pop();
         operandStack.push(operand1 * operand2);
         accumulator=operand1 * operand2;
     }
 }

 // Méthode pour effectuer une opération de division
 public void divide() {
     if (!operandStack.isEmpty()) {
    	 double operand1 = operandStack.pop();
         double operand2 = operandStack.pop();
         if (operand1 != 0) {
        	 operandStack.push(operand2 / operand1);
        	 accumulator=operand2 / operand1;
         } else {
        	 operandStack.push((double) 0);
        	 accumulator=0.0;
         }
     }
 }

 // Méthode pour empiler un nombre sur la pile
 public void push(double value) {
     operandStack.push(value);
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

 // Méthode pour obtenir la pile d'opérandes (pour des besoins de débogage, par exemple)
 public Stack<Double> getOperandStack() {
     return operandStack;
 }
}
