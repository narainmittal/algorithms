package com.nmittal.problems;

import java.util.Arrays;

/**
 * FirstNPrime Description.
 *
 * @author NarainM
 */
public final class FirstNPrime {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int n = 10000;
        int count = 0;
        int[] primes = new int[n];

        primes[count++] = 2;
        int num = 3;
        while (count < n) {
            boolean isPrime = true;
            for (int i = 0; i < count; i++) {

               // if (num % primes[i] == 0 || primes[i] > Math.sqrt(num) ) {
                 if (num % primes[i] == 0 ) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes[count++] = num;
            }
            num+=2;

        }

        System.out.print(Arrays.toString(primes));
        long end = System.currentTimeMillis();
        System.out.print(end-start);
    }
}
