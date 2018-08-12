import edu.princeton.cs.algs4.StdOut;

public class Rational {

    private final long numerator;
    private final long denominator;

    public Rational(long numerator, long denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    static final long safeMultiply(long left, long right)
            throws ArithmeticException {
        if (right > 0
                ? left > Long.MAX_VALUE/right || left < Long.MIN_VALUE/right
                : (right < -1
                ? left > Long.MIN_VALUE/right  || left < Long.MAX_VALUE/right
                : right == -1 && left == Long.MIN_VALUE) ) {
            throw new ArithmeticException("Long overflow");
        }
        return left * right;
    }

    public Rational plus(Rational b){
        long plusDenominator = safeMultiply(this.denominator, b.denominator);
        long plusNumerator = (this.numerator * b.denominator) + (b.numerator * this.denominator);
        long gcd = gcd(plusNumerator, plusDenominator);
        return new Rational(plusNumerator / gcd, plusDenominator / gcd);
    }

    public Rational minus(Rational b){
        long minusDenominator = safeMultiply(this.denominator, b.denominator);
        long minusNumerator = (this.numerator * b.denominator) - (b.numerator * this.denominator);
        long gcd = gcd(minusNumerator, minusDenominator);
        return new Rational(minusNumerator / gcd, minusDenominator / gcd);
    }

    public Rational times(Rational b){
        long timesDenominator = safeMultiply(this.denominator, b.denominator);
        long timesNumerator = this.numerator * b.numerator;

        long gcd = gcd(timesDenominator, timesNumerator);
        return new Rational(timesNumerator / gcd, timesDenominator / gcd);
    }

    public Rational divides(Rational b){
        long divDenominator = safeMultiply(this.denominator, b.numerator);
        long divNumerator = safeMultiply(this.numerator, b.denominator);

        long gcd = gcd(divNumerator, divDenominator);
        return new Rational(divNumerator / gcd, divDenominator / gcd);
    }

    private long gcd(long p, long q){
        if(q == 0) return p;
        long r = p % q;
        return gcd(q, r);
    }

    private boolean equals(Rational that){
        return this.denominator == that.denominator && this.numerator == that.numerator;
    }

    public String toString(){
        return Long.toString(this.numerator) + ", " + Long.toString(this.denominator);
    }

    public static void main(String[] args){
        //Rational r1 = new Rational(8, 999999999999999999L);
        //Rational r2 = new Rational(8 ,999999999999999999L);
        Rational r1 = new Rational(8, 1000L);
        Rational r2 = new Rational(8 ,1000L);
        Rational r3 = new Rational(4, 1000);
        System.out.println(r1.plus(r2));
        StdOut.println(r1.minus(r3));
        StdOut.println(r1.times(r2));
        StdOut.println(r1.divides(r2));
        StdOut.println(r1.equals(r2));
        StdOut.println(r1.equals(r3));
    }
}
