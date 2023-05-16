import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class TopPane extends HBox{
	Button b = new Button("Next Level >>");
	int level = 1 ;
	 Text t1 = new Text("LEVEL : " + level);
  public TopPane() {
	  int currentScore = 0, levelScore = 0;
	  spacingProperty().bind(widthProperty().divide(3));
	  setPadding(new Insets(5,5,5,5));
	  
	    
		Text t2 = new Text("Score: x");
		//OPAKLIK ya da renk DEĞİŞECEK
		
		
		//b.setOpacity(0.75);
		b.setStyle(
				"-fx-background-color: transparent;  -fx-font-size: 10px; -fx-font-family: Arial;"
						+ "-fx-font-style: italic;");
		Border.stroke(Color.BLACK);
		getChildren().addAll(t1,t2,b);
		setStyle("-fx-border-color: black");
		b.setOnAction(e -> {
			System.out.println("a");
			level++;
			t1.setText("LEVEL : " + level);
		});
  }
	
}
