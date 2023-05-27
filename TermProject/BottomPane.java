//Muhammed Hasan Erzincanli 150121031
//Yunus Emre Gezici 150121066
import java.util.Iterator;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;

public class BottomPane extends BorderPane {
	//To keep the current level
	NewLevel lvl;
	// To delete old line
	static Polyline line;
	//Last cityButton object's coordinates
	static double endX;
	static double endY;
	//Keeps DRIVE button
	Button b;
	//Keeps the current score
	int score = 0;

	public BottomPane(NewLevel lvl, Text text) {
		this.lvl = lvl;
		//Drive button is initialized
		b = new Button();
		b.setText("DRIVE");
		//To change its apperance
		b.setStyle(
				"-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 24px; -fx-font-family: Arial;"
						+ "-fx-font-style: italic;");
		setStyle("-fx-border-color: black");
		//Normally, we dont want to show it to user so opaque
		b.setOpacity(0.5);
		//When user clicks this button handle method of inner class is invoked
		b.setOnAction(new DriveButtonSetOnAction());
		//Button is set to the right and text that taken as an argument is set to the left
		setRight(b);
		setLeft(text);

	}

	class DriveButtonSetOnAction implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			//When user enter the button again we change its opacity 
			b.setOpacity(0.5);
			//Button should be clickable only if a cityButton object has been clicked
			b.setDisable(true);
			//To find vehicle's coordinaates
			double startX = lvl.vehicle.xCoordinate + 25;
			double startY = lvl.vehicle.yCoordinate + 25;
			NewCenterPane pane = lvl.getPane().center;
			//25 is added to normal value because it looks better now
			endX = NewCityButton.endX + 25;
			endY = NewCityButton.endY + 25;
			// For moving vehicle to its new coordinates
			lvl.vehicle.xCoordinate = endX;
			lvl.vehicle.yCoordinate = endY;
			//To find the vehicle is on which city now 
			for (int i = 0; i < lvl.cities.size(); i++) {
				if (lvl.cities.get(i).getId() == lvl.vehicle.getCityId())
					lvl.vehicle.setCityName(lvl.cities.get(i).getName());
			}//Substracting the passangers from others
			lvl.getPane().center.city.transportPassengers();
			//Now, id and city name are changed for its new city
			lvl.vehicle.setCityId(lvl.vehicle.getDestCityId());
			for (int i = 0; i < lvl.cities.size(); i++) {
				if (lvl.cities.get(i).getId() == lvl.vehicle.getCityId())
					lvl.vehicle.setCityName(lvl.cities.get(i).getName());
			}
			//If we do not do that vehicle does not move on the line 
			//We dont understand what it does that but it worked
			lvl.vehicle.imageView.setLayoutX(0);
			lvl.vehicle.imageView.setLayoutY(0);
			//Creates a polyline object with this points
			Polyline polyline = pane.createLine(startX, startY, endX, endY);
			//To add it to the pane
			pane.getChildren().add(polyline);
			//If it is the first line that is created we initialize the line object to that
			if (line == null) {
				line = polyline;
			}//If line keeps a polyline object old line is deleted 
			else {
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
			//Starts the animation
			pane.animation(polyline);
			//Calculates the current score
			score +=lvl.getPane().center.city.calculateScore(lvl.getPane().center.city
					.calculateDistance((int) (startX), (int) (startY), (int) (endX), (int) (endY)));
			//Add the score to the top
			lvl.getPane().top.score.set(score);
			//Bind the score's value
			lvl.getPane().top.scoreLabel.textProperty().bind(Bindings.format("Score: %d", lvl.getPane().top.score));
			//There is no passengers at 
			lvl.vehicle.pasAtVehicle = 0;
		}
	}
}
