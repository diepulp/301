package abc;

public class ALU {

    private Nzp status; //holds Nzp.NEGATIVE, Nzp.ZERO, or Nzp.POSITIVE

    public ALU() {
        status = Nzp.ZERO;
    }

    //TODO: This method will perform a math operation on two numbers
    // and set the nzp status
    // appropriately based on whether the
    // math operation resulting in a postive, negative, or zero value

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
