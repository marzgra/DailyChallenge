package com.marzgra.challenge5;

class Pair<T, U> {
    private T a;
    private U b;

    private Pair(T a, U b) {
        this.a = a;
        this.b = b;
    }

    public static <T, U> Pair<T,U> cons(T a, U b) {
        return new Pair<>(a, b);
    }

    public static <T> T car(Pair<T, ?> p) {
        return p.a;
    }

    public static <U> U cdr(Pair<?, U> p) {
        return p.b;
    }
}