package interpreter.byteCodes;

public class LabelCode extends ByteCode {
	public LabelCode() {}
	public void init() {}
	public void exec() {print();}
	public void print() {
		System.out.println("LabelCode");
	}	
}