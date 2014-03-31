package byteCodes;
import interpreter.*;

public class GotoCode extends ByteCode {
	public GotoCode() {}
	public void init() {}
	public void exec(VirtualMachine vm) {}
	public void print() {
		System.out.println("GotoCode");
	}	
}