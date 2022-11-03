package ru.warpreaktor.sort;

import static ru.warpreaktor.util.CollectionUtils.swap;

/**
 * Усовершенствованная сортировка пузырьком. Теперь мы двигаемся туда и обратно при первой итерации сдвигая
 * максимальное число в конец, а в следующей минимальное число в начало.
 */
public class ShakerSort {

    //by Warper
    public static int[] stupidShakerSort(int[] arr) {
        int pointerA = arr.length - 1;
        int pointerB = 0;
        int totalOperations = 0;

        int i = 0;
        totalOperations++;
        while (pointerA > pointerB) {
            totalOperations++;
            while (i + 1 <= pointerA) {
                totalOperations++;
                if (arr[i] > arr[i + 1]) {
                    totalOperations++;
                    swap(arr, i, i + 1);
                }
                i++;
            }
            pointerA--;
            i--;

            totalOperations++;
            while (i - 1 >= pointerB) {
                totalOperations++;
                if (arr[i] < arr[i - 1]) {
                    totalOperations++;
                    swap(arr, i, i - 1);
                }
                i--;
            }
            pointerB++;
            i++;
        }
        System.out.println("n = " + arr.length + " total operations = " + totalOperations);
        return arr;
    }

    /**
     * Если при движении по части массива перестановки не происходят, то эта часть массива уже отсортирована и,
     * следовательно, её можно исключить из рассмотрения.
     * алгоритм взят с https://www.geeksforgeeks.org/cocktail-sort/
     */
    public static int[] smartShakerSort(int arr[])
    {
        boolean swapped = true;
        int start = 0;
        int end = arr.length;
        int totalOperations = 0;

        totalOperations++;
        while (swapped == true)
        {
            swapped = false;
            totalOperations++;
            for (int i = start; i < end - 1; ++i)
            {
                totalOperations++;
                if (arr[i] > arr[i + 1]) {
                    totalOperations++;
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            totalOperations++;
            if (swapped == false){
                break;
            }
            swapped = false;
            end = end - 1;
            totalOperations++;
            for (int i = end - 1; i >= start; i--)
            {
                totalOperations++;
                if (arr[i] > arr[i + 1])
                {
                    totalOperations++;
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            start = start + 1;
        }
        System.out.println("n = " + arr.length + " total operations = " + totalOperations);
        return arr;
    }

    //алгоритм взят https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%BF%D0%B5%D1%80%D0%B5%D0%BC%D0%B5%D1%88%D0%B8%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5%D0%BC
    public static  int[] wikiShakerSort(int arr[]) {
        int buff;
        int left = 0;
        int right = arr.length - 1;
        int totalOperations = 0;

        do {
            totalOperations++;
            for (int i = left; i < right; i++) {
                totalOperations++;
                if (arr[i] > arr[i + 1]) {
                    totalOperations++;
                    buff = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buff;
                }
            }
            right--;
            totalOperations++;
            for (int i = right; i > left; i--) {
                totalOperations++;
                if (arr[i] < arr[i - 1]) {
                    totalOperations++;
                    buff = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = buff;
                }
            }
            left++;
        } while (left < right);
        totalOperations++;
        System.out.println("n = " + arr.length + " total operations = " + totalOperations);
        return arr;
    }
}
