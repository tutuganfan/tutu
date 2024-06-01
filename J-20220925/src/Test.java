import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author 12629
 * @Description：
 */
public class Test {

    public static void main1(String[] args) {
        Queue<TestBinaryTree.TreeNode> queue = new LinkedList<>();
        queue.offer(null);
        queue.offer(null);
        queue.offer(null);
        queue.offer(null);
        System.out.println(queue.size());
    }
    public static void main(String[] args) {
        TestBinaryTree testBinaryTree = new TestBinaryTree();
        TestBinaryTree.TreeNode root = testBinaryTree.createTree();

        testBinaryTree.preOrder(root);
        System.out.println();
        testBinaryTree.inOrder(root);
        System.out.println();
        testBinaryTree.postOrder(root);
        System.out.println();

       //testBinaryTree.size(root);
        //System.out.println("节点个数："+TestBinaryTree.nodeSize);
        System.out.println("节点个数："+testBinaryTree.size2(root));

        testBinaryTree.getLeafNodeCount2(root);
        System.out.println("节点个数："+TestBinaryTree.leafSize);
        //System.out.println("叶子节点个数："+testBinaryTree.getLeafNodeCount(root));

        System.out.println("第K层的节点个数："+testBinaryTree.getKLevelNodeCount(root,5));

        System.out.println("树的高度："+testBinaryTree.getHeight2(root));

        System.out.println("层序遍历：");
        testBinaryTree.levelOrder(root);

        System.out.println(testBinaryTree.isCompleteTree(root));
        System.out.println("=========================");

        Stack<TestBinaryTree.TreeNode> stack = new Stack<>();
        testBinaryTree.getPath(root,root.left.right,stack);
        System.out.println("fdsfasadfsa");

    }
}
