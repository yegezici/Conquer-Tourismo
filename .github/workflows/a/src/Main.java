import java.io.File;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	
	int currentLevel = 0;

    @Override
    public void start(Stage primaryStage) {
    	//ana menü scene burda oluşuyor gösteriliyor
    	primaryStage.setTitle("Term Project");
    	Menu menu = new Menu();
    	Scene scene = new Scene(menu, 200, 400);
        primaryStage.setScene(scene);
	    
        String[] lvlarr = {"level1.txt","level2.txt","level3.txt","level4.txt","level5.txt"};
        File name = new File(lvlarr[currentLevel]);
      	NewLevel level = new NewLevel(name);
	level.readingFile();	
   	CenterPane root = new CenterPane(level);
        BorderPane br = new BorderPane();
        BottomPane bp = new BottomPane();
        TopPane tp = new TopPane();
	    
        br.setCenter(root);
        root.setAlignment(Pos.CENTER);
        br.setTop(tp);
        br.setBottom(bp);
	//bir sonraki levelin scene de burda normalde level atlıyordum tuşa basınca fakat çok yavaş çalışıyordu ben de saldım     
        Scene scene2 = new Scene(br,500,750);
        menu.newGameButton.setOnAction(e -> {
        	
        	primaryStage.setScene(scene2);
        	
        });
        
        
        primaryStage.show();
    }
    
    
    

    public static void main(String[] args) {
        launch(args);
    }
       
}
