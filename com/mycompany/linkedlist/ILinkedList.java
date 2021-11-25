package com.mycompany.linkedlist;

public interface ILinkedList<E> extends Iterable{

    public void add (E element);

    public void add (int index, E element);

    public void clear();

    public E get (int index);

    public int indexOf(E element);

    public E remove (int index);

    public E set (int index, E Element);

    public int size();

    public <E> E[] toArray(E[] e);

    public Object[] toArray();

    public String toString();



}
