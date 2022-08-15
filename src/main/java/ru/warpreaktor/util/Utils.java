package ru.warpreaktor.util;

public class Utils {

    public static int[] swap(int[] arr, int indexA, int indexB){
        int b = arr[indexB];
        arr[indexB] = arr[indexA];
        arr[indexA] = b;
        return arr;
    }
}
