package ru.warpreaktor.the_art_of_computer_programming.volume_1_fundamental_algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EuclideanAlgorithmTest {

    @Test
    void bestCase(){
        int m = 100;
        int n = 100;
        Assertions.assertEquals(100, EuclideanAlgorithm.euclideanAlgorithm(m, n));
    }

    @Test
    void badCase(){
        int m = 89;
        int n = 55;
        Assertions.assertEquals(1, EuclideanAlgorithm.euclideanAlgorithm(m, n));
    }

    //Числа на вход в 10 млн раз больше чем в badCase
    @Test
    void bigCase(){
        int n = 893728492;
        int m = 558353084;
        Assertions.assertEquals(4, EuclideanAlgorithm.euclideanAlgorithm(m, n));
    }

    @Test
    void euclideanAlgorithm() {
        int m = 3;
        int n = 4;
        Assertions.assertEquals(1, EuclideanAlgorithm.euclideanAlgorithm(m, n));

        m = 16;
        n = 8;
        Assertions.assertEquals(8, EuclideanAlgorithm.euclideanAlgorithm(m, n));

        m = 36;
        n = 48;
        Assertions.assertEquals(12, EuclideanAlgorithm.euclideanAlgorithm(m, n));

        m = 119;
        n = 544;
        Assertions.assertEquals(17, EuclideanAlgorithm.euclideanAlgorithm(m, n));

        m = 21;
        n = 34;
        Assertions.assertEquals(1, EuclideanAlgorithm.euclideanAlgorithm(m, n));
    }
}