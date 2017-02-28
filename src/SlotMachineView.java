import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The Slot Machine View class contains all the visual components of the GUI.
 * 
 * @author Keith Groves
 *
 */
public class SlotMachineView extends JFrame
{
   // Intialize components.
   ImageIcon CHERRIES = new ImageIcon("cherries.png");
   ImageIcon LEMON = new ImageIcon("lemon.png");
   ImageIcon SPACE = new ImageIcon("space.png");
   ImageIcon SEVEN = new ImageIcon("seven.png");
   ImageIcon BAR = new ImageIcon("bar.png");
   JButton cashOut = new JButton("Cash Out");
   JButton betOne = new JButton("Bet One");
   JButton pull = new JButton("SPIN");
   JPanel gamblePanel = new JPanel();
   JPanel buttonPanel = new JPanel();
   JPanel reelPanel = new JPanel();
   JLabel reel1 = new JLabel(BAR);
   JLabel reel2 = new JLabel(BAR);
   JLabel reel3 = new JLabel(BAR);

   JLabel winnerPaid = new JLabel("Winner Paid", JLabel.CENTER);
   JLabel credits = new JLabel("Total Credits", JLabel.CENTER);
   JLabel betLabel = new JLabel("Bet", JLabel.CENTER);
   JLabel winAmount = new JLabel("0", JLabel.CENTER);
   JLabel totalMoney = new JLabel(SlotMachineModel.START + "", JLabel.CENTER);
   JLabel bet = new JLabel("0", JLabel.CENTER);

   /**
    * Constructor for the Slot Machine view.
    */
   public SlotMachineView()
   {
      super("Slot Machine");
      setLayout(new GridLayout(2, 1));
      add(reelPanel);
      add(gamblePanel);

      reelPanel.setLayout(new GridLayout(1, 3));
      gamblePanel.setLayout(new GridLayout(3, 3));
      // buttonPanel.setLayout(new GridLayout(1, 3));
      reelPanel.add(reel1);
      reelPanel.add(reel2);
      reelPanel.add(reel3);
      styleSlotMachine();
      reelPanel.setBorder(BorderFactory.createTitledBorder("Match 2 or 3 from left to right!"));
      gamblePanel.add(credits);
      gamblePanel.add(betLabel);
      gamblePanel.add(winnerPaid);
      gamblePanel.add(totalMoney);
      gamblePanel.add(bet);
      gamblePanel.add(winAmount);
      gamblePanel.add(cashOut);
      gamblePanel.add(betOne);
      gamblePanel.add(pull);

      pack();
   }

   private void styleSlotMachine()
   {
      reel1.setBackground(Color.WHITE);
      reel2.setBackground(Color.WHITE);
      reel3.setBackground(Color.WHITE);
      reel1.setOpaque(true);
      reel2.setOpaque(true);
      reel3.setOpaque(true);
      totalMoney.setOpaque(true);
      totalMoney.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      bet.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      winAmount.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      bet.setOpaque(true);
      winAmount.setOpaque(true);
      gamblePanel.setBackground(Color.lightGray);
      gamblePanel.setOpaque(true);
      gamblePanel.setBorder(BorderFactory.createLineBorder(Color.red));
   }

   private ImageIcon getIcon(String iconName)
   {
      if (iconName != null)
      {
         switch (iconName)
         {
         case "cherries":
            return CHERRIES;
         case "lemon":
            return LEMON;
         case "bar":
            return BAR;
         case "seven":
            return SEVEN;
         default:
            return SPACE;
         }
      } else
         return null;
   }

   void setReel1(String symbol)
   {
      this.reel1.setIcon(getIcon(symbol));
   }

   void setReel2(String symbol)
   {
      this.reel2.setIcon(getIcon(symbol));
   }

   void setReel3(String symbol)
   {
      this.reel3.setIcon(getIcon(symbol));
   }

   int getBetAmount()
   {
      return Integer.parseInt(bet.getText());
   }

   public JLabel getReel1()
   {
      return reel1;
   }

   public JLabel getReel2()
   {
      return reel2;
   }

   public JLabel getReel3()
   {
      return reel3;
   }

   public void addSlotListenter(ActionListener pullListener)
   {
      pull.addActionListener(pullListener);
      cashOut.addActionListener(pullListener);
      betOne.addActionListener(pullListener);
   }

   void setWinAmount(int winnings)
   {
      winAmount.setText("" + winnings);
   }

   public int getWinnings()
   {
      return Integer.parseInt(winAmount.getText());
   }

   public JButton getPull()
   {
      return pull;
   }

   public JButton getCashout()
   {
      return cashOut;
   }

   public void setBetAmount(int betAmount)
   {
      this.bet.setText(betAmount + "");
   }

   public void setTotalMoney(int total)
   {
      if (total > Integer.parseInt(totalMoney.getText()))
         totalMoney.setBackground(Color.GREEN);
      else
      {
         totalMoney.setBackground(Color.RED);
      }
      this.totalMoney.setText("" + total);
   }

   public int getTotalMoney()
   {
      return Integer.parseInt(totalMoney.getText());
   }

   public JButton getBetOne()
   {
      return betOne;
   }

}
