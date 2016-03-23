package com.test.TestProject;

/**
 * Interface to resolve any user defined variables
 * @author jj.zhang
 *
 */
public interface VariableResolver {
	public LiteralVal resolve(Operand opr) throws EvaluationException;
}
