import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class Menu extends HBox {
	Button newGameButton = new Button("New Game");
    Button continueGameButton = new Button("Continue");
    public Menu() {
    	 this.setAlignment(Pos.CENTER);
    	 setTranslateY(-10);
         getChildren().addAll(continueGameButton,newGameButton);
         Image img = new Image("backgroundmainmenu.jpg");
         ImageView iv = new ImageView(img);
         iv.setFitWidth(200);
         iv.setFitHeight(400);
         AnchorPane root = new AnchorPane();
         root.setStyle("-fx-background-image: url('path/to/image.jpg'); -fx-background-size: cover;");
         
         
    }
}
