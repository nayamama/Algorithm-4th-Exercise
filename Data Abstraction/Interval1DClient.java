import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Interval1DClient {
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        //Scanner scan = new Scanner(System.in);
        Interval1D[] intervals = new Interval1D[N];
        for(int i = 0; i < N; i++){
            Interval1D pair = new Interval1D(StdIn.readDouble(), StdIn.readDouble());
            intervals[i] = pair;
        }
        //StdOut.println(Arrays.toString(intervals));
        for(int i = 0; i < N - 1; i++){
            for(int j = i + 1; j < N; j++){
                if(intervals[i].intersects(intervals[j])) StdOut.println(intervals[i] + " " + intervals [j]);
            }
        }
    }
}
