package com.nmittal.sorting;

import java.util.Arrays;

/**
 * MergeSort Description.
 *
 * @author NarainM
 */
public final class MergeSort {

    public static void mergeSort(Comparable[] items) {

        //mergeSortRecursive(items, 0, items.length - 1);
        for (int sz = 1; sz < items.length; sz = sz + sz) {
            for (int lo = 0; lo < items.length - sz; lo += sz + sz) {

                // int low = (p -1)  * sz;
                int hi = Math.min(lo + sz + sz - 1, items.length - 1);
                int mid = lo + sz - 1;

                merge(items, lo, mid, hi);
            }
        }
    }

    public static void mergeSortRecursive(Comparable[] items, int low, int hi) {

        if (low >= 0 && hi < items.length && low < hi) {

            int mid = low + (hi - low) / 2;

            mergeSortRecursive(items, low, mid);
            mergeSortRecursive(items, mid + 1, hi);

            merge(items, low, mid, hi);

        }
    }

    private static void merge(Comparable[] items, int low, int mid, int hi) {
        final Comparable[] temp = Arrays.copyOf(items, items.length);

        int i = low;
        int j = mid + 1;

        for (int k = low; k <= hi; k++) {
            if (i > mid) {
                items[k] = temp[j++];
            } else if (j > hi) {
                items[k] = temp[i++];
            } else if (temp[j].compareTo(temp[i]) < 0) {
                items[k] = temp[j++];
            } else {
                items[k] = temp[i++];
            }
        }

//        int i = low;
//        int j = mid + 1;
//        int k = low;

//        while (i <= mid && j <= hi) {
//            if (temp[i].compareTo(temp[j]) < 0) {
//                items[k++] = temp[i++];
//            } else if (temp[i].compareTo(temp[j]) > 0) {
//                items[k++] = temp[j++];
//            } else if (temp[i].compareTo(temp[j]) == 0) {
//                items[k++] = temp[i++];
//                items[k++] = temp[j++];
//            }
//        }
//        while (i <= mid) {
//            items[k++] = temp[i++];
//        }
//        while (j <= hi) {
//            items[k++] = temp[j++];
//        }
    }
}
