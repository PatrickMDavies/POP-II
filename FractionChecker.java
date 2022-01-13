package fraction;

import java.io.*;
import java.util.*;

public class FractionChecker {
    public static void main(String[] args) {
        Fraction a = new FractionImpl(1, 2);
        Fraction b = new FractionImpl(-3);
        Fraction c = new FractionImpl("32/8");
        Fraction d = a.add(c);
        Fraction e = a.subtract(b);
        Fraction f = a.multiply(b);
        Fraction g = c.divide(b);
        Fraction h = f.abs();
        Fraction i = d.negate();
        Fraction j = i.inverse();
        int k = g.compareTo(g);
        boolean l = a.equals(b);



        System.out.println("a is " + a.toString());
        System.out.println("b is " + b.toString());
        System.out.println("c is " + c.toString());
        System.out.println("d is " + d.toString());
        System.out.println("e is " + e.toString());
        System.out.println("f is " + f.toString());
        System.out.println("g is " + g.toString());
        System.out.println("h is " + h.toString());
        System.out.println("i is " + i.toString());
        System.out.println("j is " + j.toString());
        System.out.println("k is " + k);
        System.out.println("l is " + l);
    }
}
