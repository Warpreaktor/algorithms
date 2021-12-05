package ru.warpreaktor;

import java.util.Date;
import java.util.Random;

public class Main {

    static int ARR_SIZE = 100000;
    static int NUM_BOUND = 100000;

    public static void main(String[] args) {
        int[] arr = initializeArrayNumbers();
        //Arrays.stream(arr).forEach(result -> System.out.print(result + " "));
        Date start = new Date();
        bubbleSort(arr);
        //Arrays.stream(arr).forEach(result -> System.out.print(result + " "));
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

    private static int[] initializeArrayNumbers(){
        Random random = new Random();
        int arr[] = new int[ARR_SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(NUM_BOUND);
        }
        return arr;
    }


}
