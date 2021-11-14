package test;

import abc.*;

import java.util.Arrays;

public class ABCDriver
{
	public static void main(String[] args)
	{
		//create a new ABCMachine and pass it a new program to run
		ABCMachine mach = new ABCMachine("programs/program1.abc");
		mach.runProgram();
		//print out the registers and memory after the program runs
		System.out.println("Register dump");
		mach.printRegisters();
		System.out.println("Memory dump");
		mach.printMemory();
		System.out.println(Arrays.toString(mach.getMemory()));
		System.out.println(mach.getAlu().getStatus());
	}
}
