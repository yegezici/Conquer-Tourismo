import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BottomPane extends HBox {
    public BottomPane() {
    	
    	setSpacing(250);
    	Button b = new Button("DRIVE");
		b.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 24px; -fx-font-family: Arial;"
				+ "-fx-font-style: italic;");
        b.setOnMouseEntered(e -> b.setOpacity(1.0));
        b.setOnMouseExited(e -> b.setOpacity(0.5));
         //çalışmasını görmek için yazdım
        b.setOnAction(e -> {
            System.out.println("Button clicked!");
        });
        //
    	setPadding(new Insets(15,0,150,15));
    	getChildren().addAll(new Label("Sample Text\nSample New Line"), b);
    	
    }
}
