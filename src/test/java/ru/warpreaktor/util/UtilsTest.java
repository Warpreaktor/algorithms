package ru.warpreaktor.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void compareAndGetMin() {
        Assertions.assertEquals(1, Utils.compareAndGetMin(1, 2));
        Assertions.assertEquals(-1, Utils.compareAndGetMin(5, -1));
        Assertions.assertEquals(0, Utils.compareAndGetMin(0, 10));
        Assertions.assertEquals(10, Utils.compareAndGetMin(10, 10));
    }

    @Test
    void compareAndGetMax() {
        Assertions.assertEquals(2, Utils.compareAndGetMax(1, 2));
        Assertions.assertEquals(5, Utils.compareAndGetMax(5, -1));
        Assertions.assertEquals(10, Utils.compareAndGetMax(0, 10));
        Assertions.assertEquals(10, Utils.compareAndGetMax(10, 10));
    }

    /**
     * Демонстрация того как работает упаковщик джавы.
     */
    @Test
    void wrapper(){
        Integer integer = Integer.valueOf(1);
        System.out.println(1 == integer);
    }
}