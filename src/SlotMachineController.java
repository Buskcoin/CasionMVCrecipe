import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * The Slot Machine Controller is responsible for combining the view and the
 * model depending on which key is pressed.
 * 
 * @author Keith Groves
 *
 */
public class SlotMachineController
{
   private SlotMachineView view;
   private SlotMachineModel model;
   private SlotMachineListener listener;
   public Timer timer;

   public SlotMachineController(SlotMachineView view, SlotMachineModel model)
   {
      this.view = view;
      this.model = model;
      listener = new SlotMachineListener();
      timer = new Timer(1000 / 30, listener);
      view.addSlotListenter(listener);
      view.pack();
   }

   /**
    * 
    * @author The LEAGUE of Amazing Programmers
    *
    */
   class SlotMachineListener implements ActionListener
   {
      int delay;
      private final int MAX_DELAY = 1000;

      @Override
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == view.getPull())
         {
            startPull();
         } else if ((e.getSource() == view.getBetOne()))
         {
            updateBet();
         } else if ((e.getSource() == view.getCashout()))
         {
            end();
         } else
         {
            updateReels();
         }
         if (delay > MAX_DELAY)
         {
            stopReel();
         }
         view.repaint();
      }

      void updateBet()
      {
         model.addToBet();
         view.setBetAmount(model.getBet());
         view.setTotalMoney(model.getTotalCredits());
         view.setWinAmount(0);
      }

      void updateReels()
      {
         timer.setDelay(delay);
         delay *= 1.15;
         model.pull();
         setReels();
      }

      void stopReel()
      {
         timer.stop();
         model.calculateTotal();
         int winnings = model.getWinnings();
         view.setWinAmount((winnings));
         view.setTotalMoney(model.getTotalCredits());
         view.setBetAmount(model.getBet());
         delay = 5;
         view.repaint();
      }

      void startPull()
      {
         view.setBetAmount(model.getBet());
         delay = new Random().nextInt(20) + 10;
         timer.start();
      }

      /**
		 * 
		 */
      void setReels()
      {
         view.setReel1(model.getReel1());
         view.setReel2(model.getReel2());
         view.setReel3(model.getReel3());
      }

      void end()
      {
         JOptionPane.showMessageDialog(view, "You must gamble MORE!!");
      }
   }
}
