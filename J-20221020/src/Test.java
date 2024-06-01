import java.util.*;

/**
 * @Author 12629
 * @Description：
 */
class Person {
    public String id;

    public Person(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
public class Test {

    public static void main(String[] args) {
        Person person1 = new Person("123");
        Person person2 = new Person("123");
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());

        HashBuck2<Person,Integer> hashBuck2 = new HashBuck2<>();
        hashBuck2.put(person1,10);

        System.out.println(hashBuck2.get(person2));
    }

    public static void main3(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,11);
        hashBuck.put(9,11);
        hashBuck.put(3,11);
        hashBuck.put(8,11);
        hashBuck.put(10,11);
        hashBuck.put(13,113);
        hashBuck.put(16,11);

        System.out.println(hashBuck.get(153));
    }
    //str1: 你需要输入的  str2:实际输出的
    private static void func(String str1,String str2) {
        HashSet<Character> set = new HashSet<>();
        for(char ch : str2.toUpperCase().toCharArray()) {
            set.add(ch);
        }
        //2、遍历str1
        HashSet<Character> brokenSet = new HashSet<>();

        for(char ch : str1.toUpperCase().toCharArray()) {
            //T
            if(!set.contains(ch) && !brokenSet.contains(ch)) {
                brokenSet.add(ch);//T
                System.out.print(ch);
            }
        }
    }

    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String str1 = scan.nextLine();
            String str2 = scan.nextLine();
            func(str1,str2);
        }
    }

    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        //1、先把宝石存起来
        for(int i = 0;i < jewels.length();i++) {
            char ch = jewels.charAt(i);
            set.add(ch);
        }
        //2、遍历石头
        for(int i = 0;i < stones.length();i++) {
            char ch = stones.charAt(i);
            if(set.contains(ch)) {
                count++;
            }
        }
        return count;
    }

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        //1、遍历words数组 统计当中的每个字符串出现的次数
        for (String word : words) {
            if(map.get(word) == null) {
                map.put(word,1);
            }else {
                Integer val = map.get(word);
                map.put(word,val+1);
            }
        }
        //上述代码走完 单词的次数就统计完毕
        //2、建立大小为K的小根堆,每个元素就是一个Entry
        PriorityQueue<Map.Entry<String,Integer>> minHeap =
                new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if(o1.getValue() .compareTo(o2.getValue() ) == 0) {
                            return o2.getKey().compareTo(o1.getKey());
                        }
                        return o1.getValue().compareTo(o2.getValue());
                    }
                });
        //3、遍历map当中的每个Entry
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            if(minHeap.size() < k) {
                minHeap.offer(entry);
            }else {
                Map.Entry<String,Integer> top =  minHeap.peek();
                //出堆
                if(entry.getValue().compareTo(top.getValue()) > 0) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }else {
                    //频率相同，
                    if(entry.getValue().compareTo(top.getValue()) == 0) {
                        if(top.getKey().compareTo(entry.getKey()) > 0) {
                            minHeap.poll();
                            minHeap.offer(entry);
                        }
                    }
                }
            }
        }
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Map.Entry<String,Integer> top = minHeap.poll();
            ret.add(top.getKey());
        }
        Collections.reverse(ret);
        //System.out.println("fafsdsafa");
        return ret;
    }

    public static void main2(String[] args) {
        //hello - 3
        //gao - 2 ["i","love","leetcode","i","love","coding"]

        //String[] words = {"abc","abc","abc","bcd","bcd","bcd","hello"};
        String[] words = {"i","love","leetcode","i","love","coding"};
        topKFrequent(words,3); // ret 返回：abc bcd
    }
}
