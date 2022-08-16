package ru.warpreaktor.sort;

import java.util.Arrays;

/**
 * Сортировка Слиянием - Merge Sort.
 * Утверждается, что два отсортированных массива можно слить поочерёдно сравнивая крайние левые элементы двух массивов
 * и перекладывая их в третий результирующий массив. При этом утверждается что массив из одного элемента всегда
 * отсортирован. Идея заключается в том, что бы рекурсивно вызывать метод сортировки на массивах более двух элементов,
 * пока не доберемся до двух отсортированных массивов (согласно утверждению выше). Далее вверх по стеку будем возвращать
 * уже отсортированные два массива которые так же будут подвергаться слиянию до самой верхушки стека.
 * T(n) = O(n log n)
 * код взят с лекции Павла Маврина - https://www.youtube.com/watch?v=apR9GhhjBjM&ab_channel=PavelMavrin
 */
public class MergeSort {

    public static int[] sortInteger(int[] arr) {
        if (arr.length < 2) return arr;
        //Разделим входящий массив на две примерно равные части
        int[] a, b;
        int n = arr.length;
        a = Arrays.copyOfRange(arr, 0, n / 2);
        b = Arrays.copyOfRange(arr, n / 2, n);

        a = sortInteger(a);
        b = sortInteger(b);

        int i = 0;
        int j = 0;
        int aLen = a.length;
        int bLen = b.length;
        int[] result = new int[aLen + bLen];
        while (i + j < aLen + bLen) {
            if (j == bLen || (i < aLen && a[i] < b[j])) {
                result[i + j] = a[i];
                i++;
            } else {
                result[i + j] = b[j];
                j++;
            }
        }
        return result;
    }
}
