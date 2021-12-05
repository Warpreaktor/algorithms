package ru.warpreaktor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private int[] arr = null;
    private final Random random = new Random();
    private final Main main = new Main();
    @BeforeEach
    void setUp() {
        arr = new int[]{6,1,4,5,2,9,7,3,8,0};
    }

    @AfterEach
    void cleanData(){
        arr = null;
    }

    @Test
    public void bubbleSort(){
        int[] arrExpected = new int[]{0,1,2,3,4,5,6,7,8,9};
        main.bubbleSort(arr);
        Assertions.assertArrayEquals(arr, arrExpected);
    }
}