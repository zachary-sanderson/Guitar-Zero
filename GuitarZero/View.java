import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * View.
 *
 * @author  Zachary Sanderson
 * @version 1.00, February 2019.
 */
class View extends JFrame implements PropertyChangeListener {
  private static final Dimension dimension =
      new Dimension( Constants.TILE_SIZE, Constants.TILE_SIZE );
  private static final GridLayout gridLayout =
      new GridLayout( Constants.HIGHWAY_HEIGHT, Constants.HIGHWAY_WIDTH );

  private Model       model;
  private JButton[][] tiles;
  private JPanel      panel;
  private Controller2 controller2;

  public View( Model model, Controller2 controller2 ) {
    this.model = model;
    this.controller2 = controller2;

    tiles = new JButton[ Constants.HIGHWAY_WIDTH ][ Constants.HIGHWAY_HEIGHT ];

    panel = new JPanel();
    panel.setLayout( gridLayout );

    /*
     * Set the grid tiles for the highway, add key listeners on the
     * bottom fret to register button presses.
     */
    for ( int y = 0; y < Constants.HIGHWAY_HEIGHT; y = y + 1 ) {
      for ( int x = 0; x < Constants.HIGHWAY_WIDTH; x = x + 1 ) {
        JButton tile = new JButton();
        tile.setPreferredSize( dimension );
        if ( y == Constants.HIGHWAY_HEIGHT - 3 ){
            //Guitar Buttons (to do)
          //tile.addEventListener( guitar );
        }
        tiles[ x ][ y ] = tile;
        panel.add( tile );
      }
    }

    this.add( panel );
    this.pack();

    model.addPropertyChangeListener( this );

    redraw();
  }

  /*
   * Redraw Highway.
   */
  public void redraw() {
    Highway highway  = model.getHighway();
    Color[][]  cells = highway.getCells();
    for ( int x = 0; x < Constants.HIGHWAY_WIDTH; x = x + 1 ) {
      for ( int y = 0; y < Constants.HIGHWAY_HEIGHT; y = y + 1 ) {
        tiles[ x ][ y ].setBackground( cells[ x ][ y ] );
        tiles[ x ][ y ].setOpaque( true );
        tiles[ x ][ y ].repaint();
      }
    }
  }

  /*
   * Redraw.
   */
  public void propertyChange( PropertyChangeEvent evt ) {
    redraw();
  }
}
