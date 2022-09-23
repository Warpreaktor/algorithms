package ru.warpreaktor.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * An integer array original is transformed into a doubled array changed by appending twice the value of
 * every element in original, and then randomly shuffling the resulting array.
 * <p>
 * Given an array changed, return original if changed is a doubled array.
 * If changed is not a doubled array, return an empty array. The elements in original may be returned in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: changed = [1,3,4,2,6,8]
 * Output: [1,3,4]
 * Explanation: One possible original array could be [1,3,4]:
 * - Twice the value of 1 is 1 * 2 = 2.
 * - Twice the value of 3 is 3 * 2 = 6.
 * - Twice the value of 4 is 4 * 2 = 8.
 * Other original arrays could be [4,3,1] or [3,1,4].
 * Example 2:
 * <p>
 * Input: changed = [6,3,0,1]
 * Output: []
 * Explanation: changed is not a doubled array.
 * Example 3:
 * <p>
 * Input: changed = [1]
 * Output: []
 * Explanation: changed is not a doubled array.
 */
public class FindOriginalArrayFromDoubledArray {

    /**
     * Мы исходим из того суждения, что массив, размер которого не кратно двум есть - неправильный массив,
     * а значит будем сразу возвращать ответ в виде пустого массива.
     * <p>
     * Нам потребуется: мапа в которой будут числа из входящего массива против количества их вхождений,
     * результирующий массив величиной вдвое меньше входящего, указатель на индекс в
     * результирующем массиве resultCounter и счетчик указывающий пары в мапе, которые еще не схлопнулись diffCounter.
     * <p>
     * Первым делом отсортируем входящий массив, это необходимо для того, чтобы правильно найти пары в кейсах типа 4,4,16,8,8,2.
     * Далее будем добавлять в мапу числа от большего к меньшему и инкрементировать счетчик вхождения этого числа,
     * а так же общий счетчик расхождений.
     * Если очередное число из отсортированного массива умноженное на два присутствует в мапе то считаем что у нас нашлась пара,
     * декриментируем счетчик этого числа в мапе и добавим в результирующий массив оригинальное число, сдвинув счетчик
     * resultCounter вправо, а счетчик разницы влево.
     * По окончании цикла проверим diffCounter если есть какие-то расхождения, то значит у нас остались ненайденные пары
     * и мы возвращаем пустой массив.
     *
     * Асимптотика O(N log N)
     *
     */
    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) return new int[]{};

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[changed.length / 2];
        int resultCounter = 0;
        int diffCounter = 0;

        Arrays.sort(changed);

        for (int i = changed.length - 1; i >= 0; i--) {
            int var = changed[i];
            Integer mult = map.get(var * 2);

            if (mult != null && mult != 0) {
                map.put(var * 2, mult - 1);
                result[resultCounter] = var;
                resultCounter++;
                diffCounter--;
            } else {
                map.put(var, map.get(var) == null ? 1 : map.get(var) + 1);
                diffCounter++;
            }
        }
        if (diffCounter != 0) return new int[]{};
        return result;
    }

    /**
     * Решение взято с:
     * https://leetcode.com/problems/find-original-array-from-doubled-array/discuss/2577803/JAVA-oror-Easy-Solution-oror-100-Faster-Code-oror-Beginner-Friendly
     * На первый взгляд на тесты замеряющие время выполнения кажется, что решение работает быстрее чем решение в методе findOriginalArray
     * однако, в кейсах с большими данными и большими цифрами этот метод начинает значительно проигрывать как раз из за
     * квадратичной асимптотики.
     *
     */
    public static int[] findOriginalArray2(int[] changed) {
        int[] res;
        int index = 0;
        if (changed.length % 2 == 1) return new int[0];
        res = new int[changed.length / 2];

        int max = 0;
        for (int num : changed) {
            max = Math.max(max, num);
        }
        int[] nums = new int[max + 1];
        for (int num : changed) {
            nums[num]++;
        }

        if (nums[0] % 2 == 1) return new int[0];
        index = fill(0, nums[0] / 2, res, index);

        for (int i = 1; i <= max / 2; i++) {
            if (nums[2 * i] < nums[i]) return new int[0];
            nums[2 * i] -= nums[i];
            index = fill(i, nums[i], res, index);
        }
        return index != res.length ? new int[0] : res;
    }

    private static int fill(int num, int count, int[] res, int index) {
        while (count-- > 0) {
            res[index++] = num;
        }
        return index;
    }

}
