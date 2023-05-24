import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Menu extends BorderPane {
    Button newGameButton = new Button();
    Button continueGameButton = new Button();
    Pane backgroundPane = new Pane();
    VBox buttons = new VBox();
    Text title = new Text("");
    Image backgroundImage = new Image("backgroundd.png");
    ImageView backgroundImageView = new ImageView(backgroundImage);
    public Menu() {
        
        newGameButton.setPrefHeight(100);
        newGameButton.setPrefWidth(150);
        continueGameButton.setPrefHeight(100);
        continueGameButton.setPrefWidth(150);
        
        
        Text t1 = new Text("New Game");
        Text t2 = new Text("Continue");
        
        t1.setStyle("-fx-font-size: 45px; -fx-font-family: Times New Roman; -fx-fill: #FFFFFF; -fx-stroke: #000000; -fx-stroke-width: 1px;");
        t2.setStyle("-fx-font-size: 45px; -fx-font-family: Times New Roman; -fx-fill: #FFFFFF; -fx-stroke: #000000; -fx-stroke-width: 1px;");
      
        

        newGameButton.setGraphic(t1);
        continueGameButton.setGraphic(t2);
        newGameButton.setOpacity(0.8);
        
        title.setText("Conquest Tourismo");
        title.setStyle("-fx-font-size: 55px; -fx-font-family: Times New Roman; -fx-fill: #FFFFFF; -fx-stroke: #000000; -fx-stroke-width: 1px;");
           

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);
        dropShadow.setRadius(5);
        dropShadow.setOffsetX(2);
        dropShadow.setOffsetY(2);
        title.setEffect(dropShadow);
        newGameButton.setStyle("-fx-background-color: linear-gradient(#00C8FF, #00FFA8); -fx-border-color: darkblue; -fx-border-width: 3px; -fx-border-radius: 5px;");
        continueGameButton.setStyle("-fx-background-color: linear-gradient(#00C8FF, #00FFA8); -fx-border-color: blue; -fx-border-width: 2px; -fx-border-radius: 5px;");

        
        //newGameButton.setStyle("-fx-background-color: #d5f3fe");
       // continueGameButton.setStyle("-fx-background-color: #d5f3fe");
       
        buttons.getChildren().addAll(title, newGameButton, continueGameButton);
        title.setTranslateY(-30);
        buttons.setAlignment(Pos.CENTER); 
        newGameButton.setOnMouseEntered(h -> {
            newGameButton.setOpacity(0.9);
            t1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
        });
        newGameButton.setOnMouseExited(h -> {
            newGameButton.setOpacity(0.8);
            t1.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 24));
        });
        continueGameButton.setOnMouseEntered(h -> {
            newGameButton.setOpacity(0.9);
            t2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
        });
        continueGameButton.setOnMouseExited(h -> {
            newGameButton.setOpacity(0.8);
            t2.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 24));
        });
        
        setTranslateY(-10);
        
        VBox.setMargin(newGameButton, new Insets(0, 0, 50, 0));

      //backgroundImageView.setFitWidth(500);
        //backgroundImageView.setFitHeight(500);


        //backgroundPane.getChildren().add(backgroundImageView);
        backgroundPane.setStyle("-fx-background-image: url('backgroundd.png'); -fx-background-size: cover;");
        buttons.layoutXProperty().bind(backgroundPane.widthProperty().subtract(buttons.widthProperty()).divide(2));
        buttons.layoutYProperty().bind(backgroundPane.heightProperty().subtract(buttons.heightProperty()).divide(2));
        
        backgroundPane.getChildren().add(buttons);
        
        setCenter(backgroundPane);
}
}