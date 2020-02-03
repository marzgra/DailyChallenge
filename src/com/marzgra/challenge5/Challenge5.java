package com.marzgra.challenge5;

public class Challenge5 {
    /*
    cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair.
    For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
    Given this implementation of cons:
        def cons(a, b):
            def pair(f):
                return f(a, b)
            return pair
    Implement car and cdr.
     */

    public static void main(String[] args) {
        Pair<Integer, Integer> p = Pair.cons(3, 4);
        System.out.println(Pair.car(p));
        System.out.println(Pair.cdr(p));

        Pair<Integer, Integer> p1 = Pair.cons(1, 2);
        System.out.println(Pair.car(p1));
        System.out.println(Pair.cdr(p1));
    }
}
