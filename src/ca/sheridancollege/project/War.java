package ca.sheridancollege.project;

/**
 * @author Tiffany Truong, 2020
 * @modifier Angela Noble, 2020
 * @modifier Man Shi, 2020
 */
public class War extends Game
{

   private WarCardDeck tempDeck; // temporary deck used after players flip cards, and for wager
   private WarCardDeck p1Deck; // player 1's Deck
   private WarCardDeck p2Deck; // player 2's Deck
   private String player1;
   private String player2;
   private int round = 1; // integer to count number of rounds
   private boolean gameOver = false;

   /**
    * Naming the Game
    */
   public War ()
   {
      super("War");
   }

   /**
    * Getting Player 1's Name
    *
    * @return Player 1's Name
    */
   public String getPlayer1 ()
   {
      return player1;
   }

   /**
    * Setting Player 1's Name
    *
    * @param player1 = Player 1's Name
    */
   public void setPlayer1 (String player1)
   {
      this.player1 = player1;
   }

   /**
    * Getting Player 2's Name
    *
    * @return Player 2's Name
    */
   public String getPlayer2 ()
   {
      return player2;
   }

   /**
    * Setting Player 2's Name
    *
    * @param player2 = Player 2's Name
    */
   public void setPlayer2 (String player2)
   {
      this.player2 = player2;
   }

   /**
    * Get Player 2 Deck
    *
    * @return player 2 deck
    */
   public WarCardDeck getP2Deck ()
   {
      return p2Deck;
   }

   /**
    * Set Player 2 Deck
    *
    * @param p2Deck
    */
   public void setP2Deck (WarCardDeck p2Deck)
   {
      this.p2Deck = p2Deck;
   }

   /**
    * Get Player 1 Deck
    *
    * @return player 1 Deck
    */
   public WarCardDeck getP1Deck ()
   {
      return p1Deck;
   }

   /**
    * Set Player 1 Deck
    *
    * @param p1Deck player 1 Deck
    */
   public void setP1Deck (WarCardDeck p1Deck)
   {
      this.p1Deck = p1Deck;
   }

   /**
    * Get the temporary deck
    *
    * @return the temporary deck
    */
   public WarCardDeck getTempDeck ()
   {
      return tempDeck;
   }

   /**
    * Set the temporary deck
    *
    * @param tempDeck the temporary deck
    */
   public void setTempDeck (WarCardDeck tempDeck)
   {
      this.tempDeck = tempDeck;
   }

   /**
    * Checks if the game is over
    *
    * @return if the game is over
    */
   public boolean getGameOver ()
   {
      return this.gameOver;
   }

   /**
    * Flips the last entered element of a given deck
    *
    * @param deck the given deck
    * @return the flipped card
    */
   public WarCard flipCard (WarCardDeck deck)
   {
      int index = deck.getDeck().size() - 1; // Retrieve the last element index
      WarCard flippedCard = deck.getDeck().get(index);

      deck.getDeck().remove(index); // Remove flipped card from deck

      return flippedCard;
   }

   /**
    * Compares the numerical value of given player 1 and player 2 cards and
    * places those cards in the winning hand whose card is of higher value.
    *
    * @param p1Card player 1 card
    * @param p2Card player 2 card
    */
   public void compareCards (WarCard p1Card, WarCard p2Card)
   {
      tempDeck.getDeck().add(p1Card); // player 1's card gets put into the temp deck
      tempDeck.getDeck().add(p2Card); // player 2's card gets put into the temp deck

      if (p1Card.getValue().getNumVal() > p2Card.getValue().getNumVal()) {
         // if player 1 has higher value card, give both cards to player 1
         for (int i = 0; i < tempDeck.getDeck().size(); i++) {
            p1Deck.getDeck().add(tempDeck.getDeck().get(i));
         }
         System.out.println("---- " + this.player1 + " wins the round ----");

      }
      else if (p2Card.getValue().getNumVal() > p1Card.getValue().getNumVal()) {
         // if player 2 has higher value card, give both cards to player 2
         for (int i = 0; i < tempDeck.getDeck().size(); i++) {
            p2Deck.getDeck().add(tempDeck.getDeck().get(i));
         }
         System.out.println("---- " + this.player2 + " wins the round ----");
      }
      else {
         //cards are equal value, war is declared
         System.out.println("-------- WAR --------");
         WarCard[] wager = wager();
         if (wager == null) {
            if (p1Deck.getDeck().size() == 0) { // player 1 loses
               for (int i = 0; i < tempDeck.getDeck().size(); i++) {
                  p2Deck.getDeck().add(tempDeck.getDeck().get(i)); // player 2 gets the cards
               }
            }
            else { // player 2 loses
               for (int i = 0; i < tempDeck.getDeck().size(); i++) {
                  p1Deck.getDeck().add(tempDeck.getDeck().get(i)); // player 1 gets the cards
               }
            }
         }
         else {
            WarCard p1Wager = wager[0];
            WarCard p2Wager = wager[1];
            System.out.println(this.player1 + " card is: " + p1Wager);
            System.out.println(this.player2 + " card is: " + p2Wager);
            compareCards(p1Wager, p2Wager);
         }
      }
      tempDeck.getDeck().clear(); // empty temporary deck
   }

   /**
    * Performs a wager with a given deck when war is declared. A wager consists
    * of moving 3 cards (face-down) to a temporary deck and flipping one card.
    *
    * @return the flipped card
    */
   public WarCard[] wager ()
   {
      WarCard wageredCard;
      WarCard[] flippedCard = new WarCard[2];
      int p1deckSize = p1Deck.getDeck().size();
      int p2deckSize = p2Deck.getDeck().size();

      // Check if Player 1 has enough cards for wager
      if (p1deckSize < 4) {
         // if player 1 has less then 4 cards in their hand
         if (p1deckSize == 0) { // player 1 has no cards left
            return null;
         }
         else {
            while (p1deckSize > 1) {
               wageredCard = p1Deck.getDeck().get(p1Deck.getDeck().size() - 1);
               p1Deck.getDeck().remove(wageredCard); // remove wagered cards from the deck
               tempDeck.getDeck().add(wageredCard); // add wagered cards to the temp deck
               p1deckSize--;
            }
            flippedCard[0] = flipCard(p1Deck); // player 1 flips a card 
         }
      }
      else {
         for (int i = 0; i < 3; i++) { // loop 3 times to wager 3 cards
            wageredCard = p1Deck.getDeck().get(p1Deck.getDeck().size() - 1);
            p1Deck.getDeck().remove(wageredCard);// remove wagered cards from the deck
            tempDeck.getDeck().add(wageredCard);// add wagered cards to the temp deck
         }
         flippedCard[0] = flipCard(p1Deck); // player 1 flips a card 
      }

      // Check if Player 2 has enough cards for wager
      if (p2deckSize < 4) {
         // if player 2 has less then 4 cards in their hand
         if (p2deckSize == 0) { // player 2 has no cards left
            return null;
         }
         else {
            while (p2deckSize > 1) {
               wageredCard = p2Deck.getDeck().get(p2Deck.getDeck().size() - 1);
               p2Deck.getDeck().remove(wageredCard); // remove wagered cards from the deck
               tempDeck.getDeck().add(wageredCard); // add wagered cards to the temp deck
               p2deckSize--;
            }
            flippedCard[1] = flipCard(p2Deck); // player 2 flips a card 
         }
      }
      else {
         for (int i = 0; i < 3; i++) { // loop 3 times to wager 3 cards
            wageredCard = p2Deck.getDeck().get(p2Deck.getDeck().size() - 1);
            p2Deck.getDeck().remove(wageredCard); // remove wagered cards from the deck
            tempDeck.getDeck().add(wageredCard); // add wagered cards to the temp deck
         }
         flippedCard[1] = flipCard(p2Deck); // player 2 flips a card 
      }
      return flippedCard;
   }

   /**
    * This method gets called from the main class to play a round of War.
    * The method checks if both players have cards, and then plays a round,
    * Once a player has all the cards in the deck they are declared the winner
    */
   @Override
   public void play ()
   {
      if (p1Deck.getDeck().isEmpty() || p2Deck.getDeck().isEmpty()) {
         declareWinner();
      }
      else {
         System.out.println("\nRound: " + round);
         round++;
         WarCard card1 = flipCard(p1Deck);
         System.out.println(this.player1 + " card is: " + card1);
         WarCard card2 = flipCard(p2Deck);
         System.out.println(this.player2 + " card is: " + card2);
         compareCards(card1, card2);
         System.out.println(this.player1 + " cards left: " + p1Deck.getDeck().size());
         System.out.println(this.player2 + " cards left: " + p2Deck.getDeck().size());
      }
   }

   /**
    * This method declares the winner.
    */
   @Override
   public void declareWinner ()
   {
      if (p1Deck.getDeck().isEmpty()) {
         System.out.println("\n--------------------------------------------------");
         System.out.println("\n\t\t" + this.player2 + " is the winner!");
         System.out.println("\n--------------------------------------------------");
      }
      else if (p2Deck.getDeck().isEmpty()) {
         System.out.println("\n--------------------------------------------------");
         System.out.println("\n\t\t" + this.player1 + " is the winner!");
         System.out.println("\n--------------------------------------------------");
      }
      gameOver = true;
   }
}
