package ru.warpreaktor.sort;

import ru.warpreaktor.util.CollectionUtils;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static ru.warpreaktor.util.CollectionUtils.swap;

/**
 * Алгоритм рекурсивно принимает массив и выбирает опорную точку (pivot).
 * Выбрав опорную точку, алгоритм делит весь входящий массив на три части
 * элементы меньше pivot, равные pivot и больше и так до базового случая.
 * Дойдя до базового случая соединяем массивы.
 * В этой реализации выбор опорной точки незамысловатый, это просто первый элемент входящего массива.
 * Для экономии памяти алгоритм не создает никаких новых массивов
 * и все перестановки элементов происходят внутри одного массива
 * T(n) = O(n log n)
 */
public class QuickSort {
    public AtomicInteger totalOperations = new AtomicInteger(0);

    //Учебный кейс с кубиками - 3, 1, 4, 7, 3, 6, 2
    public int[] sort(int[] arr) {
        //Если массив менее 2 элементов, то массив отсортирован
        if (arr.length < 2) return arr;
        sort(arr, 0, arr.length);
        return arr;
    }

    private int[] sort(int[] arr, int from, int to) {
        // Если разница между левой и правой границей части массива менее 2, значит эта часть отсортирована
        if (to - from < 2) return arr;
        //Граница левого массива от 0 до from
        int left = from;
        //Граница правого массива будет от from до arr.length
        int right = from;
        //Опорная точка это первый элемент во входящем массиве
        int pivot = arr[from];

        //Сравним объекты входящего массива в диапазоне from - to
        //Все перестановки будем производить в рамках одного массива
        for (int i = from; i < to; i++) {
            if (arr[i] < pivot) {
                totalOperations.incrementAndGet();
                swap(arr, i, right);
                swap(arr, left, right);
                left++;
                right++;
            } else if (arr[i] == pivot) {
                totalOperations.incrementAndGet();
                swap(arr, i, right);
                right++;
            }
            //Эта операция исключительно маркерная, для подсчета операций и в реальном алгоритме она не нужна
            else if (arr[i] > pivot) {
                totalOperations.incrementAndGet();
            }
        }
        //Рекурсивно вызывая алгоритм будем дробить массив до базового случая
        sort(arr, from, left);
        sort(arr, right, to);
        return arr;
    }
}
