import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class CityButton {
	String name;
	Image img;
	static ArrayList<Integer> points = new ArrayList<Integer>();
	int colIndex = 0, rowIndex = 0;
	int endColIndex = 0, endRowIndex = 0;

	CityButton() {

	}

	CityButton(String name, Image img, int rowIndex, int colIndex) {
		this.name = name;
		this.img = img;
		this.colIndex = colIndex;
		this.rowIndex = rowIndex;
	}

	public BorderPane cityButton(GridPane pane) {
		Button cB = new Button();
		cB.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
		cB.setOnAction(e -> {
			// row index aslinda y degeri o yuzden ilk colu almamiz laizm yerlerini
			// degistirdim
			points.add(colIndex);
			points.add(rowIndex);

			System.out.println(points.get(0));
			System.out.println(points.get(1) + "\n------------");

			if (points.size() == 4) {
				System.out.println(points.get(2));
				System.out.println(points.get(3) + "\n------------");
				endRowIndex = points.get(2);
				endColIndex = points.get(3);

				// Buraya array yerine endrowindex felan koyunca 0 veriyor sonucu
				// Aslinda tutuyor degerleri asagidaki 31li 3 kodu calistirinca sonuc gosteriyor
				// fakat anlamadim
				System.out.println(calculateDistance(points.get(0), points.get(1), points.get(2), points.get(3)));

			}

			if (points.size() == 4) {
				for (int i = points.get(0) - 1; i >= points.get(2); i--) {
					Direction d = new Direction();
					pane.add(d.createRowLine(), 1, 1);
				}
				if (points.get(0) > points.get(2)) {
					if (points.get(1) < points.get(3)) {

					}
				}
			}

			 
		});
		Label label = new Label("  " + this.name);
		label.setAlignment(Pos.BOTTOM_CENTER);

		label.toFront();

		BorderPane bP = new BorderPane();

		ImageView iv = new ImageView(this.img);
		iv.setFitHeight(35);
		iv.setFitWidth(35);

		cB.setGraphic(iv);
		VBox vB = new VBox(1);
		vB.getChildren().addAll(cB, label);
		bP.setCenter(vB);

		return bP;

	}

	public int calculateDistance(int x1, int y1, int x2, int y2) {
		return (int) (Math.ceil(Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow(y1 - y2, 2))));

	}

}
