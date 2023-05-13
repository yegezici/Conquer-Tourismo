import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Level {
	String levelName;
	int fixedCell;

	Level() {

	}

	Level(String levelName) {
		this.levelName = levelName;
	}

	public void readingFile() {
		try (Scanner input = new Scanner(new File(this.levelName))){
			City city = new City();
			Passanger passanger = new Passanger();
			Vehicle vehicle = new Vehicle();
			while (input.hasNext()) {
				String reader = input.next();
				if (reader.equals("City")) {
					city.name = input.next();
					city.locId = input.nextInt();
					city.id = input.nextInt();
				}
				if (reader.equals("Passanger")) {
					passanger.numOfPas = input.nextInt();
					passanger.startId = input.nextInt();
					passanger.destId = input.nextInt();
				}
				if (reader.equals("Vehicle")) {
					vehicle.cityId = input.nextInt();
					vehicle.capacity = input.nextInt();
				}
				if (reader.equals("Fixed")) {
					this.fixedCell = input.nextInt();
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
