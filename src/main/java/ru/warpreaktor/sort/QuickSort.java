package ru.warpreaktor.sort;

import ru.warpreaktor.util.CollectionUtils;

import java.util.ArrayList;

public class QuickSort {

    public static int[] sort(int[] arr) {
        if (arr.length < 2) return arr; //Если массив менее 2 элементов, то массив отсортирован
        sort(arr, 0, arr.length);
        return arr;
    }

    private static int[] sort(int[] arr, int from, int to) {
        if (to - from < 2) return arr; // Если разница между левой и правой границей части массива менее 2, значит эта часть отсортирована

        int left = from; //Граница левого массива от 0 до left
        int right = from; //Граница правого массива от right до arr.length
        int x = arr[from];

        for (int i = from; i < to; i++) {
            if (arr[i] < x) {
                CollectionUtils.swap(arr, i, right);
                CollectionUtils.swap(arr, left, right);
                left++;
                right++;
            } else if (arr[i] == x) {
                CollectionUtils.swap(arr, i, right);
                right++;
            }
        }
        sort(arr, from, left);
        sort(arr, right, to);
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
            if (i.length < 1) {
                continue;
            }
            sumLength += i.length;
        }

        int[] result = new int[sumLength];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i].length < 1) {
                    break;
                }
                result[count] = arr[i][j];
                count++;
            }
        }
        return result;
    }
}
