package interpreter;

import byteCodes.*;
import java.util.*;
import java.io.*;


// bcl will load the bytecodes from the file into the VM
// read each bytecode statement
// build an instance of the each corresponding bytecode
// add each bytecode class instance to the Program obj
public class ByteCodeLoader extends Object {
	
	private String srcFile = "";

	public ByteCodeLoader(String programFile) throws IOException {
		srcFile = System.getProperty("user.dir")+"/"+programFile;
	}

	// read in src
	// tokenize
	// fetch bytecode for each line
	// create corresponding instance
	// tokenize the args 
	// add the args to a vector
	// return program obj containing bytecode class instances
	public Program loadCodes() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		BufferedReader in = new BufferedReader(new FileReader(srcFile));
		String line = null;
		Vector<ByteCode> byteCodeInstances = new Vector<ByteCode>();
		Vector<Vector<String>> byteCodeStatements = new Vector<Vector<String>>();

		// we want to resolved the bc addresses (by program)
		// we want to eventually init each bc
		// we want to add each bc instance to program
	
		while((line = in.readLine()) != null) {

			// tokenize each line
			// add each token from line into temp vector
			// add each bc statment vector into bc statements vector
			// vector will be used in program to resolve addresses
			StringTokenizer byteCodeTokens = new StringTokenizer(line);
			Vector<String> tempByteCodeStatement = new Vector<String>();
			while(byteCodeTokens.hasMoreTokens()) {
				tempByteCodeStatement.add(byteCodeTokens.nextToken());
			}
			byteCodeStatements.add(tempByteCodeStatement);
	
			
			// get bytecode name from current vector statment, static position 0 e.g. get(0) == HALT
			// fetch bytecode classname from CodeTable
			// create instance of current bytecode
			// add bc instance to vector that will be used as one of Program's fields
			String bytecode = tempByteCodeStatement.get(0);
			CodeTable codetable = new CodeTable();
			String codeClass = codetable.get(bytecode);
			ByteCode bc = (ByteCode)(Class.forName("byteCodes."+codeClass).newInstance());
			byteCodeInstances.add(bc);

			// should init bytecodes w/ Vector of string args 
			// bc.init(byteCodeStatements);
		}

		Program prg = new Program();
		prg.setByteCodeInstances(byteCodeInstances);
		prg.setByteCodeFile(byteCodeStatements);
		prg.resolveAddresses();
		return prg;
	}
}