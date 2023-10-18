import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @org.junit.jupiter.api.Test
    void postorderTraverse()
    {
        System.out.println("~~postorderTraverse_Test~~");
        // Left subtree
        BinaryTree<String> hTree = new BinaryTree<>("H");
        BinaryTree<String> dTree = new BinaryTree<>("D", hTree,null);

        BinaryTree<String> eTree = new BinaryTree<>("E");
        BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);

        //Right subtree
        BinaryTree<String> fTree = new BinaryTree<>("F");
        BinaryTree<String> gTree = new BinaryTree<>("G");
        BinaryTree<String> cTree = new BinaryTree<>("C", fTree, gTree);

        // Connect left and right trees:
        BinaryTree<String> aTree = new BinaryTree<>("A", bTree, cTree);

        System.out.print("\naTree: ");
        aTree.postorderTraverse();


        //Tree2 test
        BinaryTree<String> fTree2 = new BinaryTree<>("F");
        BinaryTree<String> dTree2 = new BinaryTree<>("D", fTree2,null);

        // Make Right subtree of C, subtree E
        BinaryTree<String> gTree2 = new BinaryTree<>("G");
        BinaryTree<String> hTree2 = new BinaryTree<>("H");
        BinaryTree<String> eTree2 = new BinaryTree<>("E", gTree2, hTree2);

        //Make Subtree C
        BinaryTree<String> cTree2 = new BinaryTree<>("C", dTree2, eTree2);

        //Make Subtree B
        BinaryTree<String> bTree2 = new BinaryTree<>("B");


        //Make tree A with subtree B and Subtree C
        BinaryTree<String> aTree2 = new BinaryTree<>("A", bTree2, cTree2);

        System.out.print("\naTree2: ");
        aTree2.postorderTraverse();

        System.out.println("~~postorderTraverse_Test passed~~");


    }

    @org.junit.jupiter.api.Test
    void postorderTraverse_callBinaryNodeMethod()
    {
        System.out.println("~~postorderTraverse_callBinaryNodeMethod_Test~~");
        // Left subtree
        BinaryTree<String> hTree = new BinaryTree<>("H");
        BinaryTree<String> dTree = new BinaryTree<>("D", hTree,null);

        BinaryTree<String> eTree = new BinaryTree<>("E");
        BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);

        //Right subtree
        BinaryTree<String> fTree = new BinaryTree<>("F");
        BinaryTree<String> gTree = new BinaryTree<>("G");
        BinaryTree<String> cTree = new BinaryTree<>("C", fTree, gTree);

        // Connect left and right trees:
        BinaryTree<String> aTree = new BinaryTree<>("A", bTree, cTree);

        System.out.print("\naTree: ");
        aTree.postorderTraverse_callBinaryNodeMethod();

        //Tree2 test
        BinaryTree<String> fTree2 = new BinaryTree<>("F");
        BinaryTree<String> dTree2 = new BinaryTree<>("D", fTree2,null);

        // Make Right subtree of C, subtree E
        BinaryTree<String> gTree2 = new BinaryTree<>("G");
        BinaryTree<String> hTree2 = new BinaryTree<>("H");
        BinaryTree<String> eTree2 = new BinaryTree<>("E", gTree2, hTree2);

        //Make Subtree C
        BinaryTree<String> cTree2 = new BinaryTree<>("C", dTree2, eTree2);

        //Make Subtree B
        BinaryTree<String> bTree2 = new BinaryTree<>("B");


        //Make tree A with subtree B and Subtree C
        BinaryTree<String> aTree2 = new BinaryTree<>("A", bTree2, cTree2);
        System.out.print("\naTree2: ");
        aTree2.postorderTraverse_callBinaryNodeMethod();

        System.out.println("~~postorderTraverse_callBinaryNodeMethod_Test passed~~");

    }


    @org.junit.jupiter.api.Test
    void getHeight_callBinaryNodeMethod()
    {
        System.out.println("~~getHeight_callBinaryNodeMethod passed_Test~~");
        // Left subtree
        BinaryTree<String> hTree = new BinaryTree<>("H");
        BinaryTree<String> dTree = new BinaryTree<>("D", hTree,null);

        BinaryTree<String> eTree = new BinaryTree<>("E");
        BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);

        //Right subtree
        BinaryTree<String> fTree = new BinaryTree<>("F");
        BinaryTree<String> gTree = new BinaryTree<>("G");
        BinaryTree<String> cTree = new BinaryTree<>("C", fTree, gTree);

        // Connect left and right trees:
        BinaryTree<String> aTree = new BinaryTree<>("A", bTree, cTree);

        System.out.print("aTree height : ");
        System.out.println( aTree.getHeight_callBinaryNodeMethod());



        //Tree 2 test
        // Make Left subtree of C
        BinaryTree<String> fTree2 = new BinaryTree<>("F");
        BinaryTree<String> dTree2 = new BinaryTree<>("D", fTree,null);

        // Make Right subtree of C, subtree E
        BinaryTree<String> gTree2 = new BinaryTree<>("G");
        BinaryTree<String> hTree2 = new BinaryTree<>("H");
        BinaryTree<String> eTree2 = new BinaryTree<>("E", gTree2, hTree2);

        //Make Subtree C
        BinaryTree<String> cTree2 = new BinaryTree<>("C", dTree2, eTree2);

        //Make Subtree B
        BinaryTree<String> bTree2 = new BinaryTree<>("B");

        //Make tree A with subtree B and Subtree C
        BinaryTree<String> aTree2 = new BinaryTree<>("A", bTree2, cTree2);

        System.out.print("aTree2 height : ");
        System.out.println( aTree2.getHeight_callBinaryNodeMethod());

        System.out.println("~~getHeight_callBinaryNodeMethod passed_Test passed~~");
    }

    @org.junit.jupiter.api.Test
    void getNumberOfNodes()
    {
        System.out.println("~~getNumberOfNodes passed_Test ~~");

        System.out.println("\naTree1 Test: ");
        // Left subtree
        BinaryTree<String> hTree = new BinaryTree<>("H");
        BinaryTree<String> dTree = new BinaryTree<>("D", hTree,null);
        BinaryTree<String> eTree = new BinaryTree<>("E");
        BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);

        System.out.print("Number of subtree bTree nodes : ");
        System.out.println( bTree.getNumberOfNodes());



        //Right subtree
        BinaryTree<String> fTree = new BinaryTree<>("F");
        BinaryTree<String> gTree = new BinaryTree<>("G");
        BinaryTree<String> cTree = new BinaryTree<>("C", fTree, gTree);

        System.out.print("Number of subtree cTree nodes : ");
        System.out.println( cTree.getNumberOfNodes());



        // Connect left and right trees:
        BinaryTree<String> aTree = new BinaryTree<>("A", bTree, cTree);

        System.out.print("Number of aTree nodes aTree: ");
        System.out.println( aTree.getNumberOfNodes());



        //Tree2 test
        System.out.println("\naTree2 Test: ");
        BinaryTree<String> fTree2 = new BinaryTree<>("F");
        BinaryTree<String> dTree2 = new BinaryTree<>("D", fTree,null);

        // Make Right subtree of C, subtree E
        BinaryTree<String> gTree2 = new BinaryTree<>("G");
        BinaryTree<String> hTree2 = new BinaryTree<>("H");
        BinaryTree<String> eTree2 = new BinaryTree<>("E", gTree2, hTree2);

        //Make Subtree C
        BinaryTree<String> cTree2 = new BinaryTree<>("C", dTree2, eTree2);
        System.out.print("Number of subtree cTree2 nodes : ");
        System.out.println( cTree2.getNumberOfNodes());

        //Make Subtree B
        BinaryTree<String> bTree2 = new BinaryTree<>("B");

        System.out.print("Number of subtree bTree2 nodes : ");
        System.out.println( bTree2.getNumberOfNodes());

        //Make tree A with subtree B and Subtree C
        BinaryTree<String> aTree2 = new BinaryTree<>("A", bTree2, cTree2);

        System.out.print("Number of aTree2 nodes aTree: ");
        System.out.println( aTree2.getNumberOfNodes());

        System.out.println("~~getNumberOfNodes passed_Test passed ~~");

    }


} // End of test suite