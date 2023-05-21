import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class TopPane extends HBox{
	Button b = new Button("Next Level >>");
	Button back = new Button("<< Previous Level ");
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
		b.setDisable(true);
		b.setAlignment(Pos.CENTER);
		b.setOpacity(0.5);
		 b.setStyle("-fx-background-color: linear-gradient(#f2f2f2, #d6d6d6), linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%), linear-gradient(#dddddd 0%, #f6f6f6 50%);"
		 		+ " -fx-background-radius: 8,7,6;"+ 
		    "-fx-background-insets: 0,1,2;" +
		    "-fx-text-fill: black;" + 
		    "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		Border.stroke(Color.BLACK);
		getChildren().addAll(t1,scoreLabel,b);
		setStyle("-fx-border-color: black");
		
		b.setOnAction(e -> {
				//System.out.println("a");
	        	
			currentLevel++;
	        	
	            
			});
  }
	
}