import com.nocompany.trees.SortedBinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by igorfiller on 09.09.17.
 */
class SortedBinaryTreeTest {

    SortedBinaryTree tree;
    Random random = new Random();

    @BeforeEach
    public void setUp(){
//        tree = new SortedBinaryTree(10);
        tree = new SortedBinaryTree(new SortedBinaryTree.Node(1));
    }


    @Test
    public void isSortedTree(){
        int counter = random.nextInt(10);
        System.out.println("Counter " + counter);
        System.out.println("Root " + tree.node.value);
//        while (counter>=0) {
        PrimitiveIterator.OfInt iterator = IntStream.of(16,30,31,14,7,9,17).iterator();
        while (iterator.hasNext()) {
//            int value = random.nextInt(50);
            int value = iterator.next();
            SortedBinaryTree.Node newNode = newNodeWithRandomValue(value);
            tree.addElement(tree.node, newNode);
            System.out.println("Added node" + newNode.value);
            counter--;
        }
        System.out.println("\n");
        tree.setDepth(tree.maxDepth(tree.node));
        System.out.println("Depth " + tree.getDepth());
        tree.printSortedTreeValues(tree.node);
    }

    public SortedBinaryTree.Node newNodeWithRandomValue(Integer value){
        return new SortedBinaryTree.Node(value);
    }
}