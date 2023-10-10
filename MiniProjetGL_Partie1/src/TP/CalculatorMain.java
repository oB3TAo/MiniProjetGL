//Clément GABON et Loïc Lainé
package TP;

public class CalculatorMain {
    public static void main(String[] args) {
        CalculatorModel calculator = new CalculatorModel();

        // Effectuer quelques opérations de test
        calculator.push(5.0);
        calculator.push(3.0);
        calculator.add();
        System.out.println("Résultat après addition : " + calculator.getAccumulator());

        calculator.push(10.0);
        calculator.multiply();
        System.out.println("Résultat après multiplication : " + calculator.getAccumulator());

        calculator.push(4.0);
        calculator.divide();
        System.out.println("Résultat après division : " + calculator.getAccumulator());
        
        System.out.println("Pile d'opérandes avant vidage : " + calculator.getOperandStack());
        System.out.println("Accumulateur avant vidage : " + calculator.getAccumulator());

        // Vider la pile et l'accumulateur
        calculator.clearStack();
        calculator.clearAccumulator();

        System.out.println("Pile d'opérandes après vidage : " + calculator.getOperandStack());
        System.out.println("Accumulateur après vidage : " + calculator.getAccumulator());
    }
}

