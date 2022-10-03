import java.io. * ;
import java.util. * ;
import java.util.Scanner;

/**
 * This class contains the breadth first search and depth first search
 * path-finding algorithms for the given node graph/tree objects. 
 * @author Austin Daigle
 * @version 1.0
 * @since 4/23/2021
 */
class SortingAlgorithms {
	//Create the adjacency list ArrayList and the numberOfNodes fields for BFS/DFS calculations.
	private int numberOfNodes;
	private static ArrayList<Integer> adjacentcyList[];

	/**
	 * This is the default constructor for the sorting algorithm
	 * objects.
	 * @param nodeAmounts This integer parameter controls the amount
	 * of nodes that allowed for the tree functions.
	 */
	@SuppressWarnings("unchecked")
	SortingAlgorithms(int nodeAmounts) {
		//Define the amount of supported nodes.
		this.numberOfNodes = nodeAmounts;
		//Create the adjacent
		this.adjacentcyList = new ArrayList[nodeAmounts];
		//For nodeAmounts increments
		for (int i = 0; i < nodeAmounts; i++) {
			//set the adjacency list at i to a new ArrayList integer instance.
			adjacentcyList[i] = new ArrayList<Integer>();
		}
	}

	/**
	 * this method adds a new node definition or updates 
	 * the adjacencies of a given node that has already been created. 
	 * @param vertexNode This is integer "name" of the node.
	 * @param neighborNode This is the adjacent vertex path that is defined to the node.
	 */
	public static void addEdge(int vertexNode, int neighborNode) {
		//update the adjacency list for the node. 
		adjacentcyList[vertexNode].add(neighborNode);
	}

	/**
	 * This method takes in a the vertexNode (starting node) of the 
	 * given graphical object and it traverses it with the breath first search
	 * algorithmic path-finding process.
	 * @param vertexNode This is the node reference to the first node in the graph.
	 */
	public void BFS(int vertexNode) {
		//define all vertices in the array as false (to indicate the not traversed status).
		boolean visited[] = new boolean[numberOfNodes];

		//Create a queue object for the binary-first-search object. 
		LinkedList<Integer> queueForBFS = new LinkedList < Integer > ();

		//define the current visited node as "true" and enqueue it in the queue.
		visited[vertexNode] = true;
		queueForBFS.add(vertexNode);

		//while the queueforBFS is not equal to zero then
		while (queueForBFS.size() != 0) {
			//Dequeue a vertex object from the queue.
			vertexNode = queueForBFS.poll();
			//Printout the dequeued vertex.
			System.out.print(vertexNode + " ");

			//Create iterator object.
			Iterator <Integer> nodeIterator = adjacentcyList[vertexNode].listIterator();
			//While there are more objects 
			while (nodeIterator.hasNext()) {
				//create an integer variable to store the next in the nodeIterator.
				int nextVertex = nodeIterator.next();
				//If the node has not been visited
				if(!visited[nextVertex]) {
					//define the node has "visited"
					visited[nextVertex] = true;
					//then enqueue it as well.
					queueForBFS.add(nextVertex);
				}
			}
		}
	}

	/**
	 * This method takes in a the vertexNode (starting node) of the 
	 * given graphical object and it traverses it with the depth first search
	 * algorithmic path-finding process.
	 * @param vertexNode This is the node reference to the first node in the graph.
	 */
	public void DFS(int vertexNode) {
		//define all vertices in the array as false (to indicate the not traversed status).
		boolean visitedVerticesIndex[] = new boolean[numberOfNodes];

		//Call the cursive support method with the vertexNode and the visitedVerticesIndex as parameters.
		DFShelper(vertexNode, visitedVerticesIndex);
	}

	/**
	 * This is the private helper-function for the depth first search function.
	 * This method is a recursive function for completing the core process. 
	 * @param vertexNode This is the reference for the first node from the graph object.
	 * @param visited This is the boolean array that indicates what vertices that have 
	 * been visited.
	 */
	private void DFShelper(int vertexNode, boolean visited[]) {
		//Mark the current node as visited
		visited[vertexNode] = true;
		//Print the visited node
		System.out.print(vertexNode + " ");

		//Create the iterator object
		Iterator<Integer> nodeIterator = adjacentcyList[vertexNode].listIterator();
		//Iterate if there are more objects to iterate through
		while (nodeIterator.hasNext()) {
			//define nextNode to the next iterated node.
			int nextNode = nodeIterator.next();
			//If the node has not been visited
			if(!visited[nextNode]) {
				//recurse the method with the current iteration parameters.
				DFShelper(nextNode, visited);
			}
		}
	}

	/**
	 * This method takes a set of dimensions (rows X columns) and a directory 
	 * (in the form as a string) and converts the text data from a regular file
	 * representing a matrix into a two-dimensional object array. 
	 * @param rows This is the row dimension for the matrix that is being imported.
	 * @param columns This is the column dimension for the matrix that is being imported.
	 * @param directory This is the directory that is going to point to the file that will
	 * be scanned and imported.
	 * @return This methods returns a multi-dimensional object array of the matrix that is being
	 * imported. 
	 * @throws FileNotFoundException throws an exception if the file is not present or corrupt. 
	 */
	public static Object[] readMatrixFromFile(int rows, int columns, String directory) throws FileNotFoundException {
		//Create the file scanenr object pointed to the directory parameter.
		Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(directory)));
		//Create a multi-dimensional array at the parameter dimensions. 
		Object[][] convertedMatrix = new Object[columns][rows];
		//While the fileScanner has another line to traverse.
		while (fileScanner.hasNextLine()) {
			//for the length of the myArray
			for(int i = 0; i < convertedMatrix.length; i++) {
				//Create a string array to load the whole line as an array
				String[] line = fileScanner.nextLine().trim().split(" ");
				//for the length of the line
				for(int y = 0; y < line.length; y++) {
					//update my array's value at the given respective value of i/y. 
					convertedMatrix[i][y] = line[y];
				}
			}
		}
		//return the converted array.
		return convertedMatrix;
	}

	/**
	 * This method converts the multi-dimensional array into 
	 * nodes with adjacency associations. 
	 * @param matrix This is the matrix that will be converted into nodes/neighbors. 
	 */
	public static void convertMatrixToNodes(Object[][] matrix) {
		//for the length of the matrix
		for(int x = 0; x < matrix.length; x++) {
			//for the length of the second level of the matrix array.
			for (int y = 0; y < matrix[1].length; y++) {
				//printout the matrix
				System.out.print(matrix[x][y] + " ");
			}
			System.out.println("");
		}
		System.out.println("Printing out all associated nodes.");
		//for the length of the second level of the matrix array.
		for (int x = 0; x < matrix[1].length; x++) {
			//for the length of the matrix
			for (int y = 0; y < matrix.length; y++) {
				//If the value of v is NOT zero and the value of the matrix at the given point is not -1 then
				if (y != 0 && Integer.parseInt((String) matrix[y][x]) != -1) {
					//Printout the node association statement.
					System.out.println("Node " + x + " Neighbor:" + Integer.parseInt((String) matrix[y][x]));
					//Add a node/association from the matrix at the point. 
					addEdge(x, Integer.parseInt((String) matrix[y][x]));
				}
			}
		}
	}

	//Driver method
	public static void main(String args[]) throws FileNotFoundException {
		
		/*
		 * Create the prompt and scanner inputs for the user to input the
		 * the row and column dimensions for the matrix.
		 */
		System.out.println("how many rows are in your input matrix?");
		Scanner matrixSizeInput = new Scanner(System.in);
		System.out.print("> ");
		int rows = matrixSizeInput.nextInt();
		System.out.println("how many columns are in your input matrix?");
		System.out.print("> ");
		int columns = matrixSizeInput.nextInt();
		//Printout the matrix dimensions from the user.
		System.out.println("The matrix has "+rows+" rows and "+columns
				+" columns.");
		
		//Create the graph object for sotring the nodes and processing the BFS/DFS sorting operations.
		SortingAlgorithms graphObject = new SortingAlgorithms(rows);
		//Create a scanner for taking in the directory to the matrix file. 
		Scanner userInput = new Scanner(System.in);
		//Printout cursor prompt
		System.out.println("Please Enter Directory to a file containing the matrix to be entered.");
		System.out.print("> ");
		//Set the String variable directorySelection to the data from the scanner object.
		String fileSelection = userInput.nextLine();
		//Create a File object with the directorySelection string as it directory.
		File currentSelectedFile = new File(fileSelection);
		//Check is the File object currentSelectedDir is an actual directory
		if (currentSelectedFile.exists()) {
			//If the file is real then printout the statement and perform the rest of the operations.
			System.out.println("Printing out Matrix from file");
			/*
			 * create the the matrixData array object and set the data to the data from 
			 * readMatrixFromFile with the given parameters.
			 */
			Object[] matrixData = (readMatrixFromFile(rows, columns, fileSelection));
			//Convert the matrix to nodes/associations by calling convertMatrixToNodes.
			graphObject.convertMatrixToNodes((Object[][]) matrixData);
			//set the starting node to zero.
			int startingNode = 0;
			//Printout the data from the BFS operation.
			System.out.println("BFS Sorting Operation:");
			graphObject.BFS(startingNode);
			System.out.println();
			//Printout the data from the DFS operation.
			System.out.println("DFS Sorting Operation:");
			graphObject.DFS(startingNode);
		} 
		else {
			//If the given directory was not valid then print an error message.
			System.out.println("Error: Not a valid file directory.");		
		} 
	}
}