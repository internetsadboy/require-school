package interpreter.byteCodes;

public class StoreCode extends ByteCode {
	public StoreCode() {}
	public void init() {}
	public void exec() {print();}
	public void print() {
		System.out.println("StoreCode");
	}	
}