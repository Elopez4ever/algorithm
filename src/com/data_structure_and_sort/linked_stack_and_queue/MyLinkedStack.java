package com.data_structure_and_sort.linked_stack_and_queue;

import com.data_structure_and_sort.linked_list.linked_list_1.MyLinkedList;

public class MyLinkedStack<E> {
    private final MyLinkedList<E> list = new MyLinkedList<>();

    // 添加元素
    public void push(E e) {
        list.addLast(e);
    }

    // 弹出一个元素
    public E pop() {
        return list.removeLast();
    }

    // 找到栈顶元素
    public E peek() {
        return list.getLast();
    }

    // 返回栈中元素个数
    public int size() {
        return list.getSize();
    }
}
