import edu.princeton.cs.algs4.StdOut;

public class Line {
    private Point p1;
    private Point p2;

    public Line(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public double length(){
        return Point.distance(p1, p2);
    }

    public boolean equals(Line that){
        return (p1.equals(that.p1) && p2.equals(that.p2));
    }

    @Override
    public String toString() {
        return "(" + p1 + " " + p2 + ")";
    }

    public boolean longer(Line that){
        return this.length() > that.length();
    }

    public static void main(String[] args){
        Point a = new Point(1, 2);
        Point b = new Point(4, 6);
        Point c = new Point(4, 2);
        Line l1 = new Line(a, b);
        Line l2 = new Line(a, b);
        Line l3 = new Line(a, c);
        StdOut.println(l1);
        StdOut.println(l1.length());
        StdOut.println(l3.length());
        StdOut.printf("l1 is equals to l2 is %s.\n", l1.equals(l2));
        StdOut.printf("The length of l1 is longer than l3: %s", l1.longer(l3));

    }
}
