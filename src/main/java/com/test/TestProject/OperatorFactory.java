package com.test.TestProject;

/**
 * Makes it easy to get operators, and if extending to new operators, just add an entry here
 * @author jj.zhang
 *
 */
public class OperatorFactory {
	
	/**
	 * create an operator object based on the op literal
	 * @param op
	 * @return null if not a valid operator literal.
	 */
	public Operator createOperator(char op) {
		switch (op) {
		case '+' : return new AddOperator();
		case '-' : return new MinusOperator();
		case '*' : return new MultiOperator();
		case '/' : return new DivOperator();
		case '^' : return new PowerOperator();
		default : return null;
		}
	}

}
