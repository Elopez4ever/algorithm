package com.data_structure_and_sort.linked_stack_and_queue;


import com.data_structure_and_sort.linked_list.linked_list_1.MyLinkedList;

public class MyLinkedQueue<E> {
    private final MyLinkedList<E> list = new MyLinkedList<>();

    public void push(E e) {
        list.addLast(e);
    }

    public E pop() {
        return list.removeFirst();
    }

    public E peek() {
        return list.getFirst();
    }

    public int size() {
        return list.getSize();
    }
}
