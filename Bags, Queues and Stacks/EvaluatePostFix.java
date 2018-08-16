import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Write a program EvaluatePostfix that takes a postfix expression from standard
 * input, evaluates it, and prints the value.
 *  % java EvaluatePostfix
 *  3 4 5 + *
 *  [Ctrl-z]
 *  27
 *
 *  % java EvaluatePostfix
 *  7 16 16 16 * * * 5 16 16 * * 3 16 * 1 + + +
 *  [Ctrl-z]
 *  30001
 *
 *  % java EvaluatePostfix
 *  7 16 * 5 + 16 * 3 + 16 * 1 +
 *  [Ctrl-z]
 *  30001
 *
 *  % java-algs4 InfixToPostfix | java-algs4 EvaluatePostFix
 *  The evaluation of post fix is: 212.
 */
public class EvaluatePostFix {
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        while(!StdIn.isEmpty()){
            String c = StdIn.readString();
            if(c.equals("+")) s.push(s.pop() + s.pop());
            else if(c.equals("*")) s.push(s.pop() * s.pop());
            else s.push(Integer.parseInt(c));
        }
        StdOut.printf("The evaluation of post fix is: %d.\n", s.pop());
    }
}
