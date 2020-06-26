import java.awt.Color;
import java.awt.Point;
/*
 * Note
 *
 * @author  Zachary Sanderson
 * @version 7.01a, January 2019.
 */
  class Note {
  public Color color;

  /*
   * Create a Note at the top of a highway lane
   */
  public Note(Color color){
    this.color = color;
  }

  /*
   * Getter
   */
   public Color getColor(){
     return color;
   }
}
