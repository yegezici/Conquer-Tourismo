//Muhammed Hasan Erzincanli 150121031
//Yunus Emre Gezici 150121066
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Vehicle {
	private int cityId; // citId keeps in which city this vehicle is placed first.
	private int destCityId; // destCityId keeps the ID of the destination city to which the vehicle is
							// traveling.
	private int capacity; // capacity keeps the maximum number of capacity to transport.
	ImageView imageView; // imageView is used to show the image of this vehicle in scene.
	double xCoordinate; // x coordinate of this vehicle.
	double yCoordinate; // y coordinate of this vehicle.
	int pasAtVehicle; // It keeps how many passengers left in this vehicle.
	private String CityName; // Name of the city this vehicle is placed in.

	// No-arg constructor for this class.
	public Vehicle() {

	}

	// Vehicle() constructor takes cityId and capacity as parameters.
	public Vehicle(int cityId, int capacity) {
		this.cityId = cityId;
		this.capacity = capacity;

		Image car;

		// Determine the appropriate image based on the vehicle's capacity
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
		// Set imageView's width and height to appropriate sizes.
		imageView.setFitWidth(25);
		imageView.setFitHeight(25);
	}

	// Getter method for cityId
	public int getCityId() {
		return cityId;
	}

	// Getter method for capacity
	public int getCapacity() {
		return capacity;
	}

	// Setter method for cityId
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	// Getter method for destCityId
	public int getDestCityId() {
		return destCityId;
	}

	// Setter method for destCityId
	public void setDestCityId(int destCityId) {
		this.destCityId = destCityId;
	}

	// Getter method for CityName
	public String getCityName() {
		return CityName;
	}

	// Setter method for CityName
	public void setCityName(String cityName) {
		CityName = cityName;
	}
}
