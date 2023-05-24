import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class TopPane extends HBox {
	// To continue to next level
	Button b = new Button("Next Level >>");
	// To turn back to previous level
	Button back = new Button("<< Previous Level ");
	// To keep the integer value of current level. This is a static variable because
	// it should be same for all object
	static int currentLevel = 0;
	// To show user the current level
	Text t1 = new Text("LEVEL : " + (currentLevel + 1));
	// To bind the score
	IntegerProperty score = new SimpleIntegerProperty(0);
	// To put this value on a TopPane object
	Label scoreLabel;

	public TopPane() {
		// To arrange the spacing between buttons and others
		spacingProperty().bind(widthProperty().divide(15));
		setPadding(new Insets(0, 10, 0, 10));

		// The object is created in constructor
		scoreLabel = new Label();
		// In this part, appearance of the label is changed
		scoreLabel.setStyle("-fx-font-size: 15px; -fx-font-family: Galactus;"
				+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		scoreLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.EXTRA_BOLD, 15));
		// To show current score, this label are binding to score
		scoreLabel.textProperty().bind(Bindings.format("Score : %d", score));
		// This button is clickable only all passenger are transferred to their
		// destination cities; therefore, firstly it should not be clickable
		b.setDisable(true);
		// To put this button to center.
		b.setAlignment(Pos.CENTER);
		// In this part, appearance of the next level button is changed
		b.setStyle(
				"-fx-background-color: linear-gradient(#f2f2f2, #d6d6d6), linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%), linear-gradient(#dddddd 0%, #f6f6f6 50%);"
						+ " -fx-background-radius: 8,7,6;" + "-fx-background-insets: 0,1,2;" + "-fx-text-fill: black;"
						+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		// In this part, appearance of the previous level button is changed
		back.setStyle(
				"-fx-background-color: linear-gradient(#f2f2f2, #d6d6d6), linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%), linear-gradient(#dddddd 0%, #f6f6f6 50%);"
						+ " -fx-background-radius: 8,7,6;" + "-fx-background-insets: 0,1,2;" + "-fx-text-fill: black;"
						+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		// To put to text the center of its position.
		t1.setTextAlignment(TextAlignment.CENTER);
		// To change t1's font and size
		t1.setFont(Font.font("Lucida Sans Unicode", FontWeight.EXTRA_BOLD, 20));
		// All of the nodes are added in this HBox
		getChildren().addAll(t1, scoreLabel, back, b);
		// To user can realize this part is a different part from others
		setStyle("-fx-border-color: black");
		// Normally, it is not so much opaque but if user move the mouse click on the
		// button its opacity increases and then turn back to normal opacity value
		b.setOpacity(0.76);
		b.setOnMouseEntered(e -> {
			b.setOpacity(0.95);
		});
		b.setOnMouseExited(e -> {
			b.setOpacity(0.76);
		});
		back.setOnAction(e -> {
			// If user click back button current level decreases
			currentLevel--;
		});
		back.setOnMouseEntered(e -> {
			back.setOpacity(0.9);
		});
		back.setOnMouseExited(e -> {
			back.setOpacity(0.78);
		});

		b.setOnAction(e -> {
			// If user click b button level increases
			currentLevel++;

		});
	}

}import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class TopPane extends HBox {
	// To continue to next level
	Button b = new Button("Next Level >>");
	// To turn back to previous level
	Button back = new Button("<< Previous Level ");
	// To keep the integer value of current level. This is a static variable because
	// it should be same for all object
	static int currentLevel = 0;
	// To show user the current level
	Text t1 = new Text("LEVEL : " + (currentLevel + 1));
	// To bind the score
	IntegerProperty score = new SimpleIntegerProperty(0);
	// To put this value on a TopPane object
	Label scoreLabel;

	public TopPane() {
		// To arrange the spacing between buttons and others
		spacingProperty().bind(widthProperty().divide(15));
		setPadding(new Insets(0, 10, 0, 10));

		// The object is created in constructor
		scoreLabel = new Label();
		// In this part, appearance of the label is changed
		scoreLabel.setStyle("-fx-font-size: 15px; -fx-font-family: Galactus;"
				+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		scoreLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.EXTRA_BOLD, 15));
		// To show current score, this label are binding to score
		scoreLabel.textProperty().bind(Bindings.format("Score : %d", score));
		// This button is clickable only all passenger are transferred to their
		// destination cities; therefore, firstly it should not be clickable
		b.setDisable(true);
		// To put this button to center.
		b.setAlignment(Pos.CENTER);
		// In this part, appearance of the next level button is changed
		b.setStyle(
				"-fx-background-color: linear-gradient(#f2f2f2, #d6d6d6), linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%), linear-gradient(#dddddd 0%, #f6f6f6 50%);"
						+ " -fx-background-radius: 8,7,6;" + "-fx-background-insets: 0,1,2;" + "-fx-text-fill: black;"
						+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		// In this part, appearance of the previous level button is changed
		back.setStyle(
				"-fx-background-color: linear-gradient(#f2f2f2, #d6d6d6), linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%), linear-gradient(#dddddd 0%, #f6f6f6 50%);"
						+ " -fx-background-radius: 8,7,6;" + "-fx-background-insets: 0,1,2;" + "-fx-text-fill: black;"
						+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		// To put to text the center of its position.
		t1.setTextAlignment(TextAlignment.CENTER);
		// To change t1's font and size
		t1.setFont(Font.font("Lucida Sans Unicode", FontWeight.EXTRA_BOLD, 20));
		// All of the nodes are added in this HBox
		getChildren().addAll(t1, scoreLabel, back, b);
		// To user can realize this part is a different part from others
		setStyle("-fx-border-color: black");
		// Normally, it is not so much opaque but if user move the mouse click on the
		// button its opacity increases and then turn back to normal opacity value
		b.setOpacity(0.76);
		b.setOnMouseEntered(e -> {
			b.setOpacity(0.95);
		});
		b.setOnMouseExited(e -> {
			b.setOpacity(0.76);
		});
		back.setOnAction(e -> {
			// If user click back button current level decreases
			currentLevel--;
		});
		back.setOnMouseEntered(e -> {
			back.setOpacity(0.9);
		});
		back.setOnMouseExited(e -> {
			back.setOpacity(0.78);
		});

		b.setOnAction(e -> {
			// If user click b button level increases
			currentLevel++;

		});
	}

}
