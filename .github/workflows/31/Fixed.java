import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Fixed {
	int id;
	ImageView iv =  new ImageView(new Image("fixedcellsign.jpg"));
	public Fixed(int id) {
		this.id = id;
	}
}
