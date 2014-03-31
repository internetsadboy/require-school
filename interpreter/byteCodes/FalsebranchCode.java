package byteCodes;
import interpreter.*;

public class FalsebranchCode extends ByteCode {
	public FalsebranchCode() {}
	public void init() {}
	public void exec(VirtualMachine vm) {
		print();
	}
	public void print() {
		System.out.println("FalsebranchCode");
	}	
}