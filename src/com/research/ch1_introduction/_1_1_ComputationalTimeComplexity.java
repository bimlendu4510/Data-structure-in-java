package com.research.ch1_introduction;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Computational Time and Space Complexity =>
 *  Linear, Constant,Quadratic,Logarithmic
 * O(1), O(n), O(n^2^), O(log n), O(n * log n)
 */

public class _1_1_ComputationalTimeComplexity {
    public static void main(String... args){
        /*
            1. in case of Linear => o(n)
                e.g.walk through a list,
                    ConcurrentLinkedQueue.size()
                    remove the 0 inside ArrayList
         */
        for(int size = 1; size <= 256 * 1024 * 1024; size *= 2){
            List<Integer> list;
            long addTime = System.nanoTime();
            try{
                list = testAdd(size, CopyOnWriteArrayList::new);
            } finally {
                addTime = System.nanoTime() - addTime;
                System.out.printf("size=%d, addTime = %dms%n", size, (addTime / 1_000_000));
            }
        }
    }
    public static List<Integer> testAdd(int size, Supplier<List<Integer>> listSupplier){
        List<Integer> list = IntStream.range(0, size)
                                .boxed()
                                .collect(Collectors.toList());
        listSupplier.get().addAll(list);
        return list;
    }
}

