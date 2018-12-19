package com.nmittal.runner;

import com.nmittal.sorting.*;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Runner Description.
 *
 * @author NarainM
 */
public final class Runner {
    public static void main(String[] args) {

        String[] stringArray = new String[]{"d", "c", "1", "a", "b"};
        final Integer[] intArray = new Integer[]{4, 1, 33, 78, 2, 454, 66, 33, 73, 21, 12};

        Supplier<Comparable[]> intArraySupplier = () -> Arrays.copyOf(intArray, intArray.length);
        Consumer<Comparable[]> printArrayConsumer = (arr) -> System.out.println(Arrays.toString(arr));

        Consumer<Comparable[]> sortingAlgorithm = HeapSort::heapSort;

        sortingAlgorithm.andThen(printArrayConsumer).accept(intArraySupplier.get());
    }
}
