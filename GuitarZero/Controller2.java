import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
/*
 * Controller2 (keyboard).
 *
 * @author  Zachary Sanderson
 * @version 1.00, February 2019.
 */
class Controller2 implements KeyListener {
  private Model model;

  public Controller2( Model model ) {
    this.model = model;
  }

  public void keyReleased( KeyEvent evt ) { /* nothing */ }

  public void keyTyped( KeyEvent evt ) { /* nothing */ }

  public void keyPressed( KeyEvent evt ) {
    switch ( evt.getKeyCode() ) {

    }
  }
}
