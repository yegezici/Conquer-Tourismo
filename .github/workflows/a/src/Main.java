import java.io.File;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
	
	public void initializeCenterBoard(NewLevel lvl, CenterPane root) {
		Image img = new Image("ist.png");
		Image img1 = new Image("mersin.png");
		Image img2 = new Image("city1.png");
		Image img3 = new Image("city2.png");
		Image img4 = new Image("city3.png");
		Image img5 = new Image("city4.png");
		Image img6 = new Image("fixedcellsign.jpg");
		Image car = new Image("minivan.png");
		Image minivan = new Image("car.png");
		Image bus = new Image("bus.png");
		Image[] imgarr = { img, img1, img2, img3, img4, img5 };
		int rectangleCount = 10;
	    int i = 0, a=0, b=0;
		for (int row = 0; row < rectangleCount; row++) {
			for (int col = 0; col < rectangleCount; col++) {
				
			   if(a==lvl.cities.size()) 
				   break;
			   if(!(lvl.fixedCells.size() == b)) {
				   ImageView iv = new ImageView(img6);
				   iv.setFitWidth(35);
				   iv.setFitHeight(35);
				   root.add(iv, (lvl.fixedCells.get(b)%10) - 1, (lvl.fixedCells.get(b))/10);
		           b++;
		        }
		        if(lvl.cities.get(a).getLocId() == i ) {  //koordinatların tam olması için 1 den çıkartmıyoruz
		        CityButton cB = new CityButton(lvl.cities.get(a).getName(), imgarr[(int) (Math.random() * 6)],
		        		(lvl.cities.get(a).getLocId()%10==0 ? (lvl.cities.get(a).getLocId()%10) + 8 : (lvl.cities.get(a).getLocId()%10)),
		        		(lvl.cities.get(a).getLocId()%10 == 0) ? (lvl.cities.get(a).getLocId()/10)  : (lvl.cities.get(a).getLocId())/10+1);
		       
				if(lvl.cities.get(a).getLocId()%10 == 0) {
					root.add(cB.cityButton(), (lvl.cities.get(a).getLocId()%10) +9, (lvl.cities.get(a).getLocId()/10)-1);
				}else {
		        root.add(cB.cityButton(), (lvl.cities.get(a).getLocId()%10)- 1, (lvl.cities.get(a).getLocId()/10));
				}row = 0;
		        col = 0;
		        a++;
		        i = 0;
		        }
		        else
		        i++;
			}
			
	}
	}
    
    @Override
    public void start(Stage primaryStage) {
    
    	CenterPane root = new CenterPane();
        BorderPane br = new BorderPane();
        TopPane tp = new TopPane();
        BottomPane bp = new BottomPane();
        String[] lvlarr = {"level1.txt","level2.txt","level3.txt","level4.txt","level5.txt"};
       
		File name = new File(lvlarr[0]);
		NewLevel level = new NewLevel(name);
		level.readingFile();							
	    initializeCenterBoard(level, root);
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
