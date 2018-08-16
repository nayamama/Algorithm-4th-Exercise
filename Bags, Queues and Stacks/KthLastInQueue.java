import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Write a Queue client that takes a command-line argument k and prints the kth
 * from the last string found on standard input (assuming that standard input has k or
 * more strings).
 */
public class KthLastInQueue {
    public static void main(String[] args){
        int k = Integer.parseInt(args[0]);
        Queue<String> q = new Queue<>();
        while(!StdIn.isEmpty()) q.enqueue(StdIn.readString());  // <- to be or not to be to be or not to be
        int left = q.size() - k;
        for(int i = 0; i < left; i++) q.dequeue();
        StdOut.printf("The kth from the last string is '%s'.", q.dequeue());  // <- not
    }
}
