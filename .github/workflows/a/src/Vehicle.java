
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Vehicle {
	private int cityId;
	private int capacity;
	ImageView imageView;

	public Vehicle() {

	}

	public Vehicle(int cityId, int capacity) {
		this.cityId = cityId;
		this.capacity = capacity;
		Image car;	
		if (this.capacity <= 5) {
			car = new Image("minivan.png");
			imageView = new ImageView(car);
		} else if (this.capacity > 5 && this.capacity < 14) {
			car = new Image("car.png");
			imageView = new ImageView(car);
		} else {
			car = new Image("bus.png");
			imageView = new ImageView(car);
		}

		imageView.setFitWidth(35);
		imageView.setFitHeight(35);
	}

	public int getCityId() {
		return cityId;
	}

	public int getCapacity() {
		return capacity;
	}

	public ImageView createVehicle() {
		return null;
	}
}
