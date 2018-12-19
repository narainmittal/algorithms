package com.nmittal.sorting;

import com.nmittal.util.SimpleUtil;

/**
 * SelectionSort Description.
 *
 * @author NarainM
 */
public final class SelectionSort {
	public static void selectionSort(Comparable[] items) {
		int size = items.length;

		for (int i = 0; i < size; i++) {
			int smallestDex = i;
			for (int j = i + 1; j < size; j++) {

				if (items[smallestDex].compareTo(items[j]) > 0) {
					smallestDex = j;
				}
			}
			if (i != smallestDex) {
				SimpleUtil.swap(items, i, smallestDex);
			}
		}
	}
}
