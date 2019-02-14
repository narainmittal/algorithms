package com.nmittal.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/total-decoding-messages/0
 */
public final class AllPossibleDecodeMessages {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int gg = 0; gg < t; gg++) {
            int n = sc.nextInt();

            String s = sc.next();

            int[] dp = new int[n + 1];

            dp[0] = 1;
            dp[1] = 1;

            if (s.charAt(0) == '0') {
                System.out.println(0);
                continue;
            }
            for (int i = 2; i <= n; i++) {
                System.out.println(Arrays.toString(dp));
                dp[i] = 0;
                if (s.charAt(i - 1) > '0')
                    dp[i] = dp[i - 1];

                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')
                    dp[i] += dp[i - 2];
            }

            System.out.println(dp[n]);

        }
    }
}
