package lexer;

import java.io.*;

/**
 *  This class is used to manage the source program input stream;
 *  each read request will return the next usable character; it
 *  maintains the source column position of the character
*/
public class SourceReader {
    private BufferedReader source;
    private int lineno = 0,   // line number of source program
                position;     // position of last character processed
    private boolean isPriorEndLine = true;  // if true then last character read was newline
                                            // so read in the next line
    private String nextLine;
    private String ram = "\n";

/**
 *  Construct a new SourceReader
 *  @param sourceFile the String describing the user's source file
 *  @exception IOException is thrown if there is an I/O problem
*/
    // source is a bufferedreader composed of the file arg
    public SourceReader(String sourceFile) throws IOException {
        source = new BufferedReader(new FileReader(sourceFile));
    }

    // close the bufferedreader (stream)
    void close() {
        try {
            source.close();
        } catch (Exception e) {}
    }

/**
 *  read next char; track line #, character position in line<br>
 *  return space for newline
 *  @return the character just read in
 *  @IOException is thrown for IO problems such as end of file
*/  
    // case 1: right before \n instance
    // if isPriorEndLine -> increment lineno (line #)
    //                   -> set position = -1
    //                   -> readLine() from bufferedreader stream and assing to nextLine
    //                   -> if nextLine != null -> print nextLine (printing 'x' code statement)
    //                   -> isPriorEndLine = false
    // case 2: nextLine == null -> throw io exception
    // case 3: nextLine.length() == 0 -> indicates \n values in between/before/after x code -> isPEL = true
    // increment position
    // case 4: if position >= nextLine.length() -> isPEL = true
    // desired fxnality = return nextLine.charAt(position) -> return char at indexed position of newline string
    public char read() throws IOException {
        if (isPriorEndLine) {
            lineno++;
            position = -1;
            nextLine = source.readLine();
            if(nextLine != null) {
                ram += lineno + ". " + nextLine + "\n";
            } else {
                System.out.println(ram);
            }
            isPriorEndLine = false;
        }
        if (nextLine == null) {  // hit eof or some I/O problem
            throw new IOException();
        }
        if (nextLine.length() == 0) {
            isPriorEndLine = true;
            return ' ';
        }
        position++;
        if (position >= nextLine.length()) {
            isPriorEndLine = true;
            return ' ';
        }
        return nextLine.charAt(position);
    }

/**
 *  @return the position of the character just read in
*/
    public int getPosition() {
        return position;
    }
    
    public String getNextLine() {
        return nextLine;
    }
/**
 *  @return the line number of the character just read in
*/
    public int getLineno() {
        return lineno;
    }
    
    public String getRam() {
        return ram;
    }

}