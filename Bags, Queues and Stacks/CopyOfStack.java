import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.Random;
import java.util.UUID;

/**
 * Write an iterable Stack client that has a static method copy() that takes a stack
 * of strings as argument and returns a copy of the stack.
 */
public class CopyOfStack {
    public static Stack<String> copy(Stack<String> s){
        Stack<String> res1 = new Stack<>();
        Stack<String> res2 = new Stack<>();
        Iterator<String> iter = s.iterator();
        while(iter.hasNext()) res1.push(iter.next());
        Iterator<String> iter1 = res1.iterator();
        while(iter1.hasNext()) res2.push(iter1.next());
        return res2;
    }

    public static Stack<String> copy01(Stack<String> s){
        Stack<String> res = new Stack<>();
        while(!s.isEmpty()) res.push(s.pop());
        return res;
    }

    public static void main(String[] args){
        Stack<String> s = new Stack<>();
        Random g = new Random();
        for(int i = 0; i < 5; i++){
            String uuid = UUID.randomUUID().toString();
            s.push(uuid);
        }

        //We do not touch the original by using iterator
        StdOut.println(copy(s));
        StdOut.println(s);

        //We will touch the original stack if we do not use iterator.
        //StdOut.println(copy01(s));
        //StdOut.println(s.size());

        //Stack is a collection, we can use "addAll" method
        java.util.Stack<String> s1 = new java.util.Stack<>();
        for(int i = 0; i < 5; i++){
            String uuid = UUID.randomUUID().toString();
            s1.push(uuid);
        }
        java.util.Stack<String> colStack = new java.util.Stack<>();
        colStack.addAll(s1);
        StdOut.println("We can use java util stack library:");
        StdOut.println(colStack);

        //To validate the "addAll" is a deep copy
        StdOut.println("After we change the origin stack:");
        s1.pop();
        StdOut.println(s1);
        StdOut.println(colStack);

    }
}
