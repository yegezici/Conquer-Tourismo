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
		 	Scene scene = new Scene(new NewCenterPane(new NewLevel(new File("level2.txt"))));
	        primaryStage.setScene(scene);
	        primaryStage.show();
		
	}

}
