package ru.warpreaktor.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LuxAndStonesTest {

    @Test
    void luxAndstones() {
        String J = "ahrt";
        String S = "frqg";
        Assertions.assertEquals(1, LuxAndStones.luxAndStones(J, S));

        J = "abcd";
        S = "abfr";
        Assertions.assertEquals(2, LuxAndStones.luxAndStones(J, S));

        J = "arb";
        S = "aaa";
        Assertions.assertEquals(3, LuxAndStones.luxAndStones(J, S));

        J = "afrr";
        S = "aabc";
        Assertions.assertEquals(2, LuxAndStones.luxAndStones(J, S));
    }

    @Test
    void luxAndstones2() {
        String J = "ahrt";
        String S = "feqg";
        Assertions.assertEquals(0, LuxAndStones.luxAndStones2(J, S));

        J = "abcd";
        S = "abfr";
        Assertions.assertEquals(2, LuxAndStones.luxAndStones2(J, S));

        J = "aab";
        S = "aaa";
        Assertions.assertEquals(2, LuxAndStones.luxAndStones2(J, S));

        J = "afrr";
        S = "aabc";
        Assertions.assertEquals(1, LuxAndStones.luxAndStones2(J, S));

    }

    @Test
    void luxAndstones3() {
        String J = "ahrt";
        String S = "feqg";
        Assertions.assertEquals(0, LuxAndStones.luxAndStones3(J, S));

        J = "abcd";
        S = "abfr";
        Assertions.assertEquals(2, LuxAndStones.luxAndStones3(J, S));

        J = "atb";
        S = "aaa";
        Assertions.assertEquals(3, LuxAndStones.luxAndStones3(J, S));

        J = "afrebs";
        S = "aabc";
        Assertions.assertEquals(3, LuxAndStones.luxAndStones3(J, S));

        J = "выа";
        S = "впк";
        Assertions.assertEquals(1, LuxAndStones.luxAndStones3(J, S));
    }

    @Test
    void luxAndstones4() {
        String J = "ahrt";
        String S = "feqg";
        Assertions.assertEquals(0, LuxAndStones.luxAndStones4(J, S));

        J = "abcd";
        S = "abfr";
        Assertions.assertEquals(2, LuxAndStones.luxAndStones4(J, S));

        J = "atb";
        S = "aaa";
        Assertions.assertEquals(3, LuxAndStones.luxAndStones4(J, S));

        J = "afrebs";
        S = "aabc";
        Assertions.assertEquals(3, LuxAndStones.luxAndStones4(J, S));

        J = "выа";
        S = "впк";
        Assertions.assertEquals(1, LuxAndStones.luxAndStones4(J, S));

    }
}