public class MyMinHeap<T extends Comparable<T>> {

    private MyArrayList<T> list;

    /**
     * Constructs an empty min heap
     */
    public MyMinHeap() {
        list = new MyArrayList<>();
    }

    /**
     * Adds an item to this heap
     * @param item the item to be added to this heap
     */
    public void add(T item) {
        // Add element to the end of the ArrayList
        list.addLast(item);

        // Bubble up to maintain heap property
        siftUp(list.size() - 1);
    }

    /**
     * Retrieves and removes the minimum element of this heap
     * @return the minimum element of this heap
     */
    public T extractMin() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Heap is empty");
        }

        T min = list.get(0);

        // Move the last element to the root
        list.set(0, list.getLast());
        list.removeLast();

        if (!isEmpty()) {
            // Bubble down the new root to maintain heap property
            siftDown(0);
        }

        return min;
    }

    /**
     * Retrieves, but does not remove, the minimum element of this heap
     * @return the minimum element of this heap
     */
    public T getMin() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Heap is empty");
        }

        return list.get(0);
    }

    /**
     * Tests if this heap is empty
     * @return true if and only if this heap contains no items; false otherwise
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * Returns the number of elements in this heap
     * @return the number of elements in this heap
     */
    public int size() {
        return list.size();
    }

    /**
     * Removes all of the elements from this heap
     */
    public void clear() {
        list.clear();
    }

    /**
     * Restore the min-heap property by moving an element up
     * @param index the index of the element to move up
     */
    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2;

        if (index > 0 && list.get(index).compareTo(list.get(parentIndex)) < 0) {
            // Swap with parent
            swap(index, parentIndex);

            // Continue sifting up
            siftUp(parentIndex);
        }
    }

    /**
     * Restore the min-heap property by moving an element down
     * @param index the index of the element to move down
     */
    private void siftDown(int index) {
        int smallest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        // Find the smallest of the node and its children
        if (leftChild < list.size() && list.get(leftChild).compareTo(list.get(smallest)) < 0) {
            smallest = leftChild;
        }

        if (rightChild < list.size() && list.get(rightChild).compareTo(list.get(smallest)) < 0) {
            smallest = rightChild;
        }

        // If the smallest is not the current node, swap and continue sifting down
        if (smallest != index) {
            swap(index, smallest);
            siftDown(smallest);
        }
    }

    /**
     * Swaps two elements in the list
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /**
     * Returns a string representation of this heap
     * @return a string representation of this heap
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MinHeap: [");

        Object[] array = list.toArray();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}