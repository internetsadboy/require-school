package lexer.setup;

import java.util.*;
import java.io.*;

/**
 * TokenSetup class is used to read the tokens from file <i>tokens</i>
 * and automatically build the 2 classes/files <i>TokenType.java</i>
 * and <i>Sym.java</i><br>
 * Therefore, if there is any change to the tokens then we only need to modify
 * the file <i>tokens</i> and run this program again before using the compiler
 */
public class TokenSetup {

    private String type, value; // token type/value for new token
    private int tokenCount = 0;
    private BufferedReader in;
    private PrintWriter table, symbols; // files used for new classes
    
    
    public static void main(String args[]) {
        new TokenSetup().initTokenClasses();
    }

    // print out user's cwd via getProperty(user.dir)
    // create file seperator / to manipulate/navigate paths
    // in = lexer/setup/tokens -> tokens file to be read
    // table = lexer/TokenType.java -> printstream containing outputstream -> generate class TokenType
    // symbols = lexer/Tokens.java -> printstream containing outputstream -> generate class Tokens
    TokenSetup() {
        try {
            String sep = System.getProperty("file.separator");
            System.out.println("User's current working directory: " + System.getProperty("user.dir"));
            //String sep = System.getProperty("file.separator");
            in = new BufferedReader(new FileReader("lexer" + sep + "setup" + sep + "tokens"));
            System.out.println("User's current working directory: " + System.getProperty("user.dir") + "/lexer" + sep + "setup" + sep + "tokens");
            table = new PrintWriter(new FileOutputStream("lexer" + sep + "TokenType.java"));
            System.out.println("User's current working directory: " + System.getProperty("user.dir") + "/lexer" + "/TokenType.java");
            symbols = new PrintWriter(new FileOutputStream("lexer" + sep + "Tokens.java"));
            System.out.println("User's current working directory: " + System.getProperty("user.dir") + "/lexer" + "/Tokens.java");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * read next line which contains token information;<br>
     * each line will contain the token type used in lexical analysis and the
     * print string of the token: e.g.<br><ul>
     * <li>Program program</li>
     * <li>Int int</li>
     * <li>BOOLean boolean</li></ul>
     */
    // in(readstream which reads tokens file)
    // read the file line by line
    // fetch first element in line (type of token) -> assign to type var
    // fetch next element in line (value of token) -> assign to value var
    // throw exceptions when necessary
    // increment tokenCount
    public void getNextToken() throws IOException {
        try {
            StringTokenizer st = new StringTokenizer(in.readLine());

            type = st.nextToken();
            value = st.nextToken();
            System.out.println(type + " " + value);
        } catch (NoSuchElementException e) {
            System.out.println("***tokens file does not have 2 strings per line***");
            System.exit(1);
        } catch (NullPointerException ne) {
            // attempt to build new StringTokenizer when at end of file
            throw new IOException("***End of File***");
        }
        tokenCount++;
    }

    /**
     * initTokenClasses will create the 2 files
     */
    // table = TokenType.java
    // symbol = Token.java
    public void initTokenClasses() {

        // adding static content to TokenType.java
        table.println("package lexer;");
        table.println(" ");
        table.println("/**");
        table.println(" *  This file is automatically generated<br>");
        table.println(" *  it contains the table of mappings from token");
        table.println(" *  constants to their Symbols");
        table.println("*/");
        table.println("public class TokenType {");
        table.println("   public static java.util.HashMap<Tokens,Symbol> tokens = new java.util.HashMap<Tokens,Symbol>();");
        table.println("   public TokenType() {");

        // adding static content to Token.java
        symbols.println("package lexer;");
        symbols.println(" ");
        symbols.println("/**");
        symbols.println(" *  This file is automatically generated<br>");
        symbols.println(" *  - it contains the enumberation of all of the tokens");
        symbols.println("*/");
        symbols.println("public enum Tokens {");
        symbols.print("  BogusToken");

        // getNextToken fetches new token type and value (line by line)
        // the key value store 'tokens' is a hashmap<Tokens,Symbol>
        while (true) {
            try {
                getNextToken();
            } catch (IOException e) {
                break;
            }

            // create Tokens.type e.g. Tokens.Program
            String symType = "Tokens." + type;

            // add tokens.put(Tokens.Program, Symbol.symbol("program",Tokens.Program))
            // "tokens.put(symType, Symbol.symbol(""+value+","+symType+"))"
            table.println("     tokens.put(" + symType
                    + ", Symbol.symbol(\"" + value + "\"," + symType + "));");

            // every 5 tokens print ,\n
            // else print , after each token
            if (tokenCount % 5 == 0) {
                symbols.print(",\n    " + type);
            } else {
                symbols.print("," + type);
            }
        }

        // end TokenType.java printwriter (stream)
        table.println("   }");
        table.println("}");
        table.close();

        // end Tokens.java printwriter (stream)
        symbols.println("\n}");
        symbols.close();

        // close bufferedreader (tokens file) 
        try {
            in.close();
        } catch (Exception e) {
        }
    }
}