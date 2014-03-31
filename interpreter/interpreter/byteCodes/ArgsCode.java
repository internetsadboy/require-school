package interpreter.byteCodes;

public class ArgsCode extends ByteCode {
	public ArgsCode() {}
	public void init() {}
	public void exec() {print();}
	public void print() {
		System.out.println("ArgsCode");
	}	
}