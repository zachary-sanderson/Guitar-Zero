import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * UI.
 *
 * @author  Toby Wigglesworth
 * @version 1.00, February 2019.
 */
public class Main extends JFrame {

  ImageIcon carouselIcon = new ImageIcon(getClass().getResource("Resources/carousel.png"));
  JLabel carousel = new JLabel(carouselIcon);

  JLabel carouselLabel1;    JLabel carouselIcon1;
  JLabel carouselLabel2;    JLabel carouselIcon2;
  JLabel carouselLabel3;    JLabel carouselIcon3;
  JLabel carouselLabel4;    JLabel carouselIcon4;
  JLabel carouselLabel5;    JLabel carouselIcon5;

  ImageIcon exitIcon      = new ImageIcon (getClass().getResource( "Resources/exit.png"     ));
  ImageIcon playIcon      = new ImageIcon (getClass().getResource( "Resources/play.png"     ));
  ImageIcon selectIcon    = new ImageIcon (getClass().getResource( "Resources/select.png"   ));
  ImageIcon storeIcon     = new ImageIcon (getClass().getResource( "Resources/store.png"    ));
  ImageIcon tutorialIcon  = new ImageIcon (getClass().getResource( "Resources/tutorial.png" ));

  String btnEXIT   = "Exit";
  String btnPLAY   = "Play";
  String btnSELECT = "Select";
  String btnSTORE  = "Store";
  String btnTUT    = "Tutorial";

  public Main () {
    setTitle( "Guitar Zero" );
    setLayout(null);
    setContentPane(new JLabel(new ImageIcon("Resources/background.png")));

    carouselIcon1 = new JLabel(exitIcon);
    carouselIcon2 = new JLabel(playIcon);
    carouselIcon3 = new JLabel(selectIcon);
    carouselIcon4 = new JLabel(storeIcon);
    carouselIcon5 = new JLabel(tutorialIcon);

    carouselLabel1 = new JLabel(btnEXIT);
    carouselLabel2 = new JLabel(btnPLAY);
    carouselLabel3 = new JLabel(btnSELECT);
    carouselLabel4 = new JLabel(btnSTORE);
    carouselLabel5 = new JLabel(btnTUT);

    carouselLabel3.setFont(carouselLabel3.getFont().deriveFont(Font.BOLD, 16f));

    carouselLabel1.setHorizontalAlignment(JLabel.CENTER);
    carouselLabel2.setHorizontalAlignment(JLabel.CENTER);
    carouselLabel3.setHorizontalAlignment(JLabel.CENTER);
    carouselLabel4.setHorizontalAlignment(JLabel.CENTER);
    carouselLabel5.setHorizontalAlignment(JLabel.CENTER);

    carouselLabel1.setBounds ( 315 , 332 , 110 , 24 ); add(carouselLabel1);
    carouselLabel2.setBounds ( 450 , 332 , 110 , 24 ); add(carouselLabel2);
    carouselLabel3.setBounds ( 585 , 332 , 110 , 24 ); add(carouselLabel3);
    carouselLabel4.setBounds ( 720 , 332 , 110 , 24 ); add(carouselLabel4);
    carouselLabel5.setBounds ( 855 , 332 , 110 , 24 ); add(carouselLabel5);

    carouselIcon1.setBounds ( 315 , 218 , 110 , 110 ); add(carouselIcon1);
    carouselIcon2.setBounds ( 450 , 218 , 110 , 110 ); add(carouselIcon2);
    carouselIcon3.setBounds ( 585 , 218 , 110 , 110 ); add(carouselIcon3);
    carouselIcon4.setBounds ( 720 , 218 , 110 , 110 ); add(carouselIcon4);
    carouselIcon5.setBounds ( 855 , 218 , 110 , 110 ); add(carouselIcon5);

    carousel.setBounds (  280 , 180 , 720 , 210 ); add(carousel);


  }

  public static void main (String [] args) {
    JFrame mainFrame = new Main();
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setSize(1280,720);
    mainFrame.setVisible(true);
    mainFrame.setResizable( false );


  }

}
