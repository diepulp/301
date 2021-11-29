package abc;

import static abc.Operator.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ALUTest {

    ABCMachine abc = new ABCMachine("programs/program1.abc");

    //ALU tester
    @Test
    public void testOperate(){

        //test constructor
        assertEquals(Nzp.ZERO, abc.getAlu().getStatus());

        //test MULT
        short result =  abc.getAlu().operate((short) 2,MULT, (short)2 );
        assertEquals(result, (short)4);

        //test result
        short negative =  abc.getAlu().operate((short) 2,SUB, (short)3 );
        assertEquals(-1, negative);
        assertEquals(Nzp.NEGATIVE, abc.getAlu().getStatus());

        //test ADD
        assertEquals(4, abc.getAlu().operate((short) 2,MULT, (short)2 ));
        //test SUB
        assertEquals(0, abc.getAlu().operate((short) 2,SUB, (short)2 ));
        //testDIV
        assertEquals(1, abc.getAlu().operate((short) 2,DIV, (short)2 ));

    }


}