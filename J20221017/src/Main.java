import java.util.*;

class BinarySearchTree {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode root = null;

    /**
     * 查找一个val 是不是在当前的搜索树当中
     * @param val
     * @return 有返回 没有返回null
     */
    public TreeNode search(int val) {
        TreeNode cur = root;
        while (cur != null) {
            if(cur.val < val) {
                cur = cur.right;
            }else if(cur.val > val) {
                cur = cur.left;
            }else {
                return cur;
            }
        }
        return null;
    }

    /**
     * 插入元素key
     * @param key
     * @return
     */
    public boolean insert(int key) {
        if(root == null) {
            root = new TreeNode(key);
            return true;
        }

        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if(cur.val < key) {
                parent = cur;
                cur =cur.right;
            }else if(cur.val > key) {
                parent = cur;
                cur = cur.left;
            }else{
                return false;//相同的key是不能进行插入的
            }
        }
        //cur = null 了
        TreeNode node = new TreeNode(key);
        if(key < parent.val) {
            parent.left = node;
        }else {
            parent.right = node;
        }
        return true;
    }

    public void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    public void remove(int key) {

        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if(cur.val == key) {
                removeNode(parent,cur);
                return;
            }else if(cur.val < key) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
    }

    private void removeNode(TreeNode parent,TreeNode cur) {
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            }else if(cur == parent.left) {
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if(cur.right == null) {
            if(cur == root) {
                root = cur.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            TreeNode target = cur.right;
            TreeNode targetParent = cur;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            if(target == targetParent.left) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }
}
class Student {

}
public class Main {

    public static void main(String[] args) {
        TreeMap<String,Integer> map = new TreeMap<>();
        map.put("hello",2);
        map.put("abc",4);
        map.put("abc",14);


        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        for (Map.Entry<String,Integer> entry  : entrySet) {
            System.out.println("key: "+entry.getKey() +" val: "+entry.getValue());
        }
    }

    public static void main2(String[] args) {
        TreeMap<String,Integer> map = new TreeMap<>();
        map.put("hello",2);
        map.put("abc",4);

        Integer v = map.getOrDefault("hello2",100);
        System.out.println(v);

        System.out.println("取出Key值，进行组织，通过Set");

        Set<String> set =  map.keySet();

        System.out.println(set);


        Collection<Integer> collection = map.values();
        System.out.println(collection);
        //System.out.println(map);

        TreeMap<Student,Integer> map2 = new TreeMap<>();
        //map2.put(new Student(),1);

    }
    public static void main1(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] array = {5,3,4,1,7,8,2,6,0,9};
        for (int i = 0; i < array.length; i++) {
            binarySearchTree.insert(array[i]);
        }
        binarySearchTree.inorder(binarySearchTree.root);
        //System.out.println("Hello world!");
    }
}