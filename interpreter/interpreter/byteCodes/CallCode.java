package interpreter.byteCodes;

public class CallCode extends ByteCode {
	public CallCode() {	}
	public void init() {}
	public void exec() {print();}
	public void print() {
		System.out.println("CallCode");
	}	
}