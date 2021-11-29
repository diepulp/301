/*
 * Assignment: ABCMachine
 * Author: Susan Uland, Josh Archer, and yours truly (to a certain extent), Vladimir Ivanov
 * Date: 11/28/21
 * File: ALU.java*/
package abc;

public class ALU {

    private Nzp status; //holds Nzp.NEGATIVE, Nzp.ZERO, or Nzp.POSITIVE

    public ALU() {
        status = Nzp.ZERO;
    }

    /**
     *     This method performs a math operation on two numbers
     *     and sets the nzp status
     *     appropriately based on whether the
     *     math operation resulting in a postive, negative, or zero value
     * @param num1 source register 1
     * @param operator enum for math operations
     * @param num2 source register 2
     * @return the result of calculations
     */

    public short operate(short num1, Operator operator, short num2) {
        short result = 0;

        switch (operator){
            case ADD:
                result = (short)(num1 + num2);
                break;
                // add others
            case SUB:
                result = (short)(num1 - num2);
                break;
            case MULT:
                result = (short)(num1 * num2);
                break;
            case DIV:
                result = (short)(num1 / num2);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }

        // remember to set nzp status if result is pos, zero, or neg

        if (result == 0){
            this.status = Nzp.ZERO;
        } else {
            this.status = (result < 0) ? Nzp.NEGATIVE : Nzp.POSITIVE;
        }

        return result;//answer to ADD, SUB, MULT, DIV

    }

    public Nzp getStatus(){
        return this.status;
    }
}
