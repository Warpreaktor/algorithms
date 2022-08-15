package ru.warpreaktor.sort;

/**
 *  Классическая сортировка пузырьком. Проходим массив от начала до конца сравнивая каждое число с последующим соседним.
 *  Если соседнее число меньше, то меняем их местами. Так мы сдвинем в конец массива самое большое число.
 *  При каждой следующей итерации будем походить массив на одну ячейку меньше так как в предыдущей итерации мы уже
 *  сдвинули максимальное число.
 *  T(n) = n2
 */
public class BubbleSort {

    public static int[] sortInteger(int[] arr) {
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
}
