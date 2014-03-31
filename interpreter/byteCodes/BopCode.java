package byteCodes;
import interpreter.*;

public class BopCode extends ByteCode {
	public BopCode() {}
	public void init() {}
	public void exec(VirtualMachine vm) {print();}
	public void print() {
		System.out.println("BopCode");
	}	
}