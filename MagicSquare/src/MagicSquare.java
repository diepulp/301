import java.util.Arrays;

public class MagicSquare {
    private byte[] square;
    private short choices;

    public MagicSquare(byte[] square) {
        this.square = square;
    }

    /**
     * Expects a selection between 1-9 (inclusive) and throws an IllegalArgumentException if
     * the selection is less than 1 or greater than 9. This method then checks if the selection
     * has already been chosen.  If the selection has already been chosen, then the method
     * returns false, otherwise it will set the bit at the index selection - 1 to "on" and
     * return true.
     *
     * @param selection
     * @return
     */
    public boolean choose(byte selection) {
        //set method from bit array class
        //calls hasAlreadyChosen() method
        //checks for IllegalArgumentException(1-9)
        //checks whether the number has already been chosen...
        //if chosen returns false
        //else sets the bit and returns true

        if (selection < 1 || selection > 9) {
            throw new IllegalArgumentException();
        }

        if (hasAlreadyChosen(selection)) {
            return false;
        }

        short mask = (short) (1 << selection - 1);
        choices = (short) (mask | choices);

        return true;
    }

    /**
     * Returns true if the bit at index selection - 1 is set to the "on" position, or false if
     * the bit is in the "off" position.
     * returns true is a selection has been chosen by another player
     *
     * @param index byte from a choices short
     * @return boolean
     */
    public boolean hasAlreadyChosen(byte index) {
        short mask = (short) (1 << index - 1);
        return (mask & choices) == mask;
    }

    public short getChoices() {
        return this.choices;
    }

    public byte[] getSquare() {
        return this.square;
    }

    public String toString() {

        String result = "";
        /*char[] chars = result.toCharArray();*/
        for (int i = 0; i < square.length; i++) {
            if(i == 3 || i== 6){
               result += System.lineSeparator();
            }
            if (hasAlreadyChosen((byte)(i + 1))) {
                result += square[i] + " ";
            }else{
                result += "_ ";
            }
        }
        return result;
    }

}
