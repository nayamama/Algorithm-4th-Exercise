import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;


public class Exercises06 {
    public static void main(String[] args){
        //1.3.6
        Stack<String> s1 = new Stack<>();
        Queue<String> q1 = new Queue<>();
        for (int i = 0; i < 10; i++){
            q1.enqueue(Integer.toString(i));
        }
        StdOut.println(q1); // <- 0 1 2 3 4 5 6 7 8 9
        while (!q1.isEmpty())
            s1.push(q1.dequeue());
        while (!s1.isEmpty())
            q1.enqueue(s1.pop());
        StdOut.println(q1); // <- 9 8 7 6 5 4 3 2 1 0
    }
}
