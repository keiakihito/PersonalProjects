/**
 File Name: Task1.java
 CS 2400 Spring 2023
 Author: Keita Katsumi
 Description:
Task 1 main method makes adjacency list based on given graph
 and print all the edges to check the adjacency list representation
 Using
    BagListInterface.java
    LinkedBag.java
    ResizeableArrayBag.java
    Graph.java
 Last update: 05/08/2023
 */

public class Task1 {
    public static void main(String[] args) {
        Graph testGraph = new Graph();

        //Add vertex in the graph from A to I
        testGraph.addVertex('A');
        testGraph.addVertex('B');
        testGraph.addVertex('C');
        testGraph.addVertex('D');
        testGraph.addVertex('E');
        testGraph.addVertex('F');
        testGraph.addVertex('G');
        testGraph.addVertex('H');
        testGraph.addVertex('I');

        //Make edges
        //Make adjacency list of vertex A
        testGraph.addEdges('A','B');
        testGraph.addEdges('A','D');
        testGraph.addEdges('A','E');

        //Make adjacency list of vertex E
        testGraph.addEdges('B','E');

        //Make adjacency list of vertex C
        testGraph.addEdges('C','B');

        //Make adjacency list of vertex D
        testGraph.addEdges('D','G');

        //Make adjacency list of vertex E
        testGraph.addEdges('E','F');
        testGraph.addEdges('E','H');

        //Make adjacency list of vertex F
        testGraph.addEdges('F','H');
        testGraph.addEdges('F','C');

        //Make adjacency list of vertex G
        testGraph.addEdges('G','H');

        //Make adjacency list of vertex H
        testGraph.addEdges('H','I');

        //Make adjacency list of vertex I
        testGraph.addEdges('I','F');


        //Print all the vertices' adjacency lists
        System.out.println("Graph adjacency list: ");
        testGraph.printVertex();

    }// end of main

} // end of Task 1

/*Sample run

Graph adjacency list:
Vertex A: [E]->[D]->[B]->[^]
Vertex B: [E]->[^]
Vertex C: [B]->[^]
Vertex D: [G]->[^]
Vertex E: [H]->[F]->[^]
Vertex F: [C]->[H]->[^]
Vertex G: [H]->[^]
Vertex H: [I]->[^]
Vertex I: [F]->[^]


 */
