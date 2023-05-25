//Muhammed Hasan Erzincanli 150121031
//Yunus Emre Gezici 150121066
import java.util.ArrayList;

public class Passenger {
	private int numOfPas;                   // It stores the number of passengers in this object.
	private int startId;                    // It stores the ID of the starting city for the passengers in this object.
	private int destId;                     // It stores the ID of the destination city for the passengers in this object.
	ArrayList<Passenger> allOfPas;  	    // It represents all the passengers in the current level.
	NewLevel level;                 		// It represents a NewLevel object.
	
	public Passenger() {
       //No-arg constructor     
	}
           
	//It construct passenger object with provided with specified data fields and add this object to allOfPas array list.
	public Passenger(int numOfPas, int startId, int destId, NewLevel level) {
		this.numOfPas = numOfPas;
		this.startId = startId;
		this.destId = destId;
		this.level = level;
		allOfPas.add(this);
		
	}
    
	//GETTER AND SETTER METHODS OF DATA FIELD IN THIS OBJECT.
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
