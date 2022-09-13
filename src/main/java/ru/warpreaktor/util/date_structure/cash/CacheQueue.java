package ru.warpreaktor.util.date_structure.cash;

public class CacheQueue {
    private int size = 0;
    private CacheQueue.Node head;
    private CacheQueue.Node tall;
    private int capacity;

    public CacheQueue(int capacity) {
        this.head = null;
        this.tall = null;
        this.capacity = capacity;
    }

    /**
     *  Добавляем объект в список просто подменяя ссылки.
     */
    public CacheQueue.Node add(Object e) {
        if (size == capacity) {
            pushOut();
        }
        CacheQueue.Node newNode = new CacheQueue.Node(e);
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
     * Выталкивание происходит всегда последнего элемента. Берем предпоследний элемент списка и очищаем ссылку
     * на последний элемент, и так же ставим этот элемент в качестве последнего элемента в списке.
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
    public boolean refreshCache(CacheQueue.Node n) {
        if (unlink(n)){
            return linkFirst(n);
        } else {
            return false;
        }
    }

    /**
     * Метод позволяет просмотреть объект, который является заглавным в очереди т.е. самый последний используемый.
     */
    public CacheQueue.Node peek() {
        return head;
    }

    public int getSize() {
        return size;
    }

    /**
     * Метод "выдергивает" объект из "цепочки" очереди.
     * Для поддержания консистентности очереди, у "выдергиваемого" объекта необходимо очистить ссылки на соседние элементы,
     * а соседние элементы связать друг с другом.
     */
    public boolean unlink(CacheQueue.Node node) {
        //Neighbors
        CacheQueue.Node prev = node.previous;
        CacheQueue.Node next = node.next;
        if (prev != null) prev.next = node.next;
        if (next != null) next.previous = node.previous;
        if (tall.equals(node)) tall = next;
        if (head.equals(node)) head = prev;
        node.next = null;
        node.previous = null;

        size--;
        return node.isDeleted = true;
    }

    public boolean linkFirst(CacheQueue.Node newNode) {
        if (head == null) {
            head = newNode;
            tall = newNode;
            newNode.isDeleted = false;
            size++;
            return true;
        } else {
            CacheQueue.Node<Integer> oldHead = head;
            oldHead.next = newNode;
            newNode.previous = oldHead;
            head = newNode;
            newNode.isDeleted = false;
            size++;
            return true;
        }
    }

    public class Node<T> {
        T value;
        CacheQueue.Node<T> next;
        CacheQueue.Node<T> previous;
        boolean isDeleted = false;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public boolean isDeleted() {
            return isDeleted;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrevious() {
            return previous;
        }
    }
}
