package com.test.TestProject;

/**
 * Represents an operator such as + - ^
 * Assuming single char for the operator
 * Assuming operators are binary for now, but should not be a big deal to handle unary
 * @author jj.zhang
 *
 */
public abstract class Operator {
	protected char name;
	protected int precedence = 1;
	protected boolean binary = true;
	
	public Operand eval(Operand v1, Operand v2, VariableResolver r) throws EvaluationException {
		LiteralVal l1 = r.resolve(v1);
		LiteralVal l2 = r.resolve(v2);
		if (l1.isDouble() || l2.isDouble()) { 
			return this.computeDouble(l1, l2);
		} else {
			return this.computeLong(l1, l2);
		}
	}
	
	public abstract LiteralVal computeDouble(LiteralVal l1, LiteralVal l2);
	public abstract LiteralVal computeLong(LiteralVal l1, LiteralVal l2);
	
	public int getPrecedence() {
		return precedence;
	}
	
	public boolean isBinary() { return binary; }
	
}
