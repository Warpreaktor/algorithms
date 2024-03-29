package ru.warpreaktor.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class CollectionUtils {

    /**
     * Возвращает минимальное числов массива
     * @param arr
     * @return
     */
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
     * @param arr - ArrayList который будет скопирован
     * @return - возвращает копию ArrayList в виде массива
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
    public static double[] toArrayD(ArrayList<Double> arr) {
        double[] result = new double[arr.size()];
        int count = 0;
        for (Double i : arr) {
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
    public static void swap(int[] arr, int indexA, int indexB){
        int b = arr[indexB];
        arr[indexB] = arr[indexA];
        arr[indexA] = b;
    }
    public static void swap(double[] arr, int indexA, int indexB){
        double b = arr[indexB];
        arr[indexB] = arr[indexA];
        arr[indexA] = b;
    }
    public static char[] swap(char[] arr, int indexA, int indexB){
        char b = arr[indexB];
        arr[indexB] = arr[indexA];
        arr[indexA] = b;
        return arr;
    }
    public static void swap(ArrayList<Double> arr, int indexA, int indexB){
        double b = arr.get(indexB);
        arr.set(indexB, arr.get(indexA));
        arr.set(indexA, b);
    }

    /**
     * Печатает в консоль каждый элемент массива
     */
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void shuffleArray(int[] arr){
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            int randomIndexToSwap = rand.nextInt(arr.length);
            swap(arr, i, randomIndexToSwap);
        }
    }

    /**
     * Возвращает true если массив отсортирован
     * T(n) = O(n/2)
     */
    public static boolean isSorted(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            while (j >= i) {
                if (arr[i] > arr[j]) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    /**
     * Возвращает true если массив отсортирован.
     * Принимает ссылку на Integer переменную, для записи в нее количества проделанных операций.
     * Метод нужен для вызова его в других алгоритмах и подсчета общего количества операций работы алгоритма.
     * T(n) = O(n/2)
     */
    public static boolean isSorted(int[] arr, AtomicInteger totalOps) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            while (j >= i) {
                totalOps.incrementAndGet();
                if (arr[i] > arr[j]) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    private int[] allMax(int[] arr, int x) {
        if (arr.length < 2) return arr;
        ArrayList<Integer> result = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > x) {
                result.add(arr[i]);
            }
        }

        return CollectionUtils.toArray(result);
    }

    private int[] merge(int[]... arr) {
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
