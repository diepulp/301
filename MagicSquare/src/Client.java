import java.security.InvalidParameterException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        byte[] square = {2, 7, 6, 9, 5, 1, 4, 3, 8};
        short selections;

        MagicSquare ms = new MagicSquare(square);
        MagicSquare ms2 = new MagicSquare(square);



        boolean continueLoop = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("PLayer one enter your name: ");
        String player1 = sc.nextLine();
        System.out.println("PLayer two enter your name: ");
        String player2 = sc.nextLine();

        byte choice1 = 0;
        byte choice2 = 0;

        System.out.println(ms.getSquare());


        while(true){
        do{
           try{
           //prompt for choice for player 1
           System.out.println(player1 + " ENTER YOUR CHOICE: ");
           choice1 = sc.nextByte();
           ms.choose(choice1);

           //print out the game board for player 1
           System.out.println(ms);

           //prompt for choice for player 1
           System.out.println(player2 + " ENTER YOUR CHOICE: ");
           choice2 = sc.nextByte();
           ms2.choose(choice2);

           //print out the game board for player 1
           System.out.println(ms2);

           //validate inputs
           }catch (InvalidParameterException i){
           System.err.println("The number has already been chosen try again");
           }
           catch(IllegalArgumentException e){
           System.err.println("Choice cannot be negative. Try again");
           }
           }while(continueLoop);

            //player1

            if(result(ms.getChoices()) == 1){
                System.out.println("Player " + player1 + " won");
                break;
            }else if(result(ms2.getChoices()) == 2){
                System.out.println("It is a draw");
                break;
            }

            if(result(ms2.getChoices()) == 1){
                System.out.println("Player " + player2 + " won");
                break;
            }else if(result(ms2.getChoices()) == 2){
                System.out.println("It is a draw");
                break;
            }
}


        //continue to check fo winning conditions after inputs are validated



    }// end of main

    //check for outcome
    public static int result(short choices) {

        int outcome = 0;
        short draw = 511;
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
    }



    public static void choiceValid(byte choice, String player, Scanner sc, MagicSquare ms, MagicSquare ms2){
        boolean continueLoop = true;

        do{
            try{

                //prompt for choice for the  player
                System.out.println(player + "enter a number");
                choice = sc.nextByte();
                ms.choose(choice);

                //print out the game board for the player
                System.out.println(ms);
                System.out.println(ms.getChoices());
                System.out.println(ms2.getChoices());


                continueLoop = false;


                //validate inputs
            }catch (InvalidParameterException i){
                System.err.println("The number has already been chosen try again");
            }
            catch(IllegalArgumentException e){
                System.err.println("Choice is out of range. Try again");
            }
        }while(continueLoop);

    }

}