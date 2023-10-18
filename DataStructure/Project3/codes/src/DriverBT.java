/**
 File Name: DriverBT.java
 CS 2400 Spring 2023
 Author: Keita Katsumi
 Description:
 The class impliments public static void createTree2(BinaryTree<String> tree)
 And it tests assigned methods to check wehther they work properly.

 Last update: 04/07/2023
 */

public class DriverBT 
{
	public static void main(String[] args)
	{
		System.out.println("1st Testing Example:");
		BinaryTree<String> aTree = new BinaryTree<>();
		createTree1(aTree);
		
		System.out.println("(binaryTree) post-order: ");
		aTree.postorderTraverse();
		
		System.out.println("(binaryNode) post-order: ");
		aTree.postorderTraverse_callBinaryNodeMethod();
		
		System.out.println();
		
		System.out.println("(BinaryTree) Height of tree is " + aTree.getHeight());
		System.out.println("(BinaryNode) Height of tree is " + aTree.getHeight_callBinaryNodeMethod());
		
		System.out.println();
		
		System.out.println("(BinaryTree) # nodes of tree is " + aTree.getNumberOfNodes());
		System.out.println("(BinaryNode) # nodes of tree is " + aTree.getNumberOfNodes_callBinaryNodeMethod());

		System.out.println("==========================================");
		System.out.println();
		
		System.out.println("2nd Testing Example:");
		BinaryTree<String> aTree2 = new BinaryTree<>();
		createTree2(aTree2);
		
		System.out.println("(binaryTree) post-order: ");
		aTree2.postorderTraverse();
		
		System.out.println("(binaryNode) post-order: ");
		aTree2.postorderTraverse_callBinaryNodeMethod();
		
		System.out.println();
		
		System.out.println("(BinaryTree) Height of tree is " + aTree2.getHeight());
		System.out.println("(BinaryNode) Height of tree is " + aTree2.getHeight_callBinaryNodeMethod());
		
		System.out.println();
		
		System.out.println("(BinaryTree) # nodes of tree is " + aTree2.getNumberOfNodes());
		System.out.println("(BinaryNode) # nodes of tree is " + aTree2.getNumberOfNodes_callBinaryNodeMethod());
		
		System.out.println("Done.");
	}  // end main

	public static void createTree1(BinaryTree<String> tree)
	{ 
		// Leaves
		BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> gTree = new BinaryTree<>("G");

		// Subtrees:
		BinaryTree<String> fTree = new BinaryTree<>("F", null, gTree);
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, null);

		tree.setTree("A", bTree, cTree);
		
      System.out.println("\nGiven Tree:\n");
      System.out.println("     A      ");
      System.out.println("   /   \\  ");
      System.out.println("  B     C  ");
      System.out.println(" / \\   /  ");
      System.out.println("D   E  F   ");
      System.out.println("        \\ ");
      System.out.println("         G ");
      System.out.println();
	} // end createTree
	
	/**-------------------------------------------------------------------- */
	/**Task 4: Create a tree case as shown in assignment 3*/
	public static void createTree2(BinaryTree<String> tree)
	{
		// Make Left subtree of C
		BinaryTree<String> fTree = new BinaryTree<>("F");
		BinaryTree<String> dTree = new BinaryTree<>("D", fTree,null);

		// Make Right subtree of C, subtree E
		BinaryTree<String> gTree = new BinaryTree<>("G");
		BinaryTree<String> hTree = new BinaryTree<>("H");
		BinaryTree<String> eTree = new BinaryTree<>("E", gTree, hTree);

		//Make Subtree C
		BinaryTree<String> cTree = new BinaryTree<>("C", dTree, eTree);

		//Make Subtree B
		BinaryTree<String> bTree = new BinaryTree<>("B");

		//Make tree A with subtree B and Subtree C
		tree.setTree("A", bTree, cTree);

	} // end createTree2

}  // end DriverBT


/*
Sample Run
1st Testing Example:

Given Tree:

     A      
   /   \  
  B     C  
 / \   /  
D   E  F   
           \ 
             G 

(binaryTree) post-order: 
D E B G F C A (binaryNode) post-order: 
D E B G F C A 
(BinaryTree) Height of tree is 4
(BinaryNode) Height of tree is 4

(BinaryTree) # nodes of tree is 7
(BinaryNode) # nodes of tree is 7
==========================================

2nd Testing Example:
(binaryTree) post-order: 
B F D G H E C A (binaryNode) post-order: 
B F D G H E C A 
(BinaryTree) Height of tree is 4
(BinaryNode) Height of tree is 4

(BinaryTree) # nodes of tree is 8
(BinaryNode) # nodes of tree is 8
Done.

*/
