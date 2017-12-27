package edu.coursera.concurrent;

public class demo {
    public static void main(System[] args) {
        int count = new SieveActor().countPrimes(100);
        System.out.println("count: " + count);
    }
}
