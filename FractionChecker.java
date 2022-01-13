package fraction;

import java.io.*;
import java.util.*;

public class FractionChecker {
    public static void main(String[] args) {


        String snippet = "";

        // 0. Test for constructor with two integers as arguments

        Fraction a0 = new FractionImpl(1, 2);
        Fraction a1 = new FractionImpl(9, 63);
        Fraction a2 = new FractionImpl(0, 1);
        Fraction a3 = new FractionImpl(-2, 8);
        Fraction a4 = new FractionImpl(-24, -6);

        String[] s = {"1/2", "1/7", "0", "-1/4", "4"};
        String a = "";


        for (int i = 0; i < 5; i++) {
            // Simplest case, positive fraction with value below 1
            if (i == 0) {
                a = a0.toString();
                snippet = " { Fraction a = new FractionImpl(1, 2); } ";
            }

            // Positive fraction that requires normalisation
            if (i == 1) {
                a = a1.toString();
                snippet = " { Fraction a = new FractionImpl(1, 2); } ";
                snippet = "{ Fraction a = new FractionImpl(9, 63); }";
            }

            // Zero
            if (i == 2) {
                a = a2.toString();
                snippet = "{ Fraction a = new FractionImpl(0, 1); }";
            }
            // Negative denominator, requires normalisation
            if (i == 3) {
                a = a3.toString();
                snippet = "{ Fraction a = new FractionImpl(2, -8); }";
            }
            // Negative numerator and denominator, absolute value over one, integer equivalent
            // result
            if (i == 4) {
                a = a4.toString();
                snippet = "{ Fraction a = new FractionImpl(-24, -6); }";
            }

            if (!s[i].equals(a)) {
                System.out.println("---- On code snippet:");
                System.out.println(snippet);
                System.out.println("---- Expected value of fraction:");
                System.out.println(s[i]);
                System.out.println("---- Actual value of String s:");
                System.out.println(a);
                return;
            }

        }
        System.out.println("The two integer constructor passed all tests.");


        // 1. Test for constructor with one integer as argument (whole number)

        Fraction b0 = new FractionImpl(3);
        Fraction b1 = new FractionImpl(-1);
        Fraction b2 = new FractionImpl(10);
        Fraction b3 = new FractionImpl(-437);
        Fraction b4 = new FractionImpl(0);

        String[] s1 = {"3", "-1", "10", "-437", "0"};


        for (int i = 0; i < 5; i++) {
            // Simplest case, positive fraction with value below 10
            if (i == 0) {
                a = b0.toString();
                snippet = " { Fraction b0 = new FractionImpl(3); } ";
            }
            // Negative integer
            if (i == 1) {
                a = b1.toString();
                snippet = "{ Fraction b1 = new FractionImpl(-1); }";
            }
            // Two digits in argument
            if (i == 2) {
                a = b2.toString();
                snippet = "{ Fraction b2 = new FractionImpl(10); }";
            }
            // Negative integer, three digits in argument
            if (i == 3) {
                a = b3.toString();
                snippet = "{ Fraction b3 = new FractionImpl(-437); }";
            }
            // Zero
            if (i == 4) {
                a = b4.toString();
                snippet = "{ Fraction b4 = new FractionImpl(0); }";
            }

            if (!s1[i].equals(a)) {
                System.out.println("---- On code snippet:");
                System.out.println(snippet);
                System.out.println("---- Expected value of fraction:");
                System.out.println(s1[i]);
                System.out.println("---- Actual value of String s:");
                System.out.println(a);
                return;
            }

        }
        System.out.println("The single integer constructor passed all tests.");

        // 2. Test for constructor string as argument
        Fraction c0 = new FractionImpl("2/3");
        Fraction c1 = new FractionImpl("-3/27");
        Fraction c2 = new FractionImpl("0/100");
        Fraction c3 = new FractionImpl("31/7");
        Fraction c4 = new FractionImpl("0");

        String[] s2 = {"2/3", "-1/9", "0", "31/7", "0"};

        for (int i = 0; i < 5; i++) {
            // Positive fraction no spaces
            if (i == 0) {
                a = c0.toString();
                snippet = " { Fraction a = new FractionImpl(\"2/3\"); } ";
            }
            // Negative fraction requires normalisation, no spaces
            if (i == 1) {
                a = c1.toString();
                snippet = "{ Fraction a = new FractionImpl(\"-3/27\"); }";
            }
            // Zero, spaces before and after string
            if (i == 2) {
                a = c2.toString();
                snippet = "{ Fraction a = new FractionImpl(\" 0/100 \"); }";
            }
            // Spaces within string but not within integer
            if (i == 3) {
                a = c3.toString();
                snippet = "{ Fraction a = new FractionImpl(\"31 / 7\"); }";
            }
            // Zero
            if (i == 4) {
                a = c4.toString();
                snippet = "{ Fraction a = new FractionImpl(\"0\"); }";
            }

            if (!s2[i].equals(a)) {
                System.out.println("---- On code snippet:");
                System.out.println(snippet);
                System.out.println("---- Expected value of fraction:");
                System.out.println(s2[i]);
                System.out.println("---- Actual value of String s:");
                System.out.println(a);
                return;
            }

        }
        System.out.println("The string constructor passed all tests.");

        // 3. Test for Greatest Common Denominator
        Fraction d0 = new FractionImpl(98, 98);
        Fraction d1 = new FractionImpl("-3/27");
        Fraction d2 = new FractionImpl("303/101000");
        Fraction d3 = new FractionImpl("31/7");
        Fraction d4 = new FractionImpl("0");

        String[] s3 = {"1", "-1/9", "3/1000", "31/7", "0"};
        List<String> ResultsList3 = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            //GCD is the same for both arguments
            if (i == 0) {
                a = d0.toString();
                snippet = " { Fraction d0 = new FractionImpl(98,98); } ";
            }
            // GCD is number that is not passed as argument
            if (i == 1) {
                a = d1.toString();
                snippet = "{ Fraction d1 = new FractionImpl(\"-3/27\"); }";
            }
            // GCD is three-digit
            if (i == 2) {
                a = d2.toString();
                snippet = "{ Fraction d2 = new FractionImpl(\" 303/101000 \"); }";
            }
            // No GCD
            if (i == 3) {
                a = d3.toString();
                snippet = "{ Fraction d3 = new FractionImpl(\"31/7\"); }";
            }
            // Zero
            if (i == 4) {
                a = d4.toString();
                snippet = "{ Fraction d4 = new FractionImpl(\"0\"); }";
            }

            if (!s3[i].equals(a)) {
                System.out.println("---- On code snippet:");
                System.out.println(snippet);
                System.out.println("---- Expected value of fraction:");
                System.out.println(s3[i]);
                System.out.println("---- Actual value of String s:");
                System.out.println(a);
                return;
            }

        }
        System.out.println("The Greatest Common Divisor method passed all tests.");

        // 4. Test for add method

        String[] s4 = {"17/21", "4/3", "26/9", "3/1000", "-3934/9"};


        for (int i = 0; i < 5; i++) {
            //Add two positive fractions to give a result below one
            if (i == 0) {
                Fraction e0 = c0.add(a1);
                a = e0.toString();
                snippet = " { Fraction e0 = c0.add(a1); } ";
            }
            // Add two positive fractions to give a result above one
            if (i == 1) {
                Fraction e1 = c0.add(c0);
                a = e1.toString();
                snippet = " { Fraction e1 = c0.add(c0) } ";
            }
            // Add a positive fraction to a negative one
            if (i == 2) {
                Fraction e2 = b0.add(d1);
                a = e2.toString();
                snippet = " { Fraction e2 = b0.add(d1); } ";
            }
            // Add zero to another fraction
            if (i == 3) {
                Fraction e3 = c4.add(d2);
                a = e3.toString();
                snippet = " { Fraction e3 = a1.add(d2); } ";
            }
            // Add two negative fractions
            if (i == 4) {
                Fraction e4 = b3.add(c1);
                a = e4.toString();
                snippet = " { Fraction e4 = b3.add(c1); } ";
            }

            if (!s4[i].equals(a)) {
                System.out.println("---- On code snippet:");
                System.out.println(snippet);
                System.out.println("---- Expected value of fraction:");
                System.out.println(s4[i]);
                System.out.println("---- Actual value of String s:");
                System.out.println(a);
                return;
            }

        }
        System.out.println("The add method passed all tests.");

        // 5. Test for subtract method

        String[] s5 = {"11/21", "79/21", "-16/63", "-3/1000", "0"};


        for (int i = 0; i < 5; i++) {
            //Subtract two positive fractions to give a result below one
            if (i == 0) {
                Fraction f0 = c0.subtract(a1);
                a = f0.toString();
                snippet = " { Fraction f0 = c0.subtract(a1); } ";
            }
            // Subtract a positive fraction from a positive fraction to give a result above one
            if (i == 1) {
                Fraction f1 = d3.subtract(c0);
                a = f1.toString();
                snippet = " { Fraction f1 = d3.subtract(c0); } ";
            }
            // Subtract a positive fraction from a negative one (negative result)
            if (i == 2) {
                Fraction f2 = d1.subtract(a1);
                a = f2.toString();
                snippet = " { Fraction f2 = d1.subtract(a1); } ";
            }
            // Subtract zero from another fraction
            if (i == 3) {
                Fraction f3 = c4.subtract(d2);
                a = f3.toString();
                snippet = " { Fraction f3 = c4.subtract(d2); } ";
            }
            // Subtract two negative fractions
            if (i == 4) {
                Fraction f4 = d1.subtract(c1);
                a = f4.toString();
                snippet = " { Fraction f4 = d1.subtract(c1); } ";
            }

            if (!s5[i].equals(a)) {
                System.out.println("---- On code snippet:");
                System.out.println(snippet);
                System.out.println("---- Expected value of fraction:");
                System.out.println(s5[i]);
                System.out.println("---- Actual value of String s:");
                System.out.println(a);
                return;
            }
        }
        System.out.println("The subtract method passed all tests.");


        // 6. Test for multiply method
        String[] s6 = {"2/21", "62/21", "-1/63", "0", "1/81"};


        for (int i = 0; i < 5; i++) {
            //Multiply two positive fractions
            if (i == 0) {
                Fraction g0 = c0.multiply(a1);
                a = g0.toString();
                snippet = " { Fraction g0 = c0.multiply(a1); } ";
            }
            // Multiply two positive fractions
            if (i == 1) {
                Fraction g1 = d3.multiply(c0);
                a = g1.toString();
                snippet = " { Fraction g1 = d3.multiply(c0); } ";
            }
            // Multiply a positive fraction by a negative one
            if (i == 2) {
                Fraction g2 = d1.multiply(a1);
                a = g2.toString();
                snippet = " { Fraction g2 = d1.multiply(a1); } ";
            }
            // Multiply zero by another fraction
            if (i == 3) {
                Fraction g3 = c4.multiply(d2);
                a = g3.toString();
                snippet = " { Fraction g3 = c4.multiply(d2); } ";
            }
            // Multiply two negative fractions
            if (i == 4) {
                Fraction g4 = d1.multiply(c1);
                a = g4.toString();
                snippet = " { Fraction g4 = d1.multiply(c1); } ";
            }

            if (!s6[i].equals(a)) {
                System.out.println("---- On code snippet:");
                System.out.println(snippet);
                System.out.println("---- Expected value of fraction:");
                System.out.println(s6[i]);
                System.out.println("---- Actual value of String s:");
                System.out.println(a);
                return;
            }
        }
        System.out.println("The subtract method passed all tests.");

        // Test for divide method


        String[] s7 = {"14/3", "93/14", "-7/9", "0", "1"};


        for (int i = 0; i < 5; i++) {
            //Divide a positive fraction by a positive fraction
            if (i == 0) {
                Fraction h0 = c0.divide(a1);
                a = h0.toString();
                snippet = " { Fraction h0 = c0.divide(a1); } ";
            }
            // Divide a positive fraction from a positive fraction to give integer result
            if (i == 1) {
                Fraction h1 = d3.divide(c0);
                a = h1.toString();
                snippet = " { Fraction h1 = d3.divide(c0); } ";
            }
            // Divide a positive fraction by a negative one
            if (i == 2) {
                Fraction h2 = d1.divide(a1);
                a = h2.toString();
                snippet = " { Fraction h2 = d1.divide(a1); } ";
            }
            // Divide zero by another fraction
            if (i == 3) {
                Fraction h3 = c4.divide(d2);
                a = h3.toString();
                snippet = " { Fraction h3 = c4.divide(d2); } ";
            }
            // Divide two negative fractions to give integer result
            if (i == 4) {
                Fraction h4 = d1.divide(c1);
                a = h4.toString();
                snippet = " { Fraction h4 = d1.divide(c1); } ";
            }

            if (!s7[i].equals(a)) {
                System.out.println("---- On code snippet:");
                System.out.println(snippet);
                System.out.println("---- Expected value of fraction:");
                System.out.println(s7[i]);
                System.out.println("---- Actual value of String s:");
                System.out.println(a);
                return;
            }
        }
        System.out.println("The divide method passed all tests.");



    }
}




