import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Random;

public class Point2DClosest {
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);  // <- 10
        Random g = new Random();

        Point[] points = new Point[N];
        for(int i = 0; i < N; i++){
            double a = g.nextDouble();
            double b = g.nextDouble();
            points[i] = new Point(a, b);
        }
        StdOut.println(Arrays.toString(points));

        int total = 0;
        double dist = Double.POSITIVE_INFINITY;

        /*
        for(Point p1: points){
            for(Point p2: points){
                if (!p1.equals(p2)){
                    total++;
                    double tmp = Point.distance(p1, p2);
                    if (tmp < dist) dist = tmp;
                }
            }
        }

        StdOut.printf("The closest distance between points pair is %.3f.\n", dist);
        StdOut.println(total);  // <- 90 computations
        */
        for(int i = 0; i < N - 1; i++){
            for(int j = i + 1; j < N; j++){
                total++;
                double tmp = Point.distance(points[i], points[j]);
                if (tmp < dist) dist = tmp;
            }
        }
        StdOut.printf("The closest distance between points pair is %.3f.\n", dist);
        StdOut.println(total);  // <- 45 computations
    }
}
