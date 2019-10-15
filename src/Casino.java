import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * This is a slot machine program that implements a Model View Controller design
 * pattern.
 * 
 * @author Keith Groves
 *
 */
public class Casino
{

   /**
    * The main method is responsible for initializing the key object in this
    * program
    * 
    * @param args
    */
   public static void main(String[] args)
   {
      SlotMachineView view = new SlotMachineView();
      SlotMachineModel model = new SlotMachineModel();
      SlotMachineController controller = new SlotMachineController(view, model);
      view.setVisible(true);
      view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

}
