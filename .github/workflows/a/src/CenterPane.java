
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CenterPane extends GridPane {
	int rectangleCount = 10;

	public CenterPane() {
		int id = 1;
		
		// Anlamadigim bir hata veriyordu boyle yapinca duzeldi
		// CityButton icin innerclass actim orada gormesi icn constructorun disina aldim
		// >> sonra gerek kalmadigini anlayip tekrar iceri aldim
		//En son komple ayrildi
		//CityButton diye class var githubda
		

		for (int row = 0; row < rectangleCount; row++) {
			for (int col = 0; col < rectangleCount; col++) {
				Rectangle square = new Rectangle();
				square.widthProperty().bind(widthProperty().divide(10).subtract(10));
				square.heightProperty().bind(heightProperty().divide(10).subtract(10));
				;
				// RENKSIZ OLMASI ICIN YAZDIM
				square.setFill(Color.TRANSPARENT);
				square.setId(String.valueOf(id));

				add(square, col, row);

				
				id++;
			}
		}
	}
}	
	


