package com.test.TestProject;

import java.util.Stack;

/**
 * main entry point to evaluate an expression.
 * Can provide also a properties definition to specify user defined variables
 * @author jj.zhang
 *
 */
public class Evaluator {
	
	/**
	 * 
	 * @param expr mathematical expression to be evaluated
	 * @param varDef var=val,... definition
	 * @return
	 */
	public LiteralVal eval(String expr, String varDef) throws ParsingException {
		
		//create the Resolver using varDef
		VariableResolver resolver = new PropertyVariableResolver(varDef);
		
        char[] tokens = expr.toCharArray();

       Stack<Operand> values = new Stack<Operand>();

       Stack<Operator> ops = new Stack<Operator>();
       
       StringBuffer varName = new StringBuffer();
       
       for (int i = 0; i < tokens.length; i++)
       {
           //check white space
           if (tokens[i] == ' ') {
        	   if (varName.length() > 0) {
        		   //varname is present, need to do something here
        		   //TODO
        		   //clear the buffer
        		   varName.delete(0, varName.length());
        	   }
        	   else {
        		   continue;
        	   }
           }   
           //check to see if starts a variable
           if (tokens[i] <= 'Z' && tokens[i] >= 'a') {
        	   varName.append(tokens[i]);
        	   continue;
           }
           
           // Current token is a number, find out numbers
           //Just did the long, need to work on Double, ....
           if (tokens[i] >= '0' && tokens[i] <= '9')
           {
               StringBuffer sbuf = new StringBuffer();
               // There may be more than one digits in number
               while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                   sbuf.append(tokens[i++]);
               values.push(new LiteralVal(sbuf.toString()));
           }

          
           // Current token is an operator.
           //TODO, figure out Operators
           else if (true)
           {
           }
       }
       //TODO, NO TIME Left!!!!!!!!!!!!!!, pop and compute, ......
       
       return null;
   }


}
