import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Direction extends Line{
	int sx;
	int sy;
	int ex;
	int ey;


	Direction() {
		createRowLine();
	}


	
	public Line createRowLine() {
		Line line = new Line(0,0,20,0);
		line.setStrokeWidth(7);
		line.setStroke(Color.GREEN);
		
		return line;
	}
	public Line createColLine() {
		Line line = new Line(0,20,0,0);
		line.setStrokeWidth(7);
		line.setStroke(Color.GREEN);
		
		return line;
	}

}
