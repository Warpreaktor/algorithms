package ru.warpreaktor.util;

public class Utils {

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

    public static int compareAndGetMin(int x, int y){
        return (x < y) ? x : ((x == y) ? x : y);
    }

    public static int compareAndGetMax(int x, int y){
        return (x < y) ? y : ((x == y) ? y : x);
    }
}
