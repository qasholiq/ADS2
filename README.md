Overview
This repository contains the implementation of various algorithms and data structures as part of the Algorithms and Data Structures course (Assignment 2). 
The codebase demonstrates practical applications of fundamental data structures and algorithms in Java.
Contents
1. MyList Interface and Implementation
A custom list interface with various implementations showcasing different approaches to list data structures:

MyArrayList: Implementation of a dynamic array-based list with automatic resizing capabilities.
MyLinkedList: Implementation of a doubly linked list with efficient insertion and deletion operations.

2. MyHeap
A binary heap implementation that provides efficient methods for priority-based operations:

Supports min-heap and max-heap operations
Includes methods for adding, removing, and accessing elements with O(log n) complexity
Features heap balancing for maintaining the heap property

3. MyHashTable
A hash table implementation that handles key-value storage with efficient lookup:

Utilizes a custom hashing function to distribute keys
Implements collision resolution using separate chaining
Provides methods for put, get, remove, contains, and size operations
Includes automatic rehashing when the load factor exceeds a threshold

4. BSTNode and BinarySearchTree
A binary search tree implementation for efficient searching, insertion, and deletion:

BSTNode: Basic node structure for the binary search tree
BinarySearchTree: Implementation supporting:

Insertion while maintaining BST properties
Searching for elements in O(log n) average time complexity
In-order, pre-order, and post-order traversal
Deletion with proper tree restructuring

5. Vertex and Graph Implementations
A graph structure with supporting algorithms:

Vertex: Structure representing graph vertices with adjacency information
WeightedGraph: Implementation of a weighted graph with:

Methods to add vertices and edges
Breadth-First Search (BFS) algorithm
Dijkstra's algorithm for finding shortest paths
Depth-First Search (DFS) algorithm

Usage Examples
Examples of using the implementations:
java// Using MyArrayList
MyList<Integer> arrayList = new MyArrayList<>();
arrayList.add(10);
arrayList.add(20);
System.out.println(arrayList.get(1)); // Output: 20

// Using MyHashTable
MyHashTable<String, Integer> hashTable = new MyHashTable<>();
hashTable.put("apple", 5);
hashTable.put("banana", 10);
System.out.println(hashTable.get("apple")); // Output: 5

// Using BinarySearchTree
BinarySearchTree<Integer> bst = new BinarySearchTree<>();
bst.insert(50);
bst.insert(30);
bst.insert(70);
System.out.println(bst.search(30)); // Output: true
Implementation Details
Each data structure is implemented with a focus on efficiency and proper object-oriented design principles. Time and space complexity considerations are taken into account for all operations, 
aiming for optimal performance in practical scenarios.
