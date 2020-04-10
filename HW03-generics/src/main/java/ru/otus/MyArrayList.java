package ru.otus;

import java.util.*;

public class MyArrayList<E> implements List<E> {

    private int size;
    private Object[] values;

    public MyArrayList(int size) {
        this.size = size;
        this.values = new Object[size];
    }

    public MyArrayList() {
        this.size = 0;
        this.values = new Object[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return Arrays.asList(values).contains(o);
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return values;
    }

    @Override
    public boolean add(E element) {
        if (size == values.length) {
            values = grow();
        }
        values[size++] = element;
        return true;
    }

    private Object[] grow() {
        return Arrays.copyOf(values, size + 1);
    }

    private Object[] grow(int toAdd) {
        return Arrays.copyOf(values, size + toAdd);
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if (c.isEmpty()) {
            return false;
        }
        Object[] collectionArray = c.toArray();
        if (values.length < size + c.size()) {
            int toAdd = size + c.size() - values.length;
            values = grow(toAdd);
        }
        if (index < size + 1) {
            System.arraycopy(values, index, values, index + c.size(), size - index);
        }
        System.arraycopy(collectionArray, 0, values, index, c.size());
        size += c.size();
        return true;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E get(int index) {
        return (E) values[index];
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        E oldValue = (E) values[index];
        values[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, Object element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator() {
        return new Iterator(0);
    }

    @Override
    public ListIterator listIterator(int index) {
        return new Iterator(index);
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException();
    }

    private class Iterator implements ListIterator {
        private int cursor;
        private int lastCursor;

        public Iterator(int index) {
            cursor = index;
        }

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public E next() {
            if (cursor + 1 > size){
                throw new NoSuchElementException();
            }
            lastCursor = cursor++;
            return (E) values[lastCursor];
        }

        @Override
        public boolean hasPrevious() {
            return cursor > 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious()){
                throw new NoSuchElementException();
            }
            lastCursor = cursor--;
            return (E) values[lastCursor];
        }

        @Override
        public int nextIndex() {
            return cursor + 1;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(Object o) {
            if (lastCursor < 0){
                throw new IllegalStateException();
            }
            MyArrayList.this.set(lastCursor, (E) o);
        }

        @Override
        public void add(Object o) {
            throw new UnsupportedOperationException();
        }
    }
}
