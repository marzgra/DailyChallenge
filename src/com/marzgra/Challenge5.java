package com.marzgra;

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

    public static class Pair<T, U> {
        private T a;
        private U b;

        public Pair(T a, U b) {
            this.a = a;
            this.b = b;
        }

        private static <T, U> Pair<T,U> cons(T a, U b) {
            return new Pair<>(a, b);
        }

        public static <T> T car(Pair<T, ?> p) {
            return p.a;
        }

        public static <U> U cdr(Pair<?, U> p) {
            return p.b;
        }
    }
}
