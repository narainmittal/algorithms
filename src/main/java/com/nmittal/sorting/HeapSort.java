package com.nmittal.sorting;

import com.nmittal.util.SimpleUtil;

/**
 * HeapSort Description.
 *
 * @author NarainM
 */
public final class HeapSort {
    public static void heapSort(Comparable[] items) {

        // start from last subtree and keep going back - balance the heap
        for (int k = (items.length - 1) / 2; k >= 0; k--) {
            sink(items, k, items.length - 1);
        }
        // start from root, replace the top with last, decrement the size and balance
        int max = items.length - 1;
        for (int i = 0; i < items.length; i++) {
            SimpleUtil.swap(items, 0, max);
            sink(items, 0, --max);
        }

    }

    public static void sink(Comparable[] items, int k, int max) {
        while (k * 2 + 1 <= max) {
            int firstDex = k * 2 + 1;
            int swapDex;
            if (firstDex + 1 > max) {
                swapDex = firstDex;
            } else {
                if (SimpleUtil.greater(items, firstDex, firstDex + 1)) {
                    swapDex = firstDex;
                } else {
                    swapDex = firstDex + 1;
                }
            }
            if (SimpleUtil.greater(items, k, swapDex)) {
                break;
            }
            SimpleUtil.swap(items, k, swapDex);
            k = swapDex;
        }

    }


}
