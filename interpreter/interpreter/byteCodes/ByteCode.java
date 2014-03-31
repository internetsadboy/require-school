package interpreter.byteCodes;

import java.util.*;
import interpreter.*;

public abstract class ByteCode extends Object {
	protected StringTokenizer args;
	public ByteCode() {}
	public void print() {}
	public void init() {}
	public void exec(VirtualMachine vm) {}
}