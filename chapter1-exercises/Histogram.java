import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Histogram {
    public static void main(String args[]) {
        //calculate the intervals along x axes.
        int N = Integer.parseInt(args[0]);
        double left = Double.parseDouble(args[1]);
        double right = Double.parseDouble(args[2]);

        double interval = (right - left) / N;
        List<double[]> intervals = new ArrayList<>();
        for(int i = 0; i < N; i++){
            double[] p = {i * interval, (i+1) * interval};
            intervals.add(p);
        }
        for(double[] p: intervals){
            StdOut.println(Arrays.toString(p));
        }

        //generate a sequence of double values
        int val = 100;
        double[] input = new double[val];
        Random generator = new Random();
        for(int i = 0; i < val; i++){
            input[i] = generator.nextDouble();
        }
        //StdOut.println(Arrays.toString(input));

        //calculate frequency
        double[] freq = new double[N];
        for(double p: input){
            for (int i = 0; i < N; i++){
                if(p >= intervals.get(i)[0] && p < intervals.get(i)[1]){
                    freq[i]++;
                }
            }
        }
        double[] percentageFreq = new double[N];
        for(int i = 0; i < N; i++) percentageFreq[i] = freq[i] / val;
        //StdOut.println(Arrays.toString(percentageFreq));

        //prepare histogram data (center of rectangle, half of width, half of height
        List<double[]> positions = new ArrayList<>();
        for(int i = 0; i < N; i++){
            double[] pos = {intervals.get(i)[0] + interval / 2, percentageFreq[i] / 2, interval / 2 * 0.9, percentageFreq[i] / 2};
            positions.add(pos);
        }

        StdDraw.setXscale(-0.1, 1.1);
        StdDraw.setYscale(-0.1, 0.7);
        for(double[] pos: positions) {
            StdDraw.filledRectangle(pos[0], pos[1], pos[2], pos[3]);
        }


    }
}
