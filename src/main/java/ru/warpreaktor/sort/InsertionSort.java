package ru.warpreaktor.sort;

import ru.warpreaktor.util.Utils;

/**
 * Сортировка Вставками - Insertion Sort
 * https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%B2%D1%81%D1%82%D0%B0%D0%B2%D0%BA%D0%B0%D0%BC%D0%B8
 * алгоритм представленный Павлом Мавриным - https://www.youtube.com/watch?v=apR9GhhjBjM&ab_channel=PavelMavrin
 */
public class InsertionSort {

    /**
     * #18 - Создадим новый массив из одного элемента, который объявим отсортированным.
     * #20 - Будем вытягивать элементы по одному из неотсортированного массива.
     * #22 - И добавлять их в отсортированный массив перед элементом меньшего значения.
     */
    public static int[] sortInteger(int[] arr) {
        if (arr.length < 2) return arr;

        int[] sortedArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sortedArr[i] = arr[i];
            int j = i;
            while (j > 0 && sortedArr[j] < sortedArr[j-1] ) {
                Utils.swap(sortedArr, j, j - 1);
                j--;
            }
        }
        return sortedArr;
    }
}
