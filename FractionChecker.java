package fraction;

import java.io.*;
import java.util.*;

public class FractionChecker {
    public static void main(String[] args) {
        Fraction a = new FractionImpl(4, 8);
        Fraction b = new FractionImpl(-397);
        Fraction c = new FractionImpl("32/8");
        Fraction d = a.add(c);


        System.out.println("a is " + a.toString());
        System.out.println("b is " + b.toString());
        System.out.println("c is " + c.toString());
        System.out.println("d is " + d.toString());

    }
}
