package com.data_structure_and_sort.array_stack_and_queue;

import com.data_structure_and_sort.dynamic_array.MyArrayList;

public class MyArrayStack<E> {
    private final MyArrayList<E> array = new MyArrayList<>();

    public void push(E e) {
        array.add(e);
    }

    public E pop() {
        return array.remove(array.size() - 1);
    }

    public E peek() {
        return array.get(array.size() - 1);
    }

    public int size() {
        return array.size();
    }
}
