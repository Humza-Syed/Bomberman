import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainMenuController{
	@FXML
	TextField player1,player2,player3,player4,maxGameScore;
	@FXML
	ComboBox numOfPlayers;
	@FXML
	Button startButton;

	static int scoreToPlayTo;
	static int playerCount;

	public void initialize(){
		// Listener to the ComboBox
		numOfPlayers.valueProperty().addListener(new ChangeListener<String>(){
			@Override
			public void changed(ObservableValue<? extends String> observable,String prevValue, String newValue){
				// Only shows input to change player number for the number of players selected
				if(Integer.parseInt(newValue) == 2){
					player1.setVisible(true);
					player2.setVisible(true);
					player3.setVisible(false);
					player4.setVisible(false);
				}else if(Integer.parseInt(newValue) == 3){
					player1.setVisible(true);
					player2.setVisible(true);
					player3.setVisible(true);
					player4.setVisible(false);
				}else if(Integer.parseInt(newValue) == 4){
					player1.setVisible(true);
					player2.setVisible(true);
					player3.setVisible(true);
					player4.setVisible(true);
				}
			}
		});

		// Event Handler for the start game button
		startButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {

				if(numOfPlayers.getValue() == null)
					return;

				// Done after to prevent null creating issues
				playerCount = Integer.parseInt(numOfPlayers.getValue().toString());

				if(playerCount <= 1 || playerCount > 4){
					return;
				}

				try{
					scoreToPlayTo = Integer.parseInt(maxGameScore.getText());
				}catch(Exception e){
					scoreToPlayTo = 3;
				}

				String name1 = player1.getText();
				String name2 = player2.getText();
				String name3 = player3.getText();
				String name4 = player4.getText();

				// Checking whether or not to assign a default name
				if(name1.equals(""))
					name1 = "Player 1";
				if(name2.equals(""))
					name2 = "Player 2";
				if(name3.equals(""))
					name3 = "Player 3";
				if(name4.equals(""))
					name4 = "Player 4";

				// Creating the players needed and assigning their names.
				if(playerCount == 2){
					Main.players[0] = new Player(name1);
					Main.players[1] = new Player(name2);
				}else if(playerCount == 3){
					Main.players[0] = new Player(name1);
					Main.players[1] = new Player(name2);
					Main.players[2] = new Player(name3);
				}else{
					Main.players[0] = new Player(name1);
					Main.players[1] = new Player(name2);
					Main.players[2] = new Player(name3);
					Main.players[3] = new Player(name4);
				}

				// Changing scene to the game scene
				try{
					Parent root = FXMLLoader.load(getClass().getResource("/GameBoard.fxml"));
					Scene gameScene = new Scene(root,800,800);
					Main.mainPane.setScene(gameScene);
					Main.mainPane.show();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
}
