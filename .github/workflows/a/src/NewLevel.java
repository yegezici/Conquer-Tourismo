import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NewLevel {
	File filename;
	int fixedCell;
	Vehicle vehicle = new Vehicle();
	Passenger passanger = new Passenger();
	City city = new City();
    ArrayList<City> cities = new ArrayList<City>();
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    ArrayList<Integer> fixedCells = new ArrayList<Integer>();
    
	NewLevel() {

	}

	NewLevel(File filename) {
		this.filename = filename;
		
	}
	//Scanner boşluk görmediği için her satırı kelime olarak algılıyordu, ben de direkt nextLine ile diğer satırı String olarak alıp
	//split ile array oluşturdum. 
	public void readingFile() {
		try {
			Scanner input = new Scanner(filename); 
			String str ="";
			
			while (input.hasNextLine()) {
				 str="";
				 str = input.nextLine();
				String[] inputs = str.split(",");
				if (inputs[0].equals("City")) {
					city = new City(inputs[1],Integer.valueOf(inputs[2]),Integer.valueOf(inputs[3]));
					cities.add(city);
					
				}
				else if (inputs[0].equals("Passenger")) {
					passanger = new Passenger(Integer.valueOf(inputs[1]), Integer.valueOf(inputs[2]),Integer.valueOf(inputs[3]));
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
}
