import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class SaveAndLoad {
	String lvl ;  //Current level name
  	String saveFile = "saves.txt";      //File name that current level will be saved.
  	//Constructor takes level name "lvl" as parameter.
	public SaveAndLoad(String lvl) {
       this.lvl = lvl;
       }
	//This method save the current level into file named "saves.txt".
    public void save() {
    	//Exception handling for FileWriter.
      try {
		  FileWriter saver = new FileWriter(saveFile);            
          saver.write(lvl);                                        //Save the current level name
	      saver.close();
		  System.out.println("Saving, please don't turn of your system while your game is saving.");      //Save message if it will be successful.
		  
  } 
      catch (IOException e) {
    	  System.out.println("An error occurred. File cannot be found. " + e.getMessage());          //Error message if it will not be successful.
		        }
		    
}    
     //This method loads last level user has played.
  public static String load() {
	  //Exception handling for Scanner.
	  try {
	  File filename = new File("saves.txt");               
	  Scanner scan = new Scanner(filename);                 //Scan the save file in which last level is written.
	  System.out.println("Loading");                        //Load message
	  String last = scan.next();                            //Since it is one word, Scanner.next() method is used.
	  scan.close();
	  return last;
	  }
	  catch(IOException e) {
		  return e.toString();                               
	  }
	  
	  
	  
  }
  
  }
