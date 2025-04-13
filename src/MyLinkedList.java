public class MyLinkedList<E> implements MyList<E> {

    private class MyNode {
        E element;
        MyNode next;
        MyNode prev;

        public MyNode(E element, MyNode next, MyNode prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(E item) {
        addLast(item);
    }

    @Override
    public void set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        MyNode node = getNodeAt(index);
        node.element = item;
    }

    @Override
    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            MyNode current = getNodeAt(index);
            MyNode newNode = new MyNode(item, current, current.prev);
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(E item) {
        MyNode newNode = new MyNode(item, head, null);

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;

        if (tail == null) {
            tail = newNode;
        }

        size++;
    }

    @Override
    public void addLast(E item) {
        MyNode newNode = new MyNode(item, null, tail);

        if (tail != null) {
            tail.next = newNode;
        }

        tail = newNode;

        if (head == null) {
            head = newNode;
        }

        size++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        return getNodeAt(index).element;
    }

    @Override
    public E getFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return head.element;
    }

    @Override
    public E getLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return tail.element;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            MyNode node = getNodeAt(index);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
            size--;
        }
    }

    @Override
    public void removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        MyNode temp = head;
        head = head.next;

        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }

        temp.next = null;
        size--;
    }

    @Override
    public void removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        MyNode temp = tail;
        tail = tail.prev;

        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }

        temp.prev = null;
        size--;
    }

    @Override
    public void sort() {
        if (size <= 1) {
            return; // Already sorted
        }

        // Convert linked list to array for easier sorting
        Object[] arr = toArray();
        java.util.Arrays.sort(arr);

        // Convert back to linked list
        clear();
        for (Object obj : arr) {
            @SuppressWarnings("unchecked")
            E element = (E) obj;
            add(element);
        }
    }

    public void sort(java.util.Comparator<E> cmp) {
        if (size <= 1) {
            return; // Already sorted
        }

        // Convert linked list to array for easier sorting
        @SuppressWarnings("unchecked")
        E[] arr = (E[]) toArray();
        java.util.Arrays.sort(arr, cmp);

        // Convert back to linked list
        clear();
        for (E element : arr) {
            add(element);
        }
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        if (object == null) {
            for (MyNode node = head; node != null; node = node.next) {
                if (node.element == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (MyNode node = head; node != null; node = node.next) {
                if (object.equals(node.element)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        if (object == null) {
            for (MyNode node = tail; node != null; node = node.prev) {
                if (node.element == null) {
                    return index;
                }
                index--;
            }
        } else {
            for (MyNode node = tail; node != null; node = node.prev) {
                if (object.equals(node.element)) {
                    return index;
                }
                index--;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) >= 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (MyNode node = head; node != null; node = node.next) {
            result[i++] = node.element;
        }
        return result;
    }

    @Override
    public void clear() {
        // Help GC
        for (MyNode node = head; node != null; ) {
            MyNode next = node.next;
            node.element = null;
            node.next = null;
            node.prev = null;
            node = next;
        }

        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private MyNode getNodeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        MyNode node;
        if (index < size / 2) {
            // Traverse from head
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            // Traverse from tail
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }

        return node;
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements java.util.Iterator<E> {
        private MyNode current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }

            E element = current.element;
            current = current.next;
            return element;
        }
    }
}