package ca.sheridancollege.project;

import java.util.Scanner;

/*
 * Assignment: Deliverable 3
 */


/**
 * This Main class is used to play the game War
 *
 * @author Tiffany Truong, 2020
 * @modifier Man Shi, 2020
 * @modifier Angela Noble, 2020
 */
public class Main
{
   public static void main (String[] args)
   {

      War game1 = new War();
      Scanner scan = new Scanner(System.in);
      // Instantiate decks
      WarCardDeck mainDeck = new WarCardDeck();
      WarCardDeck p1Deck = new WarCardDeck();
      WarCardDeck p2Deck = new WarCardDeck();
      WarCardDeck tempDeck = new WarCardDeck();

      // Create and split the main deck
      mainDeck.generateMainDeck(mainDeck.getDeck()); // create the deck
      mainDeck.shuffle(); // shuffle the deck
      mainDeck.splitDeck(mainDeck, p1Deck, p2Deck); // split the deck into 2 decks

      // Set up decks for the war game
      game1.setP1Deck(p1Deck);
      game1.setP2Deck(p2Deck);
      game1.setTempDeck(tempDeck);


      System.out.println("------- This is " + game1.getGameName() + "! -------\n");

      System.out.println("Player 1, please type your name:");
      String playerName1 = scan.nextLine();
      game1.setPlayer1(playerName1);
      System.out.println("Player 2, please type your name:");
      String playerName2 = scan.nextLine();
      game1.setPlayer2(playerName2);

      // -------------- Play Each Round ------------
//        System.out.println("Type '1' to play");
//        int start = scan.nextInt();
//        if (start == 1) {
//           game1.play();
//        }
//        boolean keepPlaying = true;
//        while (keepPlaying) {
//         System.out.println("Flip Again? 1 = yes, 2= no");
//         int flipAgain = scan.nextInt();
//         if (flipAgain == 1) {
//            game1.play();
//            p1Deck.shuffle();
//            p2Deck.shuffle();
//         }
//         else {
//            break;
//         }
//      }  


      //-------------- Loop through game to see who wins ----------
      while (!game1.isGameOver()) {
         game1.play();
         p1Deck.shuffle();
         p2Deck.shuffle();
      }


   }
}
