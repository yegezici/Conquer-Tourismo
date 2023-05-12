import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class BottomPane extends BorderPane {
	public BottomPane() {

		Button b = new Button("DRIVE");
		b.setStyle(
				"-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 24px; -fx-font-family: Arial;"
						+ "-fx-font-style: italic;");
		setStyle("-fx-border-color: black");
		b.setOnMouseEntered(e -> b.setOpacity(1.0));
		b.setOnMouseExited(e -> b.setOpacity(0.5));
		// çalışmasını görmek için yazdım
		b.setOnAction(e -> {
			System.out.println("Button clicked!");
		});
		//

		setPadding(new Insets(15, 0, 150, 15));
		setRight(b);
		setLeft(new Text("SADSA"));
	}
}
