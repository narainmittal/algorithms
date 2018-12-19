package com.nmittal.sorting;

/**
 * ShellSort Description.
 *
 * @author NarainM
 */
public final class ShellSort {

    public static void shellSort(Comparable[] items) {
        int size = items.length;
        int h = 1;
        while (h < size / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            InsertionSort.insertionSort(items, h);
            h = (h - 1) / 3;
        }
    }
}
