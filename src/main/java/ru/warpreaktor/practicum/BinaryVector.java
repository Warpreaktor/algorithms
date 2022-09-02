package ru.warpreaktor.practicum;

import ru.warpreaktor.util.Utils;

/**
 * Последовательно идущие единицы.
 * Требуется найти в бинарном векторе самую длинную последовательность...
 */
public class BinaryVector {

    /**
     * Требуется найти в бинарном векторе самую длинную последовательность единиц.
     *
     * Решение с двумя указателями.
     * O(n)
     */
    public static int findSequenceOfNumber(int[] bv) {
        int result = 0;
        int i = 0;
        while (i < bv.length) {
            if (bv[i] != 1){
                i++;
                continue;
            }
            int j = i;
            while (j < bv.length && bv[j] == 1) {
                j++;
            }
            result = Utils.compareAndGetMax(result, j - i);
            i = j;
        }
        return result;
    }

    /**
     * Требуется найти в бинарном векторе самую длинную последовательность единиц.
     *
     * O(n). Сложность остаётся прежней, но это решение проще написать без ошибок, оно всего с одним
     * указателем и осуществляется в один проход по массиву.
     */
    public static int findSequenceOfNumber2(int[] bv) {
        int counter = 0;
        int result = 0;
        int i = 0;

        while(i < bv.length){
            if(bv[i] == 1){
                counter++;
            } else {
                if(result < counter) result = counter;
                counter = 0;
            }
            i++;
        }
        if(result < counter) result = counter;
        return result;
    }

    /**
     * Требуется найти в бинарном векторе самую длинную последовательность символов.
     */
    public static int maxSequence(int[] bv) {
        int result = 0;
        int i = 0;
        while (i < bv.length) {
            int j = i;
            while (j < bv.length && bv[j] == bv[i]) {
                j++;
            }
            result = Utils.compareAndGetMax(result, j - i);
            i = j;
        }
        return result;
    }
}
