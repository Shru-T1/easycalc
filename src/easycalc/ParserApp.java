package easycalc;

import java.util.Scanner;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import easycalc.grammar.*;

public class ParserApp {

    public static void main(String[] args) throws Exception {

        // ======================================================
        // Read in multiple lines of input
        // ======================================================
        
        StringBuilder sb = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        String nextLine = scan.nextLine();
        while (!nextLine.contains("$$")) {
            sb.append(nextLine);
            scan = new Scanner(System.in);
            nextLine = scan.nextLine();
        }
        scan.close();
        sb.append(nextLine);
        String str = sb.toString();
    
        // ======================================================
        // Create the parse tree from the input stream
        // ======================================================

        ANTLRInputStream input = new ANTLRInputStream(str);
        EasyCalcLexer lexer = new EasyCalcLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EasyCalcParser parser = new EasyCalcParser(tokens);
        ParseTree tree = parser.program(); // begin parsing at program rule

        // ======================================================
        // Print out the LISP-style tree
        // ======================================================
        
        System.out.println(tree.toStringTree(parser));
    }
}