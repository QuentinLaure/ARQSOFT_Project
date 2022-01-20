/* A Java program to evaluate a
   given expression where tokens
   are separated by space.
*/
package com.company;

import java.util.Stack;

public class Algorithm {
    public static int evaluate(String expression) {
        char[] tokens = expression.toCharArray();
        System.out.println("expression tokens"+tokens + "tokens.length"+tokens.length);
        // Stack for numbers: 'values'
        String D11 = "11" ;
        String AF13 = "20";

        System.out.println("printing the string int value char before if " + Integer.parseInt(D11));

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
                if(i<tokens.length) {
                    while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9') || Character.isUpperCase(tokens[i])) {
                        sbuf2.append(tokens[i]);
                        i++;
                        System.out.println("buffer containing : " + sbuf2.toString());
                        System.out.println("i = " + i + "/" + tokens.length);
                        if(i==tokens.length){
                            System.out.println("We continue");
                            continue;
                        }

                    }
                }
                System.out.println("printing the string value "+sbuf2.toString()+" at position (" +row+","+ sbuf2.toString().substring(1) +") and length = " + sbuf2.toString().length());
//                System.out.println("printing the string int value char" + Integer.parseInt( sbuf2.toString() ) );
//                values.push(Integer.parseInt(sbuf2.toString()));
                System.out.println(Spreadsheet.getCell(row,Integer.parseInt(sbuf2.toString().substring(1))));
                values.push(Integer.parseInt(Spreadsheet.getCell(row,Integer.parseInt(sbuf2.toString().substring(1))).getValue()));

                // right now the i points to the character next to the digit, since the for loop also increases
                // the i, we would skip one token position; we need to decrease the value of i by 1 to correct the offset.
                i--;
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
            System.out.println(temp - temp_integer);
            rank = temp - temp_integer ;
        }
        return rank-1; // to have 0 as A, etc..
    }

    // Driver method to test above methods
    public static void main(String[] args) {
        System.out.println(Algorithm.evaluate("100*2-12"));
//        System.out.println(Algorithm.evaluate("100 * ( 2 + 12 )"));
//        System.out.println(Algorithm.evaluate("100 * ( 2 + 12 ) / 14"));
        System.out.println("####");
        System.out.println(Algorithm.evaluate("D11+10+2*6"));

    }
}