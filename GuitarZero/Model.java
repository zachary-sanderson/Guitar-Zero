import java.awt.Color;
import java.awt.Point;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.util.Random;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
/*
 * Model.
 *
 * @author  Zachary Sanderson, Will Dinning
 * @version 1.00, February 2019.
 */
public class Model {
  private PropertyChangeSupport support;
  private Highway highway;
  public Queue<Row> rows = new LinkedList<>();
  private int score, streak = 0;
  private int multiplier = 1;
  public int currency;
  private List<Integer> thresholds = new ArrayList<>();
  public String fileName;


  public Model(int currency) {
    support = new PropertyChangeSupport( this );
    highway = new Highway();
    this.score = score;
    this.streak = streak;
    this.multiplier = multiplier;
    this.currency = currency;
  }

  public void addPropertyChangeListener( PropertyChangeListener pcl ) {
    support.addPropertyChangeListener( pcl );
  }

  public int getScore() {
    return score;
  }

  public int getCurrency(){
      return currency;
    }

  private static boolean check(List<Integer> arr, int toCheckValue)
  {
      boolean test = false;
      for (int element : arr) {
          if (element == toCheckValue) {
              test = true;
              break;
          }
      }
      return test;
  }

  public void increment() {
    score = score + (1 * multiplier);
    if (score > 500) {
      for (int i = 500; i < score; i = i + 500) {
        if ( !check(thresholds, i) ) {
          thresholds.add(i);
          currency++;
        }
      }
    }
    streak++;
    if (streak % 10 == 0) { multiplier++; }
    support.firePropertyChange( null, null, null );
  }

  /*
   * get a random array of Colors (testing function).
   */
  public Color[] chooseColors() {
    Color[] colors = new Color[ Constants.HIGHWAY_WIDTH ];
    for ( int i = 0; i < Constants.HIGHWAY_WIDTH; i++ ) {
      final Random rand = new Random();
      switch ( rand.nextInt( 3 ) ) {
        case 0 : colors[i] = Color.DARK_GRAY;
        case 1 : colors[i] = Color.WHITE;
        case 2 : colors[i] = Color.BLACK;
      }
    }
    return colors;
  }

  public void fillRows(List<Button>)

  /*
   * Move all rows of notes down the lane
   */
  public void down() {
    Row head = rows.peek();
    if (head.rowNumber == Constants.HIGHWAY_HEIGHT - 1){
      streak = 0;
      multiplier = 1;
      highway.erase( head.points() );
      rows.remove();
    }
    for ( Row row : rows ){
      highway.erase( row.points() );
      row.moveRow();
      highway.fill( row.getNotes(), row.points() );
    }
    support.firePropertyChange( null, null, null );
  }

  /*
   * Drop row onto highway.
   */
  public void drop() {
    Row row = new Row( notes );
    rows.add( row );
    highway.fill( row.getNotes(), row.points() );
  }

  /*
   * Getter.
   */
  public Highway getHighway() {
    return highway;
  }

  public void Exit() {
    try {
      File file = new File("Currency.txt");
      file.createNewFile();
      FileOutputStream fileStream = new FileOutputStream(file, false);
      OutputStreamWriter outStream = new OutputStreamWriter(fileStream);
      BufferedWriter out = new BufferedWriter(outStream);
      out.write(getCurrency());
      out.close();
      System.exit( 1 );
    }
    catch(IOException ex) {
        ex.printStackTrace();
        System.exit( 1 );
    }

  }
}
