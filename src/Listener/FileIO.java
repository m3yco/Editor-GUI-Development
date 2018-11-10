package Listener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
  
  // Dateiinhalt zeilenweise lesen
  // und als String zurueckliefern
  public static String read(String filename) {
    String content = "";
    String line;
    try {
      
      // Datei oeffnen
      BufferedReader filereader = 
          new BufferedReader(
              new FileReader(filename));
      
      // Datei zeilenweise lesen
      while ((line = filereader.readLine())
          != null){
        content += line + '\n';
      } // end while
      
      // Datei schliessen
      filereader.close();
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } // end catch
    
    // Dateiinhalt zurueckliefern
    return content;
  } // end method read()
  
  public static void write(String filename, 
                           String content){
    
    try {
      // Datei oeffnen
      FileWriter writer = 
          new FileWriter(filename);
      
      // Inhalt aus zweitem Parameter
      // auf Datei schreiben
      writer.write(content);
      
      // Datei schliessen
      writer.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } // end catch
    
  } // end method write()
} // end class FileIO
