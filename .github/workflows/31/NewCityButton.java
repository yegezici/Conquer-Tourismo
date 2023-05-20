import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class NewCityButton extends Button {
	double xCordinate;
	double yCordinate;
	ImageView iv;
	String name;
	// To take last clicked button's cordinates
	static double endX;
	static double endY;
	ArrayList<String> startCity = new ArrayList<>();
	ArrayList<String> endCity = new ArrayList<>();
	NewLevel lvl;
	int index;

	public NewCityButton(String name, Image img, double xCordinate, double yCordinate, NewLevel lvl, int index) {
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
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
	}

	public Button createButton(Text botText) {
		Button button = new Button();
		int imageSize = 35;
		iv.setFitWidth(imageSize);
		iv.setFitHeight(imageSize);
		button.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
		button.setGraphic(iv);

		button.setOnAction(e -> {
			endX = button.getLayoutX();
			endY = button.getLayoutY();
			botText.setText(getCityInformation() + "\n" + getPasssengerInformation());
			lvl.getPane().center.city = this;
			lvl.vehicle.setDestCityId(lvl.cities.get(lvl.getPane().center.city.index).getId());

		});

		return button;

	}

	public int calculateDistance(int x1, int y1, int x2, int y2) {
		x1 /= 40;
		x2 /= 40;
		y1 /= 40;
		y2 /= 40;
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
						(int) (lvl.vehicle.xCordinate), (int) (lvl.vehicle.yCordinate)),
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

	public void transportPassengers() {
		int capacity = lvl.vehicles.get(0).getCapacity();
		for (int i = 0; i < lvl.passengers.size(); i++) {
				if (endCity.get(i).equals(this.name) && startCity.get(i).equals(lvl.vehicle.getCityName())) {
					int passengersToTransport = Math.min(capacity, lvl.passengers.get(i).getNumOfPas());
					lvl.vehicle.pasAtVehicle = passengersToTransport;
					System.out.println(lvl.passengers.get(i).getNumOfPas());

					lvl.passengers.get(i).setNumOfPas(lvl.passengers.get(i).getNumOfPas() - passengersToTransport);

					System.out.println(lvl.passengers.get(i).getNumOfPas());

			
			}
		}
	}
}
