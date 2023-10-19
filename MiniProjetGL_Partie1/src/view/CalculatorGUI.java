package view;


import java.util.List;



import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class CalculatorGUI implements CalculatorGUIInterface{
	
	private Stage stage;
	private GridPane grid;
	private Button[] numberButtons;
	private Button addButton;
	private Button subButton;
	private Button mulButton;
	private Button divButton;
	private Button equalButton;
	private Button delButton;

	public CalculatorGUI(Stage primaryStage) {
		
		stage = primaryStage;
		
		//implémentation d'une Pane sous forme de grille
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setScaleX(1.2);
        grid.setScaleY(1.2);
        
        //création des boutons de 0 à 9
        numberButtons = new Button[10];
        for (int i = 0; i < 10; i++) {
        	
            numberButtons[i] = new Button(Integer.toString(i));
            int row = i / 3 + 3;
            int col = i % 3;
            grid.add(numberButtons[i], col, row);
            
        }
        
        //création des boutons "opération"
        addButton = new Button("+");
        subButton = new Button("-");
        mulButton = new Button("*");
        divButton = new Button("/");
        equalButton = new Button("=");
        delButton = new Button("del");

        grid.add(addButton, 3, 3);
        grid.add(subButton, 3, 4);
        grid.add(mulButton, 3, 5);
        grid.add(divButton, 3, 6);
        grid.add(equalButton, 2, 6);
        grid.add(delButton, 1, 6);
        
	}
	
	//affichage du GUI
	public void affiche() {
		
		stage.setTitle("Calculator");       
		Scene scene = new Scene(grid, 300, 400);
		stage.setScene(scene);		
		stage.show();
		
	}
	
	//boite de texte pour l'accumulateur
	public void change(String accu) { 
		
		// l'accumulateur apparait dans une boite de texte
        TextField displayField3 = new TextField(accu);
        displayField3.setEditable(false);
        grid.add(displayField3, 0, 2, 4, 1);
        
	}
	
	// boites de texte pour afficher les derniers éléments du operandStack (sous forme de liste)
	public void change(List<Double> stackData) {
		
		//le deuxième élément de la liste apparait dans une boite de texte
		TextField displayField1 = new TextField(Double.toString(stackData.get(1)));
        displayField1.setEditable(false);
        grid.add(displayField1, 0,0, 4, 1);
        
        //le premier élément de la liste apparait dans une boite de texte
        TextField displayField2 = new TextField(Double.toString(stackData.get(0)));
        displayField2.setEditable(false);
        grid.add(displayField2, 0, 1, 4, 1);
        
	}
	
	// permet de gérer les actions(Button) dans le Controler
	public Button getButton(int i) {
		if (i < 10) {
			return numberButtons[i];
		} 
		// si on rentre 10 on retourne le boutton plus
		else if (i==10) {
			return addButton;
		} 
		// si on rentre 11 on retourne le bouton moins 
		else if (i==11) {
			return subButton;
		} else if (i==12) {
			return mulButton;
		} else if (i==13) {
			return divButton;
		} else if (i==14) {
			return equalButton;
		} else {
			return delButton;
		}
	}
	
	
	
}
