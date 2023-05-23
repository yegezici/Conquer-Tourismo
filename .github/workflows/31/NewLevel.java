import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NewLevel {
	//Keeps the file of current level
	File file;
	//Keeps the name of this file
	String nameOfFile;
	//Keeps the vehicle in the current level
	Vehicle vehicle;
	//Keeps all cities that created in this level
	ArrayList<City> cities = new ArrayList<City>();
	//In case, there could be exist more that one car 
	ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	//Keeps all passengers that created in this level
	ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	//Keeps the fixed cells
	ArrayList<Integer> fixedCells = new ArrayList<Integer>();
	//Keeps the pane of the level
	private MainPane pane;

	//This class has just one constructor and it takes file object as an argument
	public NewLevel(File file) {
		this.file = file;
		nameOfFile = file.getName();

	}
	//In order to take input from level file, this class has a method 
	public void readingFile() {
		try {
			//Scanner object takes input from the file
			Scanner input = new Scanner(file);
			String str = "";

			while (input.hasNextLine()) {
				str = "";
				str = input.nextLine();
				String[] inputs = str.split(",");
				if (inputs[0].equals("City")) {
					cities.add(new City(inputs[1], Integer.valueOf(inputs[2]), Integer.valueOf(inputs[3]), this));

				} else if (inputs[0].equals("Passenger")) {
					passengers.add(new Passenger(Integer.valueOf(inputs[1]), Integer.valueOf(inputs[2]),
							Integer.valueOf(inputs[3]), this));
				} else if (inputs[0].equals("Vehicle")) {
					vehicle = new Vehicle(Integer.valueOf(inputs[1]), Integer.valueOf(inputs[2]));
					vehicles.add(vehicle);
				} else if (inputs[0].equals("Fixed")) {
					fixedCells.add(Integer.valueOf(inputs[1]));
				}

			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("There is no file " + e.getMessage());
		}

	}
	//This is a getter method for pane
	public MainPane getPane() {
		return pane;
	}
	//This is a setter method for pane
	public void setPane(MainPane pane) {
		this.pane = pane;
	}
}
