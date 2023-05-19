import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainNew extends Application {

	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
			File file = new File("level1.txt");
			NewLevel level = new NewLevel(file);
			level.readingFile();
			NewCenterPane pane = new NewCenterPane(level); 
		 	Scene scene = new Scene(pane);
	        primaryStage.setScene(scene);
	        primaryStage.show();
		
	}

}
