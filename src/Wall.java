import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Wall extends Rectangle {
	private boolean isDestructible;
	private Color color;

	Wall(double width,double height,boolean isDestructible, Color color){
		super(0,0,width,height);
		super.setFill(color);
		this.isDestructible = isDestructible;
		this.color = color;
	}

	public boolean getIsDestructible(){
		return isDestructible;
	}
}
