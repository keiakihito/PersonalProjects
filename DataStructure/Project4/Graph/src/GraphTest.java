import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void stubs_Test() {
        System.out.println("\n\n~~~~~~~ Graph Stub_Test~~~~~~~~~~\n\n");
        Graph testGraph = new Graph();
        testGraph.getNumOfVertex();
        testGraph.printVertex();
        testGraph.addVertex('A');
        testGraph.findVertexIndex('A');
        testGraph.addEdges('A', 'B');
        testGraph.clear();
        testGraph.contains('A');
        testGraph.toArray('A');

        System.out.println("\n\n~~~~~~~  Graph Stub_Test passed~~~~~~~~~~\n\n");
    }

    @Test
    void CTR_Test(){
        System.out.println("\n\n~~~~~~~ CTR_Test Stub_Test~~~~~~~~~~\n\n");
        Graph testGraph = new Graph();
        System.out.println(testGraph.toString());

        System.out.println("\n\n~~~~~~~  CTR_Test Stub_Test passed~~~~~~~~~~\n\n");
    }

    @Test
    void getNumOfVertex() {
        System.out.println("\n\n~~~~~~~ getNumOfVertex Stub_Test~~~~~~~~~~\n\n");
        Graph testGraph = new Graph();
        testGraph.addVertex('A');
        testGraph.addVertex('B');
        testGraph.addVertex('C');
        testGraph.printVertex();

        assertEquals(3, testGraph.getNumOfVertex());

        System.out.println("\n\n~~~~~~~  getNumOfVertex Stub_Test passed~~~~~~~~~~\n\n");
    }

    @Test
    void printVertex() {
        System.out.println("\n\n~~~~~~~ printVertex Stub_Test~~~~~~~~~~\n\n");

        System.out.println("\n\n~~~~~~~  printVertex Stub_Test passed~~~~~~~~~~\n\n");
    }

    @Test
    void addVertex() {
        System.out.println("\n\n~~~~~~~ addVertex Stub_Test~~~~~~~~~~\n\n");
        Graph testGraph = new Graph();
        testGraph.addVertex('A');
        testGraph.addVertex('B');
        testGraph.addVertex('C');
        testGraph.addVertex('A');
        testGraph.addVertex('B');
        testGraph.addVertex('C');
        testGraph.printVertex();

        System.out.println("\n\n~~~~~~~   addVertex Stub_Test passed~~~~~~~~~~\n\n");
    }

    @Test
    void findVertexIndex() {
        System.out.println("\n\n~~~~~~~ findVertexIndex Stub_Test~~~~~~~~~~\n\n");
        Graph testGraph = new Graph();
        testGraph.addVertex('A');
        testGraph.addVertex('B');
        testGraph.addVertex('C');
        testGraph.printVertex();

        assertEquals(0, testGraph.findVertexIndex('A'));
        assertEquals(1, testGraph.findVertexIndex('B'));
        assertEquals(2, testGraph.findVertexIndex('C'));
        assertEquals(-1, testGraph.findVertexIndex('D'));

        System.out.println("\n\n~~~~~~~  findVertexIndex Stub_Test passed~~~~~~~~~~\n\n");
    }

    @Test
    void addEdges() {
        System.out.println("\n\n~~~~~~~ addEdges Stub_Test~~~~~~~~~~\n\n");
        Graph testGraph = new Graph();
        testGraph.addVertex('A');
        testGraph.addVertex('B');
        testGraph.addVertex('C');

        testGraph.addEdges('A','B');
        testGraph.addEdges('B','C');
        testGraph.addEdges('C','A');

        testGraph.printVertex();


        System.out.println("\n\n~~~~~~~  addEdges Stub_Test passed~~~~~~~~~~\n\n");
    }

//    @Test
//    void isTargetVertexList() {
//        System.out.println("\n\n~~~~~~~ isTargetVertexList Stub_Test~~~~~~~~~~\n\n");
//
//        System.out.println("\n\n~~~~~~~  isTargetVertexList Stub_Test passed~~~~~~~~~~\n\n");
//    }

    @Test
    void clear() {
        System.out.println("\n\n~~~~~~~ clear Stub_Test~~~~~~~~~~\n\n");

        Graph testGraph = new Graph();
        testGraph.addVertex('A');
        testGraph.addVertex('B');
        testGraph.addVertex('C');
        testGraph.printVertex();

        assertEquals(0, testGraph.findVertexIndex('A'));
        assertEquals(1, testGraph.findVertexIndex('B'));
        assertEquals(2, testGraph.findVertexIndex('C'));
        assertEquals(-1, testGraph.findVertexIndex('D'));

        testGraph.clear();

        assertEquals(-1, testGraph.findVertexIndex('A'));
        assertEquals(-1, testGraph.findVertexIndex('B'));
        assertEquals(-1, testGraph.findVertexIndex('C'));
        assertEquals(-1, testGraph.findVertexIndex('D'));

        assertEquals(false, testGraph.contains('A'));
        assertEquals(false, testGraph.contains('B'));
        assertEquals(false, testGraph.contains('C'));
        assertEquals(false, testGraph.contains('D'));

        System.out.println("\n\n~~~~~~~  clear Stub_Test passed~~~~~~~~~~\n\n");
    }

    @Test
    void contains() {
        System.out.println("\n\n~~~~~~~  contains Stub_Test~~~~~~~~~~\n\n");
        Graph testGraph = new Graph();
        testGraph.addVertex('A');
        testGraph.addVertex('B');
        testGraph.addVertex('C');
        testGraph.printVertex();

        assertEquals(true, testGraph.contains('A'));
        assertEquals(true, testGraph.contains('B'));
        assertEquals(true, testGraph.contains('C'));
        assertEquals(false, testGraph.contains('D'));

        System.out.println("\n\n~~~~~~~   contains Stub_Test passed~~~~~~~~~~\n\n");
    }

    @Test
    void toArray() {
        System.out.println("\n\n~~~~~~~ toArray Stub_Test~~~~~~~~~~\n\n");
        Graph testGraph = new Graph();
        testGraph.addVertex('A');
        testGraph.addVertex('B');
        testGraph.addVertex('C');

        testGraph.addEdges('A','B');
        testGraph.addEdges('A','C');
        testGraph.addEdges('A','A');

        Object[] listA = testGraph.toArray('A');
        System.out.print("Adjacency list A: ");
        for (Object cha: listA){
            System.out.print(cha + " ");
        }

        testGraph.addEdges('B','C');
        testGraph.addEdges('B','B');
        testGraph.addEdges('B','A');

        System.out.print("\nAdjacency list B: ");
        Object[] listB = testGraph.toArray('B');
        for (Object cha: listB){
            System.out.print(cha + " ");
        }

        testGraph.addEdges('C','A');
        testGraph.addEdges('C','C');
        testGraph.addEdges('C','B');

        System.out.print("\nAdjacency list C: ");
        Object[] listC = testGraph.toArray('C');
        for (Object cha: listC){
            System.out.print(cha + " ");
        }

        System.out.println("\n\n~~~~~~~  toArray Stub_Test passed~~~~~~~~~~\n\n");
    }
}