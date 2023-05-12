import javafx.geometry.Insets;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class TopPane extends HBox{
	
  public TopPane() {
	  spacingProperty().bind(widthProperty().divide(3));
	  setPadding(new Insets(5,5,5,5));
		Text t1 = new Text("Level #x");
		Text t2 = new Text("Score: x");
		Text t3 = new Text("Next Level >>");
		//OPAKLIK ya da renk DEĞİŞECEK
		t3.setStyle("");
		Border.stroke(Color.BLACK);
		getChildren().addAll(t1,t2,t3);
		setStyle("-fx-border-color: black");
  }
	
}
