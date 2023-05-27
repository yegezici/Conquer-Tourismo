//Muhammed Hasan Erzincanli 150121031
//Yunus Emre Gezici 150121066
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
    Button newGameButton = new Button();            // Button for starting a new game
    Button continueGameButton = new Button();       // Button for continuing a game
    Pane backgroundPane = new Pane();               // Pane for the background image
    VBox buttons = new VBox();                      // VBox to hold the buttons and title text
    Text title = new Text("");                      // Text for the title of the menu screen
    Image backgroundImage = new Image("backgroundmainmenu.png");  // Image for the background
    ImageView backgroundImageView = new ImageView(backgroundImage);  // ImageView for the background image

    public Menu() {
        // Set preferred height and width for the buttons
        newGameButton.setPrefHeight(100);
        newGameButton.setPrefWidth(150);
        continueGameButton.setPrefHeight(100);
        continueGameButton.setPrefWidth(150);

        // Create Text objects for the button labels
        Text t1 = new Text("New Game");
        Text t2 = new Text("Continue");

        // Set styles for the button labels
        t1.setStyle("-fx-font-size: 45px; -fx-font-family: Times New Roman; -fx-fill: #FFFFFF; -fx-stroke: #000000; -fx-stroke-width: 1px;");
        t2.setStyle("-fx-font-size: 45px; -fx-font-family: Times New Roman; -fx-fill: #FFFFFF; -fx-stroke: #000000; -fx-stroke-width: 1px;");

        // Set the Text objects as the graphics for the buttons
        newGameButton.setGraphic(t1);
        continueGameButton.setGraphic(t2);

        // Set opacity and styles for the buttons
        newGameButton.setOpacity(0.8);
        newGameButton.setStyle("-fx-background-color: linear-gradient(#00C8FF, #00FFA8); -fx-border-color: darkblue; -fx-border-width: 3px; -fx-border-radius: 5px;");
        continueGameButton.setStyle("-fx-background-color: linear-gradient(#00C8FF, #00FFA8); -fx-border-color: blue; -fx-border-width: 2px; -fx-border-radius: 5px;");

        // Set the title text and styles
        title.setText("Conquest Tourismo");
        title.setStyle("-fx-font-size: 55px; -fx-font-family: Times New Roman; -fx-fill: #FFFFFF; -fx-stroke: #000000; -fx-stroke-width: 1px;");

        // Create a drop shadow effect for the title text
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);
        dropShadow.setRadius(5);
        dropShadow.setOffsetX(2);
        dropShadow.setOffsetY(2);
        title.setEffect(dropShadow);

        // Add the title and buttons to the VBox
        buttons.getChildren().addAll(title, newGameButton, continueGameButton);
        title.setTranslateY(-30);                    //Move the title upward by 30px
        buttons.setAlignment(Pos.CENTER);

        // Set mouse enter and exit event handlers for button hover effects
        //They have same effects. If cursor moves in button border, their label is set to bold style.
        newGameButton.setOnMouseEntered(h -> {
            newGameButton.setOpacity(0.9);
            t1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
        });
        newGameButton.setOnMouseExited(h -> {
            newGameButton.setOpacity(0.8);
            t1.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 24));
        });
        continueGameButton.setOnMouseEntered(h -> {
            continueGameButton.setOpacity(0.9);
            t2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
        });
        continueGameButton.setOnMouseExited(h -> {
            continueGameButton.setOpacity(0.8);
            t2.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 24));
        });
        
        
        setTranslateY(-10);
        VBox.setMargin(newGameButton, new Insets(0, 0, 50, 0)); //Set margin between buttons and title
        backgroundPane.setStyle("-fx-background-image: url('backgroundmainmenu.png'); -fx-background-size: cover;"); //Adding background image and covering all window
       
        buttons.layoutXProperty().bind(backgroundPane.widthProperty().subtract(buttons.widthProperty()).divide(2));
        buttons.layoutYProperty().bind(backgroundPane.heightProperty().subtract(buttons.heightProperty()).divide(2));

        // Add the VBox to the backgroundPane
        backgroundPane.getChildren().add(buttons);

        // Set the backgroundPane as the center of the BorderPane
        setCenter(backgroundPane);
    }
}
