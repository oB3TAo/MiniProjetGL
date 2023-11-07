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
	private Button swapButton;
	private Button dropButton;
	private Button enterButton;
	private Button dotButton;
	private Button clearButton;
	private Button delButton;
	
	private TextField displayField3;
	private TextField displayField2;
	private TextField displayField1;

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
        
        numberButtons[0] = new Button("0");
        numberButtons[0].setPrefSize(35, 35);
        grid.add(numberButtons[0], 1, 6);
        
        for (int i = 9; i > 0; i--) {
        	
            numberButtons[i] = new Button(Integer.toString(i));
            numberButtons[i].setPrefSize(35, 35);
            int row = (i-1) / 3 + 3;
            int col = (i-1) % 3 ;
            grid.add(numberButtons[i], col, row);
            
        }
        
        //création des boutons "opération"
        addButton = new Button("+"); addButton.setPrefSize(35, 35);
        subButton = new Button("-"); subButton.setPrefSize(35, 35);
        mulButton = new Button("*"); mulButton.setPrefSize(35, 35);
        divButton = new Button("/"); divButton.setPrefSize(35, 35);
        swapButton = new Button("<>"); swapButton.setPrefSize(35, 35);
        dropButton = new Button("drop"); dropButton.setPrefSize(35, 35); dropButton.setStyle("-fx-font-size:10;");
        enterButton = new Button("push"); enterButton.setPrefSize(35, 35); enterButton.setStyle("-fx-font-size:10;");
        dotButton = new Button("."); dotButton.setPrefSize(35,35);
        clearButton = new Button("C"); clearButton.setPrefSize(35,35);
        delButton = new Button("<-"); delButton.setPrefSize(35,35);
        
        grid.add(addButton, 3, 3);
        grid.add(subButton, 3, 4);
        grid.add(mulButton, 3, 5);
        grid.add(divButton, 3, 6);
        grid.add(dotButton, 0, 6);
        grid.add(enterButton, 2, 6);
        grid.add(dropButton, 0, 7);
        grid.add(swapButton, 1, 7);
        grid.add(clearButton, 2, 7);
        grid.add(delButton, 3, 7);
        
        
        displayField1 = new TextField();
        displayField1.setEditable(false);
        displayField1.setPromptText("Avant dernier opérande");
        grid.add(displayField1, 0,0, 4, 1);
        
        displayField2 = new TextField();
        displayField2.setEditable(false);
        displayField2.setPromptText("Dernier opérande");
        grid.add(displayField2, 0, 1, 4, 1);
        
        displayField3 = new TextField();
        displayField3.setEditable(false);
        displayField3.setPromptText("Accumulateur");
        grid.add(displayField3, 0, 2, 4, 1);
	}
	
	//affichage du GUI
	public void affiche() {
		
		stage.setTitle("Calculator");       
		Scene scene = new Scene(grid, 300, 500);
		stage.setScene(scene);		
		stage.show();
		
	}
	
	//boite de texte pour l'accumulateur
	public void change(String accu) { 
        displayField3.appendText(accu);
	}
	
	public String getAccumulateur() {
		return displayField3.getText();
	}
	
	public void clearAccumulateur() {
		displayField3.clear();
	}
	
	// boites de texte pour afficher les derniers éléments du operandStack (sous forme de liste)
	public void change(List<Double> stackData) {
		if (stackData.size() == 0) {
			displayField1.clear();
			displayField2.clear();
		} else if (stackData.size() == 1) {
			displayField1.clear();
			displayField2.clear();
			displayField2.setText(Double.toString(stackData.get(0)));
		} else {
			//le deuxième élément de la liste apparait dans une boite de texte
			displayField1.clear();
			displayField1.setText(Double.toString(stackData.get(stackData.size()-2)));
			//le premier élément de la liste apparait dans une boite de texte
			displayField2.clear();
			displayField2.setText(Double.toString(stackData.get(stackData.size()-1)));
		}
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
			return swapButton;
		} else if (i == 15){
			return dropButton;
		} else if (i == 16){
			return enterButton;
		} else if (i == 17){
			return dotButton;
		} else if (i == 18){
			return clearButton;
		} else {
			return delButton;
		}
	}
	
	
	
}
