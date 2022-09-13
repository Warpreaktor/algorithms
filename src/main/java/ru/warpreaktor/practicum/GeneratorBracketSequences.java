package ru.warpreaktor.practicum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Дано целое число n. Требуется вывести все правильные скобочные последовательности длины 2 * n,
 * упорядоченные лексикографически (см. https://ru.wikipedia.org/wiki/Лексикографический_порядок).
 * В задаче используются только круглые скобки.
 */
public class GeneratorBracketSequences {

    /**
     * Решение рекурсией.
     * Алгоритм взят отсюда https://habr.com/ru/company/vk/blog/420605/
     * Асимптотика -
     */
    public static ArrayList<char[]> generate(int bracketsNumber) {
        ArrayList<char[]> result = new ArrayList<>();
        int k = bracketsNumber * 2; //количество скобок
        char[] sequence = new char[k]; // пустой список, куда кладем скобки
        int cnt = 0; // разница между скобками
        int ind = 0; // индекс, по которому кладем скобку в список
        return generate(cnt, ind, k, sequence, result);
    }
    private static ArrayList<char[]> generate(int cnt, int ind, int k, char[] sequence, ArrayList<char[]> result) {

        //кладем откр.скобку, только если хватает места
        if (cnt <= k - ind - 2) {
            sequence[ind] = '(';
            generate(cnt + 1, ind + 1, k, sequence, result);
        }
        //закр.скобку можно положить всегда, если cnt > 0
        if (cnt > 0) {
            sequence[ind] = ')';
            generate(cnt - 1, ind + 1, k, sequence, result);
        }
        //выходим из рекурсии и добавляем результирующую строку в массив
        if (ind == k) {
            if (cnt == 0) {
                result.add(Arrays.copyOf(sequence, sequence.length));
            }
        }
        return result;
    }
}
