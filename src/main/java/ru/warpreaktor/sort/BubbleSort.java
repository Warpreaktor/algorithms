package ru.warpreaktor.sort;

/**
 *  Классическая сортировка пузырьком. Проходим массив от начала до конца сравнивая каждое число с последующим соседним.
 *  Если соседнее число меньше, то меняем их местами. Так мы сдвинем в конец массива самое большое число.
 *  При каждой следующей итерации будем походить массив на одну ячейку меньше так как в предыдущей итерации мы уже
 *  сдвинули максимальное число.
 *  Асимптотика - O(n2)
 */
public class BubbleSort {

    /**
     * Сортировка целых чисел
     */
    public static int[] sort(int[] arr) {
        int buf = 0; // буфер для хранения числа во время swap
        int pointer = arr.length-1; // указатель
        int totalOperations = 0;

        totalOperations++;
        for (int i = 0; i < arr.length; i++) {
            totalOperations++;
            for (int j = 0; j < pointer; j++) {
                totalOperations++;
                if (arr[j] > arr[j+1]) {
                    totalOperations++;
                    //операция swap
                    buf = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = buf;
                    //операция swap
                }
            }
            pointer--;
        }
        System.out.println("n = " + arr.length + " total operations = " + totalOperations);
        return arr;
    }
}
