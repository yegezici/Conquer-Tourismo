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
    	setPadding(new Insets(15,0,150,15));
    	b.setFont(Font.font("Arial" , FontWeight.BOLD , 24));
    	getChildren().addAll(new Label("Sample Text\nSample New Line"), b);
    	
    }
}
