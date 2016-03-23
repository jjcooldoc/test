package com.test.TestProject;

import java.util.Properties;
import java.util.Map;
import java.util.HashMap;
/**
 * Use a comma-separated properties input to resolve user defined variable to literal.
 * Right now assuming no chaining, but can be extended to do so with some extra work through recursive resolving.
 * Properties has values like:
 * variable1=1.0,variable2=4
 * ......
 * All variable name must start with a letter, and only letter, digit, and _ are allowed.
 * No duplicate variable definitions are allowed.
 * @author jj.zhang
 *
 */

public class PropertyVariableResolver implements VariableResolver {
	Map<String, LiteralVal> mapping;
	public PropertyVariableResolver(String p) throws ParsingException {
		mapping = new HashMap();
		try {
			String[] props = p.split(",");
			for (String x : props) {
				String[] v = x.split("=");
				if (isValidVariableName(v[0]) && isValidLiteral(v[1])) {
					mapping.put(v[0], new LiteralVal(v[1]));
				} else {
					throw new ParsingException("Failed to parse variable resolution properties: " + p);
				}
			}
			
		} catch (Exception e) {
			throw new ParsingException("Failed to parse variable resolution properties: " + p);
		}
		
	}
	public LiteralVal resolve(Operand opr) throws EvaluationException {
		if (opr instanceof Variable) {
			Variable v = (Variable)opr;
			LiteralVal lv = this.mapping.get(v.getName());
			if (lv == null) {
				throw new EvaluationException("Cannot resolve variable " + v.getName());
			} else {
				return lv;
			}
		} else {
			return (LiteralVal)opr;
		}
	}
	protected boolean isValidVariableName(String v) { 
		//TODO
		return true; 
	}
	
	protected boolean isValidLiteral(String v) {
		//TODO
		return true;
	}
}
