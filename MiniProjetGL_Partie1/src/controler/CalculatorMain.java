//Clément GABON et Loïc Lainé TP de Génie logiciel
package controler;

public class CalculatorMain {
    public static void main(String[] args) {
        CalculatorModel calculator = new CalculatorModel();

        // Addition
        calculator.push(5.0);
        calculator.push(3.0);
        System.out.println("Pile d'opérandes avant addition : " + calculator.getOperandStack());
        System.out.println("Accumulateur avant addition : " + calculator.getAccumulator());
        calculator.add();
        System.out.println("Résultat après addition : " + calculator.getAccumulator());
        
        
        //multiplication
        calculator.push(10.0);
        System.out.println("Pile d'opérandes avant multiplication : " + calculator.getOperandStack());
        System.out.println("Accumulateur avant multiplication : " + calculator.getAccumulator());
        calculator.multiply();
        System.out.println("Résultat après multiplication : " + calculator.getAccumulator());
       
        
        //division
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

