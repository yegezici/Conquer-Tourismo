import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;

public class NewCityButton extends Button {
	//Coordinates of this object
	double xCoordinate;
	double yCoordinate;
	//Imageview of this object
	ImageView iv;
	//Name of this city
	String name;
	// To take last clicked button's cordinates
	static double endX;
	static double endY;
	ArrayList<String> startCity = new ArrayList<>();
	ArrayList<String> endCity = new ArrayList<>();
	NewLevel lvl;
	int index;
	static int totalPas;

	public NewCityButton(String name, Image img, double xCordinate, double yCordinate, NewLevel lvl, int index) {
		this.xCoordinate = xCordinate;
		this.yCoordinate = yCordinate;
		this.iv = new ImageView(img);
		this.name = name;
		this.lvl = lvl;
		this.index = index;

		for (int i = 0; i < lvl.passengers.size(); i++) {
			for (int j = 0; j < lvl.cities.size(); j++) {
				if (lvl.cities.get(j).getId() == lvl.passengers.get(i).getStartId())
					startCity.add(lvl.cities.get(j).getName());
				if (lvl.cities.get(j).getId() == lvl.passengers.get(i).getDestId())
					endCity.add(lvl.cities.get(j).getName());
			}
		}
		for (int i = 0; i < lvl.passengers.size(); i++) {
			totalPas += lvl.passengers.get(i).getNumOfPas();
		}
	}
	//To create the button that will be shown to the user
	//First, we create a VBox to put button and name together to button then use setGraphic method
	public Button createButton(Text botText) {
		//This is our button 
		Button button = new Button();
		//To arrange imageview's size
		int imageSize = 50;
		//To put the city name on the vbox
		Text t1 = new Text(this.name);
		//We use hexagon instead of circle
		Polygon hexagon = createHexagon(imageSize);
		//Set imageview's size
		iv.setFitWidth(imageSize);
		iv.setFitHeight(imageSize);
		//To put it in a hexagon
		iv.setClip(hexagon);
		button.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
		//Finallt put them in a vbox
		VBox vbox = new VBox(iv, t1);
		vbox.setAlignment(Pos.CENTER);
		//5 pixels between nodes in VBox
		vbox.setSpacing(5);
		//Changes button's style
		button.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; "
				+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		//To put vbox on a button
		button.setGraphic(vbox);
		
		//If a button is clicked
		button.setOnAction(e -> {
			//To create a line we save this object's coordinates
			endX = button.getLayoutX();
			endY = button.getLayoutY();
			//To show passangers at this city
			botText.setText(getCityInformation() + "\n" + getPasssengerInformation());
			//To change current city in centerpane 
			lvl.getPane().center.city = this;
			//Update the current city id of the vehicle
			lvl.vehicle.setDestCityId(lvl.cities.get(lvl.getPane().center.city.index).getId());
			//Changes the opacity of drive button
			lvl.getPane().bottom.b.setOpacity(1.0);
			//Then this drive button is clickable
			lvl.getPane().bottom.b.setDisable(false);
		});

		return button;

	}

	private Polygon createHexagon(double size) {
		Polygon hexagon = new Polygon();
		double centerX = size / 2.0;
		double centerY = size / 2.0;
		double radius = size / 2.0;

		for (int i = 0; i < 6; i++) {
			double angle = 2.0 * Math.PI / 6 * i;
			double x = centerX + radius * Math.cos(angle);
			double y = centerY + radius * Math.sin(angle);
			hexagon.getPoints().addAll(x, y);
		}

		return hexagon;
	}

	public int calculateDistance(int x1, int y1, int x2, int y2) {
		x1 /= 50;
		x2 /= 50;
		y1 /= 50;
		y2 /= 50;
		return (int) (Math.ceil(Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow(y1 - y2, 2))));

	}

	public int calculateScore(int distance) {
		int cost = distance;
		int income = (int) (lvl.vehicle.pasAtVehicle * distance * 0.2);
		return income - cost;
	}

	public String getCityInformation() {
		return String.format("%s (City ID = %d, Distance = %d, Vehicle Capacity = %d)", lvl.cities.get(index).getName(),
				lvl.cities.get(index).getId(), calculateDistance((int) (endX), (int) (endY),
						(int) (lvl.vehicle.xCoordinate), (int) (lvl.vehicle.yCoordinate)),
				lvl.vehicles.get(0).getCapacity());
	}

	public String getPasssengerInformation() {
		String s1 = "";
		for (int i = 0; i < lvl.cities.size(); i++) {
			if (this.name.equals(startCity.get(i)) || this.name.equals(endCity.get(i))) {
				s1 += String.format("%s > %s (%d passengers)\n", startCity.get(i), endCity.get(i),
						lvl.passengers.get(i).getNumOfPas());
			}
		}

		String s = "";
		for (int i = 0; i < startCity.size(); i++) {
			s += String.format("%s > %s (%d passengers)\n", startCity.get(i), endCity.get(i),
					lvl.passengers.get(i).getNumOfPas());

		}
		return s1;
	}

	public boolean isTransferred() {

		int total = 0;
		for (int i = 0; i < lvl.passengers.size(); i++) {
			total += lvl.passengers.get(i).getNumOfPas();
		}
		if (total == 0)
			return true;
		else
			return false;
	}

	public void transportPassengers() {
		int capacity = lvl.vehicles.get(0).getCapacity();

		for (int i = 0; i < startCity.size(); i++) {

			if (endCity.get(i).equals(this.name) && startCity.get(i).equals(lvl.vehicle.getCityName())) {
				int passengersToTransport = Math.min(capacity, lvl.passengers.get(i).getNumOfPas());
				lvl.vehicle.pasAtVehicle = passengersToTransport;
				lvl.passengers.get(i).setNumOfPas(lvl.passengers.get(i).getNumOfPas() - passengersToTransport);

			}

		}

		if (isTransferred()) {
			lvl.getPane().top.b.setOpacity(1);
			lvl.getPane().top.b.setDisable(false);

		}
	}

}
