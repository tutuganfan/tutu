import java.util.*;

/**
 * @Author 12629
 * @Description：
 */
class Student {

}
public class Test {
    //1、统计10W个数据当中，不重复的数据？[去重]
    public static void func1(int[] array) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        System.out.println(set);
    }

    //2、统计10W个数据当中，第一个重复的数据？
    public static void func2(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if(!set.contains(array[i])) {
                set.add(array[i]);
            }else{
                System.out.println(array[i]);
                return;
            }
        }
    }
    //3、统计10W个数据当中，每个数据出现的次数？ 对应的关系
    public static void func3(int[] array) {
        HashMap<Integer,Integer> map = new HashMap<>();
        //1、遍历原来的数据，统计每个数据出现的次数
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            if(map.get(key) == null) {
                map.put(key,1);
            }else {
                int val = map.get(key);//key出现的 次数
                map.put(key,val+1);
            }
        }
        //System.out.println("dfadsaf");
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            System.out.println("key: "+entry.getKey()+" 出现了："+entry.getValue()+"次！");
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,2,1,4};
        func3(array);
    }

    public int singleNumber(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0;i < nums.length;i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
            }else{
                set.remove(nums[i]);
            }
        }

        for(int i = 0;i < nums.length;i++) {
            if(set.contains(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }


    public static void main6(String[] args) {
        int[] array = new int[10_0000];
        Random random = new Random();
        for(int i = 0;i < 10_0000;i++) {
            array[i] = random.nextInt(5_0000);
        }
        //System.out.println(Arrays.toString(array));
        func1(array);




    }

    public static void main4(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("张三",1);
        map.put("李四",2);
        map.put(null,null);
        System.out.println(map.get("张三"));

        Set<Map.Entry<String,Integer>> entries = map.entrySet();
        for(Map.Entry<String,Integer> entry : entries) {
            System.out.println(entry.getKey()+" -> " +entry.getValue());
        }
        System.out.println(map);

        HashMap<Student,Integer> map2 = new HashMap<>();
        map2.put(new Student(),2);
        map2.put(new Student(),1);
        System.out.println(map2);

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(1);
        set.add(1);
        System.out.println("size: "+ set.size());
    }

    public static void main3(String[] args) {
        TreeSet<Student> set = new TreeSet<>();
        set.add(new Student());
    }

    public static void main2(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("hello");
        set.add("world");
        System.out.println(set.contains("hello"));
    }

    public int firstUniqChar(String s) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            array[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (array[ch - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }


    public static void main1(String[] args) {
        TreeMap<String,Integer> map = new TreeMap<>();
        //所以在TreeMap当中  不可以存放key 为null
        // map.put(null,10);

    }

    /*public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        //1、遍历原来的链表 存储对应关系
        Node cur = head;
        while(cur != null) {
            Node node = new Node(cur.val);
            map.put(cur,node);
            cur = cur.next;
        }

        cur = head;
        //2、第2次遍历链表,修改next  random
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return  map.get(head);
    }*/
}
