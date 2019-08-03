import javafx.scene.image.Image;

public class Player {
	private String name;
	private int score;

	Player(String name){
		this.name = name;
		this.score = 0;
	}

	String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
