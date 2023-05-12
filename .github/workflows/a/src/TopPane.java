import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TopPane extends HBox{
	
  public TopPane() {
	  setSpacing(150);
	  setPadding(new Insets(15,15,15,15));  
	  getChildren().add(new Label("Level#1"));
	  getChildren().add(new Label("Score: 0"));
	  getChildren().add(new Button("Next Level >>"));
	  
  }
	
}
