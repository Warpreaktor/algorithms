package ru.warpreaktor.search;

/**
 * Бинарный поиск. Алгоритм получает на вход отсортированную коллекцию элементов
 * и элемент который необходимо найти.
 * Если искомый элемент присутствует в коллекции, то на выходе получаем позицию
 * в которой он был найден, в противном случае получаем null.
 */

public class BinarySearch {

    /**
     * В данном алгоритме считаем самой тяжелой операцией операцию сравнения одного объекта с другим
     * и именно эту операцию будем считать.
     * @return - позицию искомого элемента.
     */
    public static Integer binarySearch(int[] arr, int find) {
        Integer result = null;
        int start = 0;               //Начало проверяемого диапазона
        int end = arr.length - 1;   //Конец проверяемого диапазона
        int totalOperations = 0;

        while (start <= end) {
            int pointer = (start + end) / 2; //Указатель на элемент массива

            //Вернем пп номер из коллекции на элемент, если нашли его
            if (arr[pointer] == find) {
                totalOperations++;
                System.out.println("hard operations = " + totalOperations);
                return pointer;
            }
            //Сдвинем начало диапазона вправо если искомый элемент больше найденного и наоборот, если меньше
            if(arr[pointer] < find) {
                totalOperations++;
                start = pointer + 1;
            } else {
                totalOperations++;
                end = pointer - 1;
            }
        }
        System.out.println("hard operations = " + totalOperations);
        return result;
    }

    /**
     * Алгоритм взят из книги Грокаем Алгоритмы и переписан с языка Python.
     */
    public static Integer grockaemBinarySearch(int[] list, int item) {
        int low = 0;
        int high = list.length - 1;
        int totalOperations = 0;

        while (low <= high) {
            int mid = (low + high);
            int guess = list[mid];

            if (guess == item) {
                totalOperations++;
                System.out.println("hard operations = " + totalOperations);
                return mid;
            }

            if (guess > item) {
                totalOperations++;
                high = mid - 1;
            } else {
                totalOperations++;
                low = mid + 1;
            }
        }
        System.out.println("hard operations = " + totalOperations);
        return null;
    }

    /**
     * Бинарный поиск с рекурсивным вызовом.
     * Код взят с сайта https://proglib.io/p/6-search-algorithms-java
     */
    public static int recursiveBinarySearch(int arr[], int firstElement, int lastElement, int elementToSearch) {

        // условие прекращения
        if (lastElement >= firstElement) {
            int mid = firstElement + (lastElement - firstElement) / 2;

            // если средний элемент - целевой элемент, вернуть его индекс
            if (arr[mid] == elementToSearch)
                return mid;

            // если средний элемент больше целевого
            // вызываем метод рекурсивно по суженным данным
            if (arr[mid] > elementToSearch)
                return recursiveBinarySearch(arr, firstElement, mid - 1, elementToSearch);

            // также, вызываем метод рекурсивно по суженным данным
            return recursiveBinarySearch(arr, mid + 1, lastElement, elementToSearch);
        }

        return -1;
    }

}
