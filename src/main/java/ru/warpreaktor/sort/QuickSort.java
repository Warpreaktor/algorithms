package ru.warpreaktor.sort;

import ru.warpreaktor.util.CollectionUtils;

import java.util.ArrayList;

public class QuickSort {


    public static int[] sort(int[] arr){
        if(arr.length < 2) return arr;

        int x = arr[0];
        ArrayList<Integer> min = new ArrayList();
        ArrayList<Integer> equals = new ArrayList();
        ArrayList<Integer> max = new ArrayList();

        for(int i : arr){
            if(i < x){
                min.add(i);
            } else if(i == x){
                equals.add(i);
            } else {
                max.add(i);
            }
        }
        int[] minRes = sort(CollectionUtils.toArray(min));
        int[] equalsRes = sort(CollectionUtils.toArray(equals));
        int[] maxRes = sort(CollectionUtils.toArray(max));

        return merge(minRes, equalsRes, maxRes);
    }

    public static int[] sort2(int[] arr) {
        if(arr.length < 2)return arr;

        int count = 0;
        int x = arr[count];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= x ) {
                CollectionUtils.swap(arr, i, count);
                if(i != 0){
                    count++;
                }
            } else {
                count++;
            }

        }

        sorter(arr, 0, count);
        sorter(arr, count, arr.length);
        return arr;
    }

    private static int[] sorter(int[] arr, int from, int to){
        if(to - from < 2) return arr;

        int count = from;
        int x = arr[count];

        for (int i = from; i < to; i++) {
            if (arr[i] <= x ) {
                CollectionUtils.swap(arr, i, count);
                if(i != from){
                    count++;
                }

            } else {
                count++;
            }
        }
        sorter(arr, count, to);
        return arr;
    }

    private static int[] allMax(int[] arr, int x) {
        if (arr.length < 2) return arr;
        ArrayList<Integer> result = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > x) {
                result.add(arr[i]);
            }
        }

        return CollectionUtils.toArray(result);
    }

    private static int[] merge(int[]... arr) {
        if (arr.length < 2) return arr[0];

        int sumLength = 0;
        for (int[] i : arr) {
            if(i.length < 1) {
                continue;
            }
            sumLength += i.length;
        }

        int[] result = new int[sumLength];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i].length < 1){
                    break;
                }
                result[count] = arr[i][j];
                count++;
            }
        }
        return result;
    }
}
