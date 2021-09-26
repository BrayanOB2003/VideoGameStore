package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	private static MainPageGUI mainController;
	
	public static void main(String[] args) {
		
		mainController = new MainPageGUI();
		
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
		
		fxmlLoader.setController(mainController);
		
		
		Parent root = fxmlLoader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Simulador de tienda de videojuegos");
		primaryStage.show();
		
	}
}
