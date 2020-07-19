package easycalc;

import java.util.*;
import easycalc.grammar.*;
import org.antlr.v4.runtime.*;

public class AnalysisListener extends EasyCalcBaseListener{

	private final Stack <Type> stack = new Stack<>();
	private final List<String> errorList = new ArrayList<>();
	private final SortedMap<String, Type> symbolTable = new TreeMap<>();
	
	private static enum Type{
		BOOL,
		INT,
		REAL,
		ANY;
	}
	
	public String getSymbolTableString() {
		String symTab = "";
		Set s = symbolTable.entrySet();
		Iterator i = s.iterator();
		while (i.hasNext()) {
			Map.Entry m = (Map.Entry)i.next(); 
			String id = (String)m.getKey(); 
            Type type = (Type)m.getValue(); 
            symTab = symTab +"\n"+ id + " -> " + type + "\n";
		}
		
		return symTab;
	}
	
	public String getErrorMessageString() {
		StringBuilder sb = new StringBuilder();

        for(String s : errorList) {

            sb.append(s + "\n");

        }

        return sb.toString();
	}
	

	@Override 
	public void exitDeclar(EasyCalcParser.DeclarContext ctx) {
		String varType = ctx.type.getText();//??
		String varId = ctx.ID().getText();
		if(symbolTable.containsKey(varId)) {
			addRedefIdErr(varId, ctx.getStart());			
		} else {
			String v = ctx.type.getText().toUpperCase();
			if (v.equals("INT")) {
				symbolTable.put(varId, Type.INT);
				stack.push(Type.INT);
			}if (v.equals("BOOL")) {
				symbolTable.put(varId, Type.BOOL);
				stack.push(Type.BOOL);
			}if (v.equals("REAL")) {
				symbolTable.put(varId, Type.REAL);
				stack.push(Type.REAL);
			}
		}
		
	}

	@Override public void exitAssignStmt(EasyCalcParser.AssignStmtContext ctx) {
		Type asSt = stack.pop();
		if (asSt.equals(Type.ANY)) {
			stack.push(Type.ANY);
			return;
		}
		String id = ctx.ID().getText();
		if (symbolTable.containsKey(id)) {
			Type type = symbolTable.get(id);
			if (!asSt.equals(type)) {
				addTypeClashErr(ctx.getStart());
				stack.push(Type.ANY);
			}else {
				stack.push(asSt);
			}
		} else {
			addUndefIdErr(id, ctx.getStart());
		}
	}
	
	@Override public void exitReadStmt(EasyCalcParser.ReadStmtContext ctx) {
		Type Wstr = stack.pop();
		stack.push(Wstr);
	}
	
	@Override public void exitWriteStmt(EasyCalcParser.WriteStmtContext ctx) {
	Type Rstr = stack.pop();
	stack.push(Rstr);
	}
	
	@Override public void exitLitExpr(EasyCalcParser.LitExprContext ctx) { 
		String litStr = ctx.LIT().getText();
		if (litStr.equals("true")||litStr.equals("false")) {
			stack.push(Type.BOOL);
			return;
		}
		for (int i = 0; i<litStr.length();i++)
			if(litStr.charAt(i) == '.') {
				stack.push(Type.REAL);
				return;
			}
		stack.push(Type.INT);
	}
	
	@Override public void exitAndExpr(EasyCalcParser.AndExprContext ctx) {
		Type rType = stack.pop();
		Type lType = stack.pop();
		if(lType.equals(Type.ANY) || rType.equals(Type.ANY)) {
			stack.push(Type.ANY);
			return;
		}
		if(lType.equals(Type.INT)) {
			addArgErr(ctx.op, ctx.expr(0).getStart(), lType);
			stack.push(Type.ANY);
			return;
		}
		if(lType.equals(Type.REAL)) {
			addArgErr(ctx.op, ctx.expr(0).getStart(), lType);
			stack.push(Type.ANY);
			return;
		}
		if(rType.equals(Type.INT)) {
			addArgErr(ctx.op, ctx.expr(1).getStart(), rType);
			stack.push(Type.ANY);
			return;
		}
		if(rType.equals(Type.REAL)) {
			addArgErr(ctx.op, ctx.expr(1).getStart(), rType);
			stack.push(Type.ANY);
			return;
		}
		if(!lType.equals(rType)) {
			addTypeClashErr(ctx.getStart());
			stack.push(Type.ANY);
			return;
		}
		stack.push(lType);
		
	}
	
	@Override public void exitLessGrtrExpr(EasyCalcParser.LessGrtrExprContext ctx) { 
		Type rtype = stack.pop();
		Type ltype = stack.pop();
		if (ltype.equals(Type.ANY)||rtype.equals(Type.ANY)){
			stack.push(Type.ANY);
			return;
		}
		if (ltype.equals(Type.BOOL)) {
			addArgErr(ctx.op, ctx.expr(0).getStart(), ltype);
			stack.push(Type.ANY);
			return;
		}
		
		if (rtype.equals(Type.BOOL)) {
			addArgErr(ctx.op, ctx.expr(1).getStart(), rtype);
			stack.push(Type.ANY);
			return;
		}
		if (!ltype.equals(rtype)) {
			addTypeClashErr(ctx.getStart());
			stack.push(Type.ANY);
			return;
		}
		stack.push(ltype);
	
	
	}
	
	@Override public void exitEqualExpr(EasyCalcParser.EqualExprContext ctx) { 
		Type rType = stack.pop();
		Type lType = stack.pop();
		if(lType.equals(Type.ANY) || rType.equals(Type.ANY)) {
			stack.push(Type.ANY);
			return;
		}
		if(lType.equals(Type.INT)) {
			addArgErr(ctx.op, ctx.expr(0).getStart(), lType);
			stack.push(Type.ANY);
			return;
		}
		if(lType.equals(Type.REAL)) {
			addArgErr(ctx.op, ctx.expr(0).getStart(), lType);
			stack.push(Type.ANY);
			return;
		}
		if(rType.equals(Type.INT)) {
			addArgErr(ctx.op, ctx.expr(1).getStart(), rType);
			stack.push(Type.ANY);
			return;
		}
		if(rType.equals(Type.REAL)) {
			addArgErr(ctx.op, ctx.expr(1).getStart(), rType);
			stack.push(Type.ANY);
			return;
		}
		if(!lType.equals(rType)) {
			addTypeClashErr(ctx.getStart());
			stack.push(Type.ANY);
			return;
		}
		stack.push(lType);
		
	
	}
	
	
	
	@Override public void exitIfExpr(EasyCalcParser.IfExprContext ctx) { 
		Type elSt = stack.pop();
		Type thSt = stack.pop();
		Type ifSt = stack.pop();
		if (ifSt.equals(Type.ANY) || thSt.equals(Type.ANY) || elSt.equals(Type.ANY)) {
			stack.push(Type.ANY);
			return;
		}
		if (!ifSt.equals(Type.BOOL)) {

			int line = ctx.expr(0).getStart().getLine();
			int pos = ctx.expr(0).getStart().getCharPositionInLine() + 1;
			String err = "if undefined for " + ifSt + " at " + line + ":"+ pos ;
			errorList.add(err);
			stack.push(Type.ANY);
			return;
		}
		if(!thSt.equals(elSt)) {
			addTypeClashErr(ctx.expr(1).getStart());
			stack.push(Type.ANY);
			return;
		}
		stack.push(thSt);
	}
	
	
	@Override public void exitMulDivExpr(EasyCalcParser.MulDivExprContext ctx) { 
		Type rtype = stack.pop();
		Type ltype = stack.pop();
		if (ltype.equals(Type.ANY)||rtype.equals(Type.ANY)){
			stack.push(Type.ANY);
			return;
		}
		if (ltype.equals(Type.BOOL)) {
			addArgErr(ctx.op, ctx.expr(0).getStart(), ltype);
			stack.push(Type.ANY);
			return;
		}
		
		if (rtype.equals(Type.BOOL)) {
			addArgErr(ctx.op, ctx.expr(1).getStart(), rtype);
			stack.push(Type.ANY);
			return;
		}
		if (!ltype.equals(rtype)) {
			addTypeClashErr(ctx.getStart());
			stack.push(Type.ANY);
			return;
		}
		stack.push(ltype);
	}
	
	@Override public void exitIdExpr(EasyCalcParser.IdExprContext ctx) {
		String id = ctx.ID().getText();
		if(symbolTable.containsKey(id)) {
			Type type = symbolTable.get(id);
			stack.push(type);
		} else {
			addUndefIdErr(id,ctx.getStart());
		}
	}
	
	@Override public void exitToExpr(EasyCalcParser.ToExprContext ctx) {
		Type toExp = stack.pop();
		if (toExp.equals(Type.ANY)) {
			stack.push(Type.ANY);
			return;
		}
		String operator = ctx.op.getText();
		if(operator.equals("to_int")) {
			if(!toExp.equals(Type.REAL)) {
				addArgErr(ctx.op, ctx.expr().getStart(), toExp);
				stack.push(Type.ANY);
				return;
			}
		}
		if(operator.equals("to_real")) {
			if(!toExp.equals(Type.INT)) {
				addArgErr(ctx.op, ctx.expr().getStart(), toExp);
				stack.push(Type.ANY);
				return;
			}
		}
	}
	
	@Override public void exitParenExpr(EasyCalcParser.ParenExprContext ctx) { 
		
	}
	
	@Override public void exitAddSubExpr(EasyCalcParser.AddSubExprContext ctx) { 
		Type rtype = stack.pop();
		Type ltype = stack.pop();
		if (ltype.equals(Type.ANY)||rtype.equals(Type.ANY)){
			stack.push(Type.ANY);
			return;
		}
		if (ltype.equals(Type.BOOL)) {
			addArgErr(ctx.op, ctx.expr(0).getStart(), ltype);
			stack.push(Type.ANY);
			return;
		}
		
		if (rtype.equals(Type.BOOL)) {
			addArgErr(ctx.op, ctx.expr(1).getStart(), rtype);
			stack.push(Type.ANY);
			return;
		}
		if (!ltype.equals(rtype)) {
			addTypeClashErr(ctx.getStart());
			stack.push(Type.ANY);
			return;
		}
		stack.push(ltype);
	}
	
	@Override public void exitOrExpr(EasyCalcParser.OrExprContext ctx) { 
		 
		Type rtype = stack.pop();
		Type ltype = stack.pop();
		if (ltype.equals(Type.ANY)||rtype.equals(Type.ANY)){
			stack.push(Type.ANY);
			return;
		}
		if (!ltype.equals(Type.BOOL)) {
			addArgErr(ctx.op, ctx.expr(0).getStart(), ltype);
			stack.push(Type.ANY);
			return;
		}
		
		if (!rtype.equals(Type.BOOL)) {
			addArgErr(ctx.op, ctx.expr(1).getStart(), rtype);
			stack.push(Type.ANY);
			return;
		}

		
		stack.push(ltype);
	}
	
	public void addArgErr(Token optrToken, Token opndToken, Type type) {
		String tokenStr = optrToken.getText();
		int line = opndToken.getLine();
		int pos = opndToken.getCharPositionInLine() + 1;
		String err = tokenStr + " undefined for " + type + " at " + line + ":" + pos;
		errorList.add(err);
	}
	
	public void addTypeClashErr(Token opndToken) {
		int line = opndToken.getLine();
		int pos = opndToken.getCharPositionInLine() + 1;
		String err = "type clash at " + line + ":" + pos;
		errorList.add(err);
	}
	
	public void addUndefIdErr(String idToken, Token opndToken) {
		String tokenStr = idToken;
		int line = opndToken.getLine();
		int pos = opndToken.getCharPositionInLine() + 1;
		String err = tokenStr + " undefined at " + line + ":" + pos;
		errorList.add(err);
	}
	
	public void addRedefIdErr(String idToken, Token opndToken) {
		String tokenStr = idToken;
		int line = opndToken.getLine();
		int pos = opndToken.getCharPositionInLine() + 1;
		String err = "redefinition of " + tokenStr + " at " + line + ":" + pos;
		errorList.add(err);
	}
	
	}
