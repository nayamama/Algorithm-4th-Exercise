import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Interval2dClient {
    public static void main(String[] args){

        //1.2.3
        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);

        int total = 0;
        Random g = new Random();
        List<Interval2D> boxes = new ArrayList<>();
        while(total < N){
            double w1 = g.nextDouble();
            double w2 = g.nextDouble();
            double h1 = g.nextDouble();
            double h2 = g.nextDouble();
            if (w1 - w2 >= min && h1 - h2 >= min && w1 - w2 <= max && h1-h2 <= max){
                total++;
                Interval2D box = new Interval2D(new Interval1D(w2, w1), new Interval1D(h2, h1));
                boxes.add(box);
                box.draw();
            }
        }
        //StdOut.println(boxes.size());
        int intersect = 0;
        //int contain = 0;
        for(int i = 0; i < N - 1; i++){
            for(int j = i + 1; j < N; j++){
                if (boxes.get(i).intersects(boxes.get(j))) intersect += 1;
                //if (boxes.get(i).contains(boxes.get(j))) contain += 1;
            }
        }
        StdOut.printf("%d pairs of boxes are intersected with each other.\n", intersect);

        //1.2.4
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);  // <- "world"
        StdOut.println(string2);  // <- "hello"

        //1.2.5
        String s = "Hello World";
        s.toUpperCase();
        s.substring(6, 11);
        StdOut.println(s);  // <- Hello World, String object is not immutable

        s = s.toUpperCase();
        s = s.substring(6, 11);
        StdOut.println(s);  // <- WORLD, string method returns a new String object
    }
}
