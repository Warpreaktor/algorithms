package ru.warpreaktor.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.warpreaktor.util.Generator;

import java.util.Arrays;

class BucketSortTest {


    /**
     * hashBucketSort простой тест на 10 числах
     */
    @Test
    void bucketSort1() {
        int[] arr = new int[]{4,5,7,1,2,9,0,8,3,6};
        int[] result = new int[]{0,1,2,3,4,5,6,7,8,9};
        BucketSort bucketSort = new BucketSort();
        bucketSort.hashBucketSort(arr);
        Assertions.assertArrayEquals(result, arr);
        System.out.println(bucketSort.getTotalOperations());
    }

    /**
     * hashBucketSort с дублирующимися данными
     */
    @Test
    void bucketSort2() {
        int[] arr = new int[]{2,4,2,4,2,2,2,8,1,6};
        int[] result = new int[]{1,2,2,2,2,2,4,4,6,8};
        BucketSort bucketSort = new BucketSort();
        bucketSort.hashBucketSort(arr);
        Assertions.assertArrayEquals(result, arr);
        System.out.println(bucketSort.getTotalOperations());
    }

    /**
     * hashBucketSort на большом количестве данных
     * 1млн данных
     * 2999997 ops total test time ~ 530ms
     */
    @Test
    void bucketSort3() {
        int[] arr = Generator.genIntegerArray(1000000, true);
        int[] result = Arrays.copyOf(arr, arr.length);
        Arrays.sort(result);

        BucketSort bucketSort = new BucketSort();
        bucketSort.hashBucketSort(arr);
        Assertions.assertArrayEquals(result, arr);
        System.out.println(bucketSort.getTotalOperations());
    }

    /**
     * hashBucketSort и отрицательные числа
     * 20019 ops
     */
    @Test
    void bucketSort4() {
        int[] arr = new int[]{-1,-10,1,0,-15,-10000,10000,10000,10000};
        int[] result = Arrays.copyOf(arr, arr.length);
        Arrays.sort(result);

        BucketSort bucketSort = new BucketSort();
        bucketSort.hashBucketSort(arr);
        Assertions.assertArrayEquals(result, arr);
        System.out.println(bucketSort.getTotalOperations());
    }

    /**
     * simpleBucketSort простой тест на 10 числах
     */
    @Test
    void simpleBucketSort() {
        int[] arr = new int[]{4,5,7,1,2,9,0,8,3,6};
        int[] result = new int[]{0,1,2,3,4,5,6,7,8,9};
        BucketSort bucketSort = new BucketSort();
        bucketSort.simpleBucketSort(arr);
        Assertions.assertArrayEquals(result, arr);
        System.out.println(bucketSort.getTotalOperations());
    }

    /**
     * simpleBucketSort на большом количестве данных
     * 1млн данных
     * 3000000 ops; total test time ~ 247ms
     */
    @Test
    void simpleBucketSort2() {
        int[] arr = Generator.genIntegerArray(1000000, true);
        int[] result = Arrays.copyOf(arr, arr.length);
        Arrays.sort(result);

        BucketSort bucketSort = new BucketSort();
        bucketSort.simpleBucketSort(arr);
        Assertions.assertArrayEquals(result, arr);
        System.out.println(bucketSort.getTotalOperations());
    }

    /**
     * simpleBucketSort на малом количестве данных
     */
    @Test
    void simpleBucketSort3() {
        int[] arr = new int[]{1,10000};
        int[] result = Arrays.copyOf(arr, arr.length);
        Arrays.sort(result);

        BucketSort bucketSort = new BucketSort();
        bucketSort.simpleBucketSort(arr);
        Assertions.assertArrayEquals(result, arr);
        System.out.println(bucketSort.getTotalOperations());
    }

    /**
     * simpleBucketSort на дублирующихся данных с большим диапазоном min - max
     */
    @Test
    void simpleBucketSort4() {
        int[] arr = new int[]{1,1,1,1,1,10000,10000,10000,10000};
        int[] result = Arrays.copyOf(arr, arr.length);
        Arrays.sort(result);

        BucketSort bucketSort = new BucketSort();
        bucketSort.simpleBucketSort(arr);
        Assertions.assertArrayEquals(result, arr);
        System.out.println(bucketSort.getTotalOperations());
    }

    /**
     * simpleBucketSort на дублирующихся данных
     * Не работает из-за отсутствия в массиве отрицательного индекса.
     * ArrayIndexOutOfBoundsException
     */
    @Test
    void simpleBucketSort5() {
        int[] arr = new int[]{-1,-10,1,0,-15,12,};
        int[] result = Arrays.copyOf(arr, arr.length);
        Arrays.sort(result);

        BucketSort bucketSort = new BucketSort();

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            bucketSort.simpleBucketSort(arr);
        });

        System.out.println(bucketSort.getTotalOperations());
    }

    /**
     * mixedSort с дублирующимися данными
     */
    @Test
    void mixedSort1() {
        double[] arr = new double[]{0.2,0.4,0.2,0.4,0.2,0.2,0.2,0.8,0.1,0.6};
        double[] result = new double[]{0.1,0.2,0.2,0.2,0.2,0.2,0.4,0.4,0.6,0.8};
        BucketSort bucketSort = new BucketSort();
        bucketSort.mixedSort(arr);
        Assertions.assertArrayEquals(result, arr);
        System.out.println(bucketSort.getTotalOperations());
    }

    /**
     * mixedSort test на отрицательных числах
     * 29 ops
     */
    @Test
    void mixedSort2() {
        double[] arr = new double[]{-0.1,-0.10,0.1,0,-0.15,0.9,0.3,-0.5};
        double[] result = Arrays.copyOf(arr, arr.length);
        Arrays.sort(result);

        BucketSort bucketSort = new BucketSort();
        bucketSort.mixedSort(arr);
        Assertions.assertArrayEquals(result, arr);
        System.out.println(bucketSort.getTotalOperations());
    }

    /**
     * mixedSort на большом количестве данных
     * 1млн данных
     * n + ~785121 ops total test time ~ 900ms
     */
    @Test
    void mixedSort3() {
        double[] arr = Generator.genDoubleArray(1000000);

        double[] result = Arrays.copyOf(arr, arr.length);
        Arrays.sort(result);

        BucketSort bucketSort = new BucketSort();
        bucketSort.mixedSort(arr);
        Assertions.assertArrayEquals(result, arr);
        System.out.println(bucketSort.getTotalOperations());
    }
}