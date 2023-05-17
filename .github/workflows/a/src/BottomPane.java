import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class BottomPane extends BorderPane {
	NewLevel level;
	IntegerProperty propertyValue = new SimpleIntegerProperty(0);
	
	public BottomPane(Text text, NewLevel level) {
		this.level = level;
		DriveButton b = new DriveButton(level);
		b.setText("DRIVE");
		b.setStyle(
				"-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 24px; -fx-font-family: Arial;"
						+ "-fx-font-style: italic;");
		setStyle("-fx-border-color: black");
		b.setOnMouseEntered(e -> b.setOpacity(1.0));
		b.setOnMouseExited(e -> b.setOpacity(0.5));
		b.setOnAction(new DriveSetOnAction());
		Text score = new Text("score");
		score.setTextAlignment(TextAlignment.CENTER);
		setRight(b);
		
		
 
        Label propertyLabel = new Label();
        propertyLabel.textProperty().bind(Bindings.format("Property Value: %2d",propertyValue));
        setTop(propertyLabel);
        setLeft(text);
	
	}

	public void changeLoc(NewLevel level) {
		level.getCenterPane().setVx(0);
		level.getCenterPane().setVy(0);
	}

	class DriveSetOnAction implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			level.getCenterPane().getChildren().remove(level.getCenterPane().imageView);
			level.getCenterPane().add(level.getCenterPane().imageView, CityButton.getNextCity().colIndex - 1,
					CityButton.getNextCity().rowIndex - 1);
			propertyValue = level.getCenterPane().getForNextCity().loc.calculateScore();
			System.out.println(propertyValue);
			Label propertyLabel = new Label();
	        propertyLabel.textProperty().bind(Bindings.format("Property Value: %2d",propertyValue));
	        setTop(propertyLabel);
		}
	}
}
