//import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdOut;

import java.io.*;
import java.util.*;

public class Fundamentals {
    //1.1.14
    public static int lg(int N) {
        int res = 0;
        for (int n = N; n > 1; n /= 2) {
            res++;
        }
        return res;
    }

    //1.1.15
    public static int[] histogram(int[] arr, int M){
        int[] res = new int[M];  // A default value of 0 for arrays of integral types is guaranteed
        //System.out.println(res.toString());
        for (int n: arr) {
            res[n]++;
        }
        return res;
    }

    //1.1.16
    public static String exR1(int n)
    {
        if (n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }

    //1.1.18
    public static int mystery(int a, int b)
    {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }

    //1.1.19 bottom-up dynamic: time complexity is O(N), space is O(N)
    public static long F(int N) {
        int f[] = new int[N + 1];  // 1 extra to handle case N = 0
        f[0] = 0;
        f[1] = 1;

        for(int i = 2; i <= N; i++){
            f[i] = f[i-1] + f[i-2];
        }
        //System.out.println(Arrays.toString(f));
        return f[N];
    }

    //1.1.19 bottom-up dynamic: time complexity is O(N), space is O(1)
    public static int fib(int N) {
        int a = 0, b = 1, c;
        if (N == 0) return a;
        for (int i = 2; i <= N; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    //1.1.20 logarithm factorial recursive
    public static double logFactorial(int N) {
        if (N == 1 || N== 0) return Math.log(1);
        return Math.log(N) + logFactorial(N - 1);
    }

    //1.1.20 for loop solution
    public static double logFac(int N) {
        Double sum = 0.0;
        for(int i = 1; i <= N; i++){
            sum += Math.log(i);
        }
        return sum;
    }

    //1.1.22
    public static int rank(int key, int[] a)
    { return rank(key, a, 0, a.length - 1, 0); }
    public static int rank(int key, int[] a, int lo, int hi, int dep)
    {
        if (dep == 0) System.out.printf("%d %2d\n", lo, hi);
        else {
            int n = dep + 1;
            System.out.printf("%" + n + "d %2d\n", lo, hi);
        }
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            dep++;
            return rank(key, a, lo, mid - 1, dep);}
        else if (key > a[mid]) {
            dep++;
            return rank(key, a, mid + 1, hi, dep);
        }
        else return mid;
    }

    //1.1.24
    public static int gcd(int p, int q)
    {
        //System.out.printf("%2d %2d\n", p, q);
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
    public static int Euclid(){
        Scanner input = new Scanner(System.in);
        int p = input.nextInt();
        int q = input.nextInt();
        return gcd(p, q);
    }

    //1.1.27
    private static int num = 0;
    public static double binomial(int N, int k, double p)
    {
        num++;
        //System.out.println(N);
        if ((N == k) || (k == 0)) return 1.0;
        return (1.0 - p)*binomial(N-1, k, p) + p*binomial(N-1, k-1, p);
    }
    public static double binomialBottomUp(int N, int k) {
        int[][] arr = new int[N + 1][k + 1];
        int i, j;
        for(i = 0; i <= N; i++){
            for(j = 0; j <= Math.min(i, k); j++){
                if(j == 0 || j == i) arr[i][j] = 1;
                else arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }
        return arr[N][k];
    }
    public static Double helper(int N, int k, Double[][] arr) {
        System.out.println(Integer.toString(N) + " " + Integer.toString(k));
        Double res;
        if (arr[N][k] != null) return arr[N][k];
        num++;
        if ((N == k) || (k == 0)) res = 1.0;
        else res = helper(N-1, k, arr) + helper(N-1, k-1, arr);
        arr[N][k] = res;
        return res;
    }
    public static double binomialDp(int N, int k) {
        Double[][] arr = new Double[N + 1][k + 1];
        return helper(N, k, arr);
    }

    public static void main(String args[]) {
        /*
        int a = (0+15) / 2;  // <-- 7
        System.out.println(a);
        System.out.println(2.0e-6 * 100000000.1);  // <-- 200.0000002
        System.out.println(true && false || true && true);  // <-- true

        System.out.println(1 + 2 + "3");  // <-- 33
        System.out.println((1 + 2 + "3").getClass().getName());  // <-- String

        //1.1.3
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        if(a == b && b == c) System.out.println("equal");
        else System.out.println("not equal");

        //1.1.5
        Double a = Double.parseDouble(args[0]);
        Double b = Double.parseDouble(args[1]);
        if (a <= 1 && a >= 0 && b <= 1 && b >= 0) System.out.println("true");
        else System.out.println("false");

        //1.1.6
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++)
        {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }

        //1.1.7
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        System.out.println(sum);  // n * (n + 1) / 2, n = 999

        int sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < 5; j++)
                sum++;
        System.out.println(sum);  // <-- 10 * 5

        //1.1.8
        System.out.println('b');
        System.out.println('b' + 'c');  // <-- The result of adding Java chars, shorts, or bytes is an int
        System.out.println(("a" + 4).getClass().getName());  // <-- String + int = String
        System.out.println((char) ('a' + 4));

        //1.1.9
        String s = "";
        for (int n = 8; n > 0; n /= 2) {
            s = (n % 2) + s;
        }
        System.out.println(s);
        System.out.println(Integer.toBinaryString(100));

        //1.1.11
        boolean [][] arr = new boolean[3][3];
        Random generator = new Random();
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                arr[i][j] = generator.nextBoolean();
                if (arr[i][j]) System.out.println("*");
                else System.out.println(" ");
            }
        }

        //1.1.12
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        for (int i = 0; i < 10; i++)
            System.out.println(i);  // <-- 0,1,2...9

        //1.1.13
        Random generator = new Random();
        int M = 2, N = 3;
        int[][] origin = new int[M][N];
        int[][] transpose = new int[N][M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                origin[i][j] = generator.nextInt(10);
                transpose[j][i] = origin[i][j];
            }
        }

        for(int[] row: origin) System.out.println(Arrays.toString(row));
        for(int[] row: transpose) System.out.println(Arrays.toString(row));

        //test for 1.1.14
        System.out.println(lg(100));

        //test for 1.1.15
        int[] arr = new int[]{1, 4, 4, 2, 1};
        System.out.println(Arrays.toString(histogram(arr, 5)));

        //test for 1.1.16
        System.out.println(exR1(6));
        System.out.println(""+6);  // <-- String of 6

        System.out.println(mystery(2, 25));
        System.out.println(mystery(3, 11));

        //test for 1.1.19
        System.out.println(F(9));
        System.out.println(fib(9));

        //test for 1.1.20
        System.out.println(logFactorial(6));
        System.out.println(logFac(6));

        //1.1.21 input: tim 34 56 meng 56 20
        Scanner input = new Scanner(System.in);
        List<String> content = new ArrayList<>();
        while (input.hasNextLine()){  // <-- use ctrl+z to terminate input from stdin
            content.add(input.nextLine());
        }
        for (String s: content){
            String[] line = s.split(" ");
            System.out.printf("%-10s %-10.2f %-10.2f %-10.3f\n",
                    line[0],
                    Float.parseFloat(line[1]),
                    Float.parseFloat(line[2]),
                    Float.parseFloat(line[1]) / Float.parseFloat(line[2]));
        }

        //test for 1.1.22
        int key = 7;
        int[] arr = new int[]{3, 7, 9, 5, 0, -3, 10, 13, 2};
        Arrays.sort(arr);
        System.out.println(rank(key, arr));

        //test for 1.1.24
        System.out.println(Euclid());

        //1.1.26
        int a = 10, b = 9, c = 8, t;
        if (a > b) { t = a; a = b; b = t; }
        if (a > c) { t = a; a = c; c = t; }
        if (b > c) { t = b; b = c; c = t; }
        System.out.printf("%d > %d > %d", c, b, a);  // <-- 10 > 9 > 8

        //test for 1.1.27
        //Fundamentals obj = new Fundamentals();
        //Double res27 = binomial(5, 3, 0.5);
        Double res27 = binomialDp(5, 3);
        System.out.printf("The result is %.3f, the number of calls is %d", res27, num);
        */
        //1.1.30
        int N = 6;
        boolean[][] arr = new boolean[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (gcd(i, j) == 1) arr[i][j] = true;
                else arr[i][j] = false;
            }
        }
        for(boolean[] row : arr){
            StdOut.println(Arrays.toString(row));
        }
    }
}
