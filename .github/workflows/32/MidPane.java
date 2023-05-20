import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;

public class MidPane extends StackPane {
	GridPane pane = new GridPane();
	ArrayList<Double> x = new ArrayList<>();
	ArrayList<Double> y = new ArrayList<>();
	
	public MidPane(GridPane pane) {
		this.pane = pane;
		setOnMouseClicked(event -> {
			double x = event.getX();
			double y = event.getY();
			System.out.println("Mouse clicked at (" + x + ", " + y + ")");
		});
		Button button = new Button();
		pane.getChildren().add(button);
	}

	public void drawLine() {
		Line line1 = new Line();
		if (x.get(0) > x.get(1)) {
			line1.setStartX(x.get(1));
			line1.setEndX(x.get(0));
		}
	}

}
