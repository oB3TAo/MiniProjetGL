package TP;

import java.util.Stack;

//Modèle de la calculatrice
public class CalculatorModel {
 private double accumulator; // L'accumulateur
 private Stack<Double> operandStack; // La pile d'opérandes

 public CalculatorModel() {
     accumulator = 0.0;
     operandStack = new Stack<>();
 }

 // Méthode pour effectuer une opération d'addition
 public void add() {
     if (!operandStack.isEmpty()) {
         double operand1 = operandStack.pop();
         double operand2 = operandStack.pop();
         accumulator = operand1 + operand2;
     }
 }

 // Méthode pour effectuer une opération de soustraction
 public void subtract() {
     if (!operandStack.isEmpty()) {
         double operand = operandStack.pop();
         accumulator -= operand;
     }
 }

 // Méthode pour effectuer une opération de multiplication
 public void multiply() {
     if (!operandStack.isEmpty()) {
         double operand = operandStack.pop();
         accumulator *= operand;
     }
 }

 // Méthode pour effectuer une opération de division
 public void divide() {
     if (!operandStack.isEmpty()) {
         double operand = operandStack.pop();
         if (operand != 0) {
             accumulator /= operand;
         } else {
             accumulator=0;
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
