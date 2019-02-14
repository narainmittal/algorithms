package com.nmittal.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * SmallestSubstringContainingElements Description.
 *
 * @author NarainM
 */
public final class SmallestSubstringContainingElements {
    public static void main(String[] args) {


        String s = "ayyyzyxzyxyyyz";
        char[] arr = s.toCharArray();
        char[] values = new char[]{'x', 'y', 'y', 'y', 'z'};
        Map<Character, Integer> valueMap = new HashMap<>();

        for (char c : values) {
            if (valueMap.containsKey(c)) {
                valueMap.put(c, valueMap.get(c) + 1);

            } else {
                valueMap.put(c, 1);
            }

        }
        String smallest = null;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> actualMap = new HashMap<>();
            for (int j = i; j < s.length(); j++) {

                if (!valueMap.containsKey(arr[j])) {
                    continue;
                } else {
                    if (!actualMap.containsKey(arr[j])) {
                        actualMap.put(arr[j], 1);
                    } else if (actualMap.get(arr[j]) != valueMap.get(arr[j])) {
                        actualMap.put(arr[j], actualMap.get(arr[j]) + 1);
                    }
                }

                if (actualMap.equals(valueMap)) {
                    String sub = s.substring(i, j + 1);
                    if (smallest == null || smallest.length() > sub.length()) {
                        smallest = sub;
                    }
                }

            }

        }

        System.out.print("Values: " + valueMap);
        System.out.print("Smallest: " + smallest);
    }
}
