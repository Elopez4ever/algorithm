package com.data_structure_and_sort.dynamic_array;

import java.util.NoSuchElementException;

public class MyArrayList<E> {

    // 存储数据的底层数组
    private E[] data;

    // 记录当前元素个数
    private int size;

    // 默认初始容量
    private static final int INIT_CAP = 16;

    //
    public MyArrayList() {
        this(INIT_CAP);
    }

    //
    @SuppressWarnings({"unchecked"})
    public MyArrayList(int initCap) {
        data = (E[]) new Object[initCap];
        size = 0;
    }

    // 增
    public void add(E e) {
        int cap = data.length;
        if (cap == size) {
            resize(cap * 2);
        }
        data[size] = e;
        size++;
    }

    public void add(int index, E e) {
        checkPositionIndex(index);
        int cap = data.length;
        if (cap == size) {
            resize(cap * 2);
        }
        // 从后往前, 依次向前复制元素
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    // 删
    public E remove() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        int cap = data.length;
        if (size < cap / 4) {
            resize(cap / 2);
        }
        E datum = data[size - 1];
        data[size - 1] = null;
        size--;
        return datum;
    }

    public E remove(int index) {
        checkElementIndex(index);

        int cap = data.length;
        if (size < cap / 4) {
            resize(cap / 2);
        }

        E datum = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return datum;
    }

    // 查
    public E get(int index) {
        checkElementIndex(index);
        return data[index];
    }

    // 改
    public E set(int index, E e) {
        checkElementIndex(index);
        E datum = data[index];
        data[index] = e;
        return datum;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 将 data 的容量修改为 newCap
    @SuppressWarnings({"unchecked"})
    private void resize(int newCap) {
        if(newCap < 1) newCap = 1;
        E[] data = (E[]) new Object[newCap];
        // 可以用 System.arraycopy()
        for (int i = 0; i < size; i++) {
            data[i] = this.data[i];
        }
        this.data = data;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }
}
