package ru.warpreaktor.leetcode.yandex_tasks;

import java.util.Locale;
import java.util.Objects;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
 * all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidPalindrome {

    public static boolean isPalindrome2(String s) {
        if (s == null) return false;
        String reference = s.toLowerCase(Locale.ROOT).replaceAll("[\\W_]", "").trim();
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            Character ch = Character.toLowerCase(s.charAt(i));
            if (!Character.isLetterOrDigit(ch)) continue;
            sb.append(ch);
        }
        return Objects.equals(sb.toString(), reference);
    }

}
