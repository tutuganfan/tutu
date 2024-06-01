import java.util.Arrays;
import java.util.Random;

/**
 * @Author 12629
 * @Description：
 */
public class Test {

    public static void testInsert(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long start = System.currentTimeMillis();
        TestSort.insertSort(array);
        long end = System.currentTimeMillis();
        System.out.println("插入排序耗时："+(end-start));
    }

    public static void testShellSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long start = System.currentTimeMillis();
        TestSort.shellSort(array);
        long end = System.currentTimeMillis();
        System.out.println("希尔排序耗时："+(end-start));
    }

    public static void testSelectSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long start = System.currentTimeMillis();
        TestSort.selectSort(array);
        long end = System.currentTimeMillis();
        System.out.println("选择排序耗时："+(end-start));
    }

    public static void testHeapSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long start = System.currentTimeMillis();
        TestSort.heapSort(array);
        long end = System.currentTimeMillis();
        System.out.println("堆排序耗时："+(end-start));
    }

    public static void testQuickSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long start = System.currentTimeMillis();
        TestSort.quickSort(array);
        long end = System.currentTimeMillis();
        System.out.println("快速排序耗时："+(end-start));
    }

    public static void testMergeSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long start = System.currentTimeMillis();
        TestSort.mergeSort(array);
        long end = System.currentTimeMillis();
        System.out.println("归并排序耗时："+(end-start));
    }

    public static void main(String[] args) {
        int[] array = new int[100_0000];
        initOrder(array);
        //initNotOrder(array);
        //testInsert(array);
        testShellSort(array);
        //testSelectSort(array);
        testHeapSort(array);

        //testQuickSort(array);

        //testMergeSort(array);
    }

    /**
     * 将数组当中 初始化为有序的数据
     * @param array
     */
    public static void initOrder(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length-i;
            //array[i] = i;
        }
    }

    /**
     * 将数组当中的数据初始化为 无序的
     * @param array
     */
    public static void initNotOrder(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] =  random.nextInt(100_0000);
        }
    }

}
