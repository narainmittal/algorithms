package com.nmittal.sorting;

import com.nmittal.util.SimpleUtil;

/**
 * InsertionSort Description.
 *
 * @author NarainM
 */
public final class InsertionSort {
    public static void insertionSort(Comparable[] items, int gap) {
        int size = items.length;
        for (int i = 0; i < size; i += gap) {
            for (int j = i; j > 0 && items[j].compareTo(items[j - gap]) < 0; j -= gap) {
                SimpleUtil.swap(items, j, j - gap);
            }
        }
    }

    public static void insertionSort(Comparable[] items) {
        insertionSort(items, 1);
    }
}
