package interpreter.byteCodes;

public class FalsebranchCode extends ByteCode {
	public FalsebranchCode() {}
	public void init() {}
	public void exec() {
		print();
	}
	public void print() {
		System.out.println("FalsebranchCode");
	}	
}