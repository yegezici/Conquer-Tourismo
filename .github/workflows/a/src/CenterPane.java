
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
		Image img = new Image("ist.png");
		Image img1 = new Image("mersin.png");
		Image img2 = new Image("city1.png");
		Image img3 = new Image("city2.png");
		Image img4 = new Image("city3.png");
		Image img5 = new Image("city4.png");
		Image[] imgarr = { img, img1, img2, img3, img4, img5 };
		// Anlamadigim bir hata veriyordu boyle yapinca duzeldi
		// CityButton icin innerclass actim orada gormesi icn constructorun disina aldim
		// >> sonra gerek kalmadigini anlayip tekrar iceri aldim
		//En son komple ayrildi

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

				if (id == 14) {
					CityButton cB = new CityButton("Istanbul", imgarr[(int) (Math.random() * 6)]);
					add(cB.cityButton(), 3, 1);
				}
				if (id == 62) {
					CityButton cB = new CityButton("Mersin", imgarr[(int) (Math.random() * 6)]);
					add(cB.cityButton(), 1, 6);
				}
				if (id == 89) {
					CityButton cB = new CityButton("Van", imgarr[(int) (Math.random() * 6)]);
					add(cB.cityButton(), 8, 8);
				}
				id++;
			}
		}
	}

}
