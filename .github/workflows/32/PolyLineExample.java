import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class PolyLineExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create the Polyline
        Polyline polyline = new Polyline();
        polyline.getPoints().addAll(
                100.0, 300.0,
                200.0, 200.0,
                300.0, 100.0
        );

        // Create a Pane and add the Polyline to it
        Pane pane = new Pane();
        pane.getChildren().add(polyline);

        // Create a Scene and set the Pane as its root
        Scene scene = new Scene(pane, 400, 300);

        // Set the Scene to the Stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
