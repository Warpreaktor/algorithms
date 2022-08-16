package ru.warpreaktor.util;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysUtils {

    public static int min(int[] ar) {
        if (ar.length < 1) return 0;

        int result = ar[0];
        for (int i : ar) {
            if (i < result) result = i;
        }
        return result;
    }

    /**
     * Разделяет входящий массив на две примерно равные части
     * @return Возвращает List с 2 элементами index 0 и 1 это левая и правая части разделённого массива
     */
    public static ArrayList<int[]> divideTwo(int[] arr){
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

}
