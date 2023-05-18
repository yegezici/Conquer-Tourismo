import java.awt.Image;
import java.io.File;

import javafx.scene.image.ImageView;

public class Vehicle {
	private int cityId;
	private int capacity;

	public Vehicle() {

	}

	public Vehicle(int cityId, int capacity) {
		this.cityId = cityId;
		this.capacity = capacity;
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
