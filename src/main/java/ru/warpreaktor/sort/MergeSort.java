package ru.warpreaktor.sort;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static ru.warpreaktor.util.CollectionUtils.isSorted;

/**
 * Сортировка Слиянием - Merge Sort.
 * Утверждается, что два отсортированных массива можно слить поочерёдно сравнивая крайние левые элементы двух массивов
 * и перекладывая их в третий результирующий массив. При этом утверждается что массив из одного элемента всегда
 * отсортирован. Идея заключается в том, что бы рекурсивно вызывать метод сортировки на массивах более двух элементов,
 * пока не доберемся до двух отсортированных массивов (согласно утверждению выше). Далее вверх по стеку будем возвращать
 * уже отсортированные два массива которые так же будут подвергаться слиянию до самой верхушки стека.
 * T(n) = O(n log n)
 * код написан по лекции Павла Маврина - https://www.youtube.com/watch?v=apR9GhhjBjM&ab_channel=PavelMavrin
 */
public class MergeSort {
    public AtomicInteger totalOperations = new AtomicInteger(0);

    public int[] mergeSort(int[] arr) {
        int[] result = sort(arr);
        return result;
    }

    public int[] mergeSortIfNotSorted(int[] arr) {
        //Если массив менее двух элементов - массив отсортирован
        if (arr.length < 2) return arr;
        //Если массив отсортирован, вернем его как есть. T(n) = O(n)
        AtomicInteger ops = new AtomicInteger(0);
        if (isSorted(arr, totalOperations)) {
            return arr;
        }
        int[] result = sort(arr);
        return result;
    }

    private int[] sort(int[] arr) {
        //Если массив менее двух элементов - массив отсортирован
        if (arr.length < 2) return arr;
        //Разделим входящий массив на две примерно равные части
        int[] a, b;
        int n = arr.length;
        a = Arrays.copyOfRange(arr, 0, n / 2);
        b = Arrays.copyOfRange(arr, n / 2, n);

        //Будем вызывать сортировку рекурсивно отдельно для левой и правой части массива T(n) = O(log n)
        a = sort(a);
        b = sort(b);

        //Создаем третий, результирующий массив, для слияния в него двух других
        int leftArrLen = a.length;
        int rightArrLen = b.length;
        int[] result = new int[leftArrLen + rightArrLen];

        int pointerA = 0;
        int pointerB = 0;
        while (pointerA + pointerB < leftArrLen + rightArrLen) {
            //Делаем проверку на выход за границы массива и сравниваем поочередно
            // два крайних левых символа каждого из массива. T(n) = O(n)
            if (pointerB == rightArrLen || (pointerA < leftArrLen && a[pointerA] < b[pointerB])) {
                totalOperations.incrementAndGet();
                result[pointerA + pointerB] = a[pointerA];
                pointerA++;
            //Не делаем более никаких сравнений объектов, так как это самая дорогостоящая операция
            } else {
                totalOperations.incrementAndGet();
                result[pointerA + pointerB] = b[pointerB];
                pointerB++;
            }
        }
        return result;
    }
}
