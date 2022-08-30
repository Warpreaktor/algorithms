package ru.warpreaktor.sort;

import ru.warpreaktor.util.Utils;

/**
 *  Классическая сортировка пузырьком. Проходим массив от начала до конца сравнивая каждое число с последующим соседним.
 *  Если соседнее число меньше, то меняем их местами. Так мы сдвинем в конец массива самое большое число.
 *  При каждой следующей итерации будем походить массив на одну ячейку меньше так как в предыдущей итерации мы уже
 *  сдвинули максимальное число.
 *  T(n) = n2
 */
public class BubbleSort {

    public static int[] sort(int[] arr) {
        int buf = 0;
        int count = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < count-1; j++) {
                if (arr[j] > arr[j+1]){
                    buf = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = buf;
                }
            }
            count--;
        }
        return arr;
    }

    public static char[] sort(char[] arr) {
        int count = arr.length;
        while(count != 0) {
            for(int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]) {
                    Utils.swap(arr, i, i+1);
                }
            }
            count--;
        }
        return arr;
    }
}
