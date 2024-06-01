import java.util.*;

/**
 * @Author 12629
 * @Description：
 */
public class TestBinaryTree {
    static class TreeNode {
        public char val;
        public TreeNode left;//存储左孩子的引用
        public TreeNode right;//存储右孩子的引用


        public TreeNode(char val) {
            this.val = val;
        }
    }

    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;

        return A;
    }

    private static int i = 0;
    public static TreeNode createTree(String str) {
        TreeNode root = null;
        if(str.charAt(i) != '#') {
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = createTree(str);
            root.right = createTree(str);
        }else {
            i++;
        }
        return root;
    }

    // 前序遍历
    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    List<Integer> list1 = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return list1;
        }
        //System.out.print(root.val+" ");
        //list1.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list1;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        //ret.add(root.val);
        List<Integer> leftTree = preorderTraversal2(root.left);
        ret.addAll(leftTree);

        List<Integer> rightTree = preorderTraversal2(root.right);
        ret.addAll(rightTree);
        return ret;
    }



    // 中序遍历
    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    // 后序遍历
    public void postOrder(TreeNode root){
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    // 获取树中节点的个数
    public static int nodeSize = 0;
    public int size(TreeNode root) {
        if(root == null) {
            return 0;
        }
        nodeSize++;
        size(root.left);
        size(root.right);
        return nodeSize;
    }

    public int size2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int tmp = size2(root.left)+size2(root.right)+1;
        return tmp;
    }


    // 获取叶子节点的个数
    int getLeafNodeCount(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int tmp = getLeafNodeCount(root.left) +
                getLeafNodeCount(root.right);
        return tmp;
    }

    public static int leafSize = 0;
    void getLeafNodeCount2(TreeNode root) {
        if(root == null) {
            return ;
        }
        if(root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafNodeCount2(root.left);
        getLeafNodeCount2(root.right);
    }


    // 获取第K层节点的个数
    int getKLevelNodeCount(TreeNode root,int k) {
        if(root == null || k <= 0) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        int tmp = getKLevelNodeCount(root.left,k-1) +
                getKLevelNodeCount(root.right,k-1);
        return tmp;
    }

    // 获取二叉树的高度  时间复杂度：O(n)
    public int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
    }

    // 时间复杂度：O(n)
    public int getHeight2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return getHeight2(root.left) > getHeight2(root.right)
                ? getHeight2(root.left)+1 : getHeight2(root.right)+1;
    }

    // 检测值为value的元素是否存在
    public TreeNode find(TreeNode root, char val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        TreeNode ret1 = find(root.left,val);
        if(ret1 != null) {
            return ret1;
        }
        TreeNode ret2 =  find(root.right,val);
        if(ret2 != null) {
            return ret2;
        }
        return null;
    }

    //时间复杂度：O(min(M,N))  P:M  Q:N
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null  || p != null && q == null ) {
            return false;
        }
        if(p == null && q == null) {
            return true;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    //时间复杂度：root：r个节点     subRoot：有s个节点
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null ) return false;
        //1、判断两棵树 是不是两颗相同的树
        if(isSameTree(root,subRoot)) return true;
        //2、subRoot是不是 root.left 子树
        if(isSubtree(root.left,subRoot)) return true;
        //3、subRoot是不是 root.right 子树
        if(isSubtree(root.right,subRoot)) return true;
        return false;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
    }

    /**
     * 时间复杂度：O( N^2  )
     *    字节跳动： O(n)
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.right);

        return Math.abs(leftH-rightH) < 2 &&
                isBalanced(root.left) &&
                isBalanced(root.right);
    }

    public int maxDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = maxDepth2(root.left);//2   -1
        int rightHeight = maxDepth2(root.right);//0  3
        if(leftHeight >= 0 && rightHeight >= 0 &&
                Math.abs(leftHeight-rightHeight) <= 1) {
            return Math.max(leftHeight,rightHeight) + 1;
        }else {
            return -1;
        }
    }

    public boolean isBalanced2(TreeNode root) {
        if(root == null) return true;
        return maxDepth2(root) >= 0;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

        return isSymmetricChild(root.left,root.right);
    }

    private boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
        if(leftTree == null && rightTree != null ||
                leftTree != null && rightTree == null ) {
            return false;
        }
        if(leftTree == null && rightTree == null) {
            return true;
        }
        if(leftTree.val != rightTree.val) {
            return false;
        }

        return isSymmetricChild(leftTree.left,rightTree.right) &&
                isSymmetricChild(leftTree.right,rightTree.left);

    }

    //层序遍历
    public void levelOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            TreeNode cur = qu.poll();
            System.out.print(cur.val+" ");
            if(cur.left != null) {
                qu.offer(cur.left);
            }
            if(cur.right != null) {
                qu.offer(cur.right);
            }
        }
    }

    public List<List<Character>> levelOrder2(TreeNode root) {
        List<List<Character>> list = new ArrayList<>();

        if(root == null) {
            return list;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            int size = qu.size();//2  //如何确定每一层？
            List<Character> tmp = new ArrayList<>();
            while (size > 0) {
                TreeNode cur = qu.poll();
                size--;//0
                //System.out.print(cur.val + " ");
                tmp.add(cur.val);
                if (cur.left != null) {
                    qu.offer(cur.left);
                }
                if (cur.right != null) {
                    qu.offer(cur.right);
                }
            }
            list.add(tmp);
        }
        return list;
    }

    // 判断一棵树是不是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            TreeNode cur = qu.poll();
            if(cur != null) {
                qu.offer(cur.left);
                qu.offer(cur.right);
            }else {
                break;
            }
        }
        //判断队列剩下的值 是否有 非null的数据
        while (!qu.isEmpty()) {
            TreeNode pop = qu.poll();
            if(pop != null) {
                return false;
            }
        }
        return true;
    }

    public boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
        if(root == null || node == null) {
            return false;
        }

        stack.push(root);

        if(root == node) {
            return true;
        }

        boolean flg1 = getPath(root.left,node,stack);
        if(flg1 == true) {
            return true;
        }

        boolean flg2 = getPath(root.right,node,stack);
        if(flg2 == true) {
            return true;
        }
        stack.pop();
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) {
            return null;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        getPath(root,p,stack1);

        Stack<TreeNode> stack2 = new Stack<>();
        getPath(root,q,stack2);

        int size1 = stack1.size();
        int size2 = stack2.size();

        if(size1 > size2) {
            int size = size1-size2;
            while(size > 0) {
                stack1.pop();
                size--;
            }
        }else{
            int size = size2-size1;
            while(size > 0) {
                stack2.pop();
                size--;
            }
        }
        //两个栈当中 一定是相同的节点个数
        while(stack1.peek() != stack2.peek()) {
            stack1.pop();
            stack2.pop();
        }
        return stack1.peek();
    }

    TreeNode prev = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return null;
        }
        convertChild(pRootOfTree);

        TreeNode head = pRootOfTree;
        while(head.left != null) {
            head = head.left;
        }
        return head;
    }

    private void convertChild(TreeNode pCur) {
        if(pCur == null) return;
        convertChild(pCur.left);
        pCur.left = prev;
        if(prev != null) prev.right=pCur;
        prev = pCur;
        convertChild(pCur.right);
    }

    /**
     * 非递归实现前序遍历
     * @param root
     * @return
     */
    public List<Character> preorderTraversalNor(TreeNode root) {
        List<Character> ret = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {

            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val + " ");
                ret.add(cur.val);
                cur = cur.left;
            }

            TreeNode top = stack.pop();
            cur = top.right;
        }
        return ret;
    }

    public List<Character> inorderTraversalNor(TreeNode root) {
        List<Character> ret = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            ret.add(top.val);
            cur = top.right;
        }
        return ret;
    }

    public List<Character> postorderTraversalNor(TreeNode root) {
        List<Character> ret = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if (top.right == null
                    || top.right == prev) {
                ret.add(top.val);
                stack.pop();
                prev = top;
            } else {
                cur = top.right;
            }
        }
        return ret;
    }

    public String tree2str(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();

        tree2strChild(root,stringBuilder);

        return stringBuilder.toString();
    }

    public void tree2strChild(TreeNode t,StringBuilder stringBuilder) {
        if(t == null) {
            return;
        }
        stringBuilder.append(t.val);
        if(t.left != null) {
            stringBuilder.append("(");
            tree2strChild(t.left,stringBuilder);
            stringBuilder.append(")");
        }else {
            if(t.right == null) {
                return;
            }else {
                stringBuilder.append("()");
            }
        }

        if(t.right == null) {
            return;
        }else {
            stringBuilder.append("(");
            tree2strChild(t.right,stringBuilder);
            stringBuilder.append(")");
        }
    }
}
