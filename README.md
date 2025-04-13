Algorithms and Data Structures - Assignment 2
This project creates basic data storage tools from scratch in Java. These tools help store and organize data in different ways. 
The project doesn't use Java's built-in collections (like ArrayList or LinkedList).
Main Parts of the Project:
Basic Storage Containers:

1.MyArrayList:

Stores items in a row, like boxes on a shelf
Good for quickly grabbing any item if you know its position
Easy to add items at the end, harder to add in the middle


2.MyLinkedList:

Stores items as separate pieces connected by links
Like a chain where each link points to the next one
Easy to add or remove items anywhere in the list



Tools built using these containers:

1.MyStack:

Works like a stack of plates - you can only take from the top
Last item in is the first item out (LIFO)
Uses MyArrayList because we only need fast access to the end


2.MyQueue:

Works like a line of people - first come, first served
First item in is the first item out (FIFO)
Uses MyLinkedList because we need good access to both ends


3.MyMinHeap:

Always keeps the smallest item easily available
Like a funnel that always drops the smallest item first
Uses MyArrayList with special rules to maintain order



Additional Advanced Data Structures:

1.MyHashTable:

Uses a special formula to decide where to store each item
Works like a dictionary - you can look up items by their name (key)
Very fast for finding, adding, or removing items


2.BinarySearchTree:

Organizes items in a tree where smaller values go left and larger values go right
Like a family tree that makes it easy to find specific items
Good for maintaining sorted data and quickly finding items


3.WeightedGraph:

Represents connections between items, like a map of cities
Each connection has a weight (like distance or cost)
Includes tools to find the shortest path between items
