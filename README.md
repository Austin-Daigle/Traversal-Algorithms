# Traversal-Algorithms
This is a repo containing a java program that has depth first search and breath first search for node traversal. This was written in Spring of 2021.

## How it works:

This program reads a matrix.txt file and constructs an adjacent list construct by reading a letter header for its first row and each column under each letter is a set of designations for node adjacencies. A node iterator is created to create this adjacency node structure, and that structure is passed into the breath-first search algorithm and the depth-first search algorithm and the results from both are printed out.

The file being read (matrix.txt):
    
    A B C D E F G
    5 4 1 4 0 4 5
    4 3 3 6 6 6 -1
    1 2 -1 -1 -1 -1 -1
