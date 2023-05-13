import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class CityButton {
	String name;
	Image img;

	CityButton() {

	}

	CityButton(String name, Image img) {
		this.name = name;
		this.img = img;
	}

	public VBox cityButton() {

		Button cB = new Button();
		cB.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
		// çalışmasını görmek için yazdım
		cB.setOnAction(e -> {
			System.out.println("cB clicked");
		});

		// Direkt kopyaladim burayi
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

}
