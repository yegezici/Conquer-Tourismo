import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class TopPane extends HBox{
	Button b = new Button("Next Level >>");
	static int currentLevel = 0 ;
	Text t1 = new Text("LEVEL : " + (currentLevel+1));
	IntegerProperty score = new SimpleIntegerProperty(0);
	Label scoreLabel;
	
	public TopPane() {
	  int currentScore = 0, levelScore = 0;
	  spacingProperty().bind(widthProperty().divide(4));
	  setPadding(new Insets(5,5,5,5));
	  
	    
	
		scoreLabel = new Label();
		scoreLabel.textProperty().bind(
				Bindings.format("Score : %d", score));
		
		
		//b.setOpacity(0.75);
		b.setStyle(
				"-fx-background-color: transparent;  -fx-font-size: 10px; -fx-font-family: Arial;"
						+ "-fx-font-style: italic;");
		Border.stroke(Color.BLACK);
		getChildren().addAll(t1,scoreLabel,b);
		setStyle("-fx-border-color: black");
		b.setOnAction(e -> {
				//System.out.println("a");
	        	
			currentLevel++;
	        	
	            
			});
  }
	
}
