package com.mycompany.analysis;

import java.util.Collection;
import java.util.List;

public class TestClass<T>  {
    
    private T obj;

    public void timeAdd () {
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
         //   obj.remove(0);
        }
        long finish=System.nanoTime();
        long difference = finish-start;
        
    }

    public void timeInsert () {

    }

    public void timeRemove () {

    }

}
