//Clément GABON et Loïc Lainé TP de Génie logiciel
package controler;


import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import view.CalculatorGUIInterface;
import view.CalculatorGUI;

public class CalculatorMain extends Application{
    public void start(Stage primaryStage) throws Exception {
			try {
				CalculatorControlerInterface control = new CalculatorControler(primaryStage);
				//control.run();
				//control.change("accu");
				//control.change(new ArrayList<Double>());
				
				/*CalculatorGUIInterface gui = new CalculatorGUI(primaryStage);
				gui.affiche();
				gui.change("accu");
				List<Double> liste = new ArrayList<Double>();
				liste.add(1.0);
				liste.add(2.0);
				liste.add(3.0);
				gui.change(liste);*/
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		
	}
    
    public static void main(String[] args) {
      	launch(args);
    	/*CalculatorModelInterface calculator = new CalculatorModel();
        
        // Addition
        calculator.push(5.0);
        
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
        
        //swap
        calculator.push(7.0); calculator.push(3.0); calculator.push(2.0);
        System.out.println("Pile d'opérandes avant swap : " + calculator.getOperandStack());
        calculator.swap();
        System.out.println("Pile d'opérandes après swap : " + calculator.getOperandStack());*/
    }

		
}

