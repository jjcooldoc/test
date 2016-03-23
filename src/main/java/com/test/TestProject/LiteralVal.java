package com.test.TestProject;

public class LiteralVal implements Operand {
	private boolean isDouble = false;
	
	private long longVal = 0;
	private double doubleVal = 0.0;
	public LiteralVal(String input) {
		if (input.indexOf('.') >= 0) {
			isDouble = true;
			doubleVal = Double.parseDouble(input);
		} else {
			longVal = Long.parseLong(input);
		}
	}
	public LiteralVal(long in) {
		longVal = in;
	}
	public LiteralVal (double in) {
		doubleVal = in;
		isDouble = true;
	}
	public long getLongVal() { return longVal; }
	public double getDoubleVal() { return doubleVal; }
	public boolean isDouble() { return isDouble; }
}
