# Traversal-Algorithms
This is a repo containing a java program that has depth first search and breath first search for node traversal. This was written in Spring of 2021.

## How to use:
Download the [source code](https://github.com/Austin-Daigle/Traversal-Algorithms-BFS-DFS/blob/main/SortingAlgorithms.java) from the repository and execute it via the command line.

## How it works:

This program reads a [matrix.txt](https://github.com/Austin-Daigle/Traversal-Algorithms-BFS-DFS/blob/main/matrix.txt) file and constructs an adjacent list construct by reading a letter header for its first row and each column under each letter is a set of designations for node adjacencies. A node iterator is created to create this adjacency node structure, and that structure is passed into the breath-first search algorithm and the depth-first search algorithm and the results from both are printed out.

The file being read ([matrix.txt](https://github.com/Austin-Daigle/Traversal-Algorithms-BFS-DFS/blob/main/matrix.txt)):
    
    A B C D E F G
    5 4 1 4 0 4 5
    4 3 3 6 6 6 -1
    1 2 -1 -1 -1 -1 -1


## Program Psuedo code
        read a file with file handling exceptions

        for every element in the first row

            create a node 

                for every element in each respective column below the current node association

                    add given node association to the current node
                endfor
        endfor
        end of node struture creation process process
        print the node struture 
        print the BFS algorithm traversal for the node structure given
        print the DFS algorithm traversal for the node structure given
end program


## Screenshot of a successful Execution:

![SortingAlgorithms console output](https://user-images.githubusercontent.com/100094056/193483310-6dd4b2d7-95c7-4979-b192-1dd60bcc2784.PNG)




