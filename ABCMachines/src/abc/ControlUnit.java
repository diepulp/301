/*
 * Assignment: ABCMachine
 * Author: Susan Uland, Josh Archer, and yours truly to a certain extent, Vladimir Ivanov
 * Date: 11/28/21
 * File: ABCMachine.java*/
package abc;

/**
 * This class represents the Control Unit for the
 * ABC Machine
 *
 */
public class ControlUnit {

    private ABCMachine machine;

    /**
     * @param machine The ABC machine this ControlUnit belongs to
     */
    public ControlUnit(ABCMachine machine) {
        this.machine = machine;
    }

    /*
     * This method will continuously fetch, decode, execute, and store instructions/data that are
     * loaded into the ABCMachine's memory map. The program "halts" when it reaches an instruction
     * that is zero.
     */
    public void startProcessing() {

        while (!halt()) {
            fetch();
            decodeExecuteStore();
        }

    }

    /**
     *          This method performs the fetch step for the ControlUnit; accesses the memory address for the next
     *          instruction in RAM(memory array) (use the PC register);
     *          loads this instruction from memory into the Instruction Register  (IR);
     *          increment the Program Counter (PC) register
     */
    public void fetch() {
        // retrieve instruction from the memory array at pc index
        short instruction = machine.getMemory()[machine.getPc()];

        // set instruction into instruction register
        machine.setIr(instruction);

        // increment pc and set it into the pc register
        //pc++;
        //machine.setPc(++pc);
        machine.setPc((byte)(machine.getPc() + 1));
    }

    /**
     *      This method decodes and executes the instruction according to the
     *      ABCMachine Instruction Set and stores the result.
     */
    public void decodeExecuteStore() {
        // opcode values
        final short ADD=0,SUB=1,MULT=2,DIV=3,STORE=4,LOAD=5,BRANCH=6,JUMP=7;

        // get the registers needed for all instructions
        short[] reg = machine.getRegisters();

        // decode the instruction
        short src1 = isolateThreeBitsIR(10);
        short src2 = isolateThreeBitsIR(7);
        short dest = isolateThreeBitsIR(4);
        short opCode = isolateThreeBitsIR(13);

        // based on the opCode execute the correct action
        switch(opCode) {
            case ADD:
                 // add values in src1 and src2 registers and place sum in dest register
                reg[dest] = machine.getAlu().operate(reg[src1],Operator.ADD,reg[src2]);
                break;
            case SUB:
                reg[dest] = machine.getAlu()
                        .operate(reg[src1], Operator.SUB, reg[src2]);
                break;
            case MULT:
                //multiply the values is src1 * src2 and store at the dest reg
                reg[dest] = machine.getAlu()
                        .operate(reg[src1], Operator.MULT, reg[src2]);
                break;
            case DIV:
                reg[dest] = machine.getAlu()
                        .operate(reg[src1], Operator.DIV, reg[src2]);
                break;
            case STORE:
                machine.getMemory()[isolateAddressIR()] = reg[src1];
                break;
            case LOAD:
                // load from memory to a register
                reg[src1] = machine.getMemory()[isolateAddressIR()];
                break;

            case BRANCH:
                branch(src1);
                break;

            case JUMP:
              reg[machine.getPc()] = machine.getMemory()[isolateAddressIR()];
              break;

        } // end of switch

    }

    private short isolateThreeBitsIR(int shift){
        short ir = (short) (machine.getIr() >>> shift);
        return (short) (ir & 0b111);
    }

    private short isolateAddressIR(){
        return (short) (machine.getIr() & 0b1111);
    }

    // Branch program if and ALU status match
    private void branch(short nzp) {
        if ( nzp == 0b100 && machine.getAlu().getStatus() == Nzp.NEGATIVE ){
            // update the program counter to the address in the IR
            machine.setPc((byte) isolateAddressIR());

            // if nzp = 0b010 and status = Nzp.ZERO, branch
        }else if(nzp == 0b001 && machine.getAlu().getStatus() == Nzp.POSITIVE ){
            machine.setPc((byte) isolateAddressIR());

            // if nzp = 0b001 and status = Nzp.POSITIVE, branch
        }else if(nzp == 0b010 && machine.getAlu().getStatus() == Nzp.ZERO){
            machine.setPc((byte) isolateAddressIR());
        }



    }
    /**
     *
     * @return true if next instruction contains all zeros, otherwise false
     */
    public boolean halt() {
        return machine.getMemory()[machine.getPc()] == 0;
    }
}
