import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;
import java.util.List;

public class RandomConnection {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Double p = Double.parseDouble(args[1]);
        Double redius = 100.;
        Double angleIncrement = 360. / N;
        StdDraw.setPenRadius(.01);
        StdDraw.setScale(-4., 4.);
        //StdDraw.setCanvasSize(500, 500);
        List<Double[]> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Double x = redius * Math.cos(angleIncrement * i) * (Math.PI / 180);
            Double y = redius * Math.sin(angleIncrement * i) * (Math.PI / 180);
            Double[] tmp = {x, y};
            points.add(tmp);
        }
        for (Double[] point : points) {
            StdOut.println(Arrays.toString(point));
            StdDraw.point(point[0], point[1]);
        }
        Random generator = new Random();
        for (Double[] p1 : points) {
            for (Double[] p2 : points) {
                if (p1[0] != p2[0]) {
                    Double chance = generator.nextDouble();
                    StdOut.println(chance);
                    if (chance > p) StdDraw.line(p1[0], p1[1], p2[0], p2[1]);
                }
            }
        }
    }
}
