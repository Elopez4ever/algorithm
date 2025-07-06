package com.data_structure_and_sort.array_stack_and_queue;

import com.data_structure_and_sort.dynamic_array.MyArrayList;

public class MyArrayQueue<E> {
    private final MyArrayList<E> array = new MyArrayList<>();

    public void push(E e) {
        array.add(e);
    }

    public E pop() {
        return array.remove(0);
    }

    public E peek() {
        return array.get(0);
    }

    public int size() {
        return array.size();
    }
}
