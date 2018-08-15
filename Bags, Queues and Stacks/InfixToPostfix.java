import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Write a filter InfixToPostfix that converts an arithmetic expression from infix
 * to postfix.
 *
 * input: ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
 * output: 2 3 4 + 5 6 * * +
 */
public class InfixToPostfix {
    public static void main(String[] args){
        String input = "( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )";
        Stack<Character> ops = new Stack<>();
        Queue<Character> res = new Queue<>();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) != ' '){
                Character c = input.charAt(i);
                if(c.equals('+')) ops.push(c);
                else if(c.equals('*')) ops.push(c);
                else if(c.equals(')')) res.enqueue(ops.pop());
                else if(c.equals('(')) continue;
                else res.enqueue(c);
            }
        }
        StdOut.println(res);
    }
}
