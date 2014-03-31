package byteCodes;
import interpreter.*;

// 'halts' execution, 0 args
public class HaltCode extends ByteCode {
	public HaltCode() {}
	public void init() {}
	public void exec(VirtualMachine vm) {}
	public void print() {
		System.out.println("HaltCode");
	}	
}