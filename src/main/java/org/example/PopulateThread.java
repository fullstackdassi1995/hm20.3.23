package org.example;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class PopulateThread {
    private int max;
    private AtomicIntegerArray arr2 = new AtomicIntegerArray(max);

    public PopulateThread(int max) {
        this.max = max;
    }
}
