package byteCodes;
import interpreter.*;

public class ArgsCode extends ByteCode {
	public ArgsCode() {}
	public void init() {}
	public void exec(VirtualMachine vm) {
		print();
	}
	public void print() {
		System.out.println("ArgsCode");
	}	
}