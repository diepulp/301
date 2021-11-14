import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        byte[] square = {2, 7, 6, 9, 5, 1, 4, 3, 8};
        short selections;

        MagicSquare ms = new MagicSquare(square);
       /*   System.out.println(ms.choose((byte) 1));
          System.out.println(ms.choose((byte)1));
          System.out.println(ms.choose((byte)2));*/
        System.out.println(ms.choose((byte)4));
        System.out.println(ms.choose((byte)6));
        System.out.println(ms.choose((byte)5));
        MagicGame mg = new MagicGame("Barry", "Larry");
        System.out.println(mg.getMs().getChoices());



    /*    short choice = ms.getChoices();
        System.out.println(Integer.toBinaryString(choice));
        System.out.println();
         arrayString();
        System.out.println();
        System.out.println(ms.getChoices());
        System.out.println(Arrays.toString(ms.getSquare()));
        System.out.println(ms);
        System.out.println(ms.getChoices());*/

    }//new end of main
    public static void arrayString(){
        byte[] square = {2, 7, 6, 9, 5, 1, 4, 3, 8};
        for (int i = 0; i < square.length; i++) {
            if(i == 3 || i == 6){
                System.out.print(System.lineSeparator());
            }
            System.out.print(square[i] + " ");
        }

    }







/*

        selections = (short) choose(selections, choice);
        System.out.println(Integer.toBinaryString(selections));
        for (int i = 1; i < 9; i++) {
            choice++;
            selections = (short) choose(selections, choice);
        }

        System.out.println(Integer.toBinaryString(choice));

        System.out.println(Integer.toBinaryString(selections) + " " + choice);
        //toString template
        for(int i = 0; i < square.length; i++){
            if(8 == square[i]){
                System.out.print(square[i] + "@" + i);
            }else{
                System.out.print("_");
            }
        }
        System.out.println(Integer.SIZE + " " + Short.SIZE);

        System.out.println();
        String arrayString = arrayString();
        System.out.println();
        System.out.println(arrayString);

    }//end main


    public static int choose(short selections, short choice){
        short mask =(short)(1 << choice-1);
        selections = (short)(mask | selections);

        return selections;
    }
    public static String arrayString(){
        byte[] square = {2, 7, 6, 9, 5, 1, 4, 3, 8};
        for (int i = 0; i < square.length; i++) {
            if(i == 3 || i == 6){
                System.out.print(System.lineSeparator());
            }
            System.out.print("- ");
        }
        return "";
    }*/

}
