package ru.warpreaktor.util.date_structure.list;

/**
 * Простая(учебная) реализация Динамического Не Синхронизированного Массива.
 */
public class ArrayList {

    private int size = 0;
    private int capacity = 10;
    private String[] data;
    private final double capacityMultiplier = 1.5;

    public ArrayList() {
        this.data = new String[capacity];
    }

    public ArrayList(int capacity) {
        this.capacity = capacity;
        this.data = new String[capacity];
    }

    /**
     * Возвращает текущий размер SimpleArrayList
     * O(1)
     */
    public int size() {
        return size;
    }

    /**
     * Возвращает элемент по индексу
     * O(1)
     */
    public String get(int index) {
        //Выполним проверку на границы массива.
        //Для чего нужна такая проверка? Что будет если просто отдавать запрошенный элемент?
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[index];
    }

    /**
     * Заменяет элемент по индексу
     * O(1)
     */
    public void set(int index, String value) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        data[index] = value;
    }

    /**
     * Добавляет новый элемент в конец списка
     * best case = O(1); bad case = 0(n)
     */
    public boolean add(String value) {
        //Если размер массива станет больше текущей capacity, то нарастим массив
        if (size >= capacity) {
            grow(capacity);
        }
        data[size] = value;
        size++;
        return true;
    }

    /**
     * Удаление объекта по индексу.
     * Операция требует переиндексирования всех объектов следующих за удаляемым.
     * O(n)
     */
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = index; i < size; i++) {
            data[i] = data[i+1];
        }
        //При удалении объекта изменяем только диапазон доступной области
        size--;
        return true;
    }

    /**
     * Системный метод, для наращивания массива.
     */
    public void grow(int capacity) {
        //Копируем наш массив в новый, большего размера и увеличиваем вместимость
        int newCapacity = (int) (capacity * capacityMultiplier);
        String[] arr = new String[newCapacity];
        for (int i = 0; i < data.length; i++) {
            arr[i] = data[i];
        }
        this.capacity = newCapacity;
        data = arr;
    }

    /**
     * Возвращает хранимые данные в виде массива размером равным size.
     */
    public String[] toArray() {
        String[] newData = new String[this.size];
        for (int i = 0; i < newData.length; i++) {
            newData[i] = data[i];
        }
        return newData;
    }
}
