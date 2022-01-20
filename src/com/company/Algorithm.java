/* A Java program to evaluate a
   given expression where tokens
   are separated by space.
*/
package com.company;

import java.util.Stack;

public class Algorithm {
    public static Integer evaluate(String expression) {
        char[] tokens = expression.toCharArray();
        // Stack for numbers: 'values'
        Stack<Integer> values = new Stack<Integer>();

        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {

            // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
                continue;
            if (Character.isUpperCase(tokens[i])) {
                int row = getAlphabeticalRank(tokens[i]);
                StringBuffer sbuf2 = new StringBuffer();
                // There may be more than one digits in number

                while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9')|| Character.isUpperCase(tokens[i]) ) {
                    sbuf2.append(tokens[i++]);
                    if (i == tokens.length) // added to match value when we have only "A1" or B2 , etc as input after =.
                    {
                        break;}
                }

                int col = Integer.parseInt( sbuf2.toString().substring(1) );
                int resultValue = Integer.parseInt( Spreadsheet.getCell(row, col -1).getValue());
                values.push(resultValue);
                if (i == tokens.length) { // added to match value when we have only "A1" or B2 , etc as input after =.
                    break;
                }
            }

            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();

                // There may be more than one
                // digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Integer.parseInt(sbuf.toString()));
                // right now the i points to the character next to the digit, since the for loop also increases the i,
                // we would skip one token position; we need to decrease the value of i by 1 to correct the offset.
                i--;
            }

            // Current token is an opening brace, push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);

                // Closing brace encountered, solve entire brace
            else if (tokens[i] == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                // While top of 'ops' has same or greater precedence to current token, which is an operator.
                // Apply operator on top of 'ops' to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                // Push current token to 'ops'.
                ops.push(tokens[i]);
            } else {
                if(tokens[i]!='='){
                    return null;
                }
            }
             else {
                if ( tokens[i] != '=' )
                 return null;

            }
        }

        // Entire expression has been parsed at this point, apply remaining ops to remaining values
        while (!ops.empty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }
        // Top of 'values' contains result, return it
        return values.pop();
    }

    // Returns true if 'op2' has higher or same precedence as 'op1', otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    // A utility method to apply an operator 'op' on operands 'a' and 'b'. Return the result.
    public static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    public static int getAlphabeticalRank(char a){
//        String a = "D";
        int rank = -1 ;
        int temp = (int)a;
        int temp_integer = 64; //for upper case
        if(temp<=90 & temp>=65) {
            rank = temp - temp_integer ;
        }
        return rank-1; // to have 0 as A, etc..
    }
}
