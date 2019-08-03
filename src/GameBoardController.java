import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

// This is a controller for the scene created by the GameBoard.fxml. It does not control the flow of the game itself.

public class GameBoardController{
	@FXML
	GridPane playArea;
	@FXML
	HBox player1,player2,player3,player4;

	public void initialize(){
		// There will always be at least 2 players, so I don't need to put them into an if statement
		player1.getChildren().add(new Text(Main.players[0].getName() + " \nScore: " + Main.players[0].getScore()));
		player2.getChildren().add(new Text(Main.players[1].getName() + " \nScore: " + Main.players[1].getScore()));

		if(MainMenuController.playerCount == 3){
			player3.getChildren().add(new Text(Main.players[2].getName() + " \nScore: " + Main.players[2].getScore()));
		}else{
			player3.getChildren().add(new Text(Main.players[2].getName() + " \nScore: " + Main.players[2].getScore()));
			player4.getChildren().add(new Text(Main.players[3].getName() + " \nScore: " + Main.players[3].getScore()));
		}
		// TODO Start the game
	}
}
