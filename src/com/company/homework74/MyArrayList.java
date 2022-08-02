package com.company.homework74;

import java.util.Arrays;

public class MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int DEFAULT_SIZE = 0;

    public Object[] getData() {
        return data;
    }

    private Object[] data;
    private int size = DEFAULT_SIZE;
    private int capacity = DEFAULT_CAPACITY;

    public MyArrayList(int capacity) {
        this.size = DEFAULT_SIZE;
        this.capacity = capacity;
        this.data = new Object[capacity];
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Object current : data) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public void ensureCapacity(int amountElements) {
        if (amountElements > capacity) {
            data = Arrays.copyOf(data, (int) (capacity * 1.5 + 1));
        }
    }

    public void pushBack(T elements) {
        ensureCapacity(1);
        data[size] = elements;
        size++;
    }

    public void popFront() {
        data = Arrays.copyOfRange(data, 1, size);
        size--;
    }

    public void pushFront(T elements) {
        ensureCapacity(1);
        Object[] newData = new Object[capacity];
        System.arraycopy(data, 0, newData, 1, size);
        newData[0] = elements;
        size++;
    }

    public void insert(T elements, int index) {
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = elements;
    }

    public void removeAt(int index) {
        if (index <= size) {
        }
    }

    public boolean isEmpty() {
        boolean trueOrFalse;
        if (size == 0) {
            trueOrFalse = true;
        } else {
            trueOrFalse = false;
        }
        return trueOrFalse;
    }

    public void trimToSize() {
        capacity = size;
        data = Arrays.copyOf(data, capacity);
    }

    public int indexOf(T elements) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (elements.equals(data[i])) {
                count = i;
            } else {
                count = -1;
            }
        }
        return count;
    }
    public void reverse () {
        for (int i = size; i != 0; i--) {
            data[size - 1] = data[i];
        }
    }
}

