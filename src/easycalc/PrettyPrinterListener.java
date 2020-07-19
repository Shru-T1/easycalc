/*
 * Shruti Sharma
 * Project 1 Part B
 * Programming Lang Concpts 045 (Dr Mei)
 */


package easycalc;

import easycalc.grammar.*;
import easycalc.grammar.EasyCalcParser.AddSubExprContext;
import easycalc.grammar.EasyCalcParser.AndExprContext;
import easycalc.grammar.EasyCalcParser.AssignStmtContext;
import easycalc.grammar.EasyCalcParser.DeclarContext;
import easycalc.grammar.EasyCalcParser.EqualExprContext;
import easycalc.grammar.EasyCalcParser.IdExprContext;
import easycalc.grammar.EasyCalcParser.IfExprContext;
import easycalc.grammar.EasyCalcParser.LessGrtrExprContext;
import easycalc.grammar.EasyCalcParser.LitExprContext;
import easycalc.grammar.EasyCalcParser.MulDivExprContext;
import easycalc.grammar.EasyCalcParser.OrExprContext;
import easycalc.grammar.EasyCalcParser.ParenExprContext;
import easycalc.grammar.EasyCalcParser.ProgramContext;
import easycalc.grammar.EasyCalcParser.ReadStmtContext;
import easycalc.grammar.EasyCalcParser.ToExprContext;
import easycalc.grammar.EasyCalcParser.WriteStmtContext;

import java.util.*;

import org.antlr.v4.runtime.ParserRuleContext;

public class PrettyPrinterListener extends EasyCalcBaseListener{
	
	private final StringBuilder sb = new StringBuilder();//everything is appended to this string builder which later returns the final output
	private final Stack<String> stack = new Stack<>();//Stack for temporary input and operation for later use

	public String getProgramString() {
		String fin = sb+"";
		return fin;
	}
	@Override public void exitProgram(EasyCalcParser.ProgramContext ctx) {

		sb.append("$$\n");//we need not forget to include the dollar sign at the end to mark that output has ended
		}
	
	@Override 
	public void exitDeclar(EasyCalcParser.DeclarContext ctx) {
		sb.append(ctx.type.getText()).append(" ").append(ctx.ID().getText()).append(";\n");
	}
	//ctx is the starting point. The method getText is an ending point. 
	@Override public void exitAssignStmt(EasyCalcParser.AssignStmtContext ctx) {
		String res = stack.pop();//popping the value which was input into the stack suing one of the operations below
		sb.append(ctx.ID().getText()).append(" ").append(":= ").append(res).append(" ;\n");
	}
	
	@Override public void exitReadStmt(EasyCalcParser.ReadStmtContext ctx) {
		sb.append("read ").append(ctx.ID().getText()).append(" ").append(";\n");//we simply append the value of the id with read
	}
	
	@Override public void exitWriteStmt(EasyCalcParser.WriteStmtContext ctx) { 
		String res = stack.pop();
		sb.append("write ").append(res).append(" ").append(";\n");//in case of write, we need the expression that we pushed into the stack using of the methods below
	}
	
	@Override public void exitLitExpr(EasyCalcParser.LitExprContext ctx) { 
		
		//everything in the stack is a string, everything is formatted. 
		stack.push(ctx.LIT().getText());// push LIT into the stack
	}
	
	@Override public void exitAndExpr(EasyCalcParser.AndExprContext ctx) { 
		String rt = stack.pop();//the first element that comes out of the stack is actually the last one to go in so it would be the right exp
		String lt = stack.pop();// then comes out the left exp because stack is LIFO
		String res = lt + " " + ctx.op.getText() + " " + rt;// we club it with the appropriate operation
		stack.push(res);//we push back the result for popping it out later for the final output
	}
	
	@Override public void exitLessGrtrExpr(EasyCalcParser.LessGrtrExprContext ctx) { 
		String rt = stack.pop();//refer the comments in exitAndExpr method
		String lt = stack.pop();
		String res = lt + " " + ctx.op.getText() + " " + rt;
		stack.push(res);
	}
	
	@Override public void exitEqualExpr(EasyCalcParser.EqualExprContext ctx) { 
		String rt = stack.pop();//refer the comments in exitAndExpr method
		String lt = stack.pop();
		String res = lt + " " + ctx.op.getText() + " " + rt;
		stack.push(res);
	}
	
	@Override public void exitIfExpr(EasyCalcParser.IfExprContext ctx) { 
		String rt = stack.pop();//refer the comments in exitAndExpr method
		String mid = stack.pop();
		String lt = stack.pop();
		String res = " if " + lt + " then " + mid + " else " + rt;
		stack.push(res);
	}
	
	@Override public void exitMulDivExpr(EasyCalcParser.MulDivExprContext ctx) { 
		String rt = stack.pop();//pop Right expr from the stack
		String lt = stack.pop();//pop left expr from the stack
		String res = lt + " " + ctx.op.getText() + " " + rt;//get the operator (similar to how you get type)
		stack.push(res);//push formatted expr into the stack
	}
	
	@Override public void exitIdExpr(EasyCalcParser.IdExprContext ctx) {
		stack.push(ctx.ID().getText());//we push the ID for popping it out later for our final expr
	}
	
	@Override public void exitToExpr(EasyCalcParser.ToExprContext ctx) {
		String str = stack.pop();
		if (str.charAt(0) == '(' && str.charAt(str.length()-1) == ')') {//we must set the condition such that we donot have multiple parenthesis
			stack.push( ctx.op.getText() + str );}//we put parenthesis only if it is not present before
		else {stack.push(ctx.op.getText() + "(" + str + ")"); } //we push in all into the result output
	}
	
	@Override public void exitParenExpr(EasyCalcParser.ParenExprContext ctx) { 
		String str = stack.pop();
		if (str.charAt(0) == '(' && str.charAt(str.length()-1) == ')') {//we must set the condition such that we donot have multiple parenthesis
			stack.push( str );}//we put parenthesis only if it is not present before
		else {stack.push("(" + str + ")"); } //we push in all into the result output
	}
	
	@Override public void exitAddSubExpr(EasyCalcParser.AddSubExprContext ctx) { 
		String rt = stack.pop();//refer the comments in exitAndExpr method
		String lt = stack.pop();
		String res = lt + " " + ctx.op.getText() + " " + rt;
		stack.push(res);
	}
	
	@Override public void exitOrExpr(EasyCalcParser.OrExprContext ctx) { 
		String rt = stack.pop();//refer the comments in exitAndExpr method
		String lt = stack.pop();
		String res = lt + " " + ctx.op.getText() + " " + rt;
		stack.push(res);
	}
	
}
