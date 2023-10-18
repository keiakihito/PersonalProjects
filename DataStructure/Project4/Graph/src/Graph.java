/**
 File Name: Graph.java
 CS 2400 Spring 2023
 Author: Keita Katsumi
 Description:
 The class aggregates the linkedlist bag objects that realizes the adjacency list in the graph
 Using
    BagListInterface.java
    LinkedBag.java
 Last update: 05/08/2023
 */

import java.util.ArrayList;
import java.util.Objects;

public class Graph {
    private ResizeableArrayBag<LinkedBag> _vertexArr;

    //Constructor create empty array for aggregating linked list
    public Graph(){
        _vertexArr = new ResizeableArrayBag<LinkedBag>();
    }

    /**
     * @Return number of adjancy lists in the array
     * */
    public int getNumOfVertex(){
        return _vertexArr.getCurrentSize();
    }

    /**
     * Print all the vertecies and edges with linked list structure
     * */
    public void printVertex(){
        for (int i = 0; i < _vertexArr.getCurrentSize(); i++){
            System.out.print("Vertex ");
            System.out.print(_vertexArr.getItem(i).getHeadVertex()); // show vertex of the current list
            System.out.print(": ");
            _vertexArr.getItem(i).printBag(); //Show the all the edges in the list
            System.out.print("\n");
        }
    }

    /**
     * @Param Character vertex
     * @Return boolean
     * The method returns true when the vertex is a new element in the vertex array
     * */
    public void addVertex(Character vertex){
        //When the vertex is already exist in the vertex array, it exits the method.
        if(contains(vertex)){
            return; //Terminate the method
        }
        //If the vertex is a new in the list
        //Create a empty linkedList and set vertex
        LinkedBag<Character> adjancyList = new LinkedBag<>(vertex);
        _vertexArr.add(adjancyList);

    }

    /**
     * @Param Character vertex
     * @Return integer index of vertex
     * The methods iterates the vertex array and find the index target vertex
     * */
    public int findVertexIndex(Character vertex){
        for (int i = 0; i < _vertexArr.getCurrentSize(); i++){
            //Check the vertex matches vertex in the vertex array
            if (_vertexArr.getItem(i).getHeadVertex().equals(vertex)){
                return i;
            }
        }
        return -1; // -1 means vertex doesn't exist in hte graph
    }

    /**
     * @Param Character from vertex, Character to vertex
     * The method connects vertex each other and update adjancy list
     * */
    public void addEdges(Character frmVertex, Character toVertex){
        if (!(contains(frmVertex) && contains(toVertex))){
            return; // Terminate method
        }

        //Find from vertex index and
        // Add toVertex character to corresponding the linked list
        int trgtIdx = findVertexIndex(frmVertex);
        _vertexArr.getItem(trgtIdx).add(toVertex);

    }
    
    /**
     * @Param frmVertex, @LilnkedList<Character> vertex list
     * @Return boolean
     * The method checks the given character maches the vertex of the the adjacency list
     * */
    public boolean isTargetVertexList
                    (Character frmVertex, LinkedBag<Character> vertexList){
        return (vertexList.getHeadVertex().equals(frmVertex));
    }


    /**
     * The method initialize the vertex array
     * */
    public void clear(){
        _vertexArr.clear();
    }


    /**
     * @Param Character vertex
     * @Return boolean
     * The method checks whether given vertex exits in the vertex array or not.
     * */
    public boolean contains(Character vertex){
        for (int i = 0; i < _vertexArr.getCurrentSize(); i++){
            if (isTargetVertexList(vertex, _vertexArr.getItem(i)))
                return true;
        }
        return false;
    }

    /**
     * @Param Character vertex
     * @Return Object[] array
     * The method creates a new Object[] array,
     * deeply copies each element in the adjacency linkedlist 
     * and store copied elements to the new array.
     * */
    public Object[] toArray (Character vertex){
        // If given vertex doesn't exist in the vertex array, it exits the method
        if (! contains(vertex)){return null; } 
        
        //Find target adjacency list and create a new array with all the edges in the adjacency list
        int trgtIdx = findVertexIndex(vertex);
        ArrayList<Character> cpyArr = _vertexArr.getItem(trgtIdx).toArray();
        Object[]  adjacencyArr = cpyArr.toArray();
        return adjacencyArr;
    }



}// End of Graph class
