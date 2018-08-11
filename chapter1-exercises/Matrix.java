import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Matrix {
    private int row;
    private int column;

    public Matrix(int[][] m) {
        int[][] matrix = m;
    }

    //get the size of matrix
    public static int[] size(double[][] m) {
        int[] size = new int[2];
        size[0] = m.length;
        if (m[0].length != 0) {
            size[1] = m[0].length;
        }
        return size;
    }

    //vector dot product
    public static double dot(double[] x, double[] y) {
        if (x.length != y.length) throw new IllegalArgumentException("the vectors should be same length");
        double total = 0;
        for (int i = 0; i < x.length; i++) {
            total += x[i] * y[i];
        }
        return total;
    }

    //matrix-matrix product
    public static double[][] mult(double[][] a, double[][] b) {
        if (size(a)[0] != size(b)[1] || size(a)[1] != size(b)[0]) {
            throw new IllegalArgumentException("The shapes of two matrices are not compatible ");
        }
        int[] sizeA = size(a);
        int[] sizeB = size(b);
        double[][] res = new double[sizeA[0]][sizeB[1]];
        for (int i = 0; i < sizeA[0]; i++) {
            for (int j = 0; j < sizeB[1]; j++) {
                for (int k = 0; k < sizeB[0]; k++) {
                    //StdOut.printf("a = %.3f, b = %.3f\n", a[i][k], b[k][j]);
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return res;
    }

    //transpose
    public static double[][] transpose(double[][] a){
        int[] size = size(a);
        double[][] res = new double[size[1]][size[0]];
        for(int i = 0; i < size[0]; i++){
            for(int j = 0; j < size[1]; j++){
                res[j][i] = a[i][j];
            }
        }
        return res;
    }

    //matrix-vector product
    public static double[] mult(double[][] a, double[] x) {
        int[] size = size(a);
        if(size[1] != x.length) throw new IllegalArgumentException("The shapes of two matrices are not compatible ");
        double[] res = new double[size[0]];
        for(int i = 0; i < size[0]; i++){
            for(int j = 0; j < x.length; j++){
                res[i] += a[i][j] * x[j];
            }
        }
        return res;
    }

    //row vector-matrix product
    public static double[] mult(double[] y, double[][] a){
        int[] size = size(a);
        if(size[0] != y.length) throw new IllegalArgumentException("The shapes of two matrices are not compatible ");
        double[] res = new double[size[1]];
        for(int i = 0; i < size[1]; i++){
            for(int j = 0; j < y.length; j++){
                res[i] += y[j] * a[j][i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        double[][] m = new double[][]{
                new double[]{0.1, 0.2, 0.3, 0.5, 0.4},
                new double[]{0.1, 0.2, 0.6, 0.5, 0.4},
                new double[]{0.9, 1.0, 0.3, 0.5, 0.4}
        };
        for (double[] x : m) {
            StdOut.println(Arrays.toString(x));
        }

        double[] v = new double[]{0.1, 0.2, 0.3, 0.5, 0.4};
        StdOut.println(dot(v, v));

        double[][] trans = transpose(m);
        for (double[] x : trans) {
            StdOut.println(Arrays.toString(x));
        }

        double[][] multi = mult(m, trans);
        for (double[] x : multi) {
            StdOut.println(Arrays.toString(x));
        }

        StdOut.println(Arrays.toString(mult(m, v)));

        StdOut.println(Arrays.toString(mult(v, trans)));
    }
}
