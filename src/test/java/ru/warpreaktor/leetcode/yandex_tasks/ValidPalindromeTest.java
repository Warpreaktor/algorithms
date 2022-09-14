package ru.warpreaktor.leetcode.yandex_tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {

    @Test
    void isPalindrome() {
        Assertions.assertEquals(true, ValidPalindrome.isPalindrome2("A man, a plan, a canal: Panama"));
        Assertions.assertEquals(true, ValidPalindrome.isPalindrome2("1b1"));
        Assertions.assertEquals(false, ValidPalindrome.isPalindrome2(null));
        Assertions.assertEquals(false, ValidPalindrome.isPalindrome2("0P"));
        Assertions.assertEquals(true, ValidPalindrome.isPalindrome2("ab_a"));
    }

}