/*
 * Name: Imangali Amangeldi
 * PID:  A17410460
 */

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Title: dHeap Description: This program creates a Heap with d branching factor
 *
 * @author Imangali Amangeldi
 * @since 3/6/24
 *
 * @param <T> the type of elements held in this collection
 */

public class dHeap<T extends Comparable<? super T>> implements HeapInterface<T> {

    private T[] heap;   // backing array
    private int d;      // branching factor
    private int nelems; // number of elements
    private boolean isMaxHeap; // indicates whether heap is max or min

    public static final int DEFAULT_SIZE = 10;

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

    /**
     * Method to return the size of the heap
     *
     * @return  the size of the heap
     */
    @Override
    public int size() {
        return this.nelems;
    }

    /**
     * Method to remove the top element of the heap
     *
     * @throws NoSuchElementException if the size is null
     * @return  the top element of the heap
     */
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

    /**
     * Method to add an element to the heap
     *
     * @param item an item to be inserted
     * @throws NoSuchElementException if the item is null
     */
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

    /**
     * Method to clear the heap
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        this.nelems = 0;
    }

    /**
     * Method to return the top element
     *
     * @throws NoSuchElementException if the size is null
     * @return  the top element of the heap
     */
    @Override
    public T element() throws NoSuchElementException {
        if (this.nelems == 0) {
            throw new NoSuchElementException();
        }
        return this.heap[0];
    }

    /**
     * Method to calculate the index of the parent
     *
     * @return  the index of the parent
     */
    private int parent(int index) {
        if (index != 0) {
            return (index - 1) / this.d;
        } else {
            return 0;
        }
    }

    /**
     * Method to bubble up, for both max and min heap
     *
     * @param index the index to bubble up
     */
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

    /**
     * Method to trickle down, for both max and min heap
     *
     * @param index the index to trickle down
     */
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

    /**
     * Method to resize the heap is already full
     *
     */
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
