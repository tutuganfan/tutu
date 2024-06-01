class Solution {
    static class TreeNode {
        public int val;
        public TreeNode left;//存储左孩子的引用
        public TreeNode right;//存储右孩子的引用


        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTreeChild(preorder,inorder,0,inorder.length-1);
    }

    private TreeNode buildTreeChild(int[] preorder, int[] inorder,int inbegin,int inend) {
        //1、当前根节点是不是还有左子树 或者  右子树 
        if(inbegin > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        //2. 找到root再中序遍历的位置
        int rootIndex = findIndex(inorder,inbegin,inend,preorder[preIndex]);
        preIndex++;
        if(rootIndex == -1) {
            return null;
        }
        //3、构建左子树和右子树 
        root.left = buildTreeChild(preorder,inorder,inbegin,rootIndex-1);
        root.right = buildTreeChild(preorder,inorder,rootIndex+1,inend);
        return root;
    }

    private int findIndex (int[] inorder,int inbegin,int inend,int val) {
        for(int i = inbegin;i <= inend;i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}

/*
class Solution {

    public int postIndex = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length-1;
        return buildTreeChild(postorder,inorder,0,inorder.length-1);
    }

    private TreeNode buildTreeChild(int[] postorder, int[] inorder,int inbegin,int inend) {
        //1、当前根节点是不是还有左子树 或者  右子树
        if(inbegin > inend) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        //2. 找到root再中序遍历的位置
        int rootIndex = findIndex(inorder,inbegin,inend,postorder[postIndex]);
        postIndex--;
        if(rootIndex == -1) {
            return null;
        }
        //3、构建左子树和右子树

        root.right = buildTreeChild(postorder,inorder,rootIndex+1,inend);

        root.left = buildTreeChild(postorder,inorder,inbegin,rootIndex-1);

        return root;
    }

    private int findIndex (int[] inorder,int inbegin,int inend,int val) {
        for(int i = inbegin;i <= inend;i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }*/
