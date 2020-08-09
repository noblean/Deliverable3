package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Tiffany Truong, 2020
 * @modifier Angela Noble, 2020
 * @modifier Man Shi, 2020
 */
public class WarCardDeck
{
   private ArrayList<WarCard> deck;
   private int size;

   public WarCardDeck ()
   {
      deck = new ArrayList<>();
   }

   /**
    * Returns WarCardDeck as an Array List
    *
    * @return
    */
   public ArrayList<WarCard> getDeck ()
   {
      return deck;
   }

   /**
    * Retrieves deck size
    *
    * @return deck size
    */
   public int getSize ()
   {
      return size;
   }

   /**
    * Sets deck size
    *
    * @param size
    */
   public void setSize (int size)
   {
      this.size = size;
   }

   /**
    * Shuffles deck
    */
   public void shuffle ()
   {
      Collections.shuffle(deck);
   }

   /**
    * Fills an array list with WardCard objects
    *
    * @param mainDeck
    */
   public void generateMainDeck (ArrayList<WarCard> mainDeck)
   {
      for (WarCard.Suit s : WarCard.Suit.values()) {
         for (WarCard.Value v : WarCard.Value.values()) {
            WarCard c = new WarCard(s, v);
            mainDeck.add(c);
         }
      }
   }

   /**
    * Splits a deck in two and allocates them to their own deck
    *
    * @param mainDeck the main deck
    * @param p1Deck player 1 deck
    * @param p2Deck player 2 deck
    */
   public void splitDeck (WarCardDeck mainDeck, WarCardDeck p1Deck, WarCardDeck p2Deck)
   {
      //Writing to p1Deck
      for (int i = 0; i <= 25; i++) { //0-25 is the first half of the deck
         p1Deck.deck.add(mainDeck.deck.get(i));
      }

      //Writing to p2Deck
      for (int i = 26; i <= 51; i++) { //26-52 is the second half of the deck
         p2Deck.deck.add(mainDeck.deck.get(i));
      }

   }
}
