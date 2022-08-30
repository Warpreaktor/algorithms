package ru.warpreaktor.practicum;

import ru.warpreaktor.util.Utils;

public class MaxConsecutiveElements {

    /**
     * Метод считает количество одинаковых букв идущих подряд друг за другом.
     * @return - возвращает максимальное количество идущих подряд одинаковых символов.
     *
     * Решение: Нам потребуется три переменные result, в которой будем хранить промежуточный результат и i, в которой будем
     * хранить первый указатель. Третья переменная будет хранить в себе второй указатель и объявим мы ее уже внутри первого цикла.
     * Все решение строится на двух циклах while. В первом мы встаем первым указателем в начало массива, а во вторым
     * встаем туда же и в условии самого цикла сравним элемент с индексом i и элемент с индексом j. Если они равны
     * значит увеличим второй указатель на 1, сравним еще раз два индекса и будем так сравнивать до тех пор пока
     * массив с индексом j не вернёт нам отличное число от того что хранится по индексу i.
     * Когда получили отличное число, посчитаем разницу между индексами i и j это и будет промежуточным результатом.
     * Теперь сравним промежуточный результат с тем что хранится в переменной result, если он больше, то присвоим новый
     * результат переменной result.
     * Подвинем указатель i на место, где остановился указатель j
     */
    public static int maxConsecutiveElements(String str) {
        int result = 0;
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (j < str.length() && str.charAt(j) == str.charAt(i)) {
                ++j;
            }
            result = Utils.compareAndGetMax(result, j - i);
            i = j;
        }
        return result;
    }

    public static int maxConsecutiveElements(int[] arr){
        if(arr.length < 2){
            return arr.length;
        }

        int result = 0;
        int i = 0;
        while(i < arr.length){
            int j = i;
            while(j < arr.length && arr[i] == arr[j]){
                j++;
            }
            if(result < j - i){
                result = j - i;
            }
            i = j;
        }
        return result;
    }
}