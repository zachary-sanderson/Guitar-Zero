import javax.swing.JFrame;
import java.io.*;
/*
 * Guitar Zero.
 *
 * @author  Zachary Sanderson
 * @version 1.00, February 2019.
 */
public class Main {
  private static int currency = 0;

  public static int GetInitialCurrency(String fileName) {
        String line = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                currency = Integer.parseInt(line);
            }
            bufferedReader.close();
            return currency;
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "No in-game currency detected");
                return currency;
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '"
                + fileName + "'" + ". Setting in-game currency to 0.");
            return currency;
        }
  }



  public static void main( String[] argv ) {
    currency = GetInitialCurrency("Currency.txt");
    Model       model       = new Model(currency);
    Controller1 controller1 = new Controller1( model );
    Controller2 controller2    = new Controller2( model );
    View        view        = new View( model, controller2 );
    view.setVisible( true );
  }
}
