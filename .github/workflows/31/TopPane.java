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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class TopPane extends HBox{
	Button b = new Button("Next Level >>");
	Button back = new Button("<< Previous Level ");
	static int currentLevel = 0 ;
	Text t1 = new Text("LEVEL : " + (currentLevel+1));
	IntegerProperty score = new SimpleIntegerProperty(0);
	Label scoreLabel;
	
	public TopPane() {
	  int currentScore = 0, levelScore = 0;
	  spacingProperty().bind(widthProperty().divide(15));
	  setPadding(new Insets(0,10,0,10));
	  
	    
	    
		scoreLabel = new Label();
		scoreLabel.setStyle("-fx-font-size: 15px; -fx-font-family: Galactus;"
				
				+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		scoreLabel.setFont(Font.font("Lucida Sans Unicode", FontWeight.EXTRA_BOLD, 15));
		scoreLabel.textProperty().bind(
				Bindings.format("Score : %d", score));
		b.setDisable(true);
		b.setAlignment(Pos.CENTER);
		
		 b.setStyle("-fx-background-color: linear-gradient(#f2f2f2, #d6d6d6), linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%), linear-gradient(#dddddd 0%, #f6f6f6 50%);"
		 		+ " -fx-background-radius: 8,7,6;"+ 
		    "-fx-background-insets: 0,1,2;" +
		    "-fx-text-fill: black;" + 
		    "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		Border.stroke(Color.BLACK);
		back.setStyle("-fx-background-color: linear-gradient(#f2f2f2, #d6d6d6), linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%), linear-gradient(#dddddd 0%, #f6f6f6 50%);"
		 		+ " -fx-background-radius: 8,7,6;"+ 
		    "-fx-background-insets: 0,1,2;" +
		    "-fx-text-fill: black;" + 
		    "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		t1.setTextAlignment(TextAlignment.CENTER);
		t1.setStyle("-fx-font-size: 20px; -fx-font-family: Galactus;"
				+ "-fx-font-weight: bold;");
		t1.setFont(Font.font("Lucida Sans Unicode", FontWeight.EXTRA_BOLD, 20));
		getChildren().addAll(t1,scoreLabel,back,b);
		setStyle("-fx-border-color: black");
		b.setOpacity(0.76);
		b.setOnMouseEntered(e -> {
			b.setOpacity(0.95);
		});
		b.setOnMouseExited(e -> {
			b.setOpacity(0.78);
		});
		back.setOnAction(e -> {
		
			currentLevel--;
		});
		back.setOnMouseEntered(e -> {
			back.setOpacity(0.9);
		});
		back.setOnMouseExited(e -> {
			back.setOpacity(0.78);
		});
		
		
		b.setOnAction(e -> {
		
			currentLevel++;
	        	
	            
			});
  }
	
}
