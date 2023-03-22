package ru.warpreaktor.mathematic;

/**
 * Эффективный алгоритм для нахождения наибольшего общего делителя двух целых чисел.
 *
 */
public class EuclideanAlgorithm {

    public static int euclideanAlgorithm(int m, int n) {
        int r;                      // остаток от деления
        int totalOperations = 0;

        totalOperations++;
        while ((r = m % n) != 0) {  // вычислим остаток от деления m на n
            totalOperations++;
            m = n;
            n = r;
        }
        System.out.println("totalOperations = " + totalOperations);
        return n;
    }

}
