package com.data_structure_and_sort.cycle_array;


public class CycleArray<T> {
    // 实际存储元素的数组
    private T[] arr;

    // 第一个有效元素的元素的个索引,以及最后一个有效元素的下一个索引
    // 规定范围为左闭右开
    private int start;
    private int end;

    // 真实容量
    private int size;

    // 具体存了多少个数据
    private int count;

    // 初始容量
    private static final int INIT_CAPACITY = 16;

    public CycleArray() {
        this(INIT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public CycleArray(int size) {
        arr = (T[]) new Object[size];
        start = 0;
        end = 0;
        this.size = size;
        count = 0;
    }

    public void addFirst(T val) {
        if (isFull()) {
            resize(size * 2);
        }

        // 因为是左闭右开区间, 所以先移动, 后赋值
        start = (start - 1 + size) % size;
        arr[start] = val;
        count++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        // 先删除, 后移动
        T val = arr[start];
        arr[start] = null;
        start = (start + 1) % size;

        count--;

        if (count > 0 && count == size / 4) {
            resize(size / 2);
        }

        return val;
    }

    public void addLast(T e) {
        if (isFull()) {
            resize(size * 2);
        }

        // 先赋值, 后移动
        arr[end] = e;
        end = (end + 1) % size;
        count++;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        // 先移动, 后删除
        end = (end - 1 + size) % size;
        T val = arr[end];
        arr[end] = null;
        count--;

        if (count > 0 && count == size / 4) {
            resize(size / 2);
        }

        return val;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return arr[start];
    }

    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return arr[(end - 1 + size) % size];
    }


    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }

    public int size() {
        return count;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCap) {
        if (newCap < INIT_CAPACITY) {
            newCap = INIT_CAPACITY;
        }

        T[] newArr = (T[]) new Object[newCap];

        for (int i = 0; i < count; i++) {
            newArr[i] = arr[(start + i) % size];
        }

        start = 0;
        end =  size;
        size = newCap;
        arr = newArr;
    }
}
