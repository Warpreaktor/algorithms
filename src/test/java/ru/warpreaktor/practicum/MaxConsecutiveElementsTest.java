package ru.warpreaktor.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxConsecutiveElementsTest {

    @Test
    void maxConsecutiveElements() {
        String str = "аабвгддд";
        Assertions.assertEquals(3, MaxConsecutiveElements.maxConsecutiveElements(str));

        str = "аffffабвгддд";
        Assertions.assertEquals(4, MaxConsecutiveElements.maxConsecutiveElements(str));

        str = "а;'ljlklflабв4дуд";
        Assertions.assertEquals(1, MaxConsecutiveElements.maxConsecutiveElements(str));
    }
}