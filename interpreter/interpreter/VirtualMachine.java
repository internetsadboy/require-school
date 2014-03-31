package interpreter;

import java.util.*;
import interpreter.byteCodes.*;

public class VirtualMachine {
	
	private int pc;
	private RunTimeStack runStack;
	private Stack returnAddrs;
	private boolean isRunning;
	private Program program;

	public VirtualMachine(Program prog) {
		program = prog;
	}
	
	public void executeProgram() {
		pc = 0;
		runStack = new RunTimeStack();
		returnAddrs = new Stack();
		isRunning = true;
		while(isRunning) {
			ByteCode code = program.getCode(pc);
			code.exec(this);
			pc++;
		}

	}
}