import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryNodeTest {

    @Test
    void postorderTraverse_binaryNodeMethod()
    {
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
    }

    @Test
    void getHeight_binaryNodeMethod()
    {
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
    }

    @Test
    void getNumberOfNodes_binaryNodeMethod() {
    }
}