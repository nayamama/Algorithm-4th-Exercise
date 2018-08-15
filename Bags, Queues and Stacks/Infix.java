import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
Write a program that takes from standard input an expression without left parentheses
and prints the equivalent infix expression with the parentheses inserted. For
example, given the input:
1 + 2 ) * 3 - 4 ) * 5 - 6 ) )
your program should print
(( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )
 */

public class Infix {

    public static void main(String[] args){
        String input = args[0];  // <- "1 + 2 ) * 3 - 4 ) * 5 - 6 ) )"
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) != ' ') s.push(input.charAt(i));
        }
        StdOut.println(s);

        Stack<Character> res = new Stack<>();
        int count = 0;
        while(!s.isEmpty()){
            Character c = s.peek();
            if (!c.equals('*') && !c.equals(')')){
                res.push(s.pop());
            }else if (c.equals(')')){
                count++;
                res.push(s.pop());
            }else{
                if (count > 0){
                    res.push('(');
                    res.push(s.pop());
                    count--;
                }
            }
        }

        while(count > 0) {
            res.push('(');
            count--;
        }

        StdOut.println(res);

    }
}
