//Muhammed Hasan Erzincanli 150121031
//Yunus Emre Gezici 150121066
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	static int currentLevel = 0;  //It represents current level. It is static because currentLevel is modified in another classes.
	
   
	@Override
	public void start(Stage primaryStage) {
		//Create a main menu scene and display it.
		primaryStage.setTitle("Conquest Tourismo");
		Menu menu = new Menu();
		Scene scene = new Scene(menu, 500, 500);    //A 500x500 window will be constructed.
		primaryStage.setResizable(false);           //It disables to resize window.
		primaryStage.setScene(scene);
		//Since TopPane constructor does not take NewLevel as a parameter, it is constructed first and foremost.
		TopPane tp = new TopPane();    
		File levelfile = new File("saves.txt");   
		Scanner inp;
		//Check if level 0 or not and disable the continue game button.
		try {
			inp = new Scanner(levelfile);
			if(!(inp.hasNext())|| inp.next().equals("level0.txt")) {	    
			menu.continueGameButton.setDisable(true);
			}
			else {
			menu.continueGameButton.setDisable(false);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
      //When New Game button is clicked, a new scene is constructed and is displayed for level 1 data.  
		menu.newGameButton.setOnAction(e -> {
            //Create a file object of level0.txt file which is a level file with needed input data.
			File name = new File("level0.txt");
			//Create a level object and call readingFile method to scan the level 0 file.
			NewLevel level = new NewLevel(name);
			level.readingFile();
			//Create a text object that is going to be set in other classes. This text represents the each specific info about city.
			Text text = new Text();   
			//All panes are constructed in the order and add to MainPane which is subclass of BorderPane.
			NewCenterPane root = new NewCenterPane();
			BottomPane bp = new BottomPane(level,text);
			MainPane pane = new MainPane(tp, root, bp);
			root.setStyle("-fx-background-color: linear-gradient(rgba(0, 200, 255, 0.5), rgba(0, 255, 168, 0.5));");  //Background color is set.

			level.setPane(pane);
			tp.t1.setText("LEVEL: " + 0);
            Scene scene2 = new Scene(pane,500,680);
            //b refers to New Level button and this is button will be active when the number of passengers is zero.
            tp.b.setDisable(false);                                  
            tp.b.setOpacity(0.76);
            tp.back.setDisable(true);       //back refers to Previous Level button. Previous Level is going to be disabled because it is first level. 
			primaryStage.setScene(scene2);     //Switch to this scene with these panes.

		});
		//When Continue Game button is clicked, scene of last level is constructed and is displayed.  
		menu.continueGameButton.setOnAction(e -> {
            //Array of level file names.
			String[] lvlarr = {"level1.txt", "level2.txt", "level3.txt", "level4.txt", "level5.txt" };
			int index = 0;   //Index of last level
			//load method is called and find the index of last level in level array.
			String lastLevel = SaveAndLoad.load();
			System.out.println("this is " + lastLevel);
			for (int i = 0; i < lvlarr.length; i++) {
				if (lvlarr[i].equals(lastLevel))
					index = i;	
				
			}              
			//Create a File object with the last level file.
			File name = new File(SaveAndLoad.load());
			//Create a level object and call readingFile method to scan the last level file.
			
			NewLevel level = new NewLevel(name);
			level.readingFile();
			//Create a text object that is going to be set in other classes. This text represents the each specific info about city.
			Text text = new Text();
			//All panes are constructed in the order and add to MainPane which is subclass of BorderPane.	
			NewCenterPane root = new NewCenterPane(level,text);
			tp.b.setDisable(false);
			tp.b.setOpacity(0.5);		
			BottomPane bp = new BottomPane(level,text);
			MainPane pane = new MainPane(tp, root, bp);
			root.setStyle("-fx-background-color: linear-gradient(rgba(0, 200, 255, 0.5), rgba(0, 255, 168, 0.5));"); //Background color is set.
			level.setPane(pane); 
			//b refers to New Level button and this is button will be active when the number of passengers is zero.
            tp.b.setOpacity(0.5);
            //currentLevel is changed with the value of index.
			currentLevel = index;
			tp.t1.setText("LEVEL: " + (index + 1));//t1 refers to "Level : " Text and it is changed with the value of current level.
			//If currentLevel is first level, previous button is going to be disabled.
			if(currentLevel == 0) {
	            	tp.back.setDisable(true);
	            	tp.back.setOpacity(0.5);
	            }
			 else
				 tp.back.setDisable(false);
			currentLevel++;
			Scene scene2 = new Scene(pane, 500, 650);       
			primaryStage.setScene(scene2);                //Switch to this scene with these panes.
		});
		/** When Next Level button is clicked, switch to next level and construct scene with provided level info.
		 *  It works almost as same as the way new game button works. They differ in one thing and that thing is that New Game create a scene of level 1,  
		 *  Next Level button create a scene of the next level.
		*/
		tp.b.setOnAction(e -> {
			
			currentLevel++;
			String[] lvlarr = {"level0.txt", "level1.txt", "level2.txt", "level3.txt", "level4.txt", "level5.txt" };
			SaveAndLoad sl = new SaveAndLoad(lvlarr[currentLevel]);
			File name = new File(lvlarr[currentLevel]);
			NewLevel level = new NewLevel(name);
			level.readingFile();
			Text text = new Text();
			NewCenterPane root = new NewCenterPane(level,text);
			if(currentLevel == 0) {
				root = new NewCenterPane();
			}
			BottomPane bp = new BottomPane(level,text);
			MainPane pane = new MainPane(tp, root, bp);
			level.setPane(pane);
			root.setStyle("-fx-background-color: linear-gradient(rgba(0, 200, 255, 0.5), rgba(0, 255, 168, 0.5));");
			Scene scene2 = new Scene(pane, 500, 650);
			sl.save();
			primaryStage.setScene(scene2);
            tp.back.setOpacity(0.76);
			tp.t1.setText("LEVEL: " + (currentLevel));
			tp.b.setOpacity(0.5);
            tp.b.setDisable(false);
            //If it is last level, Next Level button will be passive. Because there is not an another level.
            if(lvlarr[currentLevel] == lvlarr[lvlarr.length - 1]) {
            	tp.b.setDisable(true);
            	tp.b.setOpacity(0.5);
            }
            tp.back.setDisable(false);
		});
		/** When Previous Level button is clicked, switch back to previos level and construct scene with the provided previous level info.
		 *  It works almost identical as New Level. The one thing is different is that previous level switch back.
		*/
		
		tp.back.setOnAction(e -> {
			System.out.println("This is first " + currentLevel);
			currentLevel--;
			String[] lvlarr = {"level0.txt","level1.txt", "level2.txt", "level3.txt", "level4.txt", "level5.txt" };
			System.out.println("This is second " + currentLevel);
			SaveAndLoad sl = new SaveAndLoad(lvlarr[currentLevel]);
			File name = new File(lvlarr[currentLevel]);
			NewLevel level = new NewLevel(name);
			level.readingFile();
			Text text = new Text();
			NewCenterPane root = new NewCenterPane();
			tp.b.setDisable(false);
			tp.b.setOpacity(0.76);
			if(currentLevel != 0) {
				root = new NewCenterPane(level,text);
				tp.b.setDisable(true);
				tp.b.setOpacity(0.5);
			}
			
			BottomPane bp = new BottomPane(level,text);
			MainPane pane = new MainPane(tp, root, bp);
			level.setPane(pane);
			root.setStyle("-fx-background-color: linear-gradient(rgba(0, 200, 255, 0.5), rgba(0, 255, 168, 0.5));");
			Scene scene2 = new Scene(pane, 500, 650);
			sl.save();
			primaryStage.setScene(scene2);
            
			tp.t1.setText("LEVEL: " + (currentLevel));
			
			
			//If it is first level, Previous Level button will be passive. Because there is not an previous level before the first one.
			 if(currentLevel == 0) {       
	            	tp.back.setDisable(true);
	            	tp.back.setOpacity(0.5);
	            }
			 else
				 tp.back.setDisable(false);
		});
		//Constructed scenes will be shown.
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
