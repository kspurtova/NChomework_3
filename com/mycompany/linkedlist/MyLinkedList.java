package com.mycompany.linkedlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyLinkedList<E> implements ILinkedList<E>{

    private Node<E> first;
    private Node<E> last;           // двусторонний список
    int size = 0;


    /////////////////////////////////////////////////////////////////////////////////

    //                                          Конструкторы

    public MyLinkedList() {
    }

    public MyLinkedList(Node<E> first, Node<E> last) {
        this.first = first;
        this.last = last;
    }

    ///////////////////////////////////////////////////////////////////////////////////


    @Override                           // размер списка
    public int size() {
        return size;
    }


    @Override                           // добавление элемента в конец
    public void add(E element) {
        Node<E> l = last;
        Node<E> newNode = new Node<E>(element,null, l);
        last = newNode;
        if (first == null)
            first = newNode;
        else
            l.nextNode = newNode;
        size++;
    }

    @Override                                       // удаляет все элементы из списка
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.nextNode;
            x.element = null;
            x.nextNode = null;
            x.previousNode = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }


    ///////////////////////////////////////////////////////////////////////////////////

    //                                  Перевести в массив


    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = first; x != null; x = x.nextNode)
            result[i++] = x.element;
        return result;
    }



    @Override
    public <E> E[] toArray(E[] e) {
        if (e.length < size)
            e = (E[])java.lang.reflect.Array.newInstance(
                    e.getClass().getComponentType(), size);
        int i = 0;
        E[] result = e;
        for (MyLinkedList<E>.Node<E> x = (MyLinkedList<E>.Node<E>) first; x != null; x = x.nextNode)
            result[i++] = x.element;

        if (e.length > size)
            e[size] = null;

        return e;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////

    //                                        Перевести в строку

    @Override
    public String toString() {

        String str = Arrays.toString(this.toArray());

        return "MyLinkedList: " + str;
    }


    public void printList() {
        forEach(System.out::println);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////



    @Override                                   // индекс первого вхождения указанного элемента
    public int indexOf(E element) {
        int index = 0;
        if (element == null) {
            for (Node<E> x = first; x != null; x = x.nextNode) {
                if (x.element == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.nextNode) {
                if (element.equals(x.element))
                    return index;
                index++;
            }
        }
        return -1;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////

    //                                       Действия с индексами

    Node<E> find(int index) {                       // возвращает элемент с i-ым индексом

        Node<E> elem;
        if (index < (size() / 2)) {
            elem = first;
            for (int i = 0; i < index; i++)
                elem = elem.nextNode;
        } else {
            elem = last;
            for (int i = size - 1; i > index; i--)
                elem = elem.previousNode;
        }
        return elem;
    }



    @Override
    public void add(int index, E element) {                       // добавляет i-ый элемент

        if (index<=0 && index>=size())
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");

        if (index == size)
            add(element);
        else {
            Node<E> pred = find(index).previousNode;
            Node<E> newNode = new Node<> (element, find(index), pred);
            find(index).previousNode = newNode;
            if (pred == null)
                first = newNode;
            else
                pred.nextNode = newNode;
            size++;
        }
    }


    @Override
    public E remove(int index) {                              // удаление i-ого элемента

        if (index<=0 && index>=size())
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");

        Node<E> newNode = find(index);

        E elem = newNode.element;
        Node<E> next = newNode.nextNode;
        Node<E> prev = newNode.previousNode;


        if (prev == null) {
            first = next;
        } else {
            prev.nextNode = next;
            newNode.previousNode = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.previousNode = prev;
            newNode.nextNode = null;
        }

        newNode.element = null;
        size--;

        return elem;
    }


    @Override
    public E get(int index) {                                   // получение i-го элемента
        if (index<=0 && index>=size())
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");

        return find(index).element;
    }

    @Override
    public E set(int index, E element) {                        // установка i-ого элемента
        if (index<=0 && index>=size())
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");

        Node<E> node = find(index);
        E oldVal = node.element;
        node.element = element;
        return oldVal;
    }






//////////////////////////////////////////////////////////////////////////////////////////////////////

    //                                                 Итератор

    class Itr implements Iterator {

        private int index =0;

        @Override
        public boolean hasNext() {
            if (index<size()) return true;
            return false;
        }

        @Override
        public E next() {
            E e = get(index++);
            return e;
        }

        @Override
        public void remove() {
            MyLinkedList.this.remove(size()-1);
        }
    }



    @Override
    public Iterator iterator() {
        return new Itr();
    }



    //////////////////////////////////////////////////////////////////////////////////////


    //                                           Узел

    class Node<E> {

        private E element;  // элемент
        private Node nextNode;  // ссылка на следующий узел
        private Node previousNode;  // ссылка на предыдущий узел


        // Конструктор

        public Node(E element, Node nextNode, Node previousNode) {
            this.element = element;
            this.nextNode = nextNode;
            this.previousNode = previousNode;
        }


        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
}
