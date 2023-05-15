import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Direction extends Line{
	int sx;
	int sy;
	int ex;
	int ey;


	Direction() {
		
	}


	
	public Pane createRowLine() {
	    Pane pane = new Pane();
	    Line line = new Line(0,0,50,0);
	    line.setStrokeWidth(7);
	    line.setStroke(Color.GREEN);
	    pane.getChildren().add(line);
	    pane.setPrefWidth(50);
	    pane.setPrefHeight(7);
	    return pane;
	}

	public Line createColLine() {
		Line line = new Line(0,49,0,0);
		line.setStrokeWidth(7);
		line.setStroke(Color.GREEN);
		
		return line;
	}

}
