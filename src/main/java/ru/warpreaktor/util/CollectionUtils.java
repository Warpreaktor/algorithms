package ru.warpreaktor.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class CollectionUtils {

    public static int min(int[] arr) {
        if (arr.length < 1) return 0;

        int result = arr[0];
        for (int i : arr) {
            if (i < result) result = i;
        }
        return result;
    }

    /**
     * Метод возвращает массив всех элементов из массива arr, которые меньше чем число x
     */
    private static int[] lessThan(int[] arr, int x) {
        if (arr.length < 2) return arr;
        ArrayList<Integer> result = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < x) {
                result.add(arr[i]);
            }
        }

        return toArray(result);
    }

    /**
     * Метод возвращает массив всех элементов из массива arr, которые меньше чем число x
     */
    private static int[] equalsThis(int[] arr, int x) {
        if (arr.length < 2) return arr;
        ArrayList<Integer> result = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                result.add(arr[i]);
            }
        }

        return toArray(result);
    }

    /**
     * Переносит все объекты из ArrayList в обычный массив
     * @param arr
     * @return
     */
    public static int[] toArray(ArrayList<Integer> arr) {
        int[] result = new int[arr.size()];
        int count = 0;
        for (Integer i : arr) {
            result[count] = i;
            count++;
        }
        return result;
    }

    /**
     * Разделяет входящий массив на две примерно равные части
     * @return Возвращает List с 2 элементами index 0 и 1 это левая и правая части разделённого массива
     */
    public static ArrayList<int[]> splitInHalf(int[] arr) {
        ArrayList<int[]> result = new ArrayList<>();
        if (arr.length < 2) {
            result.add(arr);
            return result;
        }
        int n = arr.length;
        result.add(Arrays.copyOfRange(arr, 0, n / 2));
        result.add(Arrays.copyOfRange(arr, n / 2, n));
        return result;
    }

    /**
     * Переворачивает переданный LinkedList изменяя его.
     */
    public static void reverse(LinkedList list) {
        Object bubble;
        int i = 0;
        int j = list.size() - 1;
        while (i < j){
            bubble = list.get(i);
            list.set(i, list.get(j));
            list.set(j, bubble);
            j--;
            i++;
        }
    }

    /**
     * Меняет местами два элемента в коллекци
     */
    public static int[] swap(int[] arr, int indexA, int indexB){
        int b = arr[indexB];
        arr[indexB] = arr[indexA];
        arr[indexA] = b;
        return arr;
    }
    public static char[] swap(char[] arr, int indexA, int indexB){
        char b = arr[indexB];
        arr[indexB] = arr[indexA];
        arr[indexA] = b;
        return arr;
    }
}
