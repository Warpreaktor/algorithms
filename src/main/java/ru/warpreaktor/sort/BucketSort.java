package ru.warpreaktor.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Сортировка корзинами.
 * Идея заключается в том, что бы разбить массив входящи элементов на константно
 * отсортированные корзины, это значит, что создав массив с количеством элементов, равному
 * в массиве.
 */
public class BucketSort {
    private AtomicInteger totalOperations = new AtomicInteger(0);

    public AtomicInteger getTotalOperations() {
        return totalOperations;
    }

    /**
     * Сортировка корзинами с заранее известными данными.
     * Простейшая реализация. Создаем индексированный список в котором каждый номер индекса будет
     * равен элементу из массива для сортировки.
     * Минусы:
     * 1. Метод НЕ работает с отрицательными числами.
     * 2. Расходуется много лишней памяти.
     */
    public void simpleBucketSort(int[] arr) {
        if (arr == null) return;

        //Вычислим максимальное число в массиве
        int max = maxInt(arr);

        if (max < 1) {
            return;
        } else {
            max += 1;
        }
        // Создаем массив с максимальной емкостью и инициализируем все данные в корзине равными 0.
        int[] buckets;
        buckets = new int[max];

        // 1. Ведем подсчет
        for (int i = 0; i < arr.length; i++) {
            totalOperations.incrementAndGet();
            buckets[arr[i]]++;
        }
        // 2. Заполняем результирующий массив согласно подсчету
        for (int i = 0, j = 0; i < max; i++) {
            while ((buckets[i]--) > 0) {
                totalOperations.incrementAndGet();
                arr[j++] = i;
            }
        }
        buckets = null;
    }

    /**
     * Сортируем корзины при помощи hash таблицы разбивая входящий массив на такое
     * количество корзин, чтобы при обратном их сложении получить отсортированный список.
     * T(n) = O(3n)
     * Плюсы:
     * 1. Можем сортировать как отрицательные числа так и положительные. Целые или вещественные.
     * Гипотетически можно сортировать вообще любые объекты, если их величину можно точно определить как самая малая или
     * самая большая. Например: если брать строки то самая малая строка может быть обозначена
     * как "а", а самая большая как "яяяяяяяяяя". Однако, нужно осознавать, что в таком
     * случае придется создать такое количество корзин, сколько будет комбинаций перестановок букв
     * в этом диапазоне. Думаю, на практике это ближе к невозможному.
     * 2. Сама сортировка происходит за линейное время.
     * Минусы:
     * 1. Требует большое количество памяти.
     * 2. Слишком узкое применение на практике.
     */
    public int[] hashBucketSort(int[] arr) {
        if (arr.length < 2) return arr;
        //Вычислим диапазон чисел в массиве O(n)
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            totalOperations.incrementAndGet();
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //Массив отсортирован. Условие для выхода из рекурсии
        if (max - min == 0) return arr;

        //Вычислим количество корзин
        int bucketNumbers = Math.abs(min) + max;
        //Корзины будем хранить в мапе, <НомерКорзины, Корзина>
        HashMap<Integer, AtomicInteger> buckets = new HashMap<>();
        //Инициализация корзин
        for (int i = min; i <= max; i++) {
            buckets.put(i, new AtomicInteger(0));
        }
        //Распределяем входящий массив по корзинам
        for (int i = 0; i < arr.length; i++) {
            totalOperations.incrementAndGet();
            buckets.get(arr[i]).incrementAndGet();
        }
        //Сортируем корзину
        int j = 0;
        for (int i = min; i <= max; i++) {
            AtomicInteger bucket = buckets.get(i);
            for (int k = 0; k < bucket.get(); k++) {
                totalOperations.incrementAndGet();
                arr[j] = i;
                j++;
            }
        }
        return arr;
    }

    /**
     * Преимуществом этой реализации является пропорциональное создание бакетов.
     * Этот метод создаёт количество корзин равное количеству элементов входящего массива.
     * Однако, по-скольку неизвестно сколько всего элементов будет в массиве, тут некоторый есть оверхед
     * При создании корзины, мы выделяем памяти равное ArrayList. Здесь же мы можем терять и в скорости.
     * This code is contributed by Rajput-Ji
     * from https://www.geeksforgeeks.org/bucket-sort-to-sort-an-array-with-negative-numbers/
     * T(n) = O(n + k)
     */
    private void mixedSort(Vector<Double> arr, int n) {
        // 1) Создадим n пустых корзин
        ArrayList<Double> b[] = new ArrayList[n];
        for (int i = 0; i < b.length; i++) {
            b[i] = new ArrayList<>();
        }
        // 2) Разложим элементы по корзинам пропорционально.
        for (int i = 0; i < n; i++) {
            totalOperations.incrementAndGet();
            int bi = (int) (n * arr.get(i)); // Index in bucket
            b[bi].add(arr.get(i));
        }
        // 3) Отсортируем корзины при помощи quicksort
        for (int i = 0; i < n; i++) {
//            Collections.sort(b[i]); //<-- this ic original code

            //<-- this is marker code
            QuickSort quickSort = new QuickSort();
            quickSort.sort(b[i]);
            totalOperations.getAndAdd(quickSort.totalOperations.get());
            //<-- end of marker code
        }
        // 4) Соберем все бакеты в результирующий массив
        int index = 0;
        arr.clear();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < b[i].size(); j++) {
                arr.add(b[i].get(j));
            }
        }
    }

    /**
     * Этот метод главным образом разбивает входящий массив
     * на две части отрицательных и положительных чисел
     * и за тем вызывает bucketSort() для обеих частей.
     */
    public void mixedSort(double arr[]) {
        int n = arr.length;
        Vector<Double> Neg = new Vector<>();
        Vector<Double> Pos = new Vector<>();

        // traverse array elements
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0)
                // store -Ve elements by
                // converting into +ve element
                Neg.add(-1 * arr[i]);
            else
                // store +ve elements
                Pos.add(arr[i]);
        }
        mixedSort(Neg, Neg.size());
        mixedSort(Pos, Pos.size());

        // First store elements of Neg[] array
        // by converting into -ve
        for (int i = 0; i < Neg.size(); i++) {
            arr[i] = -1 * Neg.get(Neg.size() - 1 - i);
        }

        // store +ve element
        for (int j = Neg.size(); j < n; j++) {
            arr[j] = Pos.get(j - Neg.size());
        }
    }

    private int maxInt(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            totalOperations.incrementAndGet();
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
