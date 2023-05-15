import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	
    @Override
    public void start(Stage primaryStage) {
    
    	
        BorderPane br = new BorderPane();
        TopPane tp = new TopPane();
        BottomPane bp = new BottomPane();
        
        String[] lvlarr = {"level1.txt","level2.txt","level3.txt","level4.txt","level5.txt"};
    	File name = new File(lvlarr[0]);
    	NewLevel level = new NewLevel(name);
		level.readingFile();	
		CenterPane root = new CenterPane(level);
		
		
		
        br.setCenter(root);
        root.setAlignment(Pos.CENTER);
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
