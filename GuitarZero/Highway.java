import java.awt.Color;
import java.awt.Point;
/*
 * Highway.
 *
 * @author  Zachary Sanderson
 * @version 1.00, February 2019.
 */
public class Highway {
  private Color[][] cells;

  public Highway() {
    cells = new Color[ Constants.HIGHWAY_WIDTH ][ Constants.HIGHWAY_HEIGHT ];
    for ( int y = 0; y < Constants.HIGHWAY_HEIGHT; y = y + 1 ) {
      for ( int x = 0; x < Constants.HIGHWAY_WIDTH; x = x + 1 ) {
        this.cells[ x ][ y ] = Color.DARK_GRAY;
      }
    }
  }

  /*
   * Getter.
   */
  public Color[][] getCells() {
    return cells;
  }

  /*
   * Erase some cells.
   */
  public void erase( Point[] pts ) {
    Color[] colors = new Color[ pts.length ];
    for ( int i = 0; i < pts.length; i++ ) {
      colors[i] = Color.DARK_GRAY;
    }
    fill( colors , pts );
  }

  /*
   * Fill some cells.
   */
  public void fill( Color[] colors, Point[] pts ) {
    for ( int i = 0; i < Constants.HIGHWAY_WIDTH ; i++ ) {
      this.cells[ pts[ i ].x ][ pts[ i ].y ] = colors[i];
    }
  }
}
