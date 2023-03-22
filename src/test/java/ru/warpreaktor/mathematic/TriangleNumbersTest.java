package ru.warpreaktor.mathematic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TriangleNumbersTest {

    @Test
    void calculate() {
        Assertions.assertEquals(10, TriangleNumbers.calculate(4));
        Assertions.assertEquals(15, TriangleNumbers.calculate(5));
        Assertions.assertEquals(28, TriangleNumbers.calculate(7));
        Assertions.assertEquals(500500, TriangleNumbers.calculate(1000));
        Random random = new Random();
//        int n = random.nextInt();
        int n = 3;
        int result = (n * 2 + n) / 2;
        System.out.println(result);
    }

    @Test
    void calculateR() {
        Assertions.assertEquals(10, TriangleNumbers.calculate(4));
        Assertions.assertEquals(15, TriangleNumbers.calculate(5));
        Assertions.assertEquals(28, TriangleNumbers.calculate(7));
        Assertions.assertEquals(500500, TriangleNumbers.calculate(1000));
    }
}