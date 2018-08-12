import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Random;

public class ExerciseString {
    //1.2.6
    public static boolean ifCirculation(String s1, String s2){
        return s1.length() == s2.length() && s1.concat(s1).contains(s2);
    }

    //1.2.7
    public static String mystery(String s)
    {// reverse the string
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return mystery(b) + mystery(a);
    }

    public static void main(String[] args){
        String s1 = "ACTGACG";
        String s2 = "TGACGAC";
        StdOut.printf("%s is a circular rotation of %s: %s.\n", s1, s2, ifCirculation(s1, s2));

        StdOut.println(mystery(s1));

        //1.2.8: When we copy the array, we just copy the reference. It is very efficient
        int T = 10;
        Random g = new Random();
        int[] arr1 = new int[T];
        int[] arr2 = new int[T];
        for(int i = 0; i < T; i++){
            arr1[i] = g.nextInt(10);
            arr2[i] = g.nextInt(10);
        }
        StdOut.println(Arrays.toString(arr1));
        StdOut.println(Arrays.toString(arr2));

        int[] t = arr1;  // swap means two arrays are independent of each other
        arr1 = arr2;
        arr2 = t;
        StdOut.println(Arrays.toString(arr1));
        StdOut.println(Arrays.toString(arr2));

        int[] arr3 = arr1;
        arr1[0] = 100;  // arr3 is the shallow copy of arr1.
        StdOut.println(Arrays.toString(arr1));
        StdOut.println(Arrays.toString(arr3));
    }
}
