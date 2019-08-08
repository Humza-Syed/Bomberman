import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Bomberman {
	private Canvas canvas;
	private GridPane playArea;
	private Wall [] innerIndestructibleWall = new Wall[30]; // There are 24 inner indestructible walls


	public Bomberman(Canvas canvas, GridPane playArea){
		this.canvas = canvas;
		this.playArea = playArea;
		createIndestructibleInnerWalls();
	}

	private void createIndestructibleInnerWalls(){
		double cellWidth = playArea.getPrefWidth()/playArea.getColumnCount();
		double cellHeight = playArea.getPrefHeight()/playArea.getRowCount();

		for(int i = 2,wallNo = 0;i <= 10;i = i + 2)
			for(int j = 2;j <= 12;j = j+2){
				innerIndestructibleWall[wallNo] = new Wall(cellWidth,cellHeight,false,Color.DARKGRAY);
				playArea.add(innerIndestructibleWall[wallNo],i,j);
				wallNo++;
			}
	}
}
