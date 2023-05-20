import java.util.Iterator;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class BottomPane extends BorderPane {
	NewLevel lvl;
	// To delete old line
	static Polyline line;
	static double endX;
	static double endY;

	public BottomPane(NewLevel lvl, Text text) {
		this.lvl = lvl;
		Button b = new Button();
		b.setText("DRIVE");
		b.setStyle(
				"-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 24px; -fx-font-family: Arial;"
						+ "-fx-font-style: italic;");
		setStyle("-fx-border-color: black");
		b.setOnMouseEntered(e -> b.setOpacity(1.0));
		b.setOnMouseExited(e -> b.setOpacity(0.5));
		b.setOnAction(new DriveButtonSetOnAction());
		Text score = new Text("score");
		score.setTextAlignment(TextAlignment.CENTER);
		setRight(b);
		setLeft(text);

	}

	class DriveButtonSetOnAction implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			double startX = lvl.vehicle.xCordinate;
			double startY = lvl.vehicle.yCordinate;
			NewCenterPane pane = lvl.getPane().center;
			endX = NewCityButton.endX;
			endY = NewCityButton.endY;
			// For moving vehicle to its new coordinates
			lvl.vehicle.xCordinate = endX;
			lvl.vehicle.yCordinate = endY;
			
			lvl.vehicle.setCityId(lvl.vehicle.getDestCityId());
			lvl.getPane().center.city.transportPassengers();
			for(int i = 0; i < lvl.cities.size(); i++) {
				if(lvl.cities.get(i).getId() ==  lvl.vehicle.getCityId())
					lvl.vehicle.setCityName(lvl.cities.get(i).getName());
			}
			
			
			Polyline polyline = pane.createLine(startX, startY, endX, endY);
			pane.getChildren().add(polyline);
			if (line == null) {
				line = polyline;
			} else {
				// Normally, we used a for loop here but it threw some exceptions that we cannot
				// handle so we found an alternative
				Iterator<Node> iterator = pane.getChildren().iterator();
				while (iterator.hasNext()) {
					Node node = iterator.next();
					if (line.equals(node)) {
						iterator.remove();
					}
				}
				line = polyline;
			}
			pane.animation(polyline);
			lvl.getPane().top.score.set(lvl.getPane().center.city.calculateScore(lvl.getPane().center.city.calculateDistance((int)(startX),
					(int)(startY),(int)(endX),(int)(endY)))); 
	        lvl.getPane().top.scoreLabel.textProperty().bind(Bindings.format("Score: %d" ,lvl.getPane().top.score));
	   
			
		}
	}

}
