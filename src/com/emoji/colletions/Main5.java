package com.emoji.colletions;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main5 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 3, 2};
        Iterator<Integer> arrayIt = new ArrayIterator<>(arr);
        System.out.println("Array");
        while (arrayIt.hasNext()) {
            System.out.println(arrayIt.next());
        }

        Integer[][] matrix = new Integer[][]{
                new Integer[]{1, 2, 3},
                new Integer[]{4, 5, 6},
                new Integer[]{7, 8, 9}};
        Iterator<Integer> matrixIt = new MatrixIterator<>(matrix);
        System.out.println("Matrix");
        while (matrixIt.hasNext()) {
            System.out.println(matrixIt.next());
        }

    }
}

class ArrayIterator<E> implements Iterator<E> {
    private int i;
    private E[] data;

    public ArrayIterator(E[] data) {
        this.data = data;
        this.i = 0;
    }

    @Override
    public boolean hasNext() {
        return i < data.length;
    }

    @Override
    public E next() {
        E element;
        try {
            element = data[i];
        } catch (ArrayIndexOutOfBoundsException exp) {
            throw new NoSuchElementException();
        }
        i++;
        return element;
    }
}

class MatrixIterator<E> implements Iterator<E> {
    private int i, j;
    private E[][] data;

    public MatrixIterator(E[][] data) {
        this.i = 0;
        this.j = 0;
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return i < data.length && j < data[i].length;
    }

    @Override
    public E next() {
        E element;
        try {
            element = data[i][j];
        } catch (ArrayIndexOutOfBoundsException exp) {
            throw new NoSuchElementException();
        }
        if (j < data[i].length - 1) {
            j++;
        } else {
            j = 0;
            i++;
        }
        return element;
    }
}

