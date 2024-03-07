/*
 * Name: Imangali Amangeldi
 * PID:  TODO
 */

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Title: dHeap Description: This program creates a Heap with d branching factor
 *
 * @author TODO
 * @since TODO
 *
 * @param <T> the type of elements held in this collection
 */

public class dHeap<T extends Comparable<? super T>> implements HeapInterface<T> {

    private T[] heap;   // backing array
    private int d;      // branching factor
    private int nelems; // number of elements
    private boolean isMaxHeap; // indicates whether heap is max or min

    private final int DEFAULT_SIZE = 10;

    /**
     * Initializes a binary max heap with capacity = 10
     */
    @SuppressWarnings("unchecked")
    public dHeap() {
        this.heap = (T[]) new Comparable[DEFAULT_SIZE];
        this.d = 2;
        this.isMaxHeap = true;
        this.nelems = 0;
    }

    /**
     * Initializes a binary max heap with a given initial capacity.
     *
     * @param heapSize The initial capacity of the heap.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int heapSize) {
        this.heap = (T[]) new Comparable[heapSize];
        this.d = 2;
        this.isMaxHeap = true;
        this.nelems = 0;
    }

    /**
     * Initializes a d-ary heap (with a given value for d), with a given initial
     * capacity.
     *
     * @param d         The number of child nodes each node in the heap should have.
     * @param heapSize  The initial capacity of the heap.
     * @param isMaxHeap indicates whether the heap should be max or min
     * @throws IllegalArgumentException if d is less than one.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int d, int heapSize, boolean isMaxHeap) throws IllegalArgumentException {
        if (d < 1) {
            throw new IllegalArgumentException();
        }

        this.heap = (T[]) new Comparable[heapSize];
        this.d = d;
        this.isMaxHeap = isMaxHeap;
        this.nelems = 0;

    }

    @Override
    public int size() {
        return this.nelems;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        T root = this.heap[0];
        this.heap[0] = this.heap[size() - 1];
        this.nelems--;
        trickleDown(0);
        return root;
    }

    @Override
    public void add(T item) throws NullPointerException {
        if (item == null) {
            throw new NullPointerException();
        }

        if (size() == this.heap.length) {
            resize();
        }

        this.nelems++;
        this.heap[size() - 1] = item;
        bubbleUp(size() - 1);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        this.nelems = 0;
    }

    @Override
    public T element() throws NoSuchElementException {
        if (this.nelems == 0) {
            throw new NoSuchElementException();
        }
        return this.heap[0];
    }

    private int parent(int index) {
        if (index != 0) {
            return (index - 1) / this.d;
        } else {
            return 0;
        }
    }

    private void bubbleUp(int index) {
        int parentIndex = parent(index);

        if (index == 0) {
            return;
        }

        if (isMaxHeap) { // Max heap
            if (this.heap[parentIndex].compareTo(this.heap[index]) < 0) {

                T temp = heap[parentIndex];
                this.heap[parentIndex] = heap[index];
                this.heap[index] = temp;

                bubbleUp(parentIndex);
                bubbleUp(index);
            }
        } else { // Min heap
            if (this.heap[parentIndex].compareTo(this.heap[index]) > 0) {

                T temp = heap[parentIndex];
                this.heap[parentIndex] = heap[index];
                this.heap[index] = temp;

                bubbleUp(parentIndex);
            }
        }
    }

    private void trickleDown(int index) {
        int indexTemp = index;
        int firstChild = (this.d * index) + 1;
        for (int i = 0; i < this.d && firstChild + i < size(); i++) {
            if (isMaxHeap) { // if max heap then compares down
                if (this.heap[firstChild + i].compareTo(this.heap[indexTemp]) > 0) {
                    indexTemp = firstChild + i;
                }
            } else { // if min heap compares down
                if (this.heap[firstChild + i].compareTo(this.heap[indexTemp]) < 0) {
                    indexTemp = firstChild + i;
                }
            }
        }

        if (indexTemp != index) { // if temp is not index then swap
            T temp = heap[index];
            this.heap[index] = heap[indexTemp];
            this.heap[indexTemp] = temp;

            trickleDown(indexTemp);
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int doubleLength = this.heap.length * 2;
        T[] doubleHeap = (T[]) new Comparable[doubleLength];
        for (int i = 0;  i < size(); i++) {
            doubleHeap[i] = this.heap[i];
        }
        this.heap = doubleHeap;
    }

}
