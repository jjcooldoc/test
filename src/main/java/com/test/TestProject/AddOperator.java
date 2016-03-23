package com.test.TestProject;

public class AddOperator extends Operator {
	
	protected char name = '+';

	@Override
	public LiteralVal computeDouble(LiteralVal l1, LiteralVal l2) {
		return new LiteralVal(l1.getDoubleVal() + l2.getDoubleVal());
	}

	@Override
	public LiteralVal computeLong(LiteralVal l1, LiteralVal l2) {
		return new LiteralVal(l1.getLongVal() + l2.getLongVal());
	}

}
