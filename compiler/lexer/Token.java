package lexer;

/** <pre>
 *  The Token class records the information for a token:
 *  1. The Symbol that describes the characters in the token
 *  2. The starting column in the source file of the token and
 *  3. The ending column in the source file of the token
 *  </pre>
*/
public class Token {
  private int leftPosition,rightPosition,lineNum;
  private Symbol symbol;

/**
 *  Create a new Token based on the given Symbol
 *  @param leftPosition is the source file column where the Token begins
 *  @param rightPosition is the source file column where the Token ends
 *  @param lineNum is current source file line number
*/
  // i think pass current line value in order to print out current line value asked in # 5
  //  int lineNum, 
  public Token(int leftPosition, int rightPosition, Symbol sym) {
   this.leftPosition = leftPosition;
   this.rightPosition = rightPosition;
   //this.lineNum = lineNum;
   this.symbol = sym;
  }

  public Symbol getSymbol() {
    return symbol;
  }
  
  // i think adding line goes after right .. stuff
  /*public void print() {
    System.out.println(" " + symbol.toString() + 
                       " left:  " + leftPosition +
                       " right: " + rightPosition);
    return;
  }*/

  // returns the name of the symbol
  public String toString() {
    return symbol.toString();
  }
  
  // returns the starting index position of the token
  public int getLeftPosition() {
    return leftPosition;
  }
  
  // returns the ending index position of the token
  public int getRightPosition() {
    return rightPosition;
  }
  
  // returns the current line num
  //public int getLineNum() {
      //return lineNum;
  //}
/**
 *  @return the integer that represents the kind of symbol we have which
 *  is actually the type of token associated with the symbol
*/
  // returns the kind of token
  public Tokens getKind() {
    return symbol.getKind();
  }
}

