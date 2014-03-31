package byteCodes;
import interpreter.*;

public class CallCode extends ByteCode {
	public CallCode() {	}
	public void init() {}
	public void exec(VirtualMachine vm) {print();}
	public void print() {
		System.out.println("CallCode");
	}	
}