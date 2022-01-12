package fraction;

import java.lang.*;
import java.lang.reflect.Constructor;
import java.math.*;

public class FractionImpl implements Fraction {
    private int numerator;
    private int denominator;

    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator
     * @param denominator
     */

    public FractionImpl(int numerator, int denominator) {
        // TODO

        if(denominator == 0) {
            throw new ArithmeticException("Denominator is zero");
        }
        else {
            if (numerator == 0 && denominator == 0){
                denominator = 1;
            }

            if (denominator < 0) {
                numerator *= -1;
                denominator *= -1;
            }
            if (denominator == 0) {
                throw new ArithmeticException("Divide by zero");
            }

            int GCD = GreatestCommonDivisor(numerator, denominator);
            numerator /= GCD;
            denominator /= GCD;

                            this.numerator = numerator;
                            this.denominator = denominator;
                        }
                    }

                    /** This method finds the GCD of the fraction*/




    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        // TODO
        this.numerator = wholeNumber;
        this.denominator = 1;
    }


    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     */

    public FractionImpl(String fraction) {
        // TODO
        // Need to remove spaces (but not if they are within integers)
        try {


            int num = 1;
            int den = 1;

            // Determine whether string has a slash (and therefore has a denominator)
            boolean ContainsSlash = false;
            for (int x = 0; x < fraction.length(); x++) {
                if (fraction.charAt(x) == ('/')){
                    ContainsSlash = true;}
            }

            if (ContainsSlash == true) {
                String frac[] = fraction.split("/");
                frac[0].replaceAll("\\s", "");
                frac[1].replaceAll("\\s", "");
                num = Integer.parseInt(frac[0]);
                den = Integer.parseInt(frac[1]);


            } else if (ContainsSlash == false) {
                num = Integer.parseInt(fraction);
                den = 1;
            }

            int GCD = GreatestCommonDivisor(num, den);
            num /= GCD;
            den /= GCD;

            this.numerator = Integer.valueOf(num);
            this.denominator = Integer.valueOf(den);
        }
        catch(NumberFormatException ex){
            System.out.println("That string could not be parsed into numbers. Please try again.");


        }
    }

    private int GreatestCommonDivisor(int n, int d){

        if ( n < 0 ){
            n *= 1;
        }

        int larger = Math.max( Math.abs(n), Math.abs(d) );
        int smaller = Math.min( Math.abs(n), Math.abs(d) );

        while (larger != 0 && smaller != 0) {
            larger = larger % smaller;
        }
        int GCD = Math.max(larger, smaller);

        return GCD;
    }

    /**
     * @inheritDoc
     * a/b + c/d is (ad + bc)/bd
     */
    @Override
    public Fraction add(Fraction f) {

        int n = ( this.numerator * ((FractionImpl)f).denominator) + ( this.denominator *
                ((FractionImpl)f).numerator);
        int d = ( this.denominator * ((FractionImpl)f).denominator);

        System.out.println(n);
        System.out.println(d);

        Fraction result = new FractionImpl(n,d);

    return result;}

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        String Result = Integer.toString(numerator);

        if (denominator != 1){
            Result = Result.concat("/" + Integer.toString(denominator));}

        return Result;
    }
}