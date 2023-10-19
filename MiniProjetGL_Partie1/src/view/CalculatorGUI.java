package view;

import java.util.List;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class CalculatorGUI implements CalculatorGUIInterface{
	
	private Stage primaryStage;

	public CalculatorGUI(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void affiche() {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 300, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void change(String accu) {
		
	}
	
	public void change(List<Double> stackData) {
		
	}
}
