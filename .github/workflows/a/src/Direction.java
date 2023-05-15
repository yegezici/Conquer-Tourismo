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


	
	public StackPane createRowLine() {
		Line line = new Line(0,0,20,0);
		line.setStrokeWidth(25);
		line.setStroke(Color.GREEN);
		StackPane stackPane = new StackPane();
		stackPane.getChildren().add(line);
		
		return stackPane;
		
	
	}
	
}
