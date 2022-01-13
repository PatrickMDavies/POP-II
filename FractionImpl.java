package fraction;

import java.lang.*;
import java.lang.reflect.Constructor;
import java.math.*;

public class FractionImpl implements Fraction {
    private int numerator;
    private int denominator;

    /**
     * This method creates a new fraction.
     *
     * The constructor throws an ArithmeticException if the denominator is zero.
     *
     * @param numerator - an integer representing the numerator of the fraction.
     * @param denominator - an integer representing the denominator of the fraction.
     */

    public FractionImpl(int numerator, int denominator) {
        // TODO

        if (denominator == 0) {
            if (numerator == 0) {
                denominator = 1;
            } else {
                throw new ArithmeticException("Denominator is zero");
            }
        }

        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }

        int GCD = GreatestCommonDivisor(numerator, denominator);
        numerator /= GCD;
        denominator /= GCD;

                        this.numerator = numerator;
                        this.denominator = denominator;
                    }




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
     * @param fraction the string representation of the fraction.
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
                String Trimmed_Numerator = frac[0].replaceAll(" ", "");
                for (int x = 0; x < Trimmed_Numerator.length(); x++) {
                    if (Character.isWhitespace(Trimmed_Numerator.charAt(x))){
                        throw new IllegalArgumentException("Spaces within integer");}
                }
                String Trimmed_Denominator = frac[1].replaceAll(" ", "");
                for (int x = 0; x < Trimmed_Denominator.length(); x++) {
                    if (Character.isWhitespace(Trimmed_Denominator.charAt(x))){
                        throw new IllegalArgumentException("Spaces within integer");}
                }

                num = Integer.parseInt(frac[0]);
                den = Integer.parseInt(frac[1]);


            } else if (ContainsSlash == false) {
                fraction.trim();
                for (int x = 0; x < fraction.length(); x++) {
                    if (Character.isWhitespace(fraction.charAt(x))) {
                        throw new IllegalArgumentException("Spaces within integer");
                    }
                    num = Integer.parseInt(fraction);
                    den = 1;
                }
            }

            if (denominator == 0) {
                if (numerator == 0) {
                    denominator = 1;
                } else {
                    throw new ArithmeticException("Denominator is zero");
                }
            }

            int GCD = GreatestCommonDivisor(num, den);
            num /= GCD;
            den /= GCD;

            this.numerator = Integer.valueOf(num);
            this.denominator = Integer.valueOf(den);
        }
        catch(NumberFormatException ex){
            System.out.println("That string could not be parsed into numbers. Please try again.");
            this.numerator = 0;
            this.denominator = 1;
        }
    }

    /** This method finds the Greatest Common Divisor of two numbers. That is the biggest number
     * that both numbers can be divided by, giving an integer result.
     *
     * This method accepts two integers as its arguments.
     *
     * @param x - the first integer.
     * @param y - the second integer.
     *
     * */
    private int GreatestCommonDivisor(int x, int y){

        if ( x < 0 ){
            y *= 1;
        }

        int larger = Math.max( Math.abs(x), Math.abs(y) );
        int smaller = Math.min( Math.abs(x), Math.abs(y) );

        while (larger != 0 && smaller != 0) {
            larger = larger % smaller;
            if (smaller > larger){
                int temp = 0;
                temp = smaller;
                smaller = larger;
                larger = temp;
            }
        }
        int GCD = Math.max(larger, smaller);

        return GCD;
    }

    /**
     * @inheritDoc
     * This method is the addition operation for fractions. It sums two fractions and
     * gives the total. The result is a new fraction.
     *
     * This method takes one fraction as its argument.
     *
     * @param f - the fraction to be added to the current fraction (this).
     */
    @Override
    public Fraction add(Fraction f) {

        int NewNumerator = ( this.numerator * ((FractionImpl)f).denominator) + ( this.denominator *
                ((FractionImpl)f).numerator);
        int NewDenominator = ( this.denominator * ((FractionImpl)f).denominator);

        Fraction result = new FractionImpl(NewNumerator, NewDenominator);

    return result;}

    /**
     * @inheritDoc
     * This method is the subtraction operation for fractions.This method
     * gives the difference between two fractions. The result is a new fraction.
     *
     * This method takes one fraction as its argument.
     *
     * @param f - the fraction to be added to the current fraction (this).
     *
     */
    @Override
    public Fraction subtract(Fraction f) {
        int NewNumerator =  ( this.numerator * ((FractionImpl)f).denominator ) - ( this.denominator *
                ((FractionImpl)f).numerator );
        int NewDenominator = ( this.denominator * ((FractionImpl)f).denominator );

        Fraction result = new FractionImpl(NewNumerator, NewDenominator);

        return result;
    }

    /**
     * @inheritDoc
     * This method is the multiplication operation for fractions. This method
     * gives the product of two fractions. The result is a new fraction.
     *
     * This method takes one fraction as its argument.
     *
     * @param f - the fraction to multiply the current fraction (this) by.
     */
    @Override
    public Fraction multiply(Fraction f) {
        int NewNumerator =  ( this.numerator * ((FractionImpl)f).numerator );
        int NewDenominator = ( this.denominator * ((FractionImpl)f).denominator );

        Fraction result = new FractionImpl(NewNumerator, NewDenominator);

        return result;
    }

    /**
     * @inheritDoc
     * This method is the division operation for fractions. This method
     * gives the quotient of two fractions. The result is a new fraction.
     *
     * This method takes one fraction as its argument.
     *
     * @param f - the fraction to divide the current fraction (this) by.
     */
    @Override
    public Fraction divide(Fraction f) {
        int NewNumerator =  ( this.numerator * ((FractionImpl)f).denominator );
        int NewDenominator = ( this.denominator * ((FractionImpl)f).numerator );

        Fraction result = new FractionImpl(NewNumerator, NewDenominator);

        return result;

    }

    /**
     * @inheritDoc
     * This method gives the absolute value (or modulus) of a fraction. It
     * gives the non-negative value of a fraction. The result is a new fraction.
     *
     * This method takes no arguments.
     *
     */
    @Override
    public Fraction abs() {
        int NewNumerator = Math.abs(this.numerator);
        int NewDenominator = this.denominator;

        Fraction result = new FractionImpl(NewNumerator, NewDenominator);

        return result;
    }

    /**
     * @inheritDoc
     * This method gives the negative of a fraction. It gives a negative value
     * for positive fractions, and a positive value for negative ones. The result is a
     * new fraction.
     *
     * This method takes no arguments.
     */
    @Override
    public Fraction negate() {
        int NewNumerator = ( this.numerator* -1 );
        int NewDenominator = this.denominator;

        Fraction result = new FractionImpl(NewNumerator, NewDenominator);

        return result;
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
     * This method compares two objects. If they are fractions with the same value,
     * it gives the result 'true'. Otherwise, the result is 'false'.
     *
     * This method takes one object as its argument.
     *
     * @param obj - the object to be compared with the current fraction (this).
     */
    @Override
    public boolean equals(Object obj) {
        if ( obj instanceof Fraction == false){
            return false;}

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
     * This method is the inversion operation for a fraction. It switches the
     * numerator and denominator of a fraction. The result is a new fraction.
     *
     * This method takes no arguments.
     */
    @Override
    public Fraction inverse() {
        int NewNumerator = this.denominator;
        int NewDenominator = this.numerator;

        Fraction result = new FractionImpl(NewNumerator, NewDenominator);

        return result;
    }

    /**
     * @inheritDoc
     * This method returns 0 if two fractions are the same, a positive integer if the
     * fraction accepted as an argument is smaller, and a negative integer otherwise.
     *
     * This method takes one fraction as its argument.
     *
     * @param o - the fraction to be compared with the current fraction (this).
     */
    @Override
    public int compareTo(Fraction o) {
        Fraction Result = this.subtract(o);

        return ((FractionImpl)Result).numerator;


    }

    /**
     * @inheritDoc
     * This method generates a string representation of a fraction. The string
     * is of the form 'numerator/denominator', but only the numerator is used if
     * the denominator is 1.
     *
     *
     */
    @Override
    public String toString() {
        String Result = Integer.toString(numerator);

        if (denominator != 1){
            Result = Result.concat("/" + Integer.toString(denominator));}

        if (numerator == 0){
            Result = "0";
        }

        return Result;
    }
}