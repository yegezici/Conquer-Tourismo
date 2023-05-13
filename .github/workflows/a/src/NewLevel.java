import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NewLevel {
	File filename;
	int fixedCell;

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
			Vehicle vehicle = new Vehicle();
			Passenger passanger = new Passenger();
			City city = new City();
			while (input.hasNext()) {
				 str = "";
				 str = input.nextLine();
				String[] inputs = str.split(",");
				if (inputs[0].equals("City")) {
					city.name = inputs[1];
					city.locId = Integer.valueOf(inputs[2]);
					city.id = Integer.valueOf(inputs[3]);
				}
				else if (inputs[0].equals("Passenger")) {
					passanger.numOfPas = Integer.valueOf(inputs[1]);
					passanger.startId = Integer.valueOf(inputs[2]);
					passanger.destId = Integer.valueOf(inputs[3]);
				}
				else if (inputs[0].equals("Vehicle")) {
					vehicle.cityId = Integer.valueOf(inputs[1]);
					vehicle.capacity = Integer.valueOf(inputs[2]);
				}
				else if (inputs[0].equals("Fixed")) {
					this.fixedCell = Integer.valueOf(inputs[1]);
				}

			}
			System.out.println(city.name);
			System.out.println(city.locId);
			System.out.println(city.id);
			System.out.println(passanger.numOfPas);
			System.out.println(passanger.startId);
			System.out.println(passanger.destId);
			System.out.println(vehicle.cityId);
			System.out.println(vehicle.capacity);
			System.out.println(fixedCell);
			
		} catch (FileNotFoundException e) {
			System.out.println("There is no file " + e.getMessage());
		}
	}
}
