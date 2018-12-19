package com.nmittal.sorting;

import com.nmittal.util.SimpleUtil;

/**
 * BubbleSort Description.
 *
 * @author NarainM
 */
public final class BubbleSort {
    public static void bubbleSort(Comparable[] items) {
        int size = items.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (items[j].compareTo(items[j + 1]) > 0) {
                    SimpleUtil.swap(items, j, j + 1);
                }
            }
        }
    }
}
