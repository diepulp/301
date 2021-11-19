/*Assignment: Magic Squares
* Author: Vladimir Ivanov
* Date: 11/18/21
* File: Client.java
* */

import java.security.InvalidParameterException;
import java.util.Scanner;


/*
* Welcome to the game of Magic Squares
***********************************
Rules:
2 players play the game.
Each player takes turns picking a number from 1-9.
No number can be chosen twice
The first player to have 3 numbers that sum to 15 wins!
2 7 6
9 5 1
4 3 8
************************************/

/**
 * Magic Square game driver class
 * game starts with an array of bytes to create the game grid
 */
public class Client {
    public static void main(String[] args) {

        byte[] square = {2, 7, 6, 9, 5, 1, 4, 3, 8};

        //Initialize two MagicSquare objects for two players
        MagicSquare ms = new MagicSquare(square);
        MagicSquare ms2 = new MagicSquare(square);

        //players choices
        byte choice;
        byte choice2;

        //game intro helper method
        intro(ms);

        //prompt for player's names
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name for player #1 ");
        String player1 = sc.nextLine();
        System.out.println("Enter a name for player #2 ");
        String player2 = sc.nextLine();

        //boolean for an exit condition for a do while loop
        boolean cont;

        //game do-while loop
        do{
            //validate player 1 input
            choiceValid(player1, sc, ms, ms2);

           //check for the outcome
            if(!toCont(player1, ms)){
                break;
            }

           //validate player 2 input
           choiceValid(player2, sc, ms2, ms);

            //check for the outcome
           cont = toCont(player2, ms2);

        }while(cont);

    }// end of main

    /**
     *
     * @param player string player to provide
     * @param ms magic square object to retrieve given player's choices
     *        which are required to determine a winner
     * @return boolean based on the result for the main control loop
     */
    public static boolean toCont(String player, MagicSquare ms){

        //boolean variable
        boolean cont = true;
        if(result(ms.getChoices()) == 1){
            System.out.println(player + " won!");
            cont = false;
        }else if(result(ms.getChoices()) == 2){
            System.out.println("It's a draw");
            cont = false;
        }
        return cont;
    }//end toCont


    /**
     * method prints a welcome screen with a provided to the MagicSquare
     * object grid layout
     * @param ms MagicSquare object to retrieve the array of bytes for the grid
     */
    public static void intro(MagicSquare ms){

        //get the byte array
        byte[] square = ms.getSquare();

        //construct a welcome screen
        StringBuilder sb = new StringBuilder();
        sb.append("Welcome to the game of Magic Squares \n")
                .append("***********************************\n")
                .append("Rules: \n2 players play the game.\n" +
                        "Each player takes turns picking a number from 1-9.\n" +
                        "No number can be chosen twice\n" +
                        "The first player to have 3 numbers that sum to 15 wins!")
                .append(System.lineSeparator());
        for (int i = 0; i < square.length; i++) {
            if(i == 3 || i== 6){
                sb.append(System.lineSeparator());
            }
            sb.append(square[i] + " ");
        }
        sb.append("\n***********************************");
        System.out.println(sb);
    }//end intro

    /**
     * method checks the result based of player's inputs
     * @param choices short choices retrieved fro the MagicSquare object
     * @return integer, depending of the result retrieved from the MS object,
     * using binary "AND" operator: 1 for win, 2 for draw; 0 to continue the game
     */
    public static int result(short choices) {

        int outcome = 0;
        short draw = 511;//I haven't a clue how to calculate all the draw combinations

        //array of short in decimal representation to be &ed with the choices
        short[] victoryConditions = {98,273,140,266,84,161,146,56};
        for(short win : victoryConditions){
            if((choices & win) == win){
                outcome = 1;
                break;
            }else if((choices & draw) == draw){
                outcome = 2;
            }
        }
        return outcome;
    }//end result


    /**
     * Method validates players choices: no negatives and out of range (1-9) numbers
     * @param player String for a given player's name
     * @param sc Scanner object to prompt for choice re-entry in case vaidation fails
     * @param ms MagicSquare object to retrieve player 1 choices
     * @param ms2  MagicSquare object to retrieve player 2 choices
     * @return boolean
     */
    public static boolean choiceValid( String player, Scanner sc, MagicSquare ms, MagicSquare ms2){

        //exit condition for the do while loop
        boolean continueLoop = true;

        //declare a choice variable in to re-enter the choice if invalid
        byte choice;

        //do while validates the choices until valid
        do {
            try {
                System.out.println(player + " enter a number");
                choice = sc.nextByte();

                //validate the choice against both players choices
                if (ms.hasAlreadyChosen(choice) || ms2.hasAlreadyChosen(choice)) {
                    throw new InvalidParameterException();
                }

                //add it the array to the short of choices for a given player
                ms.choose(choice);

                //print the grid for a given player
                System.out.println(ms);

                //if valid exit the loop
                continueLoop = false;

                //catch exceptions
            } catch (InvalidParameterException i) {
                System.err.println("The number has already been chosen try again");
            } catch (IllegalArgumentException e) {
                System.err.println("Choice is out of range. Try again");
            }
        }while(continueLoop);
        return true;
    }
}//end choice valid