import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Random;

public class diceSimulation {
    public static void main(String[] args){
        int SIDES = 6;
        double[] dist = new double[2*SIDES+1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i+j] += 1.0;
        for (int k = 2; k <= 2*SIDES; k++)
            dist[k] = Math.round(dist[k] / 36. * 1000.0) / 1000.0;
        StdOut.println(Arrays.toString(dist));

        double[] myDist = new double[2*SIDES+1];
        int N = Integer.parseInt(args[0]);  // <- N = 1000000, empirical results match the exact one to 3 decimal places
        Random g = new Random();
        for(int i = 0; i < N; i++){
            int a = g.nextInt(6) + 1;
            int b = g.nextInt(6) + 1;
            //StdOut.printf("a = %d, b = %d", a, b);
            myDist[a + b] += 1.;
        }
        for (int k = 2; k <= 2*SIDES; k++)
            myDist[k] = Math.round(myDist[k] / N * 1000.0) / 1000.0;
        StdOut.println(Arrays.toString(myDist));
    }
}
