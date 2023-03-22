package ru.warpreaktor.mathematic;

/**
 * Ряд чисел 1,3,6,10,15,21,28... получается при сложении последнего числа в ряде со следующим порядковым номером числа.
 * Ряд начинается с суммы чисел 0 + 1(порядковый номер первого числа), за тем 1(последнее число в ряду) + 2 (следующий порядковый номер),
 * далее 3 + 3, 6 + 4, 10 + 5 и т.д.
 * Числа называются треугольным, так как их можно представить вот в таком виде:
 * 4
 * 3-3
 * 2-2-2
 * 1-1-1-1
 * Общая сумма такого треугольника из 4 столбцов = 10
 */
public class TriangleNumbers {

    /**
     * Решение с циклом
     */
    public static int calculate(int triangleNumber) {
        int result = 0;
        for(int i = 1; i <= triangleNumber; i++) {
          result = result + i;
        }
        return result;
    }

    /**
     * Решение с рекурсией
     */
    public static int calculateR(int triangleNumber) {
        int result = 0;
        if (triangleNumber > 0) {
            result = calculateR(triangleNumber - 1);
        }
        return result;
    }

}
