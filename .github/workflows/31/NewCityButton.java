import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NewCityButton extends Button {
	//DoubleProperty xCordinate = new SimpleDoubleProperty();
	//DoubleProperty yCordinate = new SimpleDoubleProperty();
	double xCordinate;
	double yCordinate;
	ImageView iv;
	String name;

	public NewCityButton(String name, Image img, double xCordinate, double yCordinate) {
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
		this.iv = new ImageView(img);
		this.name = name;

	}

	public Button createButton() {
		Button button = new Button();
		int imageSize = 35;
		iv.setFitWidth(imageSize);
		iv.setFitHeight(imageSize);
		button.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
		button.setGraphic(iv);
		button.setOnAction(e ->{
			System.out.println(31);
		});
		return button;
		
	}

}
