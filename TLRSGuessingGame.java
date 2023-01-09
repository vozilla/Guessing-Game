// Name: Tuan Le & Ronin Sloan
// Class: CS &145
// Assignment: Lab 1 -- Guessing Game Remake
// Purpose: Runs a guessing game

import java.util.*;

public class TLRSGuessingGame {

   public static void main(String[] args) {
      menu();
   }
   public static void menu() {
      // initialize values2
      int totalGames = 0;
      int currentGameCount = 0;
      int totalGuessCount = 0;
      int bestGuess = 99999;
      // asks if you want to play a game
      Scanner input = new Scanner(System.in);
      System.out.println("Would You Like to Play a Guessing Game? ");
      System.out.println("Input 1 for Yes, Input 2 for No.");
      int gameConfirm = input.nextInt();
      if (gameConfirm != 1) {
         return;
      }
      // asks if you want instructions
      System.out.println("Would You Like Instructions?");
      System.out.println("Input 1 for Yes, Input 2 for No.");
      int helpConfirm = input.nextInt();
      if (helpConfirm == 1) {
         instructions();
      }
      // game while loop
      while (gameConfirm == 1) {
         totalGames++;
         currentGameCount = playGame();
         totalGuessCount += currentGameCount;
         // replay system
         System.out.println("Would you like to replay?");
         System.out.println("Input 1 for Yes, Input 2 for No.");
         gameConfirm = input.nextInt();
         // changes best guess to lowest guess count
         if (currentGameCount < bestGuess) {
            bestGuess = currentGameCount;
         }
      }
      results(totalGames, totalGuessCount, bestGuess);
   }
   // instructions method
   public static void instructions() {
      System.out.println("The goal of the game is to...");
      System.out.println("guess what number I am thinking of.");
      System.out.println("My number is always from 1-100.");
      System.out.println("I will tell if your number is...");
      System.out.println("higher of lower than mine.");
      System.out.println("Are You Ready? Enter Anything.");
      Scanner input2 = new Scanner(System.in);
      int fillerInput = input2.nextInt();
   } // end of instructions method
   // playGame method
   public static int playGame() {
      // initialize values
      int currentGuess;
      int winCondition = 0;
      int guessCount = 0;
      
      Random rand = new Random();
      int randomNumber = rand.nextInt(100) + 1;
      System.out.println("I'm thinking of a number...");
      // as long as winCondition isn't met, it replays the game
      while (winCondition == 0) {
         Scanner input3 = new Scanner(System.in);
         currentGuess = input3.nextInt();
         if (currentGuess < randomNumber) {
            System.out.println("The number I'm thinking of is higher.");
         }
         else if (currentGuess > randomNumber) {
            System.out.println("The number I'm thinking of is lower.");
         }
         else if (currentGuess == randomNumber) {
            System.out.println("You got the correct number!");
            winCondition = 1;
         }
         guessCount++;
      }
      return guessCount;
   } // end of playGame method
   // results method
   public static void results(int totalGames, int totalGuessCount, int bestGuess) {
      double averageGuesses = totalGuessCount / totalGames;
      System.out.println("Results:");
      System.out.println("Total Games: " + totalGames);
      System.out.println("Total Guesses: " + totalGuessCount);
      System.out.println("Best Game: " + bestGuess + " Guesses");
      System.out.println("Average Guesses per Game: " + averageGuesses);
   } // end of results method
} // end of TLRSGuessingGame
