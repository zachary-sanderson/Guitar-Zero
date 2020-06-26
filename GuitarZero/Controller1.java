import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
/*
 * Controller1 (clock).
 *
 * @author  Zachary Sanderson, Will Dinning
 * @version 1.00, February 2019.
 */
class Controller1 {
  private Model model;
  private Timer timer;

  public Controller1( Model model ) {
    this.model = model;
    this.timer = new Timer();

    timer.schedule( new TimerTask() {
        public void run() {
          model.down();
        }
     }, 0, Constants.INTERVAL );
  }
}
