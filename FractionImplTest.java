// 13808858
// patrickmdavies@hotmail.co.uk

package fraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionImplTest {

    Fraction a0 = new FractionImpl(1,2);
    Fraction a1 = new FractionImpl(1,4);
    Fraction a2 = new FractionImpl(3,4);
    Fraction a3 = new FractionImpl(-2,8);
    Fraction a4 = new FractionImpl(0,32);
    Fraction a5 = new FractionImpl(-2,3);
    Fraction a6 = new FractionImpl(32,8);
    Fraction a7 = new FractionImpl(-11,5);
    Fraction a8 = new FractionImpl(2,4);
    Fraction a9 = new FractionImpl(-4,6);
    Fraction a10 = new FractionImpl(-4);
    Fraction a11 = new FractionImpl("1 / 1 7 ");

    @Test
    void greatestCommonDivisor() {
        assertEquals("1/4", a1.toString(),
                "A positive fraction that cannot be normalised so it should remain");
        assertEquals("4", a6.toString(),
                "A positive fraction that is normalised by the method");
        assertEquals("-1/4", a3.toString(),
                "A negative fraction that is normalised by the method");
        assertEquals("-2/3", a5.toString(),
                "A negative fraction that cannot be normalised so it should remain");
        assertEquals("0", a4.toString(),
                "A fraction with value zero");
    }


    @Test
    void add() {
        assertEquals("3/4", a0.add(a1).toString(),
                "Add two positive fractions to give a result below one");
        assertEquals("5/4", a0.add(a2).toString(),
                "Add two positive fractions to give a result above one");
        assertEquals("3/4", a0.add(a1).toString(),
                "Add a positive fraction to a negative one");
        assertEquals("1/4", a1.add(a4).toString(),
                "Add zero to another fraction");
        assertEquals("-11/12", a5.add(a3).toString(),
                "Add two negative fractions");

    }

    @Test
    void subtract() {
        assertEquals("1/4", a0.subtract(a1).toString(),
                "Subtract two positive fractions to give a result below one");
        assertEquals("-1/4", a0.subtract(a2).toString(),
                "Subtract a positive fraction from a positive fraction to give a result above one");
        assertEquals("-14/3", a5.subtract(a6).toString(),
                "Subtract a positive fraction from a negative one (negative result)");
        assertEquals("1/4", a1.subtract(a4).toString(),
                "Subtract zero from another fraction");
        assertEquals("-5/12", a5.subtract(a3).toString(),
                "Subtract two negative fractions");
    }

    @Test
    void multiply() {
        assertEquals("2", a0.multiply(a6).toString(),
                "Multiply two positive fractions (result is higher than inputs)");
        assertEquals("1/8", a0.multiply(a1).toString(),
                "Multiply two positive fractions (result is lower than inputs)");
        assertEquals("-8/3", a5.multiply(a6).toString(),
                "Multiply a positive fraction by a negative one");
        assertEquals("0", a1.multiply(a4).toString(),
                "Multiply zero by another fraction");
        assertEquals("1/6", a5.multiply(a3).toString(),
                "Multiply two negative fractions");
    }

    @Test
    void divide() {
        assertEquals("1/8", a0.divide(a6).toString(),
                "Divide two positive fractions (result is below one)");
        assertEquals("2", a0.divide(a1).toString(),
                "Divide two positive fractions (result has denominator 1)");
        assertEquals("-1/6", a5.divide(a6).toString(),
                "Divide a positive fraction by a negative one");
        assertEquals("0", a4.divide(a1).toString(),
                "Divide zero by another fraction");
        assertEquals("8/3", a5.divide(a3).toString(),
                "Divide two negative fractions");
    }

    @Test
    void abs() {
        assertEquals("1/4", a1.abs().toString(),
                "Absolute of positive fraction");
        assertEquals("1/4", a3.abs().toString(),
                "Absolute of negative fraction ");
        assertEquals("4", a6.abs().toString(),
                "Absolute of positive integer as fraction (has denominator 1)");
        assertEquals("0", a4.abs().toString(),
                "Absolute of zero");
        assertEquals("11/5", a7.abs().toString(),
                "Absolute of negative integer with value below -1");
    }

    @Test
    void negate() {
        assertEquals("-1/4", a1.negate().toString(),
                "Negation of positive fraction");
        assertEquals("1/4", a3.negate().toString(),
                "Negation of negative fraction ");
        assertEquals("-4", a6.negate().toString(),
                "Negation of positive integer as fraction (has denominator 1)");
        assertEquals("0", a4.negate().toString(),
                "Negation of zero");
        assertEquals("11/5", a7.negate().toString(),
                "Negation of negative integer with value below -1");
    }

    @Test
    void testEquals() {
        assertEquals(true, a0.equals(a8),
                "Two different positive fractions of equal value are checked");
        assertEquals(false, a0.equals(a1),
                "Positive fractions of non-equal value are checked");
        assertEquals(true, a5.equals(a9),
                "Negative fractions of equal value are checked");
        assertEquals(false, a5.equals(a4),
                "Zero is checked against a negative value");
        assertEquals(true, a0.equals(a0),
                "Positive fraction is checked against itself");
    }

    @Test
    void inverse() {
        assertEquals("4", a1.inverse().toString(),
                "Inverse of positive fraction resulting in denominator of 1");
        assertEquals("-3/2", a5.inverse().toString(),
                "Inverse of negative fraction (denominator not 0)");
        assertEquals("1/4", a6.inverse().toString(),
                "Inverse of positive integer as fraction (with denominator 1)");
        assertEquals("0", a4.inverse().toString(),
                "Inverse of zero");
        assertEquals("-5/11", a7.inverse().toString(),
                "Inverse of negative integer with value below -1");
    }

    @Test
    void compareTo() {
        assertEquals(0, a0.compareTo(a8),
                "Two different positive fractions of equal value are checked");
        assertEquals(1, a0.compareTo(a1),
                "Positive fractions of non-equal value are checked");
        assertEquals(0, a5.compareTo(a9),
                "Negative fractions of equal value are checked");
        assertEquals(-2, a5.compareTo(a4),
                "Zero is checked against a negative value");
        assertEquals(0, a0.compareTo(a0),
                "Positive fraction is checked against itself");
    }

    @Test
    void testToString() {
        assertEquals("1/2", a8.toString(),
                "Positive fraction");
        assertEquals("-2/3", a9.toString(),
                "Negative fraction");
        assertEquals("-4", a10.toString(),
                "Negative fraction with denominator 1");
        assertEquals("0", a4.toString(),
                "Zero");
        assertEquals("1/17", a11.toString(),
                "");
    }
}