package ru.warpreaktor.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorBracketSequencesTest {

    @Test
    void generate() {
        ArrayList<char[]> arr = GeneratorBracketSequences.generate(1);
        ArrayList<char[]> assertions = new ArrayList<>();
        assertions.add(new char[]{'(',')'});
        for (int i = 0; i < arr.size(); i++) {
            Assertions.assertArrayEquals(assertions.get(i), arr.get(i));
        }

        arr = GeneratorBracketSequences.generate(2);
        assertions = new ArrayList<>();
        assertions.add(new char[]{'(','(',')',')'});
        assertions.add(new char[]{'(', ')', '(', ')'});
        for (int i = 0; i < arr.size(); i++) {
            Assertions.assertArrayEquals(assertions.get(i), arr.get(i));
        }

        arr = GeneratorBracketSequences.generate(3);
        assertions = new ArrayList<>();
        assertions.add(new char[]{'(','(','(',')',')',')'});
        assertions.add(new char[]{'(','(', ')', '(',')',')'});
        assertions.add(new char[]{'(','(', ')',')','(',')'});
        assertions.add(new char[]{'(',')', '(','(',')',')'});
        assertions.add(new char[]{'(',')', '(',')','(',')'});
        for (int i = 0; i < arr.size(); i++) {
            Assertions.assertArrayEquals(assertions.get(i), arr.get(i));
        }
    }
}