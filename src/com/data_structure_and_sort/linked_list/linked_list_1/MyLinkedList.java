package com.data_structure_and_sort.linked_list.linked_list_1;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {

    private final Node<E> head, tail;
    private int size;


    private static class Node<E> {
        E val;
        Node<E> prev, next;

        Node(E val) {
            this.val = val;
        }
    }

    public MyLinkedList() {
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // ===== 添加操作 =====

    public void addFirst(E e) {
        insertAfter(head, e);
    }

    public void addLast(E e) {
        insertAfter(tail.prev, e);
    }

    public void add(int index, E e) {
        Node<E> prevNode = getPrevNode(index);
        insertAfter(prevNode, e);
    }

    // ===== 删除操作 =====

    public E removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return unlink(head.next);
    }

    public E removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return unlink(tail.prev);
    }

    public E remove(int index) {
        Node<E> node = getNode(index);
        return unlink(node);
    }

    private E unlink(Node<E> node) {
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        prev.next = next;
        next.prev = prev;

        size--;
        return node.val;
    }

    // ===== 查找操作 =====

    public E get(int index) {
        return getNode(index).val;
    }

    public E getLast() {
        return getNode(size).val;
    }


    public E getFirst() {
        return getNode(0).val;
    }

    // ===== 修改操作 =====

    public void set(int index, E e) {
        getNode(index).val = e;
    }

    /**
     * 在指定节点之后插入新节点
     *
     * @param prev 前一个节点
     * @param e    要插入的值
     */
    private void insertAfter(Node<E> prev, E e) {
        Node<E> next = prev.next;
        Node<E> newNode = new Node<>(e);

        prev.next = newNode;
        newNode.prev = prev;

        newNode.next = next;
        next.prev = newNode;

        size++;
    }

    /**
     * 根据索引获取节点
     * @param index 索引
     * @return 节点
     */
    private Node<E> getNode(int index) {
        checkElementIndex(index);
        Node<E> cur;
        if (index < (size >> 1)) {
            cur = head.next;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail.prev;
            for (int i = size - 1; i > index - 1; i--) {
                cur = cur.prev;
            }
        }
        return cur;
    }

    /**
     * 获取 index 所在位置的前一个节点
     *
     * @param index 插入或查找位置
     * @return index 的前一个节点
     */
    private Node<E> getPrevNode(int index) {
        checkPositionIndex(index);
        Node<E> cur;
        if (index < (size >> 1)) {
            cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = size; i > index; i--) {
                cur = cur.prev;
            }
        }
        return cur;
    }

    // ===== 工具方法 =====

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    // 检查数组元素下标
    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
