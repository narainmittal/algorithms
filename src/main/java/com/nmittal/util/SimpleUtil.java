package com.nmittal.util;

/**
 * SimpleUtil Description.
 *
 * @author NarainM
 */
public final class SimpleUtil {
    public static void swap(Comparable[] items, int i, int j) {
        Comparable temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public static boolean lesser(Comparable[] items, int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    public static boolean greater(Comparable[] items, int i, int j) {
        return items[i].compareTo(items[j]) > 0;
    }

}
