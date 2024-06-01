import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author 12629
 * @Description：
 */
class Student implements Comparable<Student>{
    public int age;
    public Student(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        //return this.age - o.age;
        return o.age - this.age;
    }
}
class IntCmp implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        //return o2-o1;
        return o2.compareTo(o1);
    }
}
public class Test {


    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = { 27,15,19,18,28,34,65,49,25,37 };
        testHeap.initElem(array);
        //testHeap.createHeap();
        testHeap.heapSort();
        System.out.println("fada");
    }

    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        int[] tmp = new int[k];
        for(int i = 0; i< k;i++) {
            tmp[i] = arr[i];
        }
        return tmp;
    }

    /**
     * 时间复杂度：O(N+KlogN)
     * @param arr
     * @param k
     * @return
     */
    public static int[] smallestK2(int[] arr, int k) {
        //1. 建立一个小根堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //2、取出数组当中的每个元素，存放到小跟堆当中
        for (int i = 0; i < arr.length; i++) {
            minHeap.offer(arr[i]);
        }
        //3.弹出K个元素，存放到数组当中,返回即可  Klogn
        int[] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = minHeap.poll();
        }
        return tmp;
    }

    /**
     * 时间复杂度： O(n*logK)
     * @param arr
     * @param k
     * @return
     */
    public static int[] smallestK3(int[] arr, int k) {
        if(arr == null || k == 0) {
            return new int[0];
        }
        //1. 建立一个大根堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        //2、
        for (int i = 0; i < arr.length; i++) {
            if(minHeap.size() < k) {
                minHeap.offer(arr[i]);
            }else {
                //当前数组的元素是arr[i]    18
                int val = minHeap.peek();  //27
                if(val > arr[i]) {
                    //弹出大的
                    minHeap.poll();
                    //放进小的
                    minHeap.offer(arr[i]);
                }
            }
        }

        //3
        int[] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = minHeap.poll();
        }
        return tmp;
    }

    public static int[] smallestK4(int[] arr, int k) {
        if(arr == null || k == 0) {
            return new int[0];
        }
        //1. 建立一个大根堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        //2、
        for (int i = 0; i < k; i++) {
            minHeap.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            //当前数组的元素是arr[i]    18
            int val = minHeap.peek();  //27
            if(val > arr[i]) {
                //弹出大的
                minHeap.poll();
                //放进小的
                minHeap.offer(arr[i]);
            }
        }

        //3
        int[] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = minHeap.poll();
        }
        return tmp;
    }
    public static void main6(String[] args) {
        int[] array = {1,5,2,9,8,20,18};
        int[]  tmp = smallestK3(array,3);
        System.out.println(Arrays.toString(tmp));
    }



    public static void main5(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(11);
        arrayList.add(5);
        arrayList.add(10);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(arrayList);

        System.out.println("fsafsafa");

    }

    public static void main4(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });


        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>((x,y)->{return x.compareTo(y);});
        PriorityQueue<Integer> priorityQueue3 = new PriorityQueue<>((x,y)-> x.compareTo(y));
    }

    public static void main3(String[] args) {
        //堆-》
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new IntCmp());
        priorityQueue.offer(10);
        priorityQueue.offer(20);
        priorityQueue.offer(3);

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());

    }
    public static void main2(String[] args) {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(-1);
        priorityQueue.offer(new Student(10));
        Student student = new Student(5);
        priorityQueue.offer(student);

        System.out.println("fafasdfafa");

    }


    public static void main1(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = { 27,15,19,18,28,34,65,49,25,37 };
        testHeap.initElem(array);
        testHeap.createHeap();
        //testHeap.offer(80);
        System.out.println(testHeap.pop());
        System.out.println("faasafsasafa");
    }
}
