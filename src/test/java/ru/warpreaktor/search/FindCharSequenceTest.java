package ru.warpreaktor.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindCharSequenceTest {

    @Test
    void findCharSequence() {
        Assertions.assertEquals(true, FindCharSequence.findCharSequence("abcdef", "dbc"));
        Assertions.assertEquals(true, FindCharSequence.findCharSequence("santa", "atn"));
        Assertions.assertEquals(true, FindCharSequence.findCharSequence("debotagalish", "hilas"));
        Assertions.assertEquals(false, FindCharSequence.badFindCharSequence("acf", "bb"));
        Assertions.assertEquals(false, FindCharSequence.findCharSequence("ывпвыоывпдлылитодвлиадыолвиравы", "гне"));
        Assertions.assertEquals(false, FindCharSequence.findCharSequence("ывпвыоывпдлылитодвлиадыолвиравы", "дипллты"));
    }
}