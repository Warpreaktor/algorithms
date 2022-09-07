package ru.warpreaktor.practicum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Дан упорядоченный по неубыванию массив целых 32-разрядных чисел (int). Требуется удалить из него все повторения.
 */
public class DeletingDuplicates {

    /**
     * Решение с ArrayList. Нам потребуется скопировать все уникальные элементы в Лист, это мы сделаем за n,
     * за тем чтобы отдать обратно ту же структуру, т.е. массив элементов, нам придется скоипровать результат в этот
     * массив, что тоже получится за n. Т.е. массив из 10 элементов обработаем за 20 операций.
     * Асимптотика - O(2n) в любом случае.
     */
    public static int[] deletingDuplicates(int[] arr){
        if (arr.length < 2) return arr;
        ArrayList<Integer> preResult = new ArrayList<>();
        int i = arr.length - 1;
        // Проходим по данному массиву и перемещаем в новый массив, только уникальные элементы - асимптотика O(n)
        while(i >= 0){
            preResult.add(arr[i]);
            int j = i;
            while(j >= 0 && arr[j] == arr[i]){
                j--;
            }
            i = j;
        }
        // Копируем массив для выдачи результата
        int[] result = new int[preResult.size()];
        int j = 0;
        for(int k = preResult.size() - 1; k >= 0; k--){
            while (j < result.length) {
                result[j] = preResult.get(k);
                j++;
                break;
            }
        }

        return result;
    }

    /**
     * Решение с использованием только массива.
     * Будем копировать все уникальные элементы в заранее созданный массив величиной n. Это мы сделаем за время О(n).
     * Создадим переменную, в которой будем хранить индекс последнего уникального элемента в новом созданном массиве.
     * После того как результирующий массив будет заполнен вернем обрезанный массив до индекса посл. уник. элемента.
     * Асимптотика - O(n + операция с обрезанием массива). Метод java Arrays.copyOfRange работает быстрее чем O(n)
     */
    public static int[] deletingDuplicates2(int[] arr) {
        if (arr.length < 2) return arr;
        int[] result = new int[arr.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while(i < arr.length) {
            result[index] = arr[j];
            index++;
            while(j < arr.length && arr[j] == arr[i]) {
                j++;
            }
            i = j;
        }
        return Arrays.copyOfRange(result, 0, index);
    }
}