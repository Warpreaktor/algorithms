package ru.warpreaktor;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Main {

    static int ARR_SIZE = 100000;
    static int NUM_BOUND = 100000;

    public static void main(String[] args) {


    }

    static void test(){
        int[] arr = Generator.genIntegerArray(ARR_SIZE, false);

        Date start = new Date();
        stupidSearchInteger(arr,678098);
        System.out.println();
        System.out.println("----------------");
        Date end = new Date();
        long result = end.getTime() - start.getTime();
        System.out.println("Затрачено времени - " + (result / 1000) + " sec - " + (result % 1000) + " mill");

        Date start2 = new Date();
        binarySearchInteger(arr, 678098);
        Date end2 = new Date();
        System.out.println();
        System.out.println("----------------");
        long result2 = end2.getTime() - start2.getTime();
        System.out.println("Затрачено времени - " + (result2 / 1000) + " sec - " + (result2 % 1000) + " mill");
    }

    private void bubbleSortTest(){
        int[] arr = Generator.genIntegerArray(ARR_SIZE, true);
        Date start = new Date();
        bubbleSort(arr);
        System.out.println();
        System.out.println("----------------");
        Date end = new Date();
        long result = end.getTime() - start.getTime();
        System.out.println("Затрачено времени - " + (result / 1000) + " sec - " + (result % 1000) + " mill");
    }
    //Классическая сортировка пузырьком. Проходим массив от начала до конца сравнивая каждое число с последующим соседним.
    // Если соседнее число меньше, то меняем их местами. Так мы сдвинем в конец массива самое большое число.
    // При каждой следующей итерации будем походить массив на одну ячейку меньше так как в предыдущей итерации мы уже
    // сдвинули максимальное число.
    public static int[] bubbleSort(int[] arr) {
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

    //Усовершенствованная сортировка пузырьком. Теперь мы двигаемся туда и обратно при первой итерации сдвигая
    // максимальное число в конец, а в следующей минимальное число в начало.
    private static int[] shakerSort(int[] arr) {
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

    private static Integer stupidSearchInteger(int[] arr, int search){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == search){
                return arr[i];
            }
        }
        return null;
    }

    private static Integer binarySearchInteger(int[] arr, int search){
        if (arr.length / 2 == search){
            return arr.length / 2;
        }
        return null;
    }

}
