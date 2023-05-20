import java.util.ArrayList;

public class Passenger {
	private int numOfPas;
	private int startId;
	private int destId;
	ArrayList<Passenger> allOfPas = new ArrayList<>();
	NewLevel level;
	public Passenger() {

	}

	public Passenger(int numOfPas, int startId, int destId, NewLevel level) {
		this.numOfPas = numOfPas;
		this.startId = startId;
		this.destId = destId;
		this.level = level;
		allOfPas.add(this);
	}

	public int getNumOfPas() {
		return numOfPas;
	}

	public int getStartId() {
		return startId;
	}

	public int getDestId() {
		return destId;
	}

	public void setNumOfPas(int numOfPas) {
		this.numOfPas = numOfPas;
	}
 
}