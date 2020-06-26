import java.awt.Color;
import java.awt.Point;
/*
 * Row.
 *
 * @author  Zachary Sanderson
 * @version 1.00, February 2019.
 */
 class Row {
  protected int rowNumber;
  protected Color[] notes;

  public Row( Color[] notes ){
    this.rowNumber = 0;
    this.notes = notes;
  }

  /*
   * Move row one space down the highway.
   */
  public void moveRow() {
    rowNumber += 1;
  }

  /*
   * Returns the points of all notes on the row.
   */
  public Point[] points() {
    final Point[] res = new Point[ Constants.HIGHWAY_WIDTH ];
    for ( int i = 0; i < Constants.HIGHWAY_WIDTH; i++ ) {
      res[ i ] = new Point( i, rowNumber );
    }
    return res;
  }

  /*
   * Getter.
   */
  public Color[] getNotes() {
    return notes;
  }
}
