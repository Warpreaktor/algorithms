package ru.warpreaktor.util.date_structure.hash_table;

import java.util.Objects;

public class HashTable<K, V> {
    private int capacity = 16; //вместимость таблицы по умолчанию
    private final int MAX_CAPACITY = 1073741824; //Максимальная вместимость таблицы
    private final float LOAD_FACTOR = 0.7F; //Коэффициент заполнения
    private int threshold; //Коэффициент заполнения
    private Node<K, V>[] table; //Таблица хранимых значений
    public int size;

    public HashTable() {
        this.table = new Node[capacity];
        this.threshold = (int)(capacity * LOAD_FACTOR);
    }

    public HashTable(int capacity, float loadFactor) {
        this.table = new Node[capacity];
        this.threshold = (int)(capacity * loadFactor);
    }

    /**
     * Путем побитового сравнения вычислим index в массиве.
     * Оператор & скопирует в результат только существующие биты в обоих числах, а значит
     * никогда не будет больше числа с которым его сравнивают, в данном случае это (capacitiy - 1)
     * Пример вычисления индекса:
     * 250 (1111 1010) & (16 - 1) (0000 1111) = 10 (0000 1010)
     *
     * @param hash - хеш из которого будет вычислен индекс.
     * @return - индекс бакета
     */
    public int index(int hash) {
        return hash & (capacity - 1);
    }

    public int getSize() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    /**
     * Вставка объекта в таблицу. Из переданного ключа будет вычислен хеш методом реализованным в самом объекте.
     * Далее, из хеша будет вычислен индекс бакета, в который и будет положен объект.
     *
     * @param key   - Ключ (индекс бакета)
     * @param value - Значение хранящееся против ключа.
     * @return - Если вставка произошла в уже заполненный бакет, то вернется предыдущее значение.
     */
    public V put(K key, V value) {
        //Вычисляется хеш и индекс от ключа
        int hash = key.hashCode();
        int index = index(hash);
        Node<K, V> node = new Node<>(hash, key, value, null);
        V oldValue = null;
        //Проверяем не занято ли уже место, в которое мы планируем поместить новую ноду
        if (table[index] != null) {
            //Сохраняем значение предыдущей ноды
            oldValue = table[index].value;
            //Сравниваем два ключа и заменяем значение если ключи одинаковые
            if (table[index].key.equals(key)) {
                table[index] = node;
                //Размер таблицы остается прежним
            }
            //Иначе, связываем две ноды в один бакет
            else {
                //Новая нода в бакете всегда добавляется в начало списка
                node.next = table[index];
                table[index] = node;
                //Размер таблицы увеличивается
                size++;
            }
        } else {
            table[index] = node;
            //Размер таблицы увеличивается
            size++;
        }
        if (size >= threshold) {
            resize();
        }
        return oldValue;
    }

    /**
     * Метод возвращает объект значение хранящееся против ключа в таблице.
     * @param key - Ключ значение которого, необходимо вернуть.
     * @return - Значение хранящееся в таблице по ключу или Null если по ключу ничего нет.
     */
    public V get(Object key) {
        //Вычисляется хеш и индекс от ключа
        int hash = key.hashCode();
        int index = index(hash);

        Node<K,V> node = table[index];
        //Если по индексу располагается несколько нод, то будем перебирать их в цикле
        // сравнивая по ключу.
        while (node != null && !(node.key.equals(key))) {
            node = node.next;
        }
        // Возвращаем значение ноды если нашли ключ или Null если такого нет
        return node == null ? null : node.value;
    }

    /**
     * Удаляет ссылку на объект из структуры. Поиск объекта происходит по хешу от ключа.
     * При этом, объект находящийся в одном бакете и следующий после удаляемой ноды смещается на ее место
     */
    public void remove(Object key) {
        //Вычисляется хеш и индекс от ключа
        int hash = key.hashCode();
        int index = index(hash);

        Node<K,V> previousNode = table[index];
        Node<K,V> nextNode = table[index].next;
        if (previousNode != null && !(previousNode.key.equals(key))) {
            while (nextNode != null) {
                if (nextNode.key.equals(key)) {
                    previousNode.next = nextNode.next;
                }
                previousNode = previousNode.next;
            }
        } else {
            table[index] = nextNode;
        }
    }

    protected class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Node) {
                Node<?, ?> e = (Node<?, ?>) o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }

    /**
     * Изменяет общий размер вместимости таблицы.
     * Метод вызывается, при достижении порогового размера таблицы.
     * Метод обходит всю старую таблицу выдергивая хеш из ноды для определения ее нового индекса
     * Таким образом, все ноды переиндексируются с учетом нового размера массива.
     */
    private void resize() {
        int newCapacity = capacity * 2;
        if (newCapacity >= MAX_CAPACITY) {
            return;
        }
        Node<K, V>[] newTable = new Node[newCapacity];
        for (Node node : table) {
            if (node != null) {
                newTable[index(node.hash)] = node;
            }
        }
        this.table = newTable;
        this.capacity = newCapacity;
        this.threshold = (int)(capacity * LOAD_FACTOR);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("HashTable{");
        for(Node node : table) {
            if (node != null) {
                result.append(" (" + node.key + " -> " + node.value + ")");
            }
        }
        result.append("}");
        return result.toString();
    }
}
