import java.util.ArrayList;

public class City {
	
	private String name;  //name represents name of this city.
	private int locId;    //locId represent location id in the center pane of this city. For example, 5 means first row and fifth column.
	private int id;       //id represents specific id in this level.
	

	
	//No-arg constructor for city class.
	public City() {
    
	}
    //This constructor takes parameter as name, locId, id and level.
	public City(String name, int locId, int id) {
		this.id = id;
		this.name = name;
		this.locId = locId;
		
		
	}
    //Getter methods for name, locId, and id.
	//There are only getter methods because these data fields is constant and cannot be changed by user.
	public String getName() {
		return name;
	}

	public int getLocId() {
		return locId;
	}

	public int getId() {
		return id;
	}
}
