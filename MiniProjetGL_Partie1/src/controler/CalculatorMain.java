//Clément GABON et Loïc Lainé TP de Génie logiciel
package controler;


import javafx.stage.Stage;
import view.*;
import model.*;
//import java.util.ArrayList;
//import java.util.List;

import javafx.application.Application;


public class CalculatorMain extends Application{
    public void start(Stage primaryStage) throws Exception {
			try {
				CalculatorGUIInterface view = new CalculatorGUI(primaryStage);	
				CalculatorModelInterface model = new CalculatorModel();
				CalculatorControlerInterface control = new CalculatorControler(model,view);
				control.run();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
	}
    
    public static void main(String[] args) {
      	launch(args);
    }		
}

