import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.List;

public class ParenthesesCheck {
    private static List<Character> LEFT = Arrays.asList('(', '[', '{');
    private static Stack<Character> stack = new Stack<>();

    private static boolean isMatch(Character left, Character right){
        if(left.equals('(')) return right.equals(')');
        else if(left.equals('[')) return right.equals(']');
        else if(left.equals('{')) return right.equals('}');
        else return false;
    }

    public static boolean isBalance(String s){
        for(int i = 0; i < s.length(); i++){
            if(LEFT.contains(s.charAt(i))){
                stack.push(s.charAt(i));
            }else{
                if(!stack.isEmpty() && isMatch(stack.peek(), s.charAt(i))){
                    stack.pop();
                }
                else return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        /*
         *  [()]{}{[()()]()}
         *  true
         *
         *  [(])
         *  false
         */
        In input = new In();
        String text = input.readLine();
        StdOut.printf("The sequence is properly balanced: %s", isBalance(text));
    }
}
