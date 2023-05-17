import java.util.ArrayList;

public class City {
	private String name;
	private int locId;
	private int id;
	ArrayList<Passenger> pasAtThisCity = new ArrayList<>();
	NewLevel level;

	public City() {

	}

	public City(String name, int locId, int id, NewLevel level) {
		this.id = id;
		this.name = name;
		this.locId = locId;
		this.level = level;
		
	}

	public String getName() {
		return name;
	}

	public int getLocId() {
		return locId;
	}

	public int getId() {
		return id;
	}

	public void findingPas() {
		for (int i = 0; i < level.passengers.size(); i++) {
			if (level.passengers.get(i).getStartId() == this.id)
				pasAtThisCity.add(level.passengers.get(i));
		}
	}

}
