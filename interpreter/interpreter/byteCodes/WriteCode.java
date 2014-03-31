package interpreter.byteCodes;

public class WriteCode extends ByteCode {
	public WriteCode() {}
	public void init() {}
	public void exec() {
		print();
	}
	public void print() {
		System.out.println("WriteCode");
	}	
}