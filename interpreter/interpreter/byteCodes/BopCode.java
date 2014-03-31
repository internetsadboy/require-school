package interpreter.byteCodes;

public class BopCode extends ByteCode {
	public BopCode() {}
	public void init() {}
	public void exec() {print();}
	public void print() {
		System.out.println("BopCode");
	}	
}