package com.mycompany;

import com.mycompany.linkedlist.MyLinkedList;
import javafx.scene.shape.Circle;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        //////////////////////////////////////////////////////////////////////////////////////
        //                          Проверка LinkedList

        MyLinkedList<Integer> list = new MyLinkedList<Integer>();


        list.add(3);
        list.add(15);
        list.add(2);
        list.add(91);
        System.out.println(list.size());
        System.out.println(list.toString());
        list.printList();

        MyLinkedList<Integer> list1 = new MyLinkedList<Integer>();
        //Integer integ[] = list.toArray(list);

        list.clear();
        System.out.println(list.size());

        MyLinkedList<String> x = new MyLinkedList<String>();

        String[] y = x.toArray(new String[0]);


        MyLinkedList<Circle> circle = new MyLinkedList<>();


        ///////////////////////////////////////////////////////////////////////////////////////////////
        //                              Сравнительный анализ

        System.out.println("Сравнительный анализ:");

        long lStart;
        long lFinish;
        long difference;

        MyLinkedList<Integer> myTestList = new MyLinkedList<Integer>();
        LinkedList<Integer> testList = new LinkedList<>();


        System.out.println("Добавление элемента myTestList: ");

        lStart=System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            myTestList.add(i);
        }

        lFinish=System.nanoTime();
        difference = lFinish-lStart;
        System.out.println(difference);

        System.out.println("Поиск элемента myTestList: ");
        lStart=System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            myTestList.get(i);
        }
        lFinish=System.nanoTime();
        difference = lFinish-lStart;
        System.out.println(difference);

        System.out.println("Удаление элемента myTestList: ");
        lStart=System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            myTestList.remove(i);
        }
        lFinish=System.nanoTime();
        difference = lFinish-lStart;
        System.out.println(difference);

        System.out.println("===========================================================");


        System.out.println("Добавление элемента testList: ");
        lStart=System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            testList.add(i);
        }
        lFinish=System.nanoTime();
        difference = lFinish-lStart;
        System.out.println(difference);

        System.out.println("Поиск элемента testList: ");
        lStart=System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            testList.get(i);
        }
        lFinish=System.nanoTime();
        difference = lFinish-lStart;
        System.out.println(difference);

        System.out.println("Удаление элемента testList: ");
        lStart=System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            testList.remove(0);
        }
        lFinish=System.nanoTime();
        difference = lFinish-lStart;
        System.out.println(difference);


    }
}
