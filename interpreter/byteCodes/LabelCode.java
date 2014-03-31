package byteCodes;
import interpreter.*;

public class LabelCode extends ByteCode {
	public LabelCode() {}
	public void init() {}
	public void exec(VirtualMachine vm) {print();}
	public void print() {
		System.out.println("LabelCode");
	}	
}