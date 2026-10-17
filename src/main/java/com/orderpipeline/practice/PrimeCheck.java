package com.orderpipeline.practice;

public class PrimeCheck {

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i =2; i < n; i++)
            if (n % i == 0)
                return false;
        // inside it: if n % i == 0, the number is not prime, so return false
        return true;
    }

    public static void main(String[] args) {
        int[] tests = {97,100};
        for (int t : tests) {
            System.out.println(t + " is prime? " + isPrime(t));
        }
    }
}
