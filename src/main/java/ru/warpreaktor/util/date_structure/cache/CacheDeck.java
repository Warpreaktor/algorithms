package ru.warpreaktor.util.date_structure.cache;

/**
 * Специализированная очередь созданная для реализации кэша с выталкиванием объектов из очереди.
 * Особенность структуры заключается в том, что она позволяет работать со своими нодами.
 */
public class CacheDeck {
    private int size = 0;
    private Node head;
    private Node tall;
    private int capacity;

    public CacheDeck(int capacity) {
        this.head = null;
        this.tall = null;
        this.capacity = capacity;
    }

    /**
     *  Добавляем объект всегда в начало списка.
     * @param cacheObject - Объект, который необходимо закэшировать
     */
    public Node<Object> add(Object cacheObject) {
        //Проверка на превышение вместимости списка. При необходимости выталкиваем лишний объект.
        if (size >= capacity) {
            pushOut();
        }
        Node<Object> newNode = new Node(cacheObject);
        //При нулевом размере списка проинициализировать голову и хвост списка
        if (size == 0) {
            this.tall = newNode;
            linkFirst(newNode);
            return newNode;
        } else {
            linkFirst(newNode);
            return newNode;
        }
    }

    /**
     * Метод выталкивает из списка самый последний (т.е. самый менее используемый объект).
     * Выталкивается всегда последний элемент.
     */
    public boolean pushOut() {
        unlink(tall);
        return true;
    }

    /**
     * Перестановка объекта из любого места в очереди в начало, происходит за счет перезаписи ссылок у нескольких,
     * взаимодействующих с этим объектом элементов.
     * Асимптотика - O(1)
     */
    public boolean refreshCache(Node n) {
        if (unlink(n)){
            return linkFirst(n);
        } else {
            return false;
        }
    }

    /**
     * Метод позволяет просмотреть объект, который является заглавным в очереди т.е. самый последний используемый.
     */
    public Node peek() {
        return head;
    }

    public int getSize() {
        return size;
    }

    /**
     * Метод "выдергивает" объект из деки зачищая ссылки на соседние элементы,
     * и связывая их друг с другом.
     */
    public boolean unlink(Node node) {
        //Neighbors
        Node prev = node.previous;
        Node next = node.next;
        if (prev != null) prev.next = node.next;
        if (next != null) next.previous = node.previous;
        if (tall.equals(node)) tall = next;
        if (head.equals(node)) head = prev;
        node.next = null;
        node.previous = null;

        size--;
        return node.isRotten = true;
    }

    /**
     * Вставляет элемент в начало деки
     * @param newNode - нода, которую необходимо вставить на первое место
     */
    public boolean linkFirst(Node newNode) {
        //Проверка, не пустая ли дека.
        if (head == null) {
            head = newNode;
            tall = newNode;
            //На всякий случай, если по каким-то причинам поднимается вверх протухший объект.
            newNode.isRotten = false;
            size++;
            return true;
        } else {
            //Иначе, в голову деки вставляем новую ноду, а старая нода будет её следующим (next) элементом
            Node<Object> oldHead = head;
            oldHead.next = newNode;
            newNode.previous = oldHead;
            head = newNode;
            newNode.isRotten = false;
            size++;
            return true;
        }
    }

    public class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;
        boolean isRotten = false;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public boolean isRotten() {
            return isRotten;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrevious() {
            return previous;
        }
    }
}
