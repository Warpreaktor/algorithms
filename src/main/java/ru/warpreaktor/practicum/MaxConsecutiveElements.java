package ru.warpreaktor.practicum;

import ru.warpreaktor.util.Utils;

public class MaxConsecutiveElements {

    /**
     * Метод считает количество одинаковых букв идущих подряд друг за другом.
     * @return - возвращает максимальное количество идущих подряд одинаковых символов.
     */
    public static int maxConsecutiveElements(String str) {
        int result = 0;
        int curLetterIdx = 0;

        while (curLetterIdx < str.length()) {
            int nextLetterIdx = curLetterIdx;
            while (nextLetterIdx < str.length() && str.charAt(nextLetterIdx) == str.charAt(curLetterIdx)) {
                ++nextLetterIdx;
            }
            result = Utils.compareAndGetMax(result, nextLetterIdx - curLetterIdx);
            curLetterIdx = nextLetterIdx;
        }
        return result;
    }
}