import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class SaveAndLoad {
	String lvl ;
	String saveFile = "saves.txt";
	public SaveAndLoad(String lvl) {
       this.lvl = lvl;
       }
  public void save() {
      try {
		  FileWriter saver = new FileWriter(saveFile);
          saver.write(lvl);
	      saver.close();
		  System.out.println("Dosya oluşturuldu ve içine yazıldı.");
		  
  } 
      catch (IOException e) {
    	  System.out.println("Dosya oluşturulurken bir hata oluştu: " + e.getMessage());
		        }
		    
}
  public static String load() {
	  try {
	  File filename = new File("saves.txt");
	  Scanner scan = new Scanner(filename);
	  System.out.println("Dosya okundu");
	  String last = scan.next();
	  scan.close();
	  return last;
	  }
	  catch(IOException e) {
		  return e.toString();
	  }
	  
	  
	  
  }
  
  }