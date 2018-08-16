import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Develop a class ResizingArrayQueueOfStrings that implements the queue
 * abstraction with a fixed-size array, and then extend your implementation to use array
 * resizing to remove the size restriction.
 */

public class ResizeingArrayQueueOfStrings implements Iterable<String> {
    private String[] s;  // string queue
    private int n;       // the size of queue
    private int first;   // the index of head
    private int last;    // the index of next slot

    // constructor
    public ResizeingArrayQueueOfStrings(){
        s = new String[2];  // leave two slots for head and tail
        n = 0;
        first = 0;
        last = 0;
    }

    // check if it is empty
    public boolean isEmpty() {return n == 0;}

    // return the size of queue
    public int size() {return n;}

    // resize array with capacity
    private void resize(int capacity){
        String[] newArr = new String[capacity];
        for(int i = 0; i < n; i++){
            newArr[i] = s[(first + i) % s.length];
        }
        s = newArr;
        first = 0;
        last = n;
    }

    // add a string to queue
    public void enqueue(String str){
        if(n == s.length) resize(2 * s.length);
        s[last++] = str;
        //StdOut.printf("str is %s, s.length is %d, last is %d\n", str, s.length, last);
        /**
         * queue can be represented by an array, where the contents of the queue "wrap around"
         * the end of the array to the beginning.
         * [6th] [tail] [empty] [empty] [empty] [head] [2nd] [3rd] [4th] [5th]
         */
        StdOut.println(Arrays.toString(s));
        if(last == s.length) last = 0;
        n++;
    }

    // remove and return the item from queue
    public String dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        String str = s[first];
        s[first] = null;  // to avoid loitering
        n--;
        first++;
        //StdOut.printf("str is %s, s.length is %d, first is %d\n", str, s.length, first);
        StdOut.println(Arrays.toString(s));
        if(first == s.length) first = 0;
        if(n > 0 && n == s.length / 4) resize(s.length / 2);
        return str;
    }

    // check the item least recently added to queue
    public String peek(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return s[first];
    }

    // return the iterator of resized queue
    public Iterator<String> iterator(){
        return new thisIterator();
    }

    private class thisIterator implements Iterator<String> {
        private int i = 0;
        public boolean hasNext() {return i < n;}
        public void remove(){throw new UnsupportedOperationException();}
        public String next(){
            if (!hasNext()) throw new NoSuchElementException();
            String str = s[(first + i) % s.length];
            i++;
            return str;
        }
    }

    public static void main(String[] args){
        ResizeingArrayQueueOfStrings q = new ResizeingArrayQueueOfStrings();
        while(!StdIn.isEmpty()){  // <- to be or not to - be - - that - - - is
            String item = StdIn.readString();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.printf("\n%d items left in the queue.", q.size());
    }
}
