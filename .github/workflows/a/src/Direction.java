import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Direction extends StackPane {
	
	Direction() {
		
	}
	public StackPane createRowLine() {
        Line line = new Line(0, 0, 49, 0);
        line.setStrokeWidth(7);
        line.setStroke(Color.GREEN);
        StackPane pane = new StackPane(line);
        pane.setPrefWidth(50);
        pane.setPrefHeight(7);
        this.prefWidthProperty().bind(pane.widthProperty());
        this.prefHeightProperty().bind(pane.heightProperty());
        return pane;
    }


	    public Line createColLine() {
	        Line line = new Line(0,49,0,0);
	        line.setStrokeWidth(7);
	        line.setStroke(Color.GREEN);
	        return line;
	    }
	

}
