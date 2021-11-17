
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MagicSquareTest {

    private static byte[] selections = {2, 7, 6, 9, 5, 1, 4, 3, 8};
    private static final short[] CHOICES = {0b0_0000_0010,
            0b0_0100_0010,
            0b0_0110_0010,
            0b1_0110_0010,
            0b1_0111_0010,
            0b1_0111_0011,
            0b1_0111_1011,
            0b1_0111_1111,
            0b1_1111_1111};

    // Tests whether the numbers were added to choices
    @Test
    public void testGetChoices(){
        MagicSquare ms = new MagicSquare(selections);
        for (byte i = 0; i < selections.length; i++) {
            ms.choose(selections[i]);
        }
        //511 is 0b11111111
        assertEquals(511, ms.getChoices());

    }
    
    // Tests the getter to return the provided array
    @Test
    public void testGetSquare(){
        MagicSquare ms = new MagicSquare(selections);
        byte[] bytes = ms.getSquare();
        assertArrayEquals(bytes, selections);
    }

    //Returns true if the number has been selected
    @Test
    public void testHasAlreadyChosen(){
        MagicSquare ms = new MagicSquare(selections);
        ms.choose((byte)2);
        assertTrue("incorrectly returned false", ms.hasAlreadyChosen((byte)2));
    }
    
    @Test
    public void testPrintChoicesEmptySquare() {
        MagicSquare ms = new MagicSquare(selections);


        // redirect output from console window into a PrintStream
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // invoke toString() which now prints to the PrintStream instead of the console window
        System.out.println(ms);

        String expectedConsoleOutput = "_ _ _ "+ System.lineSeparator()+"_ _ _ "+System.lineSeparator()+"_ _ _ "+System.lineSeparator();
        assertEquals("print choices incorrect output", expectedConsoleOutput, out.toString());

    }

    @Test
    public void testChoose() {

        MagicSquare sq = new MagicSquare(selections);

        // for every selection choice in values array
        for (int i = 0; i < selections.length; i++) {

            // choose num
            sq.choose((byte) selections[i]);

            // verify that getChoices returns proper cummulative selections
            assertEquals("choice was noted incorrectly", CHOICES[i], sq.getChoices());

        }
    }



    @Test(expected = IllegalArgumentException.class)
    public void testInvalidChoice() {
        MagicSquare ms = new MagicSquare(selections);
        ms.choose((byte) -7);
        ms.choose((byte) 0);
        ms.choose((byte) 10);
    }

    @Test
    public void testPrintChoicesFullSquare() {
        MagicSquare ms = new MagicSquare(selections);

        // choose every selection in the values array
        for (byte selection : selections) {
            ms.choose((byte) selection);
        }

        // redirect output from console window into a PrintStream
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // invoke toString() which now prints to the PrintStream instead of the console window
        System.out.println(ms);

        String expectedConsoleOutput = "2 7 6 "+
                System.lineSeparator()+"9 5 1 "+
                System.lineSeparator()+"4 3 8 "+
                System.lineSeparator();

        assertEquals("print choices incorrect output", expectedConsoleOutput, out.toString());

    }


}