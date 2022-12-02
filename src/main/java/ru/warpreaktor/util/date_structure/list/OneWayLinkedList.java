package ru.warpreaktor.util.date_structure.list;

import java.util.NoSuchElementException;

/**
 * Реализация простого одностороннего монопоточного связного списка.
 * Все элементы в список добавляются только в конец.
 * Список можно проходить только в одну сторону.
 */
public class OneWayLinkedList<E> {
    private int size = 0;    //Количество нод в списке
    private LinkedNode<E> head; //Первая нода в списке
    private LinkedNode<E> tall; //Последняя нода в списке

    /**
     * Возвращает текущий размер списка.
     */
    public int getSize() {
        return size;
    }

    /**
     * Создает новую ноду в конце связного списка и записывает в новую ноду переданное значение.
     * @param value - Хранящийся в ноде объект.
     * T(n) = O(1)
     */
    public void add(E value) {
        //Если список еще пуст, его необходимо проинициализировать первым объектом.
        if (head == null ) {
            listInitialize(value);
        } else {
            //Добавляем новый элемент в конец списка.
            tall.next = new LinkedNode<>(value);
            tall = tall.next;
        }
        //Увеличим размер списка на 1
        size++;
    }

    /**
     * Получить n-й объект по индексу. Метод будет перебирать все ноды от начала списка,
     * пока не дойдет до ноды с нужным индексом, за тем он вернет её значение.
     * @param index - индекс ноды.
     * @return - Значение хранящееся в ноде с индексом переданным в параметрах
     * T(n) = O(n) где n = index
     */
    public E get(int index) {
        checkElementIndex(index);
        //Проверим, не пуст ли список
        if (size == 0) throw new NoSuchElementException("Index: "+index+", Size: "+size);
        return getNode(index).get();
    }

    /**
     * Получить объект по его значению.
     * @param value - искомое значение.
     * @return - Возвращает первый найденный объект равный переданному в параметрах значению.
     * T(n) = O(n) где n = index
     */
    public E find(E value) {
        //Проверим, не пуст ли список
        if (size == 0) throw new NoSuchElementException("Index: "+value);

        LinkedNode<E> node = head;
        for (int i = 0; i < size; i++, node = node.next) {
            if (node.get().equals(value)) {
                return node.get();
            }
        }

        throw new NoSuchElementException("value: "+value);
    }

    /**
     * Удаляет элемент по индексу из списка.
     * @param index - индекс элемента, который будет удален.
     * @return - true если удаление ноды прошло успешно.
     * @throws NoSuchElementException если список пуст
     * T(n) = O(n) где n = index
     */
    public boolean remove(int index) {
        //Проверим, не выходит ли передаваемый индекс за границы списка
        checkElementIndex(index);

        if (head == null){
            throw new NoSuchElementException("Element: "+index+", Size: "+size);
        }

        //Перецепляем ссылки.
        unlink(index);

        //Уменьшаем размер списка на 1
        size--;
        //Зануляем голову и хвост если список стал пуст
        if (size == 0) {
            head = null;
            tall = null;
        }
        return true;
    }

    /**
     * Инициализирует пустой список первой нодой.
     * @param value - значение первой ноды.
     */
    private void listInitialize(E value) {
        head = new LinkedNode<E>(value);
        tall = head;
    }

    private LinkedNode<E> getNode(int index) {
        checkElementIndex(index);
        //Поэлементно перебираем список с головы до нужного индекса
        LinkedNode<E> node = head;
        for (int i = 0; i < index; i++) {
            //Переходим к следующей ноде
            node = node.next;
        }
        return node;
    }

    /**
     * Метод выводит из связного списка Ноду.
     * У ноды с переданным индексом будет занулена ссылка на элемент next
     * А у ноды предшествующей ей будет изменена ссылка next на следующий элемент после индексной ноды
     * @param index - индекс ноды, которая будет отвязана из списка
     */
    private void unlink(int index) {
        checkElementIndex(index);
        LinkedNode<E> indexNode = head;
        LinkedNode<E> previousNode = null;
        for (int i = 0; i < index; i++) {
            //Переходим к следующей ноде
            previousNode = indexNode;
            indexNode = indexNode.next;
        }
        //Перецепляем ссылки
        if (previousNode == null){
            //Если перед искомой ноды ничего нет, значит мы удаляем голову списка.
            // Ее необходимо проинициализировать элементом следующим за удаляемым
            head = indexNode.next;
        } else {
            previousNode.linkNext(indexNode.next);
        }
        indexNode.unlink();
    }

    /**
     * Проверяет входящий индекс на нахождение его в рамках границ списка.
     * @param index - индекс элемента из списка
     * T(n) = O(1)
     */
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
    }

    /**
     * Нода - элемент связного списка. Обертка для хранящегося в списке значения.
     */
    protected class LinkedNode<E> {
        private E value;
        private LinkedNode<E> next;

        public LinkedNode(E value) {
            this.value = value;
        }

        protected E get() {
            return value;
        }

        protected void set(E value) {
            this.value = value;
        }

        protected LinkedNode<E> getNext() {
            return next;
        }

        protected void unlink() {
            next = null;
        }

        public void linkNext(LinkedNode<E> next) {
            this.next = next;
        }
    }
}
