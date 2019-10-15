import javax.swing.JOptionPane;

public class SlotMachineModel
{
   public static final int START = 50;
   // an array of reels may have been better.
   private String reel1;
   private String reel2;
   private String reel3;
   private int winnings;
   private int betAmount = 0;
   private int totalCredits;

   public SlotMachineModel()
   {
      totalCredits = START;
   }

   /**
    * Pull sets the reels to random strings.
    */
   void pull()
   {
      reel1 = getRandomString();
      reel2 = getRandomString();
      reel3 = getRandomString();
   }

   /**
    * returns a random string to set on the reels.
    * 
    * @return cherries, lemon, or bar.
    */
   private String getRandomString()
   {
      float f = (float) Math.random();
      if (f < .20)
      {
         return "cherries";
      } else if (f < .50)
      {
         return "lemon";
      } else if (f < .75)
      {
         return "bar";
      } else
      {
         return "bar";
      }
   }

   /**
    * returns the winnings
    * 
    * @return
    */
   public int getWinnings()
   {
      return winnings;
   }

   /**
    * Calculates the multiplier. If two or more strings are match from left to
    * right the player can win up to three times their bet.
    * 
    * @return
    */
   private int calulateMultiplier()
   {
      if (reel1.equals(reel2) && reel2.equals(reel3))
      {
         return 3;
      } else if (reel1.equals(reel2))
      {
         return 2;
      }
      return 0;
   }

   /**
    * Calculates the total and sets the total credits and bet ammount. Sends a
    * message if the player is out of money.
    */
   public void calculateTotal()
   {
      int multiplier = calulateMultiplier();
      winnings = betAmount * multiplier;
      totalCredits += winnings;
      betAmount = 0;
      if (totalCredits == 0)
      {
         JOptionPane.showMessageDialog(null, "Game Over");
      }
   }

   /**
    * returns reel 1
    * 
    * @return
    */
   public String getReel1()
   {
      return reel1;
   }

   /**
    * returns reel2
    * 
    * @return
    */
   public String getReel2()
   {
      return reel2;
   }

   /**
    * returns reel3
    * 
    * @return
    */
   public String getReel3()
   {
      return reel3;
   }

   /**
    * adds to the bet
    */
   public void addToBet()
   {
      if (totalCredits > 0)
      {
         betAmount++;
         totalCredits--;
      } else
      {
         JOptionPane.showMessageDialog(null, "You are out of Credits... go to the ATM");
      }
   }

   /**
    * returns the bet
    * 
    * @return bet
    */
   public int getBet()
   {
      return betAmount;
   }

   /**
    * returns the total credits.
    * 
    * @return
    */
   public int getTotalCredits()
   {
      return totalCredits;
   }

}
