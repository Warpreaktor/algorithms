package ru.warpreaktor.the_art_of_computer_programming.volume_1_fundamental_algorithms;

/**
 * Эффективный алгоритм для нахождения наибольшего общего делителя двух целых чисел.
 *
 */
public class EuclideanAlgorithm {

    public static int euclideanAlgorithm(int m, int n) {
        int r;                       // остаток от деления
        while ((r = m % n) != 0) {  // вычислим остаток от деления m на n
            m = n;
            n = r;
        }
        return n;
    }

}
