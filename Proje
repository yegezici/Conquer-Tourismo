package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Project extends Application{
	 private static final int FIELD_SIZE = 10;
     private static final int SQUARE_SIZE = 50;
    
	@Override
	public void start(Stage stage) throws Exception {
		//genel
		BorderPane goatPane = new BorderPane();
		//orta??
		GridPane mPane = new GridPane();
		//ust
		HBox top = new HBox(15);
		//alt
		BorderPane bottom = new BorderPane();
		
		//Usttekı yazıalr
		top.setPadding(new Insets(5,5,5,5));
		Text t1 = new Text("Level #x");
		Text t2 = new Text("Score: x");
		Text t3 = new Text("Next Level >>");
		Border.stroke(Color.BLACK);
		top.getChildren().addAll(t1,t2,t3);
		top.setStyle("-fx-border-color: black");
		
		//Button
		Button driveB = new Button("DRIVE");
		driveB.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 24px; -fx-font-family: Arial;"
				+ "-fx-font-style: italic;");
		bottom.setRight(driveB);
		bottom.setStyle("-fx-border-color: black");
		driveB.setOnMouseEntered(e -> driveB.setOpacity(1.0));
        driveB.setOnMouseExited(e -> driveB.setOpacity(0.5));
        //çalışmasını görmek için yazdım
        driveB.setOnAction(e -> {
            System.out.println("Button clicked!");
        });
        //
       

        Pane root = new Pane();
        

        int id = 1;

        for (int row = 0; row < FIELD_SIZE; row++) {
            for (int col = 0; col < FIELD_SIZE; col++) {
                Rectangle square = new Rectangle(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                square.setFill(Color.WHITE);
                square.setStroke(Color.WHITE);
                square.setId(String.valueOf(id));
                id++;
                root.getChildren().add(square);
            }
        }
//
		goatPane.setTop(top);
		goatPane.setCenter(root);
		goatPane.setBottom(bottom);

	
		Scene scene = new Scene(goatPane);
		stage.setScene(scene);
		stage.setTitle("Deneme31");
		stage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
