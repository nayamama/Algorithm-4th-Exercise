import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch
{
    public static int rank(int key, int[] a)
    { // Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        { // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    //1.1.29
    public static int smallerCounter(int key, int[] a)
    {
        int lo = 0;
        int hi = a.length - 1;
        int mid = 0;
        while (lo <= hi)
        {
            mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            }
            else if (key > a[mid]) {
                lo = mid + 1;
            }
            else { // if duplicate keys are present, return the position of last element
                while(a[mid+1] == key && mid+1 < a.length){
                    mid++;
                }
                break;
            }
        }
        while(a[mid] > key){ // if key is not find, it will be before the mid
            mid -= 1;
        }
        // if key is present, return mid + 1 because of 0-based index
        return mid + 1;
    }
    public static int duplicateCounter(int key, int[] a)
    {
        int lo = 0;
        int hi = a.length - 1;
        int mid = 0;
        int duplicatSum = 0;
        while (lo <= hi)
        {
            mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else {
                duplicatSum++;
                int tmp = mid;
                while(a[mid+1] == key && mid+1 < a.length){
                    mid += 1;
                    duplicatSum++;
                }
                mid = tmp;
                while(a[mid-1] == key && mid-1 >= 0){
                    mid -= 1;
                    duplicatSum++;
                }
                break;
            }
        }
        return duplicatSum;
    }

    public static void main(String[] args)
    {
        int[] whitelist = In.readInts(args[0]);
        //int whitelist[] = {1, 2, 4, 5, 8, 8, 8,  10};
        Arrays.sort(whitelist);
        StdOut.println(Arrays.toString(whitelist));

        //test for 1.1.29
        //StdOut.println(smallerCounter(8, whitelist));
        //StdOut.println(duplicateCounter(8, whitelist));
        StdOut.println(smallerCounter(Integer.parseInt(args[1]), whitelist));
        StdOut.println(duplicateCounter(Integer.parseInt(args[1]), whitelist));

        //1.1.28
        List<Integer> copyList = new ArrayList<>(whitelist[0]);
        for (int i = 0; i < whitelist.length - 1; i++) {
            if (whitelist[i + 1] != whitelist [i]) {
                copyList.add(whitelist[i + 1]);
            }
        }
        StdOut.println(Arrays.toString(copyList.toArray()));

        while (!StdIn.isEmpty())
        { // Read key, print if not in whitelist.
            int key = StdIn.readInt();
            if (rank(key, whitelist) < 0)
                StdOut.println(key);
        }

    }
}