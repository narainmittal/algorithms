package com.nmittal.problems;

/**
 * StringFindIndex Description.
 *
 * @author NarainM
 */
public final class StringFindIndex {

    public static int indexOf(String s, String sub) {
        int firstDex = -1;
        int subDex = 0;
        //int end = s.length()-1;

        if (sub.length() > s.length()) {
            return -1;
        }

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == sub.charAt(subDex)) {
                subDex++;
            } else {
                subDex = 0;
            }

            if (subDex == sub.length()) {
                firstDex = i - sub.length() + 1;
                break;
            }

        }
        return firstDex;
    }

    public static void main(String[] args) {
        String s = "abcdef";
        String sub = "efg";

        System.out.print("first index: " + indexOf(s, sub));
    }


}
