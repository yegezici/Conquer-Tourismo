
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Vehicle {
	private int cityId;
	private int capacity;
	ImageView imageView;
	double xCordinate;
	double yCordinate;

	public Vehicle() {

	}

	public Vehicle(int cityId, int capacity) {
		this.cityId = cityId;
		this.capacity = capacity;
		Image car;	
		if (this.capacity <= 5) {
			car = new Image("new_car.png");
			imageView = new ImageView(car);
		} else if (this.capacity > 5 && this.capacity < 14) {
			car = new Image("new_minivan.png");
			imageView = new ImageView(car);
		} else {
			car = new Image("new_bus.png");
			imageView = new ImageView(car);
		}

		imageView.setFitWidth(25);
		imageView.setFitHeight(25);
	}

	public int getCityId() {
		return cityId;
	}

	public int getCapacity() {
		return capacity;
	}
}
