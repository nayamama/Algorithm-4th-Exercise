import edu.princeton.cs.algs4.StdOut;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public static double distance(Point p1, Point p2){
        //StdOut.printf("x, y for p1 is %.1f and %.1f", p1.x, p1.y);
        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }

    private boolean equals(Point p2){
        return (x == p2.x && y == p2.y);
    }

    public String toString(){
        return "(" + Double.toString(x) + " " + Double.toString(y) + ")";
    }

    public static void main(String[] args){
        Point a = new Point(1., 2);
        Point b = new Point(4, 6);
        Point c = new Point(1., 2);

        StdOut.printf("the distance between a and b is %.3f.\n", distance(a, b));
        StdOut.printf("a and c is equal: %s\n", a.equals(c));
        StdOut.println(b);
    }
}
