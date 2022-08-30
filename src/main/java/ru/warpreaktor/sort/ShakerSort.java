package ru.warpreaktor.sort;

/**
 *  Усовершенствованная сортировка пузырьком. Теперь мы двигаемся туда и обратно при первой итерации сдвигая
 *  максимальное число в конец, а в следующей минимальное число в начало.
 */
public class ShakerSort {

    public static int[] sort(int[] arr) {
        int buf = 0;
        int count = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
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
