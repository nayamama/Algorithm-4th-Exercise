import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class VisualCounter {
    private int N;  // maximum number of operations
    private int max;  //maximum absolute value for the counter
    private int count = 0;
    private int incrementCount = 0;
    private int decrementCount = 0;
    private List<Integer> tollyArr= new ArrayList<>();

    public VisualCounter(int N, int max) {
        this.N = N;
        this.max = max;
    }

    public int totalOperation(){
        return incrementCount + decrementCount;
    }
    public int absOperation(){
        return Math.abs(incrementCount - decrementCount);
    }

    public void increment() {
        if (totalOperation() < N && absOperation() < max) {
            this.count++;
            this.incrementCount++;
            tollyArr.add(tally());
        }else{
            throw new IllegalArgumentException("The number of increment exceeds limitation.");
        }
    }
    public void decrement() {
        if (totalOperation() < N && absOperation() < max) {
            this.count--;
            this.decrementCount++;
            tollyArr.add(tally());
        }else{
            throw new IllegalArgumentException("The number of decrement exceeds the limitation");
        }
    }

    public int tally() { return this.count; }

    public void draw(){
        StdDraw.setXscale(0, totalOperation());
        StdDraw.setYscale(0, totalOperation());
        for(int i = 0; i < totalOperation() - 1; i++){
            StdDraw.line(i, tollyArr.get(i), i + 1, tollyArr.get(i + 1));
        }
    }

    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        VisualCounter counter = new VisualCounter(N, max);
        counter.increment();
        counter.increment();
        counter.increment();
        counter.decrement();
        counter.increment();
        counter.decrement();
        counter.decrement();
        StdOut.printf("increment operation is %d, decrement operation is %d, total operation is %d, tally is %d", counter.incrementCount, counter.decrementCount, counter.totalOperation(), counter.tally());
        counter.draw();

    }
}
