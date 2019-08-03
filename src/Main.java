import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	static Player[] players = new Player[4];
	static Stage mainPane;

	@Override
	public void start(Stage primaryStage) throws Exception {
		mainPane = primaryStage;
		mainPane.setTitle("Bomberman");
		Parent root = FXMLLoader.load(getClass().getResource("/MainMenu.fxml"));
		Scene scene = new Scene(root);
		mainPane.setScene(scene);
		mainPane.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
