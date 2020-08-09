package ca.sheridancollege.project;

/**
 * @author Angela Noble, 2020
 * @modifier Tiffany Truong, 2020
 * @modifier Man Shi, 2020
 */
public class WarCard extends Card
{
   private Suit suit;
   private Value value;

   public enum Suit
   {
      CLUBS, HEART, DIAMOND, SPADE
   }

   public enum Value
   {
      ACE(1),
      TWO(2),
      THREE(3),
      FOUR(4),
      FIVE(5),
      SIX(6),
      SEVEN(7),
      EIGHT(8),
      NINE(9),
      TEN(10),
      JACK(11),
      QUEEN(12),
      KING(13);

      private int numVal;

      private Value (int numVal)
      {
         this.numVal = numVal;
      }

      public int getNumVal ()
      {
         return this.numVal;
      }

   }

   public WarCard (Suit suit, Value value)
   {
      this.suit = suit;
      this.value = value;
   }

   public Value getValue ()
   {
      return this.value;
   }

   @Override
   public String toString ()
   {
      return "[" + this.suit + ", " + this.value + "]";
   }
}
