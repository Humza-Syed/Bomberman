import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite{
	private Image image;
	private double posX,posY;
	private double velX,velY;
	private double width,height;

	Sprite(Image image, double x, double y){
		this.image = image;
		this.posX = x;
		this.posY = y;
		velX = velY = 0;
		this.width = image.getWidth();
		this.height = image.getHeight();
	}

	void update(double time){ // Update the sprite locations
		this.posX += velX * time;
		this.posY += velY * time;
	}

	void render(GraphicsContext gc){
		gc.drawImage(image,posX,posY);
	}

	private Rectangle2D getBoundary(){
		return new Rectangle2D(posX,posY,width,height);
	}

	boolean intersects(Sprite s){
		return s.getBoundary().intersects(this.getBoundary());
	}

	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}

	public double getVelX() {
		return velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setPosition(double x, double y){
		this.posX = x;
		this.posY = y;
	}

	public void setVelocity(double x, double y){
		this.velX = x;
		this.velY = y;
	}

	public Image getImage(){
		return this.image;
	}
}
