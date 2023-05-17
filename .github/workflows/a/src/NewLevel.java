import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NewLevel {
	File file;
	String nameOfFile;
	int score;
	int fixedCell;
	Vehicle vehicle = new Vehicle();
	Passenger passanger = new Passenger();
	City city = new City();
    ArrayList<City> cities = new ArrayList<City>();
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    ArrayList<Integer> fixedCells = new ArrayList<Integer>();
    private CenterPane centerpane;
	
    
    NewLevel() {

	}

	NewLevel(File file) {
		this.file = file;
		nameOfFile = file.getName();
	}
	//Scanner boşluk görmediği için her satırı kelime olarak algılıyordu, ben de direkt nextLine ile diğer satırı String olarak alıp
	//split ile array oluşturdum. 
	public void readingFile() {
		try {
			Scanner input = new Scanner(file); 
			String str ="";
			
			while (input.hasNextLine()) {
				 str="";
				 str = input.nextLine();
				String[] inputs = str.split(",");
				if (inputs[0].equals("City")) {
					city = new City(inputs[1],Integer.valueOf(inputs[2]),Integer.valueOf(inputs[3]),this);
					cities.add(city);
					
				}
				else if (inputs[0].equals("Passenger")) {
					passanger = new Passenger(Integer.valueOf(inputs[1]), Integer.valueOf(inputs[2]),Integer.valueOf(inputs[3]),this);
					passengers.add(passanger);
				}
				else if (inputs[0].equals("Vehicle")) {
					vehicle = new Vehicle(Integer.valueOf(inputs[1]), Integer.valueOf(inputs[2]));
					vehicles.add(vehicle);
				}
				else if (inputs[0].equals("Fixed")) {
					this.fixedCell = Integer.valueOf(inputs[1]);
					fixedCells.add(fixedCell);
				}
            
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("There is no file " + e.getMessage());
		}
		
	}

	public void setCenterPane(CenterPane centerPane) {
		this.centerpane = centerPane;
	}
	public CenterPane getCenterPane() {
		return this.centerpane;
	}
}
