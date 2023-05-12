import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    
    @Override
    public void start(Stage primaryStage) {
    
    	CustomPane root = new CustomPane();
        BorderPane br = new BorderPane();
        TopPane tp = new TopPane();
        BottomPane bp = new BottomPane();
        br.setCenter(root);
        br.setTop(tp);
        br.setBottom(bp);
        
        

        Scene scene = new Scene(br, 500, 750);
        primaryStage.setTitle("Square Field");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
