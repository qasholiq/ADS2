
public class Main {

    public static void main(String[] args) {
        // Test all data structures
        testMyArrayList();
        testMyLinkedList();
        testMyStack();
        testMyQueue();
        testMyMinHeap();
    }

    private static void testMyArrayList() {
        System.out.println("=== Testing MyArrayList ===");

        MyArrayList<Integer> list = new MyArrayList<>();

        // Test add and size
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Size after adding 3 elements: " + list.size());  // Expected: 3

        // Test get
        System.out.println("Element at index 1: " + list.get(1));  // Expected: 20

        // Test add at index
        list.add(1, 15);
        System.out.println("Element at index 1 after insert: " + list.get(1));  // Expected: 15
        System.out.println("Element at index 2 after insert: " + list.get(2));  // Expected: 20

        // Test set
        list.set(2, 25);
        System.out.println("Element at index 2 after set: " + list.get(2));  // Expected: 25

        // Test removeFirst and removeLast
        list.removeFirst();
        System.out.println("First element after removeFirst: " + list.getFirst());  // Expected: 15
        list.removeLast();
        System.out.println("Last element after removeLast: " + list.getLast());  // Expected: 25

        // Test indexOf and exists
        list.add(15);
        System.out.println("Index of 15: " + list.indexOf(15));  // Expected: 0
        System.out.println("Last index of 15: " + list.lastIndexOf(15));  // Expected: 2
        System.out.println("Exists 15: " + list.exists(15));  // Expected: true
        System.out.println("Exists 30: " + list.exists(30));  // Expected: false

        // Test iterator
        System.out.print("Iterating through elements: ");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Test sort
        list.add(5);
        System.out.print("Before sort: ");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        list.sort();
        System.out.print("After sort: ");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Test clear
        list.clear();
        System.out.println("Size after clear: " + list.size());  // Expected: 0
    }

    private static void testMyLinkedList() {
        System.out.println("\n=== Testing MyLinkedList ===");

        MyLinkedList<String> list = new MyLinkedList<>();

        // Test add and size
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("Size after adding 3 elements: " + list.size());  // Expected: 3

        // Test get
        System.out.println("Element at index 1: " + list.get(1));  // Expected: Banana

        // Test add at index
        list.add(1, "Blueberry");
        System.out.println("Element at index 1 after insert: " + list.get(1));  // Expected: Blueberry
        System.out.println("Element at index 2 after insert: " + list.get(2));  // Expected: Banana

        // Test addFirst and addLast
        list.addFirst("Apricot");
        list.addLast("Date");
        System.out.println("First element after addFirst: " + list.getFirst());  // Expected: Apricot
        System.out.println("Last element after addLast: " + list.getLast());  // Expected: Date

        // Test removeFirst and removeLast
        list.removeFirst();
        System.out.println("First element after removeFirst: " + list.getFirst());  // Expected: Apple
        list.removeLast();
        System.out.println("Last element after removeLast: " + list.getLast());  // Expected: Cherry

        // Test indexOf and exists
        list.add("Banana");  // Now we have Apple, Blueberry, Banana, Cherry, Banana
        System.out.println("Index of Banana: " + list.indexOf("Banana"));  // Expected: 2
        System.out.println("Last index of Banana: " + list.lastIndexOf("Banana"));  // Expected: 4
        System.out.println("Exists Banana: " + list.exists("Banana"));  // Expected: true
        System.out.println("Exists Date: " + list.exists("Date"));  // Expected: false

        // Test iterator
        System.out.print("Iterating through elements: ");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();

        // Test sort
        System.out.print("Before sort: ");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();

        list.sort();
        System.out.print("After sort: ");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();

        // Test clear
        list.clear();
        System.out.println("Size after clear: " + list.size());  // Expected: 0
    }

    private static void testMyStack() {
        System.out.println("\n=== Testing MyStack ===");

        MyStack<Integer> stack = new MyStack<>();

        // Test push and size
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Size after pushing 3 elements: " + stack.size());  // Expected: 3

        // Test peek
        System.out.println("Top element: " + stack.peek());  // Expected: 30

        // Test pop
        System.out.println("Popped element: " + stack.pop());  // Expected: 30
        System.out.println("Size after pop: " + stack.size());  // Expected: 2
        System.out.println("New top element: " + stack.peek());  // Expected: 20

        // Test isEmpty
        System.out.println("Is stack empty? " + stack.isEmpty());  // Expected: false

        // Test clear
        stack.clear();
        System.out.println("Size after clear: " + stack.size());  // Expected: 0
        System.out.println("Is stack empty? " + stack.isEmpty());  // Expected: true
    }

    private static void testMyQueue() {
        System.out.println("\n=== Testing MyQueue ===");

        MyQueue<String> queue = new MyQueue<>();

        // Test enqueue and size
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        System.out.println("Size after enqueuing 3 elements: " + queue.size());  // Expected: 3

        // Test peek
        System.out.println("Front element: " + queue.peek());  // Expected: First

        // Test dequeue
        System.out.println("Dequeued element: " + queue.dequeue());  // Expected: First
        System.out.println("Size after dequeue: " + queue.size());  // Expected: 2
        System.out.println("New front element: " + queue.peek());  // Expected: Second

        // Test isEmpty
        System.out.println("Is queue empty? " + queue.isEmpty());  // Expected: false

        // Test clear
        queue.clear();
        System.out.println("Size after clear: " + queue.size());  // Expected: 0
        System.out.println("Is queue empty? " + queue.isEmpty());  // Expected: true
    }

    private static void testMyMinHeap() {
        System.out.println("\n=== Testing MyMinHeap ===");

        MyMinHeap<Integer> heap = new MyMinHeap<>();

        // Test add and size
        heap.add(30);
        heap.add(10);
        heap.add(20);
        heap.add(5);
        System.out.println("Size after adding 4 elements: " + heap.size());  // Expected: 4

        // Test getMin
        System.out.println("Min element: " + heap.getMin());  // Expected: 5

        // Test extractMin
        System.out.println("Extracted min element: " + heap.extractMin());  // Expected: 5
        System.out.println("Size after extractMin: " + heap.size());  // Expected: 3
        System.out.println("New min element: " + heap.getMin());  // Expected: 10

        // Test extractMin again
        System.out.println("Extracted min element: " + heap.extractMin());  // Expected: 10
        System.out.println("Extracted min element: " + heap.extractMin());  // Expected: 20
        System.out.println("Extracted min element: " + heap.extractMin());  // Expected: 30

        // Test isEmpty
        System.out.println("Is heap empty? " + heap.isEmpty());  // Expected: true

        // Test adding more elements after emptying
        heap.add(15);
        heap.add(7);
        System.out.println("Min element after re-adding: " + heap.getMin());  // Expected: 7
    }
}