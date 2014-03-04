package lexer;

/**
 *  The Symbol class is used to store all user strings along with
 *  an indication of the kind of strings they are; e.g. the id "abc" will
 *  store the "abc" in name and Sym.Tokens.Identifier in kind
*/
public class Symbol {
  private String name;
  private Tokens kind;   // token kind of symbol

  private Symbol(String n, Tokens kind) {
    name = n;
    this.kind = kind;
  }

  // symbols contains all strings in the source program
  private static java.util.HashMap<String,Symbol> symbols = new java.util.HashMap<String,Symbol>();

  public String toString() {
  return name;
  }

  public Tokens getKind() {
    return kind;
  }

  /**
   * Return the unique symbol associated with a string.
   * Repeated calls to <tt>symbol("abc")</tt> will return the same Symbol.
   */
  public static Symbol symbol(String newTokenString, Tokens kind) {
        // returns value associated with the key 'newTokenString' in the hashmap<String,Symbol> symbols
  Symbol s = symbols.get(newTokenString);
        // if s == null then newTokenString dne in hashmap symbols
        // if token of type bogustoken -> return null
        // else create a new symbol
        // add symbol the symbols hashmap
  if (s == null) {
      if (kind == Tokens.BogusToken) {  // bogus string so don't enter into symbols
          return null;
      }
      // System.out.println("new symbol: "+u+" Kind: "+kind);
            // create new Symbol(name of token, kind of token)
            // add new symbol to the hash
            s = new Symbol(newTokenString,kind);
            symbols.put(newTokenString,s);
  }
  return s;
  }
}

