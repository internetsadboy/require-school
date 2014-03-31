package interpreter.byteCodes;

// pop top 'n' levels of runtime stack
// param {int} n, 1 arg 
public class PopCode extends ByteCode {
	public PopCode() {}
	public void init(int n) {
		
	}
	public void exec() {}
	public void print() {
		System.out.println("PopCode");
	}	
}