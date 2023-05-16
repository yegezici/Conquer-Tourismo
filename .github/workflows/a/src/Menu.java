import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Menu extends Pane {
    Button newGameButton = new Button();
    Button continueGameButton = new Button();
    Pane backgroundPane = new Pane();
    VBox buttons = new VBox();
    Image backgroundImage = new Image("backgroundmainmenu.jpg");
    ImageView backgroundImageView = new ImageView(backgroundImage);
    public Menu() {
        
        newGameButton.setPrefHeight(150);
        newGameButton.setPrefWidth(150);
        continueGameButton.setPrefHeight(150);
        continueGameButton.setPrefWidth(150);
        Text t1 = new Text("New Game");
        Text t2 = new Text("Continue");
        t1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
        t2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));

        newGameButton.setGraphic(t1);
        continueGameButton.setGraphic(t2);
        newGameButton.setOpacity(0.8);
       
        newGameButton.setStyle("-fx-border-color: darkblue; -fx-border-width: 3px; -fx-border-radius: 5px;");
        continueGameButton.setStyle("-fx-border-color: blue; -fx-border-width: 2px; -fx-border-radius: 5px;");
        newGameButton.setStyle("-fx-background-color: #d5f3fe");
        continueGameButton.setStyle("-fx-background-color: #d5f3fe");
       
        buttons.getChildren().addAll(newGameButton, continueGameButton);
        buttons.setAlignment(Pos.CENTER); 
        newGameButton.setOnMouseEntered(h -> {
        	newGameButton.setOpacity(0.9);
        	
        }); 
        newGameButton.setOnMouseExited(h -> {
        	newGameButton.setOpacity(0.8);
        	
        }); 
        continueGameButton.setOnMouseEntered(h -> {
        	continueGameButton.setOpacity(0.9);
        	
        }); 
        continueGameButton.setOnMouseExited(h -> {
        	continueGameButton.setOpacity(0.8);
        	
        }); 
        
        setTranslateY(-10);
        VBox.setMargin(newGameButton, new Insets(0, 0, 35, 0));

        
        backgroundImageView.setFitWidth(500);
        backgroundImageView.setFitHeight(500);

       
        backgroundPane.getChildren().add(backgroundImageView);
        backgroundPane.setStyle("-fx-background-image: url('backgroundmainmenu.jpg'); -fx-background-size: cover;");
        buttons.layoutXProperty().bind(backgroundPane.widthProperty().subtract(buttons.widthProperty()).divide(2));
        buttons.layoutYProperty().bind(backgroundPane.heightProperty().subtract(buttons.heightProperty()).divide(2));
        getChildren().addAll(backgroundPane, buttons);
    }
}
