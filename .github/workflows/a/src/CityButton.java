import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CityButton {
	String name;
	Image img;
  //  int[] points = new int[4];
    ArrayList<Integer> points = new ArrayList<Integer>(); 
    int colIndex = 0, rowIndex = 0, endColIndex = 0, endRowIndex = 0;
	CityButton() {

	}

	CityButton(String name, Image img, int rowIndex, int colIndex) {
		this.name = name;
		this.img = img;
		this.colIndex = colIndex;
		this.rowIndex = rowIndex;
	}

	public VBox cityButton() {
        
		Button cB = new Button();
	    cB.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
	    
	    GridPane.setColumnIndex(cB, colIndex);
	    GridPane.setRowIndex(cB, rowIndex);
	    cB.setOnAction(e -> {              //buralardan pek emin değilim mesafe formülünü yazdım ama yanlış gibi bir bakarsın koordinatları tam alıyor
	        points.add(colIndex);
	        points.add(rowIndex);
	    });
	        if(points.size() == 2) {
	        	endColIndex = colIndex;
	        	endRowIndex = rowIndex;
	        }
	          points.add(endColIndex);
        	  points.add(endRowIndex);
	       
	      cB.setOnAction(e -> {
	           System.out.println(calculateDistance(rowIndex, colIndex, endRowIndex, endColIndex));    	  
	      });
	       
	    

		// Direkt kopyaladim burayi -- 
		Label label = new Label(this.name);
		label.setAlignment(Pos.BOTTOM_CENTER);
//			label.setFont(Font.font("Arial", FontWeight.BOLD, 12));
		label.toFront();

		VBox vb = new VBox(1);
		vb.setAlignment(Pos.CENTER);

		ImageView iv = new ImageView(this.img);
		iv.setFitHeight(35);
		iv.setFitWidth(35);

		cB.setGraphic(iv);
		vb.getChildren().addAll(cB, label);

		return vb;

	}
	
	public int calculateDistance(int x1,int y1,int x2,int y2) {
	 return (int) Math.ceil(Math.sqrt(Math.pow((x1-x2), 2) + Math.pow(y1-y2, 2)));
	}

}
