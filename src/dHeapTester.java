import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class dHeapTester {
    private dHeap<Integer> maxHeapTestBinary;
    private dHeap<Integer> maxHeapTestD;
    private dHeap<Integer> minHeapTestBinary;
    private dHeap<Integer> minHeapTestD;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        maxHeapTestBinary = new dHeap<>();
        maxHeapTestD = new dHeap<>(3, 20, true);
        minHeapTestBinary = new dHeap<>(2,10,false);
        minHeapTestD = new dHeap<>(3,20,false);

        maxHeapTestBinary.add(20);
        maxHeapTestBinary.add(31);
        maxHeapTestBinary.add(42);
        maxHeapTestBinary.add(53);
        maxHeapTestBinary.add(64);

        maxHeapTestD.add(64);
        maxHeapTestD.add(31);
        maxHeapTestD.add(42);
        maxHeapTestD.add(53);
        maxHeapTestD.add(20);

        minHeapTestBinary.add(6);
        minHeapTestBinary.add(4);
        minHeapTestBinary.add(17);
        minHeapTestBinary.add(6);
        minHeapTestBinary.add(1);

        minHeapTestD.add(6);
        minHeapTestD.add(4);
        minHeapTestD.add(17);
        minHeapTestD.add(6);
        minHeapTestD.add(1);

    }

    @org.junit.jupiter.api.Test
    void size() {
        assertSame(maxHeapTestBinary.size(), 5);
        assertSame(maxHeapTestD.size(), 5);
        assertSame(minHeapTestD.size(), 5);
        maxHeapTestD.remove();
        assertSame(maxHeapTestD.size(),4);
        maxHeapTestD.remove();
        maxHeapTestD.remove();
        maxHeapTestD.remove();
        maxHeapTestD.remove();
        assertThrows(NoSuchElementException.class, () -> {
            maxHeapTestD.remove();
        });
    }

    @org.junit.jupiter.api.Test
    void remove() {
        assertSame(maxHeapTestD.remove(), 64);
        assertSame(maxHeapTestD.size(),4);
        assertSame(maxHeapTestD.remove(), 53);
        assertSame(maxHeapTestD.remove(), 42);
        assertSame(maxHeapTestD.remove(), 31);
        assertSame(maxHeapTestD.remove(), 20);
        assertThrows(NoSuchElementException.class, () -> {
            maxHeapTestD.remove();
        });
    }

    @org.junit.jupiter.api.Test
    void add() {
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void element() {
    }
}