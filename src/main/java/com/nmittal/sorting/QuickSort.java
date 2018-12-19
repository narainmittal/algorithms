package com.nmittal.sorting;

import com.nmittal.util.SimpleUtil;

import java.util.Arrays;

/**
 * QuickSort Description.
 *
 * @author NarainM
 */
public final class QuickSort {

    public static void quickSort(Comparable[] items) {
        quickSortRecursive(items, 0, items.length - 1);
    }

    private static void quickSortRecursive(Comparable[] items, int lo, int hi) {

//        if(lo > hi){
//            swap(items, lo, pivot);
//            quickSortRecursive(items, lo, pivot);
//            return;
//        }
        int pivot = lo + (hi - lo) / 2;
        System.out.println(String.format("quickSortRecursive items: %s, low %s, hi %s, pivot %s", Arrays.toString(items), lo, hi, pivot));
        int i = lo;
        int j = hi;
        Object p = items[pivot];
        while (i <= j) {
            while (items[i].compareTo(p) < 0) {
                i++;
            }
            while (items[j].compareTo(p) > 0) {
                j--;
            }
            if (i <= j) {
                SimpleUtil.swap(items, i, j);
                i++;
                j--;
            }
        }

        if (lo < j) {
            quickSortRecursive(items, lo, j);
        }
        if (i < hi) {
            quickSortRecursive(items, i, hi);
        }
    }
}
