import java.util.Iterator;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class BottomPane extends BorderPane {
	NewLevel lvl;
	// To delete old line
	static Polyline line;
	static double endX;
	static double endY;
	Button b;

	public BottomPane(NewLevel lvl, Text text) {
		this.lvl = lvl;
		b = new Button();
		b.setText("DRIVE");
		b.setStyle(
				"-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 24px; -fx-font-family: Arial;"
						+ "-fx-font-style: italic;");
		setStyle("-fx-border-color: black");
		b.setOpacity(0.5);
		b.setOnAction(new DriveButtonSetOnAction());
		Text score = new Text("score");
		score.setTextAlignment(TextAlignment.CENTER);
		setRight(b);
		setLeft(text);

	}

	class DriveButtonSetOnAction implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			b.setOpacity(0.5);
			b.setDisable(true);
			double startX = lvl.vehicle.xCordinate + 25;
			double startY = lvl.vehicle.yCordinate + 25;
			NewCenterPane pane = lvl.getPane().center;
			endX = NewCityButton.endX + 25;
			endY = NewCityButton.endY + 25;
			// For moving vehicle to its new coordinates
			lvl.vehicle.xCordinate = endX;
			lvl.vehicle.yCordinate = endY;

			for (int i = 0; i < lvl.cities.size(); i++) {
				if (lvl.cities.get(i).getId() == lvl.vehicle.getCityId())
					lvl.vehicle.setCityName(lvl.cities.get(i).getName());
			}
			lvl.getPane().center.city.transportPassengers();

			lvl.vehicle.setCityId(lvl.vehicle.getDestCityId());
			for (int i = 0; i < lvl.cities.size(); i++) {
				if (lvl.cities.get(i).getId() == lvl.vehicle.getCityId())
					lvl.vehicle.setCityName(lvl.cities.get(i).getName());
			}
			lvl.vehicle.imageView.setLayoutX(0);
			lvl.vehicle.imageView.setLayoutY(0);
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
			lvl.getPane().top.score.set(lvl.getPane().center.city.calculateScore(lvl.getPane().center.city
					.calculateDistance((int) (startX), (int) (startY), (int) (endX), (int) (endY))));
			lvl.getPane().top.scoreLabel.textProperty().bind(Bindings.format("Score: %d", lvl.getPane().top.score));

		}
	}
}
