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
		ArrayList<String> startCity = new ArrayList<>();               //Passengers' starting cities      
		ArrayList<String> endCity = new ArrayList<>();                 //Passengers' destination cities 
		NewLevel lvl;
		int index;               //Index of this city in the cities array
		static int totalPas;    //Total number of passenger

	public NewCityButton(String name, Image img, double xCordinate, double yCordinate, NewLevel lvl, int index) {
		this.xCoordinate = xCordinate;
		this.yCoordinate = yCordinate;
		this.iv = new ImageView(img);
		this.name = name;
		this.lvl = lvl;
		this.index = index;
 /** Iterate through the passengers array list and in that loop iterate through the cities array list.  
  *  If a passenger's startId matches any city ID, that city name is added to startCity array list. Likewise, if endId matches, that city name is added to endCity.
     */
		for (int i = 0; i < lvl.passengers.size(); i++) {      
			for (int j = 0; j < lvl.cities.size(); j++) {
				if (lvl.cities.get(j).getId() == lvl.passengers.get(i).getStartId())
					startCity.add(lvl.cities.get(j).getName());
				if (lvl.cities.get(j).getId() == lvl.passengers.get(i).getDestId())
					endCity.add(lvl.cities.get(j).getName());
			}
		}
		//Calculating total number of passengers.
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
	    // Create a new Polygon object to represent the hexagon
	    Polygon hexagon = new Polygon();
	    // Calculate the center coordinates and radius of the hexagon
	    double centerX = size / 2.0;
	    double centerY = size / 2.0;
	    double radius = size / 2.0;
	    // Iterate through each side of the hexagon
	    for (int i = 0; i < 6; i++) {
	        // Calculate the angle for the current side
	        double angle = 2.0 * Math.PI / 6 * i;
	        // Calculate the x and y coordinates for the current vertex
	        double x = centerX + radius * Math.cos(angle);
	        double y = centerY + radius * Math.sin(angle);
	        // Add the x and y coordinates to the polygon's list of points
	        hexagon.getPoints().addAll(x, y);
	    }
	    // Return the completed hexagon polygon
	    return hexagon;
	}
	
	
	public int calculateDistance(int x1, int y1, int x2, int y2) {
		//Since the cell width and height is 50 times bigger than actual coordinates, points are divided by 50.
		x1 /= 50;    
		x2 /= 50;
		y1 /= 50;
		y2 /= 50;
		//Euclidean distance calculation
		return (int) (Math.ceil(Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow(y1 - y2, 2))));

	}
  
	public int calculateScore(int distance) {
		//Calculate the score according to given formula.
		int cost = distance;
		int income = (int) (lvl.vehicle.pasAtVehicle * distance * 0.2);
		return income - cost;
	}

	public String getCityInformation() {
		//Return a String with the given information about name and ID of city, distance between clicked city and vehicle, vehicle capacity. 
		return String.format("%s (City ID = %d, Distance = %d, Vehicle Capacity = %d)", lvl.cities.get(index).getName(),
				lvl.cities.get(index).getId(), calculateDistance((int) (endX), (int) (endY),
						(int) (lvl.vehicle.xCoordinate), (int) (lvl.vehicle.yCoordinate)),
				lvl.vehicles.get(0).getCapacity());
	}

	public String getPasssengerInformation() {
	    String s1 = ""; // String variable to store the formatted passenger information 
	    // Iterate through the cities in the "lvl" object
	    for (int i = 0; i < lvl.cities.size(); i++) {
	        // Check if the current city matches the start or end city of the passenger
	        if (this.name.equals(startCity.get(i)) || this.name.equals(endCity.get(i))) {
	            // Format the passenger information and append it to the result string
	            s1 += String.format("%s > %s (%d passengers)\n", startCity.get(i), endCity.get(i),
	                                lvl.passengers.get(i).getNumOfPas());
	        }
	    }
	    // Return the formatted passenger information
	    return s1;
	}

	public boolean isTransferred() {
   //This method checks if all passenger in this level are transferred or not.
		int total = 0;
		for (int i = 0; i < lvl.passengers.size(); i++) {             //Iterate through passenger array list in "lvl" object of NewLevel class.
			total += lvl.passengers.get(i).getNumOfPas();
		}
		if (total == 0)
			return true;
		else
			return false;
	}

	public void transportPassengers() {
		int capacity = lvl.vehicles.get(0).getCapacity();      //"capacity" initializes with the vehicle capacity. 

		for (int i = 0; i < startCity.size(); i++) {        //Iterate through startCity array list.

/** If a passenger's destination city matches this city's name AND that passenger is in the same location of vehicle, transport that passenger.
	Firstly, capacity and number of passenger is checked to find which one is minimum. Then number of passenger is set based on that number. 		
		*/
			if (endCity.get(i).equals(this.name) && startCity.get(i).equals(lvl.vehicle.getCityName())) {    
				int passengersToTransport = Math.min(capacity, lvl.passengers.get(i).getNumOfPas());
				lvl.vehicle.pasAtVehicle = passengersToTransport;
				lvl.passengers.get(i).setNumOfPas(lvl.passengers.get(i).getNumOfPas() - passengersToTransport);


			}

		}
        //If all passengers are transferred, Next Level button will be active.
		if (isTransferred()) {
			lvl.getPane().top.b.setOpacity(1);
			lvl.getPane().top.b.setDisable(false);

		}
	}
}
